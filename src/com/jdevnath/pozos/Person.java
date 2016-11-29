/**
 * 
 */
package com.jdevnath.pozos;

import javax.xml.bind.annotation.*;

/**
 * @author dev2014
 *
 */
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
	@XmlElement(name="name")
	private String name;

	@XmlElement(name="height")
	private String height;

	@XmlElement(name="weight")
	private String weight;
	
	public Person() {
		super();
	}

	public Person(String name, String height, String weight) {
		this.setName(name);
		this.setHeight(height);
		this.setWeight(weight);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	
}
