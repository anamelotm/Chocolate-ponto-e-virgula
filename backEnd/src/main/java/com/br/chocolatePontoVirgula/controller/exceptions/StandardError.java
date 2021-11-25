package com.br.chocolatePontoVirgula.controller.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
public class StandardError implements Serializable {
    private Instant Timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
    public StandardError(){};
}
