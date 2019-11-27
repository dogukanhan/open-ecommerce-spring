package com.dogukanhan.ecom.appserver.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object resourceId) {
        super("Resource not found by id =" + resourceId);
    }

}
