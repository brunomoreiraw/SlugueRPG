package Jogo;

import java.util.Random;

public class Enemy {
	
	private String nome;
	private int ataque;
	private int pvs;
	private int defesa;
	private Random rola = new Random();
	
	public Enemy(String nome, int pv, int ataque, int defesa){
		setNome(nome);
		setPvsEnemy(pv);
		setAtaque(ataque);
		setDefesa(defesa);
	}
	
	public int getPvsEnemy() {return pvs;}
	public void setPvsEnemy(int pvs) {this.pvs = pvs;}
	
	public int getAtaque() {return ataque;}
	public void setAtaque(int ataque) {this.ataque = ataque;}
	
	public int getDefesa() {return defesa;}
	public void setDefesa(int defesa) {this.defesa = defesa;}
	
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public int d20(){
		int d20 = rola.nextInt(20);
		return d20 + ataque;
	}
	
	public int atacar(Personagem p){
			int dano = rola.nextInt(ataque);
			int vidaAtual = p.getPv() - dano;
			
			if(vidaAtual > 0) {
				p.setPv(vidaAtual);
			}else p.setPv(0);
			
			return dano;
	}
	
	public String toString(){
		return "Nome: " + nome + "\n" +
				"Ataque: " + ataque + "\n" +
				"Defesa: " + defesa + "\n" +
				"Pontos de Vida: " + pvs;
	}

}
