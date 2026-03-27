package br.com.indra.projeto_indra2026_jr.controller;

import br.com.indra.projeto_indra2026_jr.Entity.Categorias;
import br.com.indra.projeto_indra2026_jr.Service.CategoriasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriasService categoriasService;

    @PostMapping
    public ResponseEntity<Categorias> salvarCategoria(@RequestBody Categorias categorias) {
        return ResponseEntity.ok(categoriasService.salvarCategoria(categorias));
    }

    @GetMapping
    public ResponseEntity<List<Categorias>> findAll() {
        return ResponseEntity.ok(categoriasService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorias> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriasService.findById(id));
    }

    @GetMapping("/nome")
    public ResponseEntity<Categorias> findByNome(@RequestParam String nome) {
        return ResponseEntity.ok(categoriasService.findByNome(nome));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        categoriasService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categorias> atualizarCategoria(@PathVariable Long id, @RequestBody Categorias categorias) {
        return ResponseEntity.ok(categoriasService.atualizarCategoriaPorId(id, categorias));
    }
}