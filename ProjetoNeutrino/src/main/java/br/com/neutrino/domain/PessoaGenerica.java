package br.com.neutrino.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author David Nogueira
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class PessoaGenerica extends EntidadeGenerica {

    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false)
    private String apelido;
    @Column(columnDefinition = "BIGINT(15) not null")
    private Long documento;
    @Column(columnDefinition = "BIGINT(15)")
    private Long incEstadual;
    @Column(columnDefinition = "BIGINT(15)")
    private Long incMunicipal;
    @Column(columnDefinition = "BIGINT(11)")
    private Long fone1;
    @Column(columnDefinition = "BIGINT(15)")
    private Long fone2;
    @Column(length = 50)
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public Long getIncEstadual() {
        return incEstadual;
    }

    public void setIncEstadual(Long incEstadual) {
        this.incEstadual = incEstadual;
    }

    public Long getIncMunicipal() {
        return incMunicipal;
    }

    public void setIncMunicipal(Long incMunicipal) {
        this.incMunicipal = incMunicipal;
    }

    public Long getFone1() {
        return fone1;
    }

    public void setFone1(Long fone1) {
        this.fone1 = fone1;
    }

    public Long getFone2() {
        return fone2;
    }

    public void setFone2(Long fone2) {
        this.fone2 = fone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
