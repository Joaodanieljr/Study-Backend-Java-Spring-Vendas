package com.joaodanieljr.service.impl;

import com.joaodanieljr.domain.entity.Cliente;
import com.joaodanieljr.domain.entity.ItemPedido;
import com.joaodanieljr.domain.entity.Pedido;
import com.joaodanieljr.domain.entity.Produto;
import com.joaodanieljr.domain.repository.Clientes;
import com.joaodanieljr.domain.repository.Itens;
import com.joaodanieljr.domain.repository.Pedidos;
import com.joaodanieljr.domain.repository.Produtos;
import com.joaodanieljr.dto.ItensPedidoDTO;
import com.joaodanieljr.dto.PedidoDTO;
import com.joaodanieljr.exceptions.RegraNegocioException;
import com.joaodanieljr.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoService service;

    @Autowired
    private Pedidos pedidosRepository;

    @Autowired
    private Clientes clientesRepository;

    @Autowired
    private Produtos produtosRepository;

    @Autowired
    private Itens itensPedidoRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository.findById(idCliente).orElseThrow(() -> new RegraNegocioException("Codigo de cliente invalido"));

        Pedido pedido = new Pedido();
        pedido.setDataPedido(LocalDate.now());
        pedido.setTotal(dto.getTotal());
        pedido.setCliente(cliente);

        List<ItemPedido> itensPedido =  converterItens(pedido, dto.getItens());
        pedidosRepository.save(pedido);
        itensPedidoRepository.saveAll(itensPedido);
        pedido.setItens(itensPedido);
        return pedido;
    }

    private List<ItemPedido> converterItens(Pedido pedido, List<ItensPedidoDTO> itens){
        if (itens.isEmpty()){
            throw new RegraNegocioException("Não é possivel realizar um pedido sem itens");
        }
        return itens.stream().map(dto -> {
            Integer idProduto = dto.getProduto();
            Produto produto = produtosRepository.findById(idProduto).orElseThrow(() -> new RegraNegocioException("Codigo de produto invalido: " + idProduto));

            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setQuantidade(dto.getQuantidade());
            itemPedido.setPedido(pedido);
            itemPedido.setProduto(produto);
            return itemPedido;
        }).collect(Collectors.toList());

    }

}
