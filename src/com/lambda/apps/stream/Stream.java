package com.lambda.apps.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stream {
	
	private static List<Person> personList = new ArrayList<>(
			Arrays.asList(
					new Person("Adeeb", "Siddiqui", 34),
					new Person("Maisha", "Rahman", 27),
					new Person("Fayaz", "Siddiqui", 29)
				)
			);

	public static void main(String[] args) {

		personList.forEach(p -> System.out.println(p));

		System.out.println("-----After sorting-----");
		personList.sort( (Person p1, Person p2) -> p1.getAge() - p2.getAge());
		personList.forEach(p -> System.out.println(p));

		System.out.println("-----Use of Stream-----");
		personList.stream()
			.filter(p -> p.getLastName().startsWith("R"))
			.forEach(p -> System.out.println(p)); // <-- Terminal operation of a Stream, no operation can be done after this
		
		System.out.println("-------");
		
		personList.removeIf(p -> p.getAge() == 27);
		personList.forEach(p -> System.out.println(p));
	}

}
