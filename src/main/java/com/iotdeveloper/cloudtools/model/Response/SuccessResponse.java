package com.iotdeveloper.cloudtools.model.Response;

/**
 * Created by lwplvx on 2018/3/12.
 */
public class SuccessResponse extends AbstractJsonResponse {

    @Override
    public String getErrorCode() {
        return ErrorCodes.Success;
    }

    @Override
    public String getErrorMessage() {
        return ErrorCodes.Success;
    }
}
