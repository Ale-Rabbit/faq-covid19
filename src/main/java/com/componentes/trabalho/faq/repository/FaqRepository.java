package com.componentes.trabalho.faq.repository;

import com.componentes.trabalho.faq.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepository extends JpaRepository<Faq, Integer> {
}
