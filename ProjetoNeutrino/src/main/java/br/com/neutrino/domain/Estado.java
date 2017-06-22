package br.com.neutrino.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author David Nogueira
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tab_estado", schema = "neutrino")
public class Estado extends EntidadeGenerica {

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 2, nullable = false, unique = true)
    private String sigla;

    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<Cidade> getCidade() {
        return cidade;
    }

    public void setCidade(List<Cidade> cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return cidade.toString();
    }

}
