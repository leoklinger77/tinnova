package com.vehicleregistration.vehicleregistration.models;

public  class SuccessResponse<T> {
    private boolean success;
    private T object;

    public SuccessResponse(boolean success, T object) {
        this.success = success;
        this.object = object;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getObject() {
        return object;
    }
}
