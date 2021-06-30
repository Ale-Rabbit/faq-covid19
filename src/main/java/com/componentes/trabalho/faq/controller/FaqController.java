package com.componentes.trabalho.faq.controller;

import com.componentes.trabalho.faq.entrada.DtoEntradaInserirFaq;
import com.componentes.trabalho.faq.retorno.DtoRetornoConsultarFaq;
import com.componentes.trabalho.faq.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Boolean> inserirFaq(@RequestBody DtoEntradaInserirFaq entrada){
        return ResponseEntity.ok().body(service.inserirFaq(entrada));
    }


}
