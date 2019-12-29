package com.skills;

import java.io.IOException;

import com.google.gson.JsonSyntaxException;
import com.skills.process.Reader;
import com.skills.process.SkillFinder;

public class Main {
	public static void main(String[] args) throws JsonSyntaxException, IOException {
		System.out.println("Skill Finder....");
		String skill=new Reader().Read();
		SkillFinder sf = new SkillFinder();
		sf.finder(skill);
	}
}
