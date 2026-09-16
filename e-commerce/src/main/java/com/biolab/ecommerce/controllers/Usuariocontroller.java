package com.biolab.ecommerce.controllers;

import com.biolab.ecommerce.DTOs.UsuarioDTO;
import com.biolab.ecommerce.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class Usuariocontroller {

    private final UsuarioService service;
    public Usuariocontroller(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UsuarioDTO dto){
        return ResponseEntity.ok(service.criar(dto));
    }



}
