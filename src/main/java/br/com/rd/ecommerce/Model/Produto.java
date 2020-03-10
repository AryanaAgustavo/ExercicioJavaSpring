package br.com.rd.ecommerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "tb_produto")

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column (name = "ds_nome")
    private String nome;

    @NotNull
    @Column (name = "nr_quantidade")
    private Integer quantidadeEstoque;

    @NotNull
    @Column (name = "nr_preco")
    private Double preco;

    @ManyToOne(targetEntity = Categoria.class)
    @JoinColumn(name = "cd_categoria")
    private Categoria categoria;

}
