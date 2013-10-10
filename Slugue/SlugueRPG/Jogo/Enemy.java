package Jogo;

public class Enemy {
	
	private String nome;
	private int ataque;
	private int pvs;
	
	public Enemy(String nome){
		setNome(nome);
		pvs = 13;
		ataque = 2;
	}
	
	public int getPvsEnemy() {return pvs;}
	public void setPvsEnemy(int pvs) {this.pvs = pvs;}
	
	public int getAtaque() {return ataque;}
	public void setAtaque(int ataque) {this.ataque = ataque;}
	
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public String toString(){
		return "Nome: " + nome + "\n" +
				"Pontos de Vida: " + pvs;
			
	}

}
