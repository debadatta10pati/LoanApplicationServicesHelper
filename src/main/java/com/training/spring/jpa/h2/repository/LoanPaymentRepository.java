package com.training.spring.jpa.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.spring.jpa.h2.model.ApplicantInfo;
import com.training.spring.jpa.h2.model.LoanPayment;

public interface LoanPaymentRepository extends JpaRepository<LoanPayment, Long> {

	LoanPayment findByPersonalId(Long personalId);

}
