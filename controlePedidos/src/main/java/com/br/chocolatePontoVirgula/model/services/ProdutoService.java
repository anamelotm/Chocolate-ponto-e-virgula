package com.br.chocolatePontoVirgula.model.services;

import com.br.chocolatePontoVirgula.model.entity.Cliente;
import com.br.chocolatePontoVirgula.model.entity.ItemPedido;
import com.br.chocolatePontoVirgula.model.entity.Produto;
import com.br.chocolatePontoVirgula.model.form.ProdutoForm;
import com.br.chocolatePontoVirgula.model.repository.ItemPedidoRepository;
import com.br.chocolatePontoVirgula.model.repository.ProdutoRepository;
import com.br.chocolatePontoVirgula.model.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public void save(@Validated ProdutoForm produto) {
        //pega os dados do produtoForm e atribuindo a um produto
        Produto p = new Produto();
        p.setNome(produto.getNome());
        p.setDescricaoProduto(produto.getDescricaoProduto());
        p.setUnidadeMedida(produto.getUnidadeMedida());
        p.setValorUnitario(produto.getValorUnitario());
        p.setStatus(produto.isStatus());
        p.setUrlFoto(produto.getUrlFoto());
        p.setPeso(produto.getPeso());
        p.setDataFabricacao((java.sql.Date.valueOf(produto.getDataFabricacao())));
        p.setDataValidade((java.sql.Date.valueOf(produto.getDataValidade())));
        p.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        produtoRepository.save(p);
    }

    public ResponseEntity<String> update(Long id, Produto produto){
        Produto produtoPesquisado = produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto não encontrado."));

        produtoPesquisado.setNome(produto.getNome());
        produtoRepository.save(produtoPesquisado);
        return ResponseEntity.ok().body("Produto alterado com sucesso!");

    }

    //verificar antes de excluir um produto para ver se ele está na tabela itemPedido
    public ResponseEntity<String> delete(Long id) throws URISyntaxException {
        Produto p = produtoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Produto não encontrado."));

        URI uri = new URI("http://localhost:8080/itens-pedidos/produtosnoitem/" + id);
        ResponseEntity<List<ItemPedido>> qnt = ResponseEntity.created(uri).body(itemPedidoRepository.produtoHasPedido(id));

        if(!qnt.getBody().isEmpty()){
            return ResponseEntity.badRequest().body("Existem pedidos com esse produto");
        } else {
            produtoRepository.deleteById(id);
            return ResponseEntity.ok().body("Produto excluído");
        }
    }

    public Page<Produto> findAll(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Produto não encontrado."));
    }

    public ResponseEntity<String> inativar(Long id){
        Produto produtoExcluir = produtoRepository.getById(id);
        produtoExcluir.setStatus(false);
        produtoRepository.save(produtoExcluir);
        return ResponseEntity.ok().body("Produto inativado com sucesso!");
    }

    public List<Produto> consultaProdutosAtivos() {
        return produtoRepository.findByStatusTrue();
    }

    public void atualizarEstoque(Long id, Produto p){
        Optional<Produto> byId = produtoRepository.findById(id);
        if(byId.isPresent()){ produtoRepository.atualizarEstoque(id, p.getQuantidadeEstoque());
        }
    }

    public Integer verificarEstoque(Produto produto){
        Produto produtoEstoque = produtoRepository.getById(produto.getId());
        return produtoEstoque.getQuantidadeEstoque();
    }

}
