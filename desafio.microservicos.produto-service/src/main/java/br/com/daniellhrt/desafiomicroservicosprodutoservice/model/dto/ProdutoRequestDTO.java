package br.com.daniellhrt.desafiomicroservicosprodutoservice.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProdutoRequestDTO(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotNull
        @Positive
        Double preco
) {
}
