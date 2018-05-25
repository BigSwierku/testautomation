package com.jsystems.api;
import com.fasterxml.jackson.annotation.JsonProperty;
public class ErrorResponse {


        @JsonProperty("Error")
        public ErrorBody error;

        @Override
        public String toString() {
            return "ErrorResponse{" +
                    "error=" + error +
                    '}';
        }

        public class ErrorBody {

            @JsonProperty("error.code")
            public int errorCode;
            @JsonProperty("validation_erro")
            public String validationError;
            public String message;

            @Override
            public String toString() {
                return "ErrorBody{" +
                        "error_code=" + errorCode +
                        ", validation_erro='" + validationError + '\'' +
                        ", message='" + message + '\'' +
                        '}';
            }
        }
    }

