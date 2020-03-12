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
@Entity
@Table (name = "tb_pedido")

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer id;

    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Column(name ="valorPedido")
    private BigDecimal valorPedido;

    @Column(name = "valorFrete")
    private BigDecimal valorFrete;

    @Column(name = "id_cliente")
    private Integer idCliente;

    @OneToMany(cascade = CascadeType.ALL) //ação em cascata - ex: se apagar/atualizar a lista de item tbm apaga/atualiza... muda automatico
    @JoinColumn(name = "id_pedido") //passa o nome da coluna relacionada da tabela itemPedido
    private List<ItemPedido> itemPedidos;
}
