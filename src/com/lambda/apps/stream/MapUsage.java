package com.lambda.apps.stream;

import java.util.HashMap;
import java.util.Map;

public class MapUsage {

    public static void main(String[] args) {

        Map<String, Boolean> hashMap = new HashMap<>();
        hashMap.put("hasCleanedRoom", true);
        hashMap.put("hasDoneHomework", true);
        hashMap.put("hasEatenVeggies", true);

        boolean buyPrize = hashMap.entrySet()
                .stream()
                .filter( m -> m.getValue() == false )
                .map( m -> m.getValue())
                .findFirst()
                .orElse(Boolean.TRUE);

        System.out.println("Deserve prize: " + buyPrize);
    }
}
