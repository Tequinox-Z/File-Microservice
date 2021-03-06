package com.tx.practisesmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tx.practisesmanagement.model.File;

/**
 * Repository for files
 * @author Salvador
 */
@Repository
public interface FileRepository extends JpaRepository<File, String> {

}
