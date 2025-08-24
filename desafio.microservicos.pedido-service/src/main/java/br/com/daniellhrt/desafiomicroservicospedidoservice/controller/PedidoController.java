package br.com.daniellhrt.desafiomicroservicospedidoservice.controller;


import br.com.daniellhrt.desafiomicroservicospedidoservice.dto.PedidoRequestDTO;
import br.com.daniellhrt.desafiomicroservicospedidoservice.dto.PedidoResponseDTO;
import br.com.daniellhrt.desafiomicroservicospedidoservice.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping

    public ResponseEntity<PedidoResponseDTO> simular(@RequestBody @Valid PedidoRequestDTO request) {
        return ResponseEntity.ok(service.simular(request));
    }
}
