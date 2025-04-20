package com.projetofinal.projetofinal.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetofinal.projetofinal.models.PessoaModel;
import com.projetofinal.projetofinal.repositories.PessoaRepository;

import lombok.AllArgsConstructor;




@RestController
@RequestMapping("/pessoas")
@CrossOrigin("*")
@AllArgsConstructor

public class PessoaController {
    private PessoaRepository pessoaRepository;

    @GetMapping
    public ResponseEntity<List<PessoaModel>> pegaTodasAsPessoas(){
        return new ResponseEntity<>(pessoaRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PessoaModel> criarNovaPessoa(@RequestBody PessoaModel novaPessoa) {
        novaPessoa.setId(null);
        return new ResponseEntity<>(pessoaRepository.save(novaPessoa), HttpStatus.OK);
    }
    
    @PutMapping
        public ResponseEntity<PessoaModel> editarPessoa(@RequestBody PessoaModel atualizaPessoa){
        
        return new ResponseEntity<>(pessoaRepository.save(atualizaPessoa), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PessoaModel> deletarPessoa(@PathVariable Integer id){

        pessoaRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
