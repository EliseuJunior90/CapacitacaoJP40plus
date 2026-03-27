package br.com.indra.projeto_indra2026_jr.repository;

import br.com.indra.projeto_indra2026_jr.Entity.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

    boolean existsByNome(String nome);

}
