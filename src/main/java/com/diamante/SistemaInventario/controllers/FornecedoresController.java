package com.diamante.SistemaInventario.controllers;

import com.diamante.SistemaInventario.models.Fornecedores;
import com.diamante.SistemaInventario.services.FornecedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedoresController {

    @Autowired
    private FornecedoresService service;

    @GetMapping
    public List<Fornecedores> getFornecedores() {
        return service.getFornecedores();
    }

    @PostMapping
    public ResponseEntity<Fornecedores> addFornecedor(@RequestBody Fornecedores fornecedor) {
        var novoFornecedor = service.addFornecedor(fornecedor);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novoFornecedor);
    }

    @GetMapping("{id}")
    public ResponseEntity<Fornecedores> getFornecedorById(@PathVariable Long id) {
        return service.getFornecedorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFornecedor(@PathVariable Long id) {
        service.deleteFornecedor(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Fornecedores> updateFornecedor(@PathVariable Long id, @RequestBody Fornecedores newFornecedor) {
        Fornecedores fornecedor = service.updateFornecedor(id, newFornecedor);
        return ResponseEntity.ok(fornecedor);
    }
}
