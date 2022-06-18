package com.tx.practisesmanagement.error;



import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

/**
 * Indicates the error occurred
 * @author Salvador
 */
public class RestError implements Serializable {

	private static final long serialVersionUID = 1L;
	private HttpStatus estado;													// Status code
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime fecha;												// Date
	private String mensaje;														// Message
	
	
	/**
	 * Constructor whitout parameters
	 * @param status
	 * @param message
	 */
	public RestError(HttpStatus estado, String mensaje) {
		super();
		this.estado = estado;
		this.fecha = LocalDateTime.now();
		this.mensaje = mensaje;
	}
	/**
	 * Constructor with message
	 * @param mensaje: Message to set
	 */
	public RestError(String mensaje) {
		super();
		this.fecha = LocalDateTime.now();
		this.mensaje = mensaje;
	}
	
	/**
	 * Get the status code
	 * @return Status code
	 */
	public HttpStatus getEstado() {
		return estado;
	}
	
	/**
	 * Get the date
	 * @return Date 
	 */
	public LocalDateTime getFecha() {
		return fecha;
	}
	
	/**
	 * Get the message
	 * @return Message of error
	 */
	public String getMensaje() {
		return mensaje;
	}
}
