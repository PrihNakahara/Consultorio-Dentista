package br.edu.unicid.bean;

import java.util.Date;

public class Cliente {
	private int cdCliente;
	private String nomeCliente;
	private String emailCliente;
	private Date dtaNasc;
	private int idadeCliente;
	private String endCliente;
	private String estadoCivil;
	private int telefone;
	private boolean convenio;
	

	public Cliente(int cdCliente, String nomeCliente, String emailCliente, Date dtaNasc, int idadeCliente, String endCliente,
			String estadoCivil, int telefone, boolean convenio) {
		super();
		this.cdCliente = cdCliente;
		this.nomeCliente = nomeCliente;
		this.emailCliente = emailCliente;
		this.dtaNasc = dtaNasc;
		this.idadeCliente = idadeCliente;
		this.endCliente = endCliente;
		this.estadoCivil = estadoCivil;
		this.telefone = telefone;
		this.convenio = convenio;
		
	}
	
	public Cliente() {}

	public int getcdCliente() {
		return cdCliente;
	}

	public void setcdCliente(int cdCliente) {
		this.cdCliente = cdCliente;
	}

	public String getnomeCliente() {
		return nomeCliente;
	}

	public void setnomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getemailCliente() {
		return emailCliente;
	}

	public void setemailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public Date getDtaNasc() {
		return dtaNasc;
	}

	public void setDtaNasc(Date dtaNasc) {
		this.dtaNasc = dtaNasc;
	}

	public int getidadeCliente() {
		return idadeCliente;
	}

	public void setidadeCliente(int idadeCliente) {
		this.idadeCliente = idadeCliente;
	}

	public String getendCliente() {
		return endCliente;
	}

	public void setendCliente(String endCliente) {
		this.endCliente = endCliente;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public boolean isConvenio() {
		return convenio;
	}

	public void setConvenio(boolean convenio) {
		this.convenio = convenio;
	}

	}
