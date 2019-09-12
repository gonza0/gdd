package com.springboot.backend.rest.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
* @author gonzaloguzman97@gmail.com
*/
@Service
public class GddService {

	@Autowired
	private Environment env;

	@Autowired
	private ObjectMapper mapper;

	/**
	 * Consume servicio GDD
	 * utiliza endpoint a traves de archivo de propiedades
	 * @return
	 * @throws IOException
	 */
	public JsonNode getGddResponse() throws IOException {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(env.getProperty("url"), String.class);
		JsonNode json = mapper.readTree(response.getBody());
		return getMissingDates(json);
		
	}

	/**
	 * retorna data procesada con las fechas faltantes
	 * @param json
	 * @return
	 */
	private JsonNode getMissingDates(JsonNode json) {
		
		LocalDate start = LocalDate.parse(json.get("fechaCreacion").asText());
		LocalDate end = LocalDate.parse(json.get("fechaFin").asText());
		
		List<LocalDate> dates = new ArrayList<>();
		ArrayNode arrayNode = (ArrayNode) json.get("fechas");
	
		while (start.isBefore(end)) {
			dates.add(start);
		    start = start.plusMonths(1);
		}
		
		//Remueve elementos los elementos repetidos de la lista
		for (JsonNode jsonNode : arrayNode) {
			dates.removeIf(p -> p.toString().contains(jsonNode.asText()));
		}
		
		//crea nuevo arreglo con las fechasFaltantes y lo agrega a la 
		//respuesta final.
		ArrayNode result = mapper.valueToTree(dates);
		((ObjectNode) json).putArray("fechasFaltantes").addAll(result);
		
		return json;
	}
	
	
	
	
}
