package com.skills;

import java.io.IOException;


import com.google.gson.JsonSyntaxException;
import com.skills.process.SkillFinder;
import com.skills.process.SkillInputReader;

public class Main {
	public static void main(String[] args) throws JsonSyntaxException, IOException {
		System.out.println("Skill Finder....");
		SkillInputReader reader = new SkillInputReader();
		String skill=reader.Read();
		SkillFinder sf = new SkillFinder();
		sf.find(skill);
	}
}
