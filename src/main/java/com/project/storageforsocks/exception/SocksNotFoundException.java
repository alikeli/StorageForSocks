package com.project.storageforsocks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class SocksNotFoundException extends RuntimeException {
    public SocksNotFoundException() {
        super("Pair not found, not enough items");
    }
}
