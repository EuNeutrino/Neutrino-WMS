package br.com.neutrino.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author David Nogueira
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "tab_pessoa", schema = "neutrino")
public class Pessoa extends EntidadeGenerica {

	@Column(columnDefinition = "boolean not null")
	private boolean cliente;

	@Column(columnDefinition = "boolean not null")
	private boolean fornecedor;

	@Column(columnDefinition = "boolean not null")
	private boolean vendedor;

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(length = 50, nullable = false)
	private String apelido;

	@Column(columnDefinition = "BIGINT(15) not null")
	private Long documento;

	@Column(length = 1, nullable = false)
	private char tipo;

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public boolean isCliente() {
		return cliente;
	}

	public void setCliente(boolean cliente) {
		this.cliente = cliente;
	}

	public boolean isFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(boolean fornecedor) {
		this.fornecedor = fornecedor;
	}

	public boolean isVendedor() {
		return vendedor;
	}

	public void setVendedor(boolean vendedor) {
		this.vendedor = vendedor;
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

	public String getNome() {
		return nome;
	}

	public Long getDocumento() {
		return documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
		result = prime * result + (cliente ? 1231 : 1237);
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + (fornecedor ? 1231 : 1237);
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (vendedor ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (apelido == null) {
			if (other.apelido != null)
				return false;
		} else if (!apelido.equals(other.apelido))
			return false;
		if (cliente != other.cliente)
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (fornecedor != other.fornecedor)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (vendedor != other.vendedor)
			return false;
		return true;
	}

}
