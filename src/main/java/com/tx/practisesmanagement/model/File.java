package com.tx.practisesmanagement.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
/**
 * File class
 * @author Salvador
 */
public class File {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;														// Id
	private String name;													// Name
	private String mimeType;												// Mime-Type
	
	@JsonIgnore
	private byte[] data;													// Data
	
	@Lob
	private Long size;														// Size of file
	
	
	/**
	 * Constructor whitout parameters
	 */
	public File() {
		super();
	}

	/**
	 * Constructor with parameters
	 * @param name: Name of file
	 * @param mimeType: Mime type of file
	 * @param data: Data of file
	 * @param size: Size of file
	 */
	public File(String name, String mimeType, byte[] data, Long size) {
		super();
		this.name = name;
		this.mimeType = mimeType;
		this.data = data;
		this.size = size;
	}
	
	/**
	 * Constructor with id
	 * @param id: Id of file
	 */
	public File(String id) {
		this.id = id;
	}

	/**
	 * Get the id of file
	 * @return: Id of file
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the new id of file
	 * @param id: New id for the file
	 */
	public void setId(String id) {
		this.id = id;
	}

	
	/**
	 * Get name of file
	 * @return: Name of file
	 */
	public String getName() {
		return name;
	}


	/**
	 * Set a new name for the file
	 * @param name: New name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Get the mime type of file
	 * @return: Mime type
	 */
	public String getMimeType() {
		return mimeType;
	}


	/**
	 * Set a new mime type
	 * @param mimeType: Mime type to set
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	/**
	 * Get data of file
	 * @return: Data of file
	 */
	public byte[] getData() {
		return data;
	}

	/**
	 * Set the data of file
	 * @param data: New data
	 */
	public void setData(byte[] data) {
		this.data = data;
	}

	/**
	 * Get the file size
	 * @return: Size of file
	 */
	public Long getSize() {
		return size;
	}


	/**
	 * Set the new size for file
	 * @param size: New size
	 */
	public void setSize(Long size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "File [name=" + name + ", mimeType=" + mimeType + ", size=" + size + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		File other = (File) obj;
		return Objects.equals(id, other.id);
	}
	
}
