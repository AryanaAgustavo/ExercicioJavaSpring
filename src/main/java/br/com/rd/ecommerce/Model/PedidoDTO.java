package br.com.rd.ecommerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Integer id;
    private Date data;
    private BigDecimal valorPedido;
    private BigDecimal valorFrete;
    private Integer idCliente;
    private List<ItemPedidoDTO> itemPedidos;
}
