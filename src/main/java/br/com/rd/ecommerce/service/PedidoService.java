package br.com.rd.ecommerce.service;


import br.com.rd.ecommerce.Model.ItemPedido;
import br.com.rd.ecommerce.Model.ItemPedidoDTO;
import br.com.rd.ecommerce.Model.Pedido;
import br.com.rd.ecommerce.Model.PedidoDTO;
import br.com.rd.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("PedidoService")
public class PedidoService {

    @Autowired
    PedidoRepository repository;

    public ResponseEntity salvar(PedidoDTO pedidoDTO) {
        //colocar todas as validações
        if(pedidoDTO == null || pedidoDTO.getIdCliente() == null)
            return ResponseEntity.badRequest().body(new Exception("idCliente não foi informado"));
        if (pedidoDTO.getItemPedidos() == null)
            return ResponseEntity.badRequest().body((new Exception("Pedido não contém itens")));

        Pedido pedidoEntity = new Pedido();
        pedidoEntity.setId(pedidoDTO.getId());
        pedidoEntity.setIdCliente(pedidoDTO.getIdCliente());
        pedidoEntity.setData(pedidoDTO.getData());
        pedidoEntity.setValorFrete(pedidoDTO.getValorFrete());
        pedidoEntity.setValorPedido(pedidoDTO.getValorPedido());

        List<ItemPedido> listaItens = new ArrayList<>();
        for(ItemPedidoDTO itPedido: pedidoDTO.getItemPedidos()){
            ItemPedido it = new ItemPedido();
            it.setValorProduto(itPedido.getValorProduto());
            it.setQuantidade(itPedido.getQuantidade());
            it.setIdProduto(itPedido.getIdProduto());
            it.setCodPedido(itPedido.getCodPedido());

            listaItens.add(it);
        }

        pedidoEntity.setItemPedidos(listaItens);
        Pedido retornoEntity = repository.save(pedidoEntity);

        return  ResponseEntity.ok().body(retornoEntity);
    }
}


