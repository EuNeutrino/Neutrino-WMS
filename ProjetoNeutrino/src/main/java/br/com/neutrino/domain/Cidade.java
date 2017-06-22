package br.com.neutrino.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author David Nogueira
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tab_cidade", schema = "neutrino")
public class Cidade extends EntidadeGenerica {

    @OneToMany(mappedBy = "cidade")
    private List<Unidade> unidade;

    @Column(length = 50, nullable = false)
    private String nome;

    @ManyToOne(optional = false)
    private Estado estado;

    @Column(columnDefinition = "BIGINT(8) not null")
    private Long cep;

    @Column(columnDefinition = "BIGINT(7) not null")
    private Long ibge;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public Long getIbge() {
        return ibge;
    }

    public void setIbge(Long ibge) {
        this.ibge = ibge;
    }

    public List<Unidade> getUnidade() {
        return unidade;
    }

    public void setUnidade(List<Unidade> unidade) {
        this.unidade = unidade;
    }

}
