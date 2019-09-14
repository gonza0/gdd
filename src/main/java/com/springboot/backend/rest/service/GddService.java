package com.springboot.backend.rest.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.backend.rest.model.ResponseDate;

/**
 * @author gonzaloguzman97@gmail.com
 */
@Service
public class GddService {

	@Autowired
	private Environment env;

	/**
	 * Consume servicio GDD utiliza endpoint a traves de archivo de propiedades
	 * 
	 * @return
	 * @throws IOException
	 */
	public ResponseDate getGddResponse() throws IOException {

		RestTemplate restTemplate = new RestTemplate();
		ResponseDate response = restTemplate.getForObject(env.getProperty("url"), ResponseDate.class);
		return getMissingDates(response);
	}

	/**
	 * retorna data procesada con las fechas faltantes
	 * 
	 * @param json
	 * @return
	 */
	private ResponseDate getMissingDates(ResponseDate responseDate) {

		LocalDate start = responseDate.getFechaCreacion();
		LocalDate end = responseDate.getFechaFin();
		List<LocalDate> dates = new ArrayList<>();

		//Crea lista de todas las fechas desde fecha inicio a fin.
		while (start.isBefore(end)) {
			dates.add(start);
			start = start.plusMonths(1);
		}

		// Remueve elementos los elementos repetidos de la lista
		responseDate.getFechas().forEach(v -> {
			dates.removeIf(p -> p.isEqual(v));
		});

		// llena la lista con las fechasFaltantes y lo agrega a la
		// respuesta final.
		responseDate.setFechasFaltantes(dates);
	
		return responseDate;
	}

}
