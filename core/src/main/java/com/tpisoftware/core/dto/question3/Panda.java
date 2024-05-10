package com.tpisoftware.core.dto.question3;

import org.springframework.stereotype.Component;

@Component("zebra")
public class Panda implements Animal {
    @Override
    public void eat() {
        System.out.println("Panda eat bamboo.");
    }
}
