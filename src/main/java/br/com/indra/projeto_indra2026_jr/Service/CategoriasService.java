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

    public static Categorias salvar(Categorias categoria) {
        return null;
    }

    public Categorias salcarCategoria (Categorias categorias) {
        if (categoriasRepository.existsByNome(categorias.getNome())) {
            throw new RuntimeException("Categoria já existe");
        }
        return categoriasRepository.save(categorias);
    }


}



