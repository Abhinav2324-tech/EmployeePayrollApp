package com.bridgelabz.employeepayrollapp.dto;

/**
 * Wraps the result of a REST request in a message and a data field.
 */
public class ResponseDTO {
    private final String message;
    private final Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}