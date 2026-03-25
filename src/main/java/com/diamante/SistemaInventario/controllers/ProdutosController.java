package com.diamante.SistemaInventario.controllers;

import com.diamante.SistemaInventario.models.Produtos;
import com.diamante.SistemaInventario.services.ProdutosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService service;

    @GetMapping
    public List<Produtos> getProdutos() {
        return service.getProdutos();
    }

    @PostMapping
    public ResponseEntity<Produtos> addProduto(@RequestBody Produtos produto) {
        var novoProduto = service.addProduto(produto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novoProduto);
    }

    @GetMapping("{id}")
    public ResponseEntity<Produtos> getProdutoById(@PathVariable Long id) {
        return service.getProdutoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        service.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Produtos> updateProduto(@PathVariable Long id, @RequestBody Produtos newProduto) {
        Produtos produto = service.updateProduto(id, newProduto);
        return ResponseEntity.ok(produto);
    }
}
