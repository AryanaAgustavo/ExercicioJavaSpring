package br.com.rd.ecommerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDTO {
    private Integer id;
    private String idProduto;
    private BigDecimal valorProduto;
    private Integer quantidade;
    private Integer codPedido;

}
