package Jogo;

import java.util.Random;

public class Arma {
	private String nome;
	private int dano;
	private char tipo;
	private Random rola = new Random();
	
	public Arma(String nome, int dano, char tipo){
		setNome(nome);
		setDano(dano);
		setTipo(tipo);
	}

	public int getDano() {
		return dano;
	}
	public void setDano(int dano) {
		this.dano = dano;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
		
	public int danoInf(Personagem p){
		int damage = 0;
		int dado = rola.nextInt(dano);
		if(tipo == 'c'){
			damage = p.getForc() + dado;
		}
		if(tipo == 'd'){
			damage = p.getAgi() + dado;
		}
		if(tipo == 'm'){
			damage = p.getSab() + dado;
		}	
		return damage;
	}
	
}
