package com.springboot.backend.rest.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase encargada de la transferencia de 
 * datos entre los componentes de la aplicación
 * @author gonzaloguzman97@gmail.com
 */
public class ResponseDate {

	private int id;
	private LocalDate fechaCreacion;
	private LocalDate fechaFin;
	private List<LocalDate> fechas;
	private List<LocalDate> fechasFaltantes;

	public ResponseDate() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public List<LocalDate> getFechas() {
		return fechas;
	}

	public void setFechas(List<LocalDate> fechas) {
		this.fechas = fechas;
	}

	public List<LocalDate> getFechasFaltantes() {
		return fechasFaltantes;
	}

	public void setFechasFaltantes(List<LocalDate> fechasFaltantes) {
		this.fechasFaltantes = fechasFaltantes;
	}
}
