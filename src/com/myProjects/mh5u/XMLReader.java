package com.myProjects.mh5u;


import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XMLReader {
	org.w3c.dom.Document dom = null;
	private ArrayList<Monster> myMonsters = new ArrayList<Monster>();
	private ArrayList<Weapon> myWeapons = new ArrayList<Weapon>();
	
	ArrayList<Monster> getMyMonsters() {
		return myMonsters;
	}

	ArrayList<Weapon> getMyWeapons() {
		return myWeapons;
	}

	XMLReader(){
		parseXmlFile();
		parseMonsters();
		parseWeapons();
	}
	
	//not finding the file
	private void parseXmlFile(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try{
			DocumentBuilder db = dbf.newDocumentBuilder();
			File mh4u = new File("MH4U.xml");
			dom = db.parse(mh4u);
		}
		catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}
		catch(SAXException se) {
			se.printStackTrace();
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private void parseMonsters(){
		//get the root element
		Element docElement = dom.getDocumentElement();
		NodeList nl = docElement.getElementsByTagName("Monster");
		if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {
				//get the employee element
				Element monsterElement = (Element)nl.item(i);
				//get the Employee object
				Monster monster = new Monster();
				monster = monster.getMonster(monsterElement);
				//add it to list
				myMonsters.add(monster);
			}
		}
	}

	private void parseWeapons(){
		//get the root element
		Element docElement = dom.getDocumentElement();
		NodeList nl = docElement.getElementsByTagName("Weapon");
		if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {
				//get the employee element
				Element weaponElement = (Element)nl.item(i);
				//get the Employee object
				Weapon weapon = new Weapon();
				weapon = weapon.getWeapon(weaponElement);
				//add it to list
				myWeapons.add(weapon);
			}
		}
	}
	
	public String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}
	public int getIntValue(Element ele, String tagName) {
		//in production application you would catch the exception
		return Integer.parseInt(getTextValue(ele,tagName));
	}

}
