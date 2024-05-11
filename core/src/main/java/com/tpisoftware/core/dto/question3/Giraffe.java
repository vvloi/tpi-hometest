package com.tpisoftware.core.dto.question3;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("tiger")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Giraffe implements Animal {
    @Override
    public void eat() {
        System.out.println("Giraffe eat grass.");
    }
}
