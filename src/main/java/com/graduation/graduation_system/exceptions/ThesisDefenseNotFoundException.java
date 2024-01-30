package com.graduation.graduation_system.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ThesisDefenseNotFoundException extends RuntimeException{
    public ThesisDefenseNotFoundException(String message) {
        super(message);
    }
}
