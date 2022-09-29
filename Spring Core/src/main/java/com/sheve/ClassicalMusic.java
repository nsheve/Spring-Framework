package com.sheve;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

public class ClassicalMusic implements Music {
    List<String> classicMusic = Arrays.asList("Чайковский", "Дунаевский", "Муссорский");

    @Override
    public List<String> getSong() {
        return classicMusic;
    }
}
