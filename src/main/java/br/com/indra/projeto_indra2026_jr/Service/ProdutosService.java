package br.com.indra.projeto_indra2026_jr.Service;

import br.com.indra.projeto_indra2026_jr.Entity.Produtos;
import br.com.indra.projeto_indra2026_jr.repository.ProdutosRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutosService {

    private final ProdutosRepository produtosRepository;

    public ProdutosService(ProdutosRepository produtosRepository) {
    this.produtosRepository = produtosRepository;}

    public void salvarProduto(Produtos produtos) {
        boolean jaExiste =  produtosRepository.existsBycodigoDeBarras(produtos.getCodigoDeBarras());
            if (jaExiste && !produtos.getCodigoDeBarras().equals(produtos.getCodigoDeBarras())) {
                throw new RuntimeException("Código de Barras já em uso");
            }
            produtos.setCodigoDeBarras(produtos.getCodigoDeBarras());
        produtosRepository.saveAndFlush(produtos);
    }

    public Produtos findById (Long id) {
        return produtosRepository.findById(id).orElseThrow(
                () -> new RuntimeException("ID do Produto não encontrado"));
    }

    public Produtos buscarPorNome (String nome) {
        return produtosRepository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Nome do Produto não encontrado"));
    }

    public Produtos buscarPorCodigo (String codigo) {
        return produtosRepository.findBycodigoDeBarras(codigo).orElseThrow(
                () -> new RuntimeException("codigo do Produto não encontrado"));
    }

    public void excluirProdutoPorCodigo(String codigo) {
        Produtos produto = produtosRepository.findBycodigoDeBarras(codigo).orElseThrow(
                () -> new RuntimeException("Código do Produto não encontrado"));
        produtosRepository.delete(produto);
    }

    public void excluirProdutoPorId(Long id) {
        Produtos produto = produtosRepository.findById(id).orElseThrow(
                () -> new RuntimeException("ID do Produto não encontrado"));
        produtosRepository.delete(produto);
    }

    public Produtos atualizarProdutoPorId (Long id, Produtos produtos) {
        Produtos produtoEntity = produtosRepository.findById(id).orElseThrow(() ->
            new RuntimeException("Produto não encontrado"));


        Produtos produtoAtualizado = Produtos.builder()
            .codigoDeBarras(produtos.getCodigoDeBarras()
            != null ? produtos.getCodigoDeBarras() : produtoEntity.getCodigoDeBarras())

            .descricao(produtos.getDescricao()
            != null ? produtos.getDescricao() : produtoEntity.getDescricao())

            .nome(produtos.getNome()
            != null ? produtos.getNome() : produtoEntity.getNome())

            .preco(produtos.getPreco() != null ? produtos.getPreco() : produtoEntity.getPreco())
            .build();

        produtosRepository.saveAndFlush(produtoAtualizado);
        return produtoEntity;
    }


}
