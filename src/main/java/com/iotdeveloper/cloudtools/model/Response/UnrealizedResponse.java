package com.iotdeveloper.cloudtools.model.Response;

public class UnrealizedResponse extends AbstractJsonResponse {
    String message;

    public UnrealizedResponse(String message) {
        this.message = message;
    }

    @Override
    public String getErrorCode() {
        return ErrorCodes.Unrealized;
    }

    @Override
    public String getErrorMessage() {
        if (this.message != null) {
            return this.message + " " + ErrorCodes.Unrealized;
        }
        return ErrorCodes.Unrealized + " 未实现";
    }
}
