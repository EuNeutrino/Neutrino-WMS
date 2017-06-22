package br.com.neutrino.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author David Nogueira
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tab_unidade", schema = "neutrino")
public class Unidade extends PessoaGenerica {

    @ManyToOne(optional = false)
    private Cidade cidade;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}
