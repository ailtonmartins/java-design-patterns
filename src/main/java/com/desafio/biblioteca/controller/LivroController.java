package com.desafio.biblioteca.controller;


import com.desafio.biblioteca.facade.BibliotecaFacade;
import com.desafio.biblioteca.model.Livro;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
@Tag(name = "Livros", description = "API para gerenciamento de livros")
public class LivroController {

    @Autowired
    private BibliotecaFacade bibliotecaFacade;

    @GetMapping
    @Operation(summary = "Listar todos os livros", description = "Retorna uma lista de todos os livros disponíveis")
    public List<Livro> listarLivros() {
        return bibliotecaFacade.listarLivros();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obter livro por ID", description = "Retorna um livro específico pelo seu ID")
    public Optional<Livro> obterLivro(@PathVariable Long id) {
        return bibliotecaFacade.obterLivroPorId(id);
    }

    @PostMapping
    @Operation(summary = "Adicionar novo livro", description = "Adiciona um novo livro à biblioteca")
    public Livro adicionarLivro(@RequestBody Livro livro) {
        return bibliotecaFacade.adicionarLivro(livro);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover livro por ID", description = "Remove um livro específico pelo seu ID")
    public void removerLivro(@PathVariable Long id) {
        bibliotecaFacade.removerLivro(id);
    }
}