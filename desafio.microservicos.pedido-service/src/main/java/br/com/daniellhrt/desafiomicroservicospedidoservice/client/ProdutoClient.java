package br.com.daniellhrt.desafiomicroservicospedidoservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "produto-service")
public interface ProdutoClient {

    @GetMapping("/produtos/{id}")
    ProdutoDTO buscar(@PathVariable("id") Long id);
}
