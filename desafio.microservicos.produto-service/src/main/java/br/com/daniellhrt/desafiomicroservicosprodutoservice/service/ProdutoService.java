package br.com.daniellhrt.desafiomicroservicosprodutoservice.service;

import br.com.daniellhrt.desafiomicroservicosprodutoservice.model.dto.ProdutoRequestDTO;
import br.com.daniellhrt.desafiomicroservicosprodutoservice.model.dto.ProdutoResponseDTO;
import br.com.daniellhrt.desafiomicroservicosprodutoservice.model.Produto;
import br.com.daniellhrt.desafiomicroservicosprodutoservice.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repo) {
        this.repository = repo;
    }

    public ProdutoResponseDTO criar(ProdutoRequestDTO request) {
        var produto = repository.save(new Produto(null, request.nome(), request.descricao(), request.preco()));
        return toResp(produto);
    }

    public List<ProdutoResponseDTO> listar() {
        return repository.findAll().stream().map(this::toResp).toList();
    }

    public ProdutoResponseDTO buscar(Long id) {
        var produto = repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return toResp(produto);
    }

    public Produto toEntity(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    private ProdutoResponseDTO toResp(Produto produto) {
        return new ProdutoResponseDTO(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco());
    }
}

