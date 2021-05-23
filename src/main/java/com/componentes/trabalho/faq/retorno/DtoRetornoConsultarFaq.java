package com.componentes.trabalho.faq.retorno;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoRetornoConsultarFaq implements Serializable {

    private Integer id;

    private String pergunta;

    private String resposta;


}
