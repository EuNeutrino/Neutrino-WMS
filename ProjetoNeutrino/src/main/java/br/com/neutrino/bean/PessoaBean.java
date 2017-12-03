package br.com.neutrino.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.neutrino.dao.PessoaDAO;
import br.com.neutrino.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean extends BeanGenerico {
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private PessoaDAO pessoaDAO;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public PessoaDAO getPessoaDAO() {
		return pessoaDAO;
	}

	public void setPessoaDAO(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}

	@Override
	@PostConstruct
	public void listar() {
		try {
			pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();
		} catch (RuntimeException erro) {
			getMessagesGlobalError("Houve um erro ao tentar listar as pessoas, contate o suporte!");
			erro.printStackTrace();
		}

	}

	@Override
	public void novo() {
		pessoa = new Pessoa();
		pessoaDAO = new PessoaDAO();
		try {
			pessoas = pessoaDAO.listar();
		} catch (RuntimeException erro) {
			getMessagesGlobalError("Houve um erro ao tentar listar as pessoas, contate o suporte!");
			erro.printStackTrace();
		}
	}

	@Override
	public void salvar() {
		try {
			pessoaDAO = new PessoaDAO();
			pessoaDAO.merge(pessoa);
			pessoa = new Pessoa();
			pessoas = pessoaDAO.listar();
			getMessagesGlobalInfo("Pessoa salvo com sucesso!");
		} catch (RuntimeException erro) {
			getMessagesGlobalError("Houve um erro ao tentar listar as pessoas, contate o suporte!");
			erro.printStackTrace();
		}
	}

	@Override
	public void editar(ActionEvent evento) {
		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionado");
			pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();
		} catch (RuntimeException erro) {
			getMessagesGlobalError("Houve um problema ao tentar listar as pessoas, contate o suporte!");
			erro.printStackTrace();
		}
	}

	@Override
	public void excluir(ActionEvent evento) {
		pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionado");
		try {
			pessoaDAO = new PessoaDAO();
			pessoaDAO.excluir(pessoa);
			pessoas = pessoaDAO.listar();
			getMessagesGlobalInfo("Pessoa excluido com sucesso!");
		} catch (RuntimeException erro) {
			getMessagesGlobalError("Houve um problema ao tentar listar as pessoas, contate o suporte!");
			erro.printStackTrace();
		}
	}

}
