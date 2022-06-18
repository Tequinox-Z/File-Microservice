package com.tx.practisesmanagement.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tx.practisesmanagement.model.File;
import com.tx.practisesmanagement.repository.FileRepository;

@Service
/**
 * Service of files
 * @author Salvador
 *
 */
public class FileService {
	
	@Autowired
	private FileRepository fileRepository;									// Repository of files
	
	/**
	 * Save a new file
	 * @param fileToSave: File to save
	 * @return: File saved
	 * @throws IOException: Exception in case of error
	 */
	public File saveFile(MultipartFile fileToSave) throws IOException {
		// Generate a new file and set the info and data
		File newFile = new File (
								fileToSave.getOriginalFilename(), 
								fileToSave.getContentType(), 
								fileToSave.getBytes(), 
								fileToSave.getSize()
								);
		// Save the file
		return fileRepository.save(newFile);
	}
	
	/**
	 * Get a file
	 * @param id: Id of file
	 * @return File
	 */
	public File getFile(String id) {
		return fileRepository.findById(id).orElse(null);
	}
	
}
