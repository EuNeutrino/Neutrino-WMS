package br.com.neutrino.bean;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

@SuppressWarnings("serial")

public abstract class BeanGenerico implements Serializable {

	
	public abstract void listar();

	public abstract void novo();

	public abstract void salvar();

	public abstract void editar(ActionEvent evento);

	public abstract void excluir(ActionEvent evento);

	public void getMessagesGlobalInfo(String mensagem) {
		Messages.addGlobalInfo(mensagem);
	}

	public void getMessagesGlobalError(String mensagem) {
		Messages.addGlobalError(mensagem);

	}
}
