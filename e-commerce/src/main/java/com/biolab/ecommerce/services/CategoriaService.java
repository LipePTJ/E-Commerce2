package com.biolab.ecommerce.services;

import com.biolab.ecommerce.DTOs.CategoriaDTO;
import com.biolab.ecommerce.entities.Categoria;
import com.biolab.ecommerce.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    public String criarCategoria(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());
        categoriaRepository.save(categoria);
        return "Categoria Criada com Sucesso!!";
    }
    public CategoriaDTO atualizarCat(Long id, CategoriaDTO dto) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow();
        CategoriaDTO cdto = new CategoriaDTO();
        categoria.setNome(dto.getNome());
        categoriaRepository.save(categoria);
        cdto.setId(categoria.getId());
        cdto.setNome(categoria.getNome());
        return cdto;
    }
    public String delete(Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow();
        categoriaRepository.deleteById(categoria.getId());
        return "excluido!";
    }
    public List<Categoria> buscarTodasCat() {
        return categoriaRepository.findAll();
    }
    public Categoria buscarCatId(Long id) {
        return categoriaRepository.findById(id).orElseThrow();
    }
}