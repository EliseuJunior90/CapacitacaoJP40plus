package br.com.indra.projeto_indra2026_jr.controller;

import br.com.indra.projeto_indra2026_jr.Entity.Categorias;
import br.com.indra.projeto_indra2026_jr.Entity.Produtos;
import br.com.indra.projeto_indra2026_jr.Service.CategoriasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriasService categoriasService; {

    }
