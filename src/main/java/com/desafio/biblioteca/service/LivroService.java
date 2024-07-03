package com.desafio.biblioteca.service;

import com.desafio.biblioteca.model.Livro;
import com.desafio.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private static LivroService instance;

    @Autowired
    private LivroRepository livroRepository;

    private LivroService() {}

    public static LivroService getInstance() {
        if (instance == null) {
            instance = new LivroService();
        }
        return instance;
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Optional<Livro> obterPorId(Long id) {
        return livroRepository.findById(id);
    }

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }
}