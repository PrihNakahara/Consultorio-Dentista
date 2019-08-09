package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.edu.unicid.bean.Calculo;
import br.edu.unicid.bean.Servico;

public class CalculoDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Calculo Calculo;
	private Double soma = 0D;
	private String somar = "";
	private String resposta;
	
	public Double adicionar(Double add) throws Exception {
		Calculo cal = new Calculo();
		
		//somar="<html><br>"+somar+"Servico: "+descricao+" Valor: R$"+add+"</html>";
		soma=soma+add;
		return soma;
	}
	
	
	
	
}
