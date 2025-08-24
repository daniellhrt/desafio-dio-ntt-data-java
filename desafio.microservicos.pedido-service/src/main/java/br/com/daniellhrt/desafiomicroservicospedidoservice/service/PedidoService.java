package br.com.daniellhrt.desafiomicroservicospedidoservice.service;


import br.com.daniellhrt.desafiomicroservicospedidoservice.client.ProdutoClient;
import br.com.daniellhrt.desafiomicroservicospedidoservice.client.ProdutoDTO;
import br.com.daniellhrt.desafiomicroservicospedidoservice.dto.ItemPedidoRequestDTO;
import br.com.daniellhrt.desafiomicroservicospedidoservice.dto.ItemPedidoResponseDTO;
import br.com.daniellhrt.desafiomicroservicospedidoservice.dto.PedidoRequestDTO;
import br.com.daniellhrt.desafiomicroservicospedidoservice.dto.PedidoResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final ProdutoClient produtoClient;

    public PedidoService(ProdutoClient produtoClient) {
        this.produtoClient = produtoClient;
    }

    public PedidoResponseDTO simular(PedidoRequestDTO req) {
        List<ItemPedidoResponseDTO> itens = new ArrayList<>();
        double total = 0.0;

        for (ItemPedidoRequestDTO item : req.itens()) {
            ProdutoDTO produto = produtoClient.buscar(item.produtoId());
            double subtotal = produto.preco() * item.quantidade();
            total += subtotal;
            itens.add(new ItemPedidoResponseDTO(produto.id(), produto.nome(), produto.preco(), item.quantidade(), subtotal));
        }

        return new PedidoResponseDTO(itens, total);
    }
}
