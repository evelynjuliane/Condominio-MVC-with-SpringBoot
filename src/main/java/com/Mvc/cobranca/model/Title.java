package com.Mvc.cobranca.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Title {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	
	private BigDecimal value;
	
	@Enumerated(EnumType.STRING)
	private StatusTitle status;
	
	
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getdDueDate() {
		return dueDate;
	}
	public void setDataVencimento(Date dueDate) {
		this.dueDate = dueDate;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValor(BigDecimal value) {
		this.value = value;
	}
	public StatusTitle getStatus() {
		return status;
	}
	public void setStatus(StatusTitle status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Title other = (Title) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	
}
