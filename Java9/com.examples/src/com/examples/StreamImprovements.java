package com.examples;

import java.util.stream.Stream;

public class StreamImprovements {

	public static void main(String[] args) {
		
		
		//takewhile
		Stream.of(1,2,3,4,8,10,25,5,7,18,0)
			.takeWhile(v -> v < 15)
			.forEach(System.out::println);

		//dropWhile
		Stream.of(3,4,8,10,25,1,5,7,18,0)
		.dropWhile(v -> v < 9)
		.forEach(System.out::println);
		
		
		//ofNullable
		Stream<Integer> streamOfNullable = Stream.ofNullable(null);
		streamOfNullable.forEach(System.out::println); // vazio
		
		Stream<Integer> streamOf = Stream.of(null);
		streamOf.forEach(System.out::println); // java.lang.NullPointerException
		
	}

}
