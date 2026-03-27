package br.com.indra.projeto_indra2026_jr.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Categorias")
@Getter
@Setter
@Builder
public class Categorias {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(nullable = false, updatable = false)

    private Long id;
    private String nome;


    @OneToMany
    private List<Produtos> produtos;

}
