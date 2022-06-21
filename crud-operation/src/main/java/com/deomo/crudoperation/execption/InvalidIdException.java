package com.deomo.crudoperation.execption;


public class InvalidIdException extends RuntimeException{

    public InvalidIdException(String message) {
        super(message);
    }
}
