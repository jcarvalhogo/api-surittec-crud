package br.com.jcarvalho.api.surittec.entity;


import javax.persistence.*;
import java.util.Date;

@Entity(name = "operacao")
public class Operacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String usuario;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(nullable = false)
    private String acao;
    @Column(nullable = false)
    private String tabela;

    public Operacao() {
    }

    public Operacao(Long id, String usuario, Date data, String acao, String tabela) {
        this.id = id;
        this.usuario = usuario;
        this.data = data;
        this.acao = acao;
        this.tabela = tabela;
    }
}
