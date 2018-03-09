package com.webcps.webcps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webcps.webcps.model.TrTfTransfast;

@Repository
public interface TrTfTransfastRepo extends JpaRepository<TrTfTransfast, String> {

}
