package com.microservice.foodorderservice.common;

public class CommonConstants {
    private CommonConstants() {
        // To implicit the public constructor. [SonarLint]
    }

    public static final String UNKNOWN = "unknown";
    public static final String NOT_FOUND = "Not found";
    public static final String FOUND = "Found";
    public static final String OK = "ok";
    public static final String FAILED = "Failed";
    public static final String INTERNAL_SERVER_ERROR = "Internal server error";
}
