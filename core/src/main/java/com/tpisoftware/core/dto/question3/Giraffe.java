package com.tpisoftware.core.dto.question3;

import org.springframework.stereotype.Component;

@Component("tiger")
public class Giraffe implements Animal {
    @Override
    public void eat() {
        System.out.println("Giraffe eat grass.");
    }
}
