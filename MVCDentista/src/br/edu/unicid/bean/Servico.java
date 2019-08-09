package br.edu.unicid.bean;

import java.sql.Date;

public class Servico {
	
	private int cdOrca;
	private String Descricao;
	private Double Preco;
	
	
	public Servico(int cdOrca, String Descricao, Double Preco) {
		super();
		this.cdOrca = cdOrca;
		this.Descricao = Descricao;
		this.Preco = Preco;
		
	}
	
	public int getCdOrca() {
		return cdOrca;
	}

	public void setCdOrca(int cdOrca) {
		this.cdOrca = cdOrca;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public Double getPreco() {
		return Preco;
	}

	public void setPreco(Double preco) {
		Preco = preco;
	}

	public Servico() {}
}
