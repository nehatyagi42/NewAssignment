package com.skills.process;

import java.util.Scanner;

public class Reader {

	private Scanner sc;

	public Reader() {
		sc = new Scanner(System.in);
	}

	public String Read() {
		System.out.println("Enter the  name of technologies ");
		String str = sc.next();
		return str;
	}
}
