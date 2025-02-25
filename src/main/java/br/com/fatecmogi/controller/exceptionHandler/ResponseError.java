package br.com.fatecmogi.controller.exceptionHandler;

import lombok.Getter;

@Getter
public class ResponseError {

    private int status;
    private String message;

    public ResponseError(int status, String message) {
        this.status = status;
        this.message = message;
    }

}
