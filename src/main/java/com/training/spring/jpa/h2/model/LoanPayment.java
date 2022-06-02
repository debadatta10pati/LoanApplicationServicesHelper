package com.training.spring.jpa.h2.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LoanPayment")
public class LoanPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "paymentAmount")
	private Long paymentAmount;

	@Column(name = "personalId")
	private Long personalId;

	@Column(name = "paymentDate")
	private Date paymentDate;

	public LoanPayment() {

	}
	
	

	public LoanPayment(Long paymentAmount, Long personalId, Date paymentDate) {
		this.paymentAmount = paymentAmount;
		this.personalId = personalId;
		this.paymentDate = paymentDate;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Long getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Long paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Long getPersonalId() {
		return personalId;
	}

	public void setPersonalId(Long personalId) {
		this.personalId = personalId;
	}

}
