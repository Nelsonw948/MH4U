package com.myProjects.mh5u;

import org.w3c.dom.Element;

public class Weapon {
	private String name;
	private String type;
	private String elements;
	private int attack;
	private int slots;
	private int affinity;
	private int defence;
	
	Weapon(String name, String type, String elements, int attack, int slots, int affinity, int defence) {
		super();
		this.name = name;
		this.type = type;
		this.elements = elements;
		this.attack = attack;
		this.slots = slots;
		this.affinity = affinity;
		this.defence = defence;
	}

	Weapon(){
		
	}
	
	public Weapon getWeapon(Element weaponElement){
		XMLReader reader = new XMLReader();
		String name = reader.getTextValue(weaponElement, "Name");;
		String type = reader.getTextValue(weaponElement, "Type");;
		String elements = reader.getTextValue(weaponElement, "Elements");;
		int attack = reader.getIntValue(weaponElement, "Attack");
		int slots = reader.getIntValue(weaponElement, "Slots");
		int affinity = reader.getIntValue(weaponElement, "Affinity");
		int defence = reader.getIntValue(weaponElement, "Defence");
		
		Weapon newWeapon = new Weapon(name, type, elements, attack, slots, affinity, defence);
		return newWeapon;
	}
	
}
