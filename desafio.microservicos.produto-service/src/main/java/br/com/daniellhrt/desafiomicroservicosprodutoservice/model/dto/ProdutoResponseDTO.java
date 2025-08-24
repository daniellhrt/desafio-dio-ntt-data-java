package br.com.daniellhrt.desafiomicroservicosprodutoservice.model.dto;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        String descricao,
        Double preco
) {
}
