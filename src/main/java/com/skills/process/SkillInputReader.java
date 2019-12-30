package com.skills.process;

import java.util.Scanner;

public class SkillInputReader {

	private Scanner sc;

	public SkillInputReader() {
		sc = new Scanner(System.in);
	}

	/**
	 * 
	 * @return 
	 */
	public String Read() {
		System.out.println("Enter the  name of Skill ");
		String str = sc.next();
		return str;
	}
}
