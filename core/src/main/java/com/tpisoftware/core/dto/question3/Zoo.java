package com.tpisoftware.core.dto.question3;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Zoo {
    private final Animal tiger;
    private final Animal zebra;

    @PostConstruct
    public void process() {
        tiger.eat();
        zebra.eat();
    }
}
