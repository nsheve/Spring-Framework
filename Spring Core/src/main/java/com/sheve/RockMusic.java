package com.sheve;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

public class RockMusic implements Music {
    List<String> rockList = Arrays.asList("AC/DC", "Rumshtain", "PHARAON");
    @Override
    public List<String> getSong() {
        return rockList;
    }
}
