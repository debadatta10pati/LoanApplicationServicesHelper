package com.training.spring.jpa.h2.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.jpa.h2.model.ApplicantInfo;
import com.training.spring.jpa.h2.model.LoanPayment;
import com.training.spring.jpa.h2.repository.ApplicantRepository;
import com.training.spring.jpa.h2.repository.LoanPaymentRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/loan")
public class LoanController {

	@Autowired
	ApplicantRepository applicantRepository;

	@Autowired
	LoanPaymentRepository loanPaymentRepository;

	@GetMapping("/getApplicant/{personalId}")
	public ResponseEntity<ApplicantInfo> getApplicantByPersonalId(@PathVariable("personalId") long personalId) {
		ApplicantInfo applicantData = applicantRepository.findByPersonalId(personalId);

		return new ResponseEntity<>(applicantData, HttpStatus.OK);

	}

	@PostMapping("/saveApplicant")
	public ResponseEntity<ApplicantInfo> createApplicant(@RequestBody ApplicantInfo applicant) {
		System.out.println(" Loan application received : applicant name =  " + applicant.getName());
		try {
			ApplicantInfo applicantInfo = applicantRepository.save(new ApplicantInfo(applicant.getName(),
					applicant.getSurName(), applicant.getPersonalId(), applicant.getDob(), applicant.getEmail(),
					applicant.getLoanAmount(), applicant.getLoanTerm(), applicant.getAge(),0,applicant.getLoanAmount()));
			return new ResponseEntity<>(applicantInfo, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateLoanDecisionByLoanDepartment")
	public ResponseEntity<ApplicantInfo> updateLoanDecisionByLoanDepartment(@RequestBody ApplicantInfo applicant) {
		System.out.println(" Loan decision received : applicant personal Id =  " + applicant.getPersonalId());
		try {
			ApplicantInfo applicantData = applicantRepository.findByPersonalId(applicant.getPersonalId());
			applicantData.setLoanDecision(applicant.getLoanDecision());
			return new ResponseEntity<>(applicantRepository.save(applicantData), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/loanPaymentDoneByCustomer")
	public ResponseEntity<ApplicantInfo> loanPaymentDoneByCustomer(@RequestBody LoanPayment loanPayment) {
		System.out.println(" Loan payment received : applicant personalId =  " + loanPayment.getPersonalId());
		try {
			LoanPayment loanPaymentInfo = loanPaymentRepository
					.save(new LoanPayment(loanPayment.getPaymentAmount(), loanPayment.getPersonalId(), new Date()));

			ApplicantInfo applicantData = applicantRepository.findByPersonalId(loanPayment.getPersonalId());

			Integer loanTermsPaid = applicantData.getLoanTermsPaid();
			
			if(loanTermsPaid!=null)
			{
				applicantData.setLoanTermsPaid(loanTermsPaid + 1);
			}
			else
			{
				applicantData.setLoanTermsPaid(1);
			}

			
			if (applicantData.getLoanAmount().equals(applicantData.getUnPaidPrincipal())) {

				applicantData.setUnPaidPrincipal(applicantData.getLoanAmount() - loanPayment.getPaymentAmount());
			} else if (applicantData.getLoanAmount() > applicantData.getUnPaidPrincipal()) {
				applicantData.setUnPaidPrincipal(applicantData.getUnPaidPrincipal() - loanPayment.getPaymentAmount());
			}
			applicantRepository.save(applicantData);

			return new ResponseEntity<>(null, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/updateLoanPaymentStatus")
	public ResponseEntity<ApplicantInfo> updateLoanPaymentStatus(@RequestBody ApplicantInfo applicantInfo) {
		System.out.println(" Loan payment status update : applicant personalId =  " + applicantInfo.getPersonalId());
		try {

			ApplicantInfo applicantData = applicantRepository.findByPersonalId(applicantInfo.getPersonalId());

			applicantData.setLoanPaymentStatus(applicantInfo.getLoanPaymentStatus());

			applicantRepository.save(applicantData);

			return new ResponseEntity<>(null, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
