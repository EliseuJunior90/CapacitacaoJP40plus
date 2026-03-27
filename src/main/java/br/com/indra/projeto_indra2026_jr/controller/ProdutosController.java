package br.com.indra.projeto_indra2026_jr.controller;

import br.com.indra.projeto_indra2026_jr.Service.ProdutosService;
import br.com.indra.projeto_indra2026_jr.Entity.Produtos;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutosController {

    private final ProdutosService produtosService;


    @PostMapping
    public ResponseEntity<Void> salvarProdutos(@RequestBody Produtos produtos) {
        produtosService.salvarProduto(produtos);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/codigo")
    public ResponseEntity<Produtos> buscarPorCodigo(@RequestParam String codigo) {
        return ResponseEntity.ok(produtosService.buscarPorCodigo(codigo));
    }

    @GetMapping("/id")
    public ResponseEntity<Produtos> findById (@RequestParam Long id) {
        return ResponseEntity.ok(produtosService.findById(id));
    }

    @GetMapping("/nome")
    public ResponseEntity<Produtos> buscarPorNome (@RequestParam String nome) {
        return ResponseEntity.ok(produtosService.buscarPorNome(nome));
    }

    @DeleteMapping
    public ResponseEntity<Void> excluirProduto(@RequestParam String codigo) {
        produtosService.excluirProdutoPorCodigo(codigo);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> excluirProdutoPorId(@RequestParam Long id) {
        produtosService.excluirProdutoPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produtos> atualizarProdutos(@PathVariable Long id, @RequestBody Produtos produtos) {
        return ResponseEntity.ok(produtosService.atualizarProdutoPorId(id, produtos));

    }
}