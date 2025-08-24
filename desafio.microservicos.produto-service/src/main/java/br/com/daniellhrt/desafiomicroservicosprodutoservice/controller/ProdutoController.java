package br.com.daniellhrt.desafiomicroservicosprodutoservice.controller;


import br.com.daniellhrt.desafiomicroservicosprodutoservice.model.dto.ProdutoRequestDTO;
import br.com.daniellhrt.desafiomicroservicosprodutoservice.model.dto.ProdutoResponseDTO;
import br.com.daniellhrt.desafiomicroservicosprodutoservice.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService service;
    public ProdutoController(ProdutoService service){ this.service = service; }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criar(@RequestBody @Valid ProdutoRequestDTO request){
        return ResponseEntity.ok(service.criar(request));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscar(@PathVariable Long id){
        return ResponseEntity.ok(service.buscar(id));
    }
}

