package br.com.indra.projeto_indra2026_jr.repository;

import br.com.indra.projeto_indra2026_jr.Entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



import java.util.Optional;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

    boolean existsBycodigoDeBarras (String codigo);

    Optional<Produtos> findBycodigoDeBarras(String codigo);
    Optional<Produtos> findById(Long id);
    Optional<Produtos> findByNome(String nome);

    @Transactional
    void deleteBycodigoDeBarras(String codigo);
    @Transactional
    void deleteById(Long id);

}
