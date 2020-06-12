package com.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalImprovement {

	public static void main(String[] args) {
		List<Optional<String>> list = Arrays.asList (
			      Optional.empty(), 
			      Optional.of("A"), 
			      Optional.empty(), 
			      Optional.of("B"));
		
		Stream<Optional<String>> streamOfOptional = list.stream();
		
		List values = streamOfOptional
					.flatMap(Optional::stream)
					.collect(Collectors.toList());
		
		System.out.println(values);
		
		
	}
}
