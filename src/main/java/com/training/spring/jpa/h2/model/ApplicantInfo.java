package com.training.spring.jpa.h2.model;

import javax.persistence.*;

@Entity
@Table(name = "ApplicantInfo")
public class ApplicantInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "surName")
	private String surName;

	@Column(name = "personalId")
	private Long personalId;

	@Column(name = "dob")
	private String dob;

	@Column(name = "age")
	private Long age;

	@Column(name = "email")
	public String email;

	@Column(name = "loanAmount")
	public Long loanAmount;

	@Column(name = "loanDecision")
	public String loanDecision;

	@Column(name = "loanPaymentStatus")
	public String loanPaymentStatus;

	@Column(name = "loanTerm")
	private Long loanTerm;

	@Column(name = "loanTermsPaid")
	private Integer loanTermsPaid;

	@Column(name = "unPaidPrincipal")
	private Long unPaidPrincipal;

	public ApplicantInfo() {

	}

	public ApplicantInfo(String name, String surName, Long personalId, String dob, String email, Long loanAmount,
			Long loanTerm, Long age, Integer loanTermsPaid, Long unPaidPrincipal) {

		this.name = name;
		this.surName = surName;
		this.personalId = personalId;
		this.dob = dob;
		this.email = email;
		this.loanAmount = loanAmount;
		this.loanTerm = loanTerm;
		this.age = age;
		this.loanTermsPaid = loanTermsPaid;
		this.unPaidPrincipal = unPaidPrincipal;
	}

	public ApplicantInfo(String name, String surName, Long personalId, String dob, String email) {

		this.name = name;
		this.surName = surName;
		this.personalId = personalId;
		this.dob = dob;
		this.email = email;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Long getPersonalId() {
		return personalId;
	}

	public void setPersonalId(Long personalId) {
		this.personalId = personalId;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanDecision() {
		return loanDecision;
	}

	public void setLoanDecision(String loanDecision) {
		this.loanDecision = loanDecision;
	}

	public String getLoanPaymentStatus() {
		return loanPaymentStatus;
	}

	public void setLoanPaymentStatus(String loanPaymentStatus) {
		this.loanPaymentStatus = loanPaymentStatus;
	}

	public Integer getLoanTermsPaid() {
		return loanTermsPaid;
	}

	public void setLoanTermsPaid(Integer loanTermsPaid) {
		this.loanTermsPaid = loanTermsPaid;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}



	public Long getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(Long loanTerm) {
		this.loanTerm = loanTerm;
	}

	public Long getUnPaidPrincipal() {
		return unPaidPrincipal;
	}

	public void setUnPaidPrincipal(Long unPaidPrincipal) {
		this.unPaidPrincipal = unPaidPrincipal;
	}

	@Override
	public String toString() {
		return "ApplicantInfo [id=" + id + ", name=" + name + ", surName=" + surName + ", personalId=" + personalId
				+ ", dob=" + dob + ", email=" + email + ", loanAmount=" + loanAmount + ", loanDecision=" + loanDecision
				+ ", loanPaymentStatus=" + loanPaymentStatus + ", loanTermsPaid=" + loanTermsPaid + ", unPaidPrincipal="
				+ unPaidPrincipal + "]";
	}

}
