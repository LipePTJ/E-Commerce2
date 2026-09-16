package com.biolab.ecommerce.services;

import com.biolab.ecommerce.DTOs.UsuarioDTO;
import com.biolab.ecommerce.entities.Usuario;
import com.biolab.ecommerce.entities.enums.Role;
import com.biolab.ecommerce.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;
    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public String criar(UsuarioDTO u){

        Usuario usuario = new Usuario();
        usuario.setEmail(u.getEmail());
        usuario.setNome(u.getNome());
        usuario.setSenha(u.getSenha());
        usuario.setTelefone(u.getTelefone());
        usuario.setRoles(Role.USER);
        repo.save(usuario);
        return "Usuario criado com sucesso!" ;
    }


}
