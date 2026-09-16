package com.biolab.ecommerce.services;

import com.biolab.ecommerce.DTOs.PedidoDTO;
import com.biolab.ecommerce.controllers.PedidoController;
import com.biolab.ecommerce.entities.Pedido;
import com.biolab.ecommerce.entities.Usuario;
import com.biolab.ecommerce.entities.enums.StatusPedido;
import com.biolab.ecommerce.repositories.PedidoRepository;
import com.biolab.ecommerce.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;
    public PedidoService(PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public String criarPedido(PedidoDTO dto){
        Usuario u = usuarioRepository.findById(dto.getIdCliente()).orElseThrow();
        Pedido p = new Pedido();
        p.setCliente(u);
        p.setMomento(dto.getMomento());
        p.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
        pedidoRepository.save(p);
        return "Pedido criado com sucesso";
    }

    public String deletarPedido(long id){
        Pedido pedido = pedidoRepository.findById(id).orElseThrow();
        pedidoRepository.deleteById(id);
        return "Excluido com sucesso";
    }
}
