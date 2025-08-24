package br.com.daniellhrt.desafiomicroservicospedidoservice.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record PedidoRequestDTO(@NotNull List<ItemPedidoRequestDTO> itens) {
}
