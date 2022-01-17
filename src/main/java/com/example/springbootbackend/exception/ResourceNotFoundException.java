package com.example.springbootbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String recourceName;
    private String fieldName;
    private Object fieldId;

    public ResourceNotFoundException(String recourceName, String fieldName, Object fieldId) {
        this.recourceName = recourceName;
        this.fieldName = fieldName;
        this.fieldId = fieldId;
    }

    public String getRecourceName() {
        return recourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldId() {
        return fieldId;
    }
}
