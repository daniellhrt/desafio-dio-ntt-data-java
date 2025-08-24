package br.com.daniellhrt.desafiomicroservicospedidoservice.dto;

public record ItemPedidoResponseDTO(
        Long produtoId,
        String nome,
        double precoUnitario,
        int quantidade,
        double subtotal
) {

}

