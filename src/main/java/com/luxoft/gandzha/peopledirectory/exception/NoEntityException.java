package com.luxoft.gandzha.peopledirectory.exception;

public class NoEntityException extends Exception{
    @Override
    public String getMessage() {
        return "Employee not found";
    }
}
