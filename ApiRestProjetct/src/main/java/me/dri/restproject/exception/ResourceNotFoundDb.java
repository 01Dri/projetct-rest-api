package me.dri.restproject.exception;

public class ResourceNotFoundDb extends RuntimeException {

    public ResourceNotFoundDb(Object id) {
        super("Resource not found, id " + id);
    }
}
