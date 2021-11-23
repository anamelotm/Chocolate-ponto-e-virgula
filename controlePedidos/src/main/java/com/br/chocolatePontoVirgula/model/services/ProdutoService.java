package com.br.chocolatePontoVirgula.model.services;

import com.br.chocolatePontoVirgula.model.entity.Produto;
import com.br.chocolatePontoVirgula.model.form.ProdutoForm;
import com.br.chocolatePontoVirgula.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public void save(@Validated ProdutoForm produto) {
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


    public void update(@PathVariable Long id, Produto produto){

        Produto produtoPesquisado = produtoRepository.getById(id);

        if(produtoPesquisado != null){
            produtoPesquisado.setNome(produto.getNome());
            produtoRepository.save(produtoPesquisado);
        }
    }

    public void delete(Long id){
        produtoRepository.deleteById(id);
    }

    public Page<Produto> findAll(Pageable pageable) {


        return produtoRepository.findAll(pageable);

    }

    public ResponseEntity<Produto> findById(Long id) {
        Produto produto = produtoRepository.findById(id).get();
        return ResponseEntity.ok().body(produto);
    }

    public void inativar(Long id){
        Produto produtoExcluir = produtoRepository.getById(id);
        produtoExcluir.setStatus(false);
        produtoRepository.save(produtoExcluir);
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
