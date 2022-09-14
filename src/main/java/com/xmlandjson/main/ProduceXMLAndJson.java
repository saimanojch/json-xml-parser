package com.xmlandjson.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.xmlandjson.model.Department;
import com.xmlandjson.model.Student;
import com.xmlandjson.util.DepartmentParser;

public class ProduceXMLAndJson {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Student std1 = new Student("Sai", "Manoj", formatter.parse("12/06/1996"));
		Student std2 = new Student("Yessu", "Ch", formatter.parse("16/10/1998"));
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(std1);
		studentList.add(std2);

		Department department = new Department(0, "ECE", studentList);

		String outputInXML = DepartmentParser.serialise(department, "XML");
		String outputInJSON = DepartmentParser.serialise(department, "JSON");

		System.out.println(outputInXML);
		System.out.println("--------------------------------------------");
		System.out.println(outputInJSON);
		System.out.println("============================================");

		Department departmentInJson = DepartmentParser.deserialiser(outputInJSON, "JSON");
		Department departmentInXML = DepartmentParser.deserialiser(outputInXML, "XML");
		System.out.println("Parsed from JSON \n " + departmentInJson);
		System.out.println("--------------------------------------------");
		System.out.println("Parsed from XML \n " + departmentInXML);

	}

}
