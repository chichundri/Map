package com.test;

public class Test {

	private Test() {

	}

	// public static void main(String[] args) {
	// Age age = new Age();
	// age.setDay(1);
	// age.setMonth(1);
	// age.setYear(1992);
	// ImmutableStudent student = new ImmutableStudent(1, "Alex", age);
	//
	// System.out.println("Alex age year before modification = " +
	// student.getAge().getYear());
	// student.getAge().setYear(1993);
	// System.out.println("Alex age year after modification = " +
	// student.getAge().getYear());
	// }

	public static void main(String[] args) {
		int x = 1;
		int y = 2;
		System.out.print("Values of x & y before primitive modification: ");
		System.out.println(" x = " + x + " ; y = " + y);
		modifyPrimitiveTypes(x, y);
		System.out.print("Values of x & y after primitive modification: ");
		System.out.println(" x = " + x + " ; y = " + y);
	}

	private static void modifyPrimitiveTypes(int x, int y) {
		x = 5;
		y = 10;
	}

}
