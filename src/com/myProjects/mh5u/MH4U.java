package com.myProjects.mh5u;

import java.lang.reflect.*;

public class MH4U{
	public static void main(String[] args){
		XMLReader reader = new XMLReader();
		System.out.println("Program Start");
		for(Monster m : reader.getMyMonsters()){
			for(Field f : m.getClass().getDeclaredFields()){
				System.out.println(f.getName().toUpperCase() + ": ");
			}
		}	
		System.out.println("Program End");
	}

}
