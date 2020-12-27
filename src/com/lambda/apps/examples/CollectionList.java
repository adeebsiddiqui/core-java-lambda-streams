package com.lambda.apps.examples;

import com.lambda.apps.model.Laptop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CollectionList {

    private static List<Laptop> laptopList = new ArrayList<>(
            Arrays.asList(
                    new Laptop("HP", 800),
                    new Laptop("Macbook", 1200),
                    new Laptop("Dell", 500)
            )
    );

    public static void main(String[] args) {
        System.out.println("-----List before Sorting-----");
        laptopList.forEach(l -> System.out.println(l));

        laptopList.sort(Comparator.comparingInt(Laptop::getPrice));

        System.out.println("\n-----List after Sorting-----");
        laptopList.forEach(System.out::println);

        System.out.println("\n-----List after Removing-----");
        laptopList.removeIf(l -> "HP".equals(l.getBrand()));
        laptopList.forEach(System.out::println);
    }
}
