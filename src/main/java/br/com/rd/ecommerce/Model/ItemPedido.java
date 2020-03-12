package br.com.rd.ecommerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "tb_pedido_item")

public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_pedido_item")
    private Integer id;

    @Column(name = "cd_produto")
    private  String idProduto;

    @Column(name = "nr_valorProduto")
    private BigDecimal valorProduto;

    @Column(name = "nr_quantidae")
    private Integer quantidade;

    @Column(name = "cod_pedido")
    private Integer codPedido;


}
