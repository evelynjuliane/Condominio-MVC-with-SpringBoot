package com.Mvc.cobranca.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.Mvc.cobranca.model.Title;
import com.Mvc.cobranca.repository.Titles;

@Service
public class CreateTitleServices {
	
	@Autowired 
	private Titles titles;
	
	public void save(Title title){
		try {
			titles.save(title);
		}catch(DataIntegrityViolationException e){
			throw new IllegalArgumentException("Formato de data inválido");
		}
		
	}

}
