package com.training.spring.jpa.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.spring.jpa.h2.model.ApplicantInfo;

public interface ApplicantRepository extends JpaRepository<ApplicantInfo, Long> {

	ApplicantInfo findByPersonalId(Long personalId);

}
