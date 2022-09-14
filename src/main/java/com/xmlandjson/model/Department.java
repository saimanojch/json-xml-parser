package com.xmlandjson.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "department")
public class Department {
	
	@JsonProperty
	private int departmentId;
	@JsonProperty
	private String departmentName;
	@JsonProperty
	@JacksonXmlElementWrapper(localName = "students")
	  @JacksonXmlProperty(localName = "student")
	private List<Student> students;
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Department(int departmentId, String departmentName, List<Student> students) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.students = students;
	}
	public Department() {
		super();
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", students="
				+ students + "]";
	}
	

}
