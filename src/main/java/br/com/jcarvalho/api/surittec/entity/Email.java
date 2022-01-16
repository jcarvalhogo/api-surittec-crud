package br.com.jcarvalho.api.surittec.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "email")
@Data
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 120, nullable = false)
    private String descricao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name = "fk_email"), referencedColumnName = "id")
    private Cliente cliente;

    public Email() {
    }

    public Email(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
}
