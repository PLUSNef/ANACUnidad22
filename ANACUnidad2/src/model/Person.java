package model;

import java.io.Serializable;

public class Person implements Serializable{
	private String id;
	private String name;
	private String report;
	private String relation;
	
	
	
	public Person(String id, String name, String report, String relation) {
		super();
		this.id = id;
		this.name = name;
		this.report = report;
		this.relation = relation;
	}



	public Person() {
		this("","","","");
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getReport() {
		return report;
	}



	public void setReport(String report) {
		this.report = report;
	}



	public String getRelation() {
		return relation;
	}



	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	
	
}
