package com.examples;

public class Process {

	public static void main(String[] args) {
		ProcessHandle process = ProcessHandle.current();
		
		System.out.println("Current process id: " + process.pid());
		System.out.println("Current process id: " + process.isAlive());
		System.out.println("Current process id: " + process.destroy()); //java.lang.IllegalStateException: destroy of current process not allowed
		
	}
}
