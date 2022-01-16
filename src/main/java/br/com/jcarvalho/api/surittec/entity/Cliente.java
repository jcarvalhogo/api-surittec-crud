package br.com.jcarvalho.api.surittec.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity(name = "cliente")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotBlank
    @Length(max = 100, min = 3, message = "O nome deverá ter no mínino {min} e no máximo {max} caracteres")
    private String nome;
    @Column
    @NotBlank
    @Length(max = 14)
    private String cpf;
    @Column
    @NotBlank
    @Length(max = 100, message = "O endereço deverá ter no máximo {max} caracteres")
    private String endereco;
    @Column
    @NotBlank
    @Length(max = 9)
    private String cep;
    @Column
    @NotBlank
    @Length(max = 80, message = "O complemento deverá ter no máximo {max} caracteres")
    private String complemento;
    @Column
    @NotBlank
    @Length(max = 80, message = "O complemento deverá ter no máximo {max} caracteres")
    private String cidade;
    @Column
    @NotBlank
    @Length(max = 2)
    private String uf;
    @Column
    @Temporal(TemporalType.DATE)
    private Date data;
    @Length(max = 60, message = "O bairro deverá ter no máximo {max} caracteres")
    @Column(nullable = false)
    private String bairro;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private List<Telefone> telefones;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private List<Email> emails;

    public Cliente(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Cliente() {
    }
}
