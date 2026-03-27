package br.com.indra.projeto_indra2026_jr.Service;

import br.com.indra.projeto_indra2026_jr.Entity.Categorias;
import br.com.indra.projeto_indra2026_jr.repository.CategoriasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoriasService {

    private final CategoriasRepository categoriasRepository;

    public CategoriasService(CategoriasRepository categoriasRepository) {
    this.categoriasRepository = categoriasRepository;
    }

    public Categorias salvarCategoria(Categorias categorias) {
        if (categoriasRepository.existsByNome(categorias.getNome())) {
            throw new RuntimeException("Categoria já existe");
        }
        return categoriasRepository.save(categorias);
    }

    public List<Categorias> findAll() {
        return categoriasRepository.findAll();
    }

    public Categorias findById(Long id) {
        return categoriasRepository.findById(id).orElseThrow(
                () -> new RuntimeException("ID da Categoria não encontrado"));
    }

    public Categorias findByNome(String nome) {
        return categoriasRepository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Nome da Categoria não encontrado"));
    }

    public void deleteById(Long id) {
        Categorias categoria = categoriasRepository.findById(id).orElseThrow(
                () -> new RuntimeException("ID da Categoria não encontrado"));
        categoriasRepository.delete(categoria);
    }

    public Categorias atualizarCategoriaPorId(Long id, Categorias categorias) {
        Categorias categoriaEntity = categoriasRepository.findById(id).orElseThrow(() ->
            new RuntimeException("Categoria não encontrada"));

        Categorias categoriaAtualizada = Categorias.builder()
            .id(id)
            .nome(categorias.getNome() != null ? categorias.getNome() : categoriaEntity.getNome())
            .build();

        categoriasRepository.saveAndFlush(categoriaAtualizada);
        return categoriaEntity;
    }

}
