package com.componentes.trabalho.faq.service;

import com.componentes.trabalho.faq.entity.Faq;
import com.componentes.trabalho.faq.repository.FaqRepository;
import com.componentes.trabalho.faq.retorno.DtoRetornoConsultarFaq;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FaqService {

    @Autowired
    private FaqRepository repository;

    public List<DtoRetornoConsultarFaq> consultarFaq (){

        List<DtoRetornoConsultarFaq> retorno = new ArrayList<>();
        List<Faq> faq = repository.findAll();

        if(faq != null && !faq.isEmpty()){

            retorno = faq.stream().map(f -> {

                return DtoRetornoConsultarFaq.builder()
                                             .id(f.getId())
                                             .pergunta(f.getPergunta())
                                             .resposta(f.getResposta())
                                             .build();

            }).collect(Collectors.toList());

        }

        return retorno;

    }

}