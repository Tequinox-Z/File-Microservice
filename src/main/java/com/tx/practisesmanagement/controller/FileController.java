package com.tx.practisesmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tx.practisesmanagement.error.RestError;
import com.tx.practisesmanagement.model.File;
import com.tx.practisesmanagement.service.FileService;

@RestController
@CrossOrigin("*")
/**
 * Controller for files
 * @author Salvador
 */
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	/**
	 * Upload a file
	 * @param file: File to upload
	 * @return: Status 
	 */
	@PostMapping("/upload")
	public ResponseEntity upload(@RequestParam("file") MultipartFile file) {
	    
		// Check if the file is empty
		
		if (file.isEmpty() || file.getSize() == 0) {
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
		  		  new RestError(HttpStatus.BAD_REQUEST, "El fichero está vacío")
		    );
		}
		
		try {
			// Try save the file
			
			return ResponseEntity.status(HttpStatus.CREATED).body(fileService.saveFile(file));
	    } 
	    catch (Exception e) {
	    	
	    	// If exist a error with the file we report it
	    	
	    	return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(
	    		  new RestError(HttpStatus.EXPECTATION_FAILED, "Error al subir fichero")
	    	);
	    }
	}
	
	
	/**
	 * Get a file fron the server
	 * @param id: File id 
	 * @return: File 
	 */
	@GetMapping("/files/{id}")
	public ResponseEntity getFile(@PathVariable String id) {
		
		File file = fileService.getFile(id);										// Get the file
		
		
		// Check if file exist
		
		if (file == null) {
		    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
			  		  new RestError(HttpStatus.NOT_FOUND, "El fichero no existe")
			);
		}
		
		// Set headers
		
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("content-type", 
	      file.getMimeType());
	    
	    
	    // Return the file 
	    
		return ResponseEntity.ok()
				.headers(responseHeaders)
				.body(file.getData());
	}
	
	/**
	 * Controller advice, check that the file does not exceed the size
	 * @author Salvador
	 */
	@ControllerAdvice
	public class FileUploadExceptionAdvice extends ResponseEntityExceptionHandler {
	  @ExceptionHandler(MaxUploadSizeExceededException.class)
	  public ResponseEntity<RestError> handleMaxSizeException(MaxUploadSizeExceededException exc) {
	    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new RestError(HttpStatus.EXPECTATION_FAILED, "Fichero demasiado grande"));
	  }
	}
}
