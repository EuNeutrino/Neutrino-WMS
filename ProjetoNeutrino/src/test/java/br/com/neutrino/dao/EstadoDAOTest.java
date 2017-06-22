/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.neutrino.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.neutrino.domain.Estado;

/**
 *
 * @author David Nogueira
 */
public class EstadoDAOTest {

	@Test
	@Ignore

	public void testSomeMethod() {
		EstadoDAO dao = new EstadoDAO();

		Estado estado = new Estado();
		List<Estado> lista = dao.listar();

		for (int i = 0; i < lista.size(); i++) {
			estado = lista.get(i);
			System.out.println("ESTADO: " + estado.getNome());

		}

		// fail("The test case is a prototype.");
	}

	@Test

	public void salvar() {
		EstadoDAO dao = new EstadoDAO();
		Estado estado = new Estado();
		estado.setId(7L);
		estado.setNome("PARAIBA");
		estado.setSigla("PB");

		dao.merge(estado);
	}

	@Test

	public void BuscarPorNome() {
		EstadoDAO dao = new EstadoDAO();
		Estado estado = new Estado();
		List<Estado> lista = dao.buscarPorNome("A");

		for (int i = 0; i < lista.size(); i++) {
			estado = lista.get(i);
			System.out.println("ESTADO: " + estado.getNome());

		}
	}

	@Test
	@Ignore
	public void buscaPorCodigo() {
		EstadoDAO dao = new EstadoDAO();
		Estado estado = dao.buscar(1L);
		System.out.println(estado.getNome());

	}
}
