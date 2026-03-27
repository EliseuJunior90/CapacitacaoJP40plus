package br.com.indra.projeto_indra2026_jr.repository;

import br.com.indra.projeto_indra2026_jr.Entity.Categorias;
import br.com.indra.projeto_indra2026_jr.Entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

    boolean existsByNome(String nome);

    Optional<Categorias> findById(Long id);
    Optional<Categorias> findByNome(String nome);

    @Transactional
    void deleteById(Long id);
}
