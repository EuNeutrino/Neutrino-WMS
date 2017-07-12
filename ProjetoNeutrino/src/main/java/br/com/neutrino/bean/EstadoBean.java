package br.com.neutrino.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.neutrino.dao.EstadoDAO;
import br.com.neutrino.domain.Estado;

/**
 *
 * @author David Nogueira
 */
@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	private Estado estado;
	private EstadoDAO dao;
	private List<Estado> estados;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public void salvar() {
		try {
			dao = new EstadoDAO();
			dao.merge(estado);
			estado = new Estado();
			estados = dao.listar();
			Messages.addGlobalInfo("Estado salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Houve um probelma ao tesntar salvar o estado, contate o suporte!");
			erro.printStackTrace();

		}
	}

	@PostConstruct
	public void listar() {
		try {
			dao = new EstadoDAO();
			estados = dao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Houve um probelma ao tentar listar os estados, contate o suporte!");
			erro.printStackTrace();

		}
	}

	public void novo() {
		estado = new Estado();

	}

	public void excluir(ActionEvent evento) {
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
		try {
			dao = new EstadoDAO();
			dao.excluir(estado);
			estados = dao.listar();
			Messages.addGlobalInfo("Estado excluido com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Houve um probelma ao tentar excluir o estado, contate o suporte!");
			erro.printStackTrace();

		}
	}

	public void editar(ActionEvent evento) {
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");

	}
}
