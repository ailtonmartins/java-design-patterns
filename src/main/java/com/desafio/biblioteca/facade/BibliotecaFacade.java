package com.desafio.biblioteca.facade;

import com.desafio.biblioteca.model.Livro;
import com.desafio.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BibliotecaFacade {

    @Autowired
    private LivroService livroService;

    public List<Livro> listarLivros() {
        return livroService.listarTodos();
    }

    public Optional<Livro> obterLivroPorId(Long id) {
        return livroService.obterPorId(id);
    }

    public Livro adicionarLivro(Livro livro) {
        return livroService.salvar(livro);
    }

    public void removerLivro(Long id) {
        livroService.deletar(id);
    }
}