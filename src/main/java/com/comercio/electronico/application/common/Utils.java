package com.comercio.electronico.application.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class Utils {

	public String objectToJson(Object object) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			return "";
		}
	}
	
	public Object jsonToObject(String json, Class<?> classObject) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			return mapper.readValue(json, classObject);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

	public String getHourFormat(LocalTime time) {
		return time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}
	
	public String getDateFormat(LocalDate date) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return date.format(dateTimeFormatter); 
	}
	
	public String getTimeFormat(LocalDateTime date) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return date.format(dateTimeFormatter); 
	}
	
	public String getDateFormat(LocalDate date, String formato) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formato);
		return date.format(dateTimeFormatter); 
	}

	public String getLog(Object object, String typeMessage) {
		Map<String, Object> map = new HashMap<>();
		map.put("fecha", getDateFormat(LocalDate.now()));
		map.put("hora", getHourFormat(LocalTime.now()));
		map.put("data", object);
		map.put("tipo", typeMessage);
		return objectToJson(map);
	}
	
}
