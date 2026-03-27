package br.com.indra.projeto_indra2026_jr.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Produtos")

public class Produtos {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="codigo_barras", unique = true)
    private String codigoDeBarras;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private BigDecimal preco;
    
    @Column(name = "quantidade_estoque")
    private Integer quantidadeEstoque;

    @ManyToOne
    @JoinColumn(name = "categorias_id", nullable = false)
    private Categorias categorias;

}
