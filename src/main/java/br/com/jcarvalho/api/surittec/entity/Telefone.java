package br.com.jcarvalho.api.surittec.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "telefone")
@Data
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 14, nullable = false)
    private String numero;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name = "fk_telefone"), referencedColumnName = "id")
    private Cliente cliente;

    public Telefone() {
    }

    public Telefone(Long id, String numero) {
        this.id = id;
        this.numero = numero;
    }
}
