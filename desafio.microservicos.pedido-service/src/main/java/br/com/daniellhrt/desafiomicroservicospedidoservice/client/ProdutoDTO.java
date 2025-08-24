package br.com.daniellhrt.desafiomicroservicospedidoservice.client;

public record ProdutoDTO(
        Long id,
        String nome,
        String descricao,
        Double preco
) {

}
