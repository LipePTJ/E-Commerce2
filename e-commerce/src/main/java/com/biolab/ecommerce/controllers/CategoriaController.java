package com.biolab.ecommerce.controllers;

import com.biolab.ecommerce.DTOs.CategoriaDTO;
import com.biolab.ecommerce.services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService service;
    public CategoriaController(CategoriaService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<?> criarCat(@RequestBody CategoriaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarCategoria(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCat(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.buscarCatId(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCat(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<?> buscarTodasCat(){
        return ResponseEntity.ok(service.buscarTodasCat());
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCat(@PathVariable Long id, @RequestBody CategoriaDTO dto) {
        CategoriaDTO categoriaAtualizada = service.atualizarCat(id, dto);
        return ResponseEntity.ok(categoriaAtualizada);
    }
}

