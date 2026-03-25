package com.diamante.SistemaInventario.services;

import com.diamante.SistemaInventario.Repositorys.FornecedoresRepository;
import com.diamante.SistemaInventario.models.Fornecedores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedoresService {
    @Autowired
    private FornecedoresRepository repository;

    public List<Fornecedores> getFornecedores() {
        return repository.findAll();
    }

    public Fornecedores addFornecedor(Fornecedores fornecedor) {
        return repository.save(fornecedor);
    }

    public Optional<Fornecedores> getFornecedorById(Long id) {
        return repository.findById(id);
    }

    private Fornecedores findFornecedorOrThrow(Long id) {
        return getFornecedorById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));
    }

    public void deleteFornecedor(Long id) {
        findFornecedorOrThrow(id);
        repository.deleteById(id);
    }

    public Fornecedores updateFornecedor(Long id, Fornecedores newFornecedor) {
        findFornecedorOrThrow(id);
        newFornecedor.setId(id);
        return repository.save(newFornecedor);
    }
}
