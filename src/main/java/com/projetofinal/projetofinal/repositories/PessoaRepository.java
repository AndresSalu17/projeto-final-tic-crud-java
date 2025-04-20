package com.projetofinal.projetofinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetofinal.projetofinal.models.PessoaModel;

public interface PessoaRepository extends JpaRepository <PessoaModel, Integer> {
    
}
