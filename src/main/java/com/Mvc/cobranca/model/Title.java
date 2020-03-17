package com.Mvc.cobranca.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Title {
	
	
	private Long code;
	private String description;
	private Date dataVencimento;
	private BigDecimal valor;
	private StatusTitle status;
}
