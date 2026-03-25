package com.diamante.SistemaInventario.Repositorys;

import com.diamante.SistemaInventario.models.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
}
