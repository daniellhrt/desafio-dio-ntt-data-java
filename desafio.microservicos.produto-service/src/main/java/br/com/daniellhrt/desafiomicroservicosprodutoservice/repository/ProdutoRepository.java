package br.com.daniellhrt.desafiomicroservicosprodutoservice.repository;

import br.com.daniellhrt.desafiomicroservicosprodutoservice.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
