package com.examples;

import java.util.List;
import java.util.Map;
import static java.util.Map.entry;


public class Colletions {

	public static void main(String[] args) {
		List names = List.of("Junior", "Gabriela");
		
		names.forEach(System.out::println);
		//names.add("Rafael");//java.lang.UnsupportedOperationException because is immutable
		Map mapIdName = Map.of(1, "Junior", 2, "Gabiela");
		mapIdName.forEach((k, v) -> System.out.println(k + " - " + v));
		
		List list1 = List.of(50,60,35);
		List list2 = List.of(15,25,32);
		
		Map entiryMap = Map.ofEntries(entry(1, list1), entry(2,list2));
		
		System.out.println(entiryMap); // {1=[50, 60, 35], 2=[15, 25, 32]}
	}
}
