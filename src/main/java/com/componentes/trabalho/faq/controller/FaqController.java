package com.componentes.trabalho.faq.controller;

import com.componentes.trabalho.faq.retorno.DtoRetornoConsultarFaq;
import com.componentes.trabalho.faq.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/faq")
public class FaqController {

    @Autowired
    public FaqService service;

    @GetMapping
    public ResponseEntity<List<DtoRetornoConsultarFaq>> consultarFaq(){
        return ResponseEntity.ok().body(service.consultarFaq());
    }

}
