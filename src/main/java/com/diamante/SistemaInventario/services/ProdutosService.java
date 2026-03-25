package com.diamante.SistemaInventario.services;

import com.diamante.SistemaInventario.Repositorys.ProdutosRepository;
import com.diamante.SistemaInventario.models.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {
    @Autowired
    private ProdutosRepository repository;

    public List<Produtos> getProdutos() {
        return repository.findAll();
    }

    public Produtos addProduto(Produtos produtos) {
        return repository.save(produtos);
    }

    public Optional<Produtos> getProdutoById(Long id) {
        return repository.findById(id);
    }

    private Produtos findProdutoOrThrow(Long id) {
        return getProdutoById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }

    public void deleteProduto(Long id) {
        findProdutoOrThrow(id);
        repository.deleteById(id);
    }

    public Produtos updateProduto(Long id, Produtos newProduto) {
        findProdutoOrThrow(id);
        newProduto.setId(id);
        return repository.save(newProduto);
    }
}
