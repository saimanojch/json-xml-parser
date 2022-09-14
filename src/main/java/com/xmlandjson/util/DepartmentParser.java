package com.xmlandjson.util;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.xmlandjson.model.Department;

public class DepartmentParser {

	private static final ObjectMapper XML_MAPPER = new XmlMapper();
	private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

	public static String serialise(Department department, String format) {
		XML_MAPPER.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
		JSON_MAPPER.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
		return format.equals("JSON") ? serialise(department, JSON_MAPPER) : serialise(department, XML_MAPPER);

	}

	private static String serialise(Department department, ObjectMapper objMapper) {
		try {
			return objMapper.writeValueAsString(department);
		} catch (IOException e) {
			throw new UncheckedIOException("failed to marshall", e);
		}
	}

	public static Department deserialiser(String department, String format) {
		XML_MAPPER.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
		JSON_MAPPER.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
		return format.equals("JSON") ? deserialise(department, JSON_MAPPER) : deserialise(department, XML_MAPPER);
	}

	private static Department deserialise(String department, ObjectMapper objMapper) {
		try {
			return objMapper.readValue(department, Department.class);
		} catch (JsonProcessingException e) {
			throw new UncheckedIOException("failed to unmarshall", e);
		}
	}

}
