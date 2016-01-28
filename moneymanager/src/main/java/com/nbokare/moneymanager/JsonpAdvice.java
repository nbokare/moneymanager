package com.nbokare.moneymanager;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@ControllerAdvice
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
    @PostConstruct
    public void init() {
        System.out.println("******** Advice initialized");
    }

    public JsonpAdvice() {
        super("callback");
    }
}
