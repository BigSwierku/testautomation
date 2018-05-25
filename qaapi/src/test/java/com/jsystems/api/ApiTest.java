package com.jsystems.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiTest extends ConfigRestAssured {


    @Test
    @DisplayName("First api rest test")
    public void apiFirstTest() {

        given()
                .when()
                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Piotr"))
                .body("surname", equalTo("Kowalski"));

    }

    @Test
    @DisplayName("Second api test")
    public void secondTest() {
        given()
                .when()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("[0].imie", equalTo("Piotr"))
                .body("[0].nazwisko", equalTo("Kowalski"))
                .body("[0].device[0].type", equalTo("computer"));
        //.body("[0].device[0].device.model[0].produce", equalTo("dell"));
    }

    @Test
    @DisplayName("Mapping test")
    public void mappingTest() {
        JsonPath jsonPath = given()
                .spec(Specificator.requestSpecification)
                .when()
                .get("/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();


        WeakUser userObj = jsonPath.getObject("", WeakUser.class);
        assertThat(userObj.name, equalTo("Piotr"));
        assertThat(userObj.surname, equalTo("Kowalski"));
    }

    @Test
    @DisplayName("Fourth test")
    public void fourthTest() {

        JsonPath jsonPath = given()
                .spec(Specificator.requestSpecification)
                .when()
                .get("/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        jsonPath.prettyPrint();
        List<User> users = jsonPath.getList("", User.class);

        assertThat(users.get(0).device.get(0).deviceModel.get(0).produce, equalTo("dell"));
        //System.out.println(users.toString());

    }

    @Test
    @DisplayName("Fifth test")
    public void fifthTest() {
        Response response = given()
                .spec(Specificator.requestSpecification)
                .when()
                .get("/5a6b69ec3100009d211b8aeb")
                .andReturn();

        WeakUser myObj = response
                .then()
                .extract()
                .body()
                .as(WeakUser.class);

        System.out.println(myObj.toString());

        assertThat(myObj.name, equalTo("Piotr"));
        assertThat(myObj.surname, equalTo("Kowalski"));

    }

    @Test
    @DisplayName("Fifth test")
    public void nextTest() {

        Response response = given()
                .spec(Specificator.requestSpecification)
                .when()
                .get("/5a6a58222e0000d0377a7789")
                .andReturn();

        User[] usersTab = response
                .then()
                .extract()
                .body()
                .as(User[].class);

        List<User> users = Arrays.asList(usersTab);

        System.out.println(users.get(0).toString());
        System.out.println(users.get(0).device.get(0).deviceModel.get(0).toString());

        assertTrue(response.contentType().equals("application/json"));
        assertThat(users.get(0).device.get(0).type, equalTo("computer"));
        assertThat(users.get(0).device.get(0).deviceModel.get(0).produce, equalTo("dell"));
        assertThat(users.get(0).device.get(0).deviceModel.get(0).screenSize, equalTo("17"));


    }


    @Test
    @DisplayName("error test")
    public void errorTest() {

        Response response = given()
                .spec(requestSpecBuilder)
                .when()
                .get("/5a690b452e000054007a73cd")
                .andReturn();

        ErrorResponse errorResponse = response
                .then()
                .extract()
                .body()
                .as(ErrorResponse.class);

        System.out.println(errorResponse.toString());

        assertTrue(errorResponse.error.errorCode == 400);
        assertThat(errorResponse.error.validationError, equalTo("invalid_email"));
        assertThat(errorResponse.error.message, equalTo("your email is invalid"));
    }

//    @Test
//    @DisplayName("======================Testy z użyciem  RequestSpecBuilder")
//    public void specBuiilderTest() {
//
//        //przenosimy do Configa
////        RequestSpecification requestSpecBuilder = new RequestSpecBuilder()
////                .addCookie("cookie")
////                .addHeader("Authorization", "autoryzacja")
////                .setContentType(ContentType.JSON)
////                .setBaseUri("http://www.mocky.io/v2/")
////                .build();
//
//        Response response = given()
//                .spec(requestSpecBuilderWithContentHtml)
//                .contentType(ContentType.HTML)
//                .when()
////                .get("http://www.mocky.io/v2//5a6b77973100009d211b8b0d")
//                .get("/5a6b77973100009d211b8b0d")
//                .andReturn();
//
//        WeakUser myObj = response
//                .then()
//                .extract()
//                .body()
//                .as(WeakUser.class);
//
//        assertThat(myObj.name,equalTo("Piotr"));
//    }


    @Test
    @DisplayName("post test")
    public void postTest() {

        Response response = given()
                .spec(requestSpecBuilder)
                .when()
                .body(new WeakUser("John","Nowak"))
                .post("/5a690a1b2e000051007a73cb")
                .andReturn();

        String responsePost = Arrays.asList(response
                .then()
                .statusCode(201)
                .extract()
                .body()
                .as(String[].class)).toString();

        System.out.println(responsePost);

        assertThat(responsePost,equalTo("[]"));


    }

    @Test//nice one
    @DisplayName("Test for mapping response to the reference type")
    public void genericTypeTest() throws IOException {
        Response response = given()
                .spec(requestSpecBuilder)
                .when()
//                .get("http://www.mocky.io/v2/5a690b452e000054007a73cd")
                .get("/5b05bf3f3200007100ebfa04")
                .andReturn();


        System.out.println(response
                .then()
                .extract()
                .body().toString());


        ObjectMapper objectMapper = new ObjectMapper();

        TestUserGeneric<Integer> testUserGeneric = objectMapper.readValue(response
                .then()
                .extract()
                .body().asInputStream(), new TypeReference<TestUserGeneric<Integer>>() {
        });

        System.out.println(testUserGeneric);
        assertTrue(testUserGeneric.id==1);
    }

    @Test//nice one
    @DisplayName("Test for mapping response to the reference type String")
    public void genericTypeStringTest() throws IOException {
        Response response = given()
                .spec(requestSpecBuilder)
                .when()
//                .get("http://www.mocky.io/v2/5a690b452e000054007a73cd")
                .get("/5b05c83e3200009700ebfa2b")
                .andReturn();


        System.out.println(response
                .then()
                .extract()
                .body().toString());


        ObjectMapper objectMapper = new ObjectMapper();

        TestUserGeneric<String> testUserGeneric = objectMapper.readValue(response
                .then()
                .extract()
                .body().asInputStream(), new TypeReference<TestUserGeneric<String>>() {
        });

        System.out.println(testUserGeneric);
        assertTrue(testUserGeneric.id.equals("1a"));
    }



    @Test
    @DisplayName("Get Book by Id test")
    public void getBookById(){


        Response response = given()
                .spec(requestSpecBuilderFaker)
                .when()
                .get("/api/Books/{id}",1)
                .andReturn();


//        List<Book> books = Arrays.asList(response
//                .then()
//                .extract()
//                .body()
//                .as(Book[].class));
        Book book =response
                .then()
                .extract()
                .body()
                .as(Book.class);
       System.out.println(book.publishDate);
        assertTrue(book.id == 1);
       // assertTrue(books.get(0).publishDate.toString().equals("2018-05-24T10:08:30.753524+00:00"));

    }
}

