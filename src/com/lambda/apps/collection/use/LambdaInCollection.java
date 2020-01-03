package com.lambda.apps.collection.use;

import com.lambda.apps.model.Laptop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaInCollection {

    private static List<Laptop> laptopList = new ArrayList<>(
            Arrays.asList(
                    new Laptop("HP", 800),
                    new Laptop("Macbook", 1200),
                    new Laptop("Dell", 500)
            )
    );

    public static void main(String[] args) {

        laptopList.forEach( l -> System.out.println(l));

        System.out.println("\n-----After Sorting-----");
        laptopList.sort( (l, t) -> l.getPrice() - t.getPrice() ); /**Use of Comparator using Lambda*/
        laptopList.forEach( l -> System.out.println(l));

        System.out.println("\n-----After Removing-----");
        laptopList.removeIf( l -> "HP".equals(l.getBrand()));
        laptopList.forEach(System.out::println);
    }
}
