package br.com.rd.ecommerce.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor //cria construtor com todos os parametros
@NoArgsConstructor //cria construtos sem parametros
@Entity //declarar que é uma entidade *lembrar do banco de dados
@Table(name = "tb_user")
public class User {
    //gerar um id automaticamente
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //auto incremento dos números
    @Column
    private Long id;

    @NotNull
    @Column (name = "ds_first_name")
    private String firstName;

    @NotNull
    @Column (name = "ds_last_name")
    private String lastName;

    @NotNull
    @Column (name = "nr_age")
    private Integer age;

}
