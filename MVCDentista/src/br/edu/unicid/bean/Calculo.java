package br.edu.unicid.bean;

public class Calculo {

	private Double Add;
	private Double soma;
	
	
	public Calculo(Double Add, Double soma) {
		super();
		this.Add = Add;
		this.soma = soma;
	}
	
	public Calculo() {}

	public Double getAdd() {
		return Add;
	}

	public void setAdd(Double add) {
		Add = add;
	}

	public Double getSoma() {
		return soma;
	}

	public void setSoma(Double soma) {
		this.soma = soma;
	}
	
	


}

	

