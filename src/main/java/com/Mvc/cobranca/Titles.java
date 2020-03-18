package com.Mvc.cobranca;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Mvc.cobranca.model.Title;

public interface Titles extends JpaRepository<Title, Long> {

}
