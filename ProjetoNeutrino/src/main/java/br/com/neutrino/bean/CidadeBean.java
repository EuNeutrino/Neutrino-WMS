package br.com.neutrino.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.neutrino.dao.CidadeDAO;
import br.com.neutrino.dao.EstadoDAO;
import br.com.neutrino.domain.Cidade;
import br.com.neutrino.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {

	private Cidade cidade;
	private List<Cidade> cidades;
	private CidadeDAO cidadeDAO;

	private EstadoDAO estadoDAO;
	private List<Estado> estados;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void listar() {
		try {
			cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Houve um erro ao tentar listar as cidades, contate o suporte!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		cidade = new Cidade();
		estadoDAO = new EstadoDAO();
		try {
			estados = estadoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Houve um erro ao tentar listar as estados, contate o suporte!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			cidadeDAO = new CidadeDAO();
			cidadeDAO.merge(cidade);

			cidade = new Cidade();
			cidades = cidadeDAO.listar();

			estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

			Messages.addGlobalInfo("Cidadae salvo com sucesso!");
		} catch (RuntimeException erro) {
			erro.printStackTrace();
			Messages.addGlobalError("Houve um problema ao tentar salvar a cidade, contate o suporte!");
		}

	}

	public void editar(ActionEvent evento) {
		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionado");
			estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Houve um problema ao tentar listar as estados, contate o suporte!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionado");
		try {
			cidadeDAO = new CidadeDAO();
			cidadeDAO.excluir(cidade);
			cidades = cidadeDAO.listar();
			Messages.addGlobalInfo("Cidade excluido com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Houve um problema ao tentar excluir a cidade, contate o suporte!");
			erro.printStackTrace();
		}
	}

}