package com.componentes.trabalho.faq.service;

import com.componentes.trabalho.faq.entity.Faq;
import com.componentes.trabalho.faq.entrada.DtoEntradaAtualizarFaq;
import com.componentes.trabalho.faq.entrada.DtoEntradaInserirFaq;
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

    public Boolean inserirFaq(DtoEntradaInserirFaq entrada){

        Faq novaFaq = Faq.builder()
                         .pergunta(entrada.getPergunta())
                         .resposta(entrada.getResposta())
                         .build();

        return (repository.save(novaFaq) != null);

    }

    public Boolean atualizarFaq(DtoEntradaAtualizarFaq entrada){

        Faq faqBase = repository.getById(entrada.getId());

        if(faqBase != null){

            faqBase.setPergunta(entrada.getPergunta());
            faqBase.setResposta(entrada.getResposta());

        }

        return (repository.save(faqBase) != null);

    }

    public Boolean deletarFaq(Integer id) {

        try {

            repository.deleteById(id);

        } catch (Exception e){
            return false;
        }

        return true;

    }


}
