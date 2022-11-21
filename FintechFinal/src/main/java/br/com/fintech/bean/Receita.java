package br.com.fintech.bean;

import java.util.Calendar;

public class Receita {
	
	private int codigo;
	private String nome;
	private double valor;
	private Calendar dataReceita;

	public Receita () {
		super();
	}
	
	public Receita(int codigo, String nome, double valor, Calendar dataReceita) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.dataReceita = dataReceita;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDataReceita() {
		return dataReceita;
	}

	public void setDataReceita(Calendar dataReceita) {
		this.dataReceita = dataReceita;
	}
	

	
	
	
}

