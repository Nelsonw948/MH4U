package com.myProjects.mh5u;

import org.w3c.dom.Element;

public class Monster {
	private String name;
	private String elements;
	private String ailments;
	private String description;
	//private Map<String, int[]> elementDamage;
	//private Map<String, int[]> elementDamageArmored;
	

	Monster(String name, String elements, String ailments, String description){
		this.name = name;
		this.elements = elements;
		this.ailments = ailments;
		this.description = description;
	}
	Monster(){
		
	}
	
	public Monster getMonster(Element monsterElement){
		XMLReader reader = new XMLReader();
		String name = reader.getTextValue(monsterElement, "Name");
		String elements = reader.getTextValue(monsterElement, "Elements");
		String ailments = reader.getTextValue(monsterElement, "Ailments");
		String description = reader.getTextValue(monsterElement, "Description");
		if(description == "") description = "No description available.";
		Monster newMonster = new Monster(name, elements, ailments, description);
		return newMonster;
	}

	
}
