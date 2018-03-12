package com.iotdeveloper.cloudtools.model.Response;

/**
 * Created by lwplvx on 2018/3/12.
 */
public class ErrorResponse extends AbstractJsonResponse {

    String errorMessage = null;

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getErrorCode() {
        return ErrorCodes.Error;
    }

    @Override
    public String getErrorMessage() {
        if (errorMessage != null) {
            return errorMessage;
        }
        return ErrorCodes.Error;
    }
}