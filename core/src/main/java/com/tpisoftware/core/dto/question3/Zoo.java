package com.tpisoftware.core.dto.question3;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Zoo {
    /*
     * this is a prototype scope bean, it'll create new instance of this bean when was called to
     */
    private final Animal tiger;

    /*
     * this is a prototype scope bean, it'll create new instance of this bean when was called to
     */
    private final Animal zebra;

    @PostConstruct
    public void process() {
        tiger.eat();
        zebra.eat();
    }
}
