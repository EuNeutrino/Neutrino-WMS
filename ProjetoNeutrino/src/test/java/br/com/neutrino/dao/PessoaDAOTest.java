/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.neutrino.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.com.neutrino.domain.Pessoa;

/**
 *
 * @author David Nogueira
 */
public class PessoaDAOTest {

	@Test

	public void salvar() {
		PessoaDAO dao = new PessoaDAO();

		Pessoa pessoa = new Pessoa();

		pessoa.setCliente(true);
		pessoa.setFornecedor(true);
		pessoa.setVendedor(true);
		pessoa.setApelido("APELIDO APELIDO DA PESSOA");
		pessoa.setDocumento(35629492000163L);
		pessoa.setNome("NOME DA PESSOA");
		pessoa.setTipo('J');

		dao.merge(pessoa);

	}

	@Ignore
	@Test
	public void editar() {

		PessoaDAO dao = new PessoaDAO();

		Pessoa pessoa = dao.buscar(1L);
		pessoa.setFornecedor(false);
		dao.editar(pessoa);

	}

}
