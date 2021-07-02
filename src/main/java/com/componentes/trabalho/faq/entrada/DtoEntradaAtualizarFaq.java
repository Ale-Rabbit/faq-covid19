package com.componentes.trabalho.faq.entrada;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoEntradaAtualizarFaq {

    private Integer id;

    private String pergunta;

    private String resposta;

}
