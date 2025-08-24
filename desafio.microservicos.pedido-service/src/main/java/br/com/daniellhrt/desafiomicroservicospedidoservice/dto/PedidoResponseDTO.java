package br.com.daniellhrt.desafiomicroservicospedidoservice.dto;

import java.util.List;

public record PedidoResponseDTO(
        List<ItemPedidoResponseDTO> itens,
        double total) {
}
