package Jogo;

public class Personagem {
	
	private String nome;
	private String classe;
	//private String raca; //TODO
	private int forc;
	private int agi;
	private int sab;
	private int ataque;
	private int pv;
	private int pm;
	
	public Personagem(String nome, String classe, int forc, int agi, int sab){
		setNome(nome);
		this.classe = classe;
		setForc(forc);
		setAgi(agi);
		setSab(sab);
		this.pv = forc * 2;
		this.pm = sab * 3;
		this.ataque = forc;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getForc() {
		return forc;
	}
	public void setForc(int forc) {
		this.forc = forc;
	}
	public int getAgi() {
		return agi;
	}
	public void setAgi(int agi) {
		this.agi = agi;
	}
	public int getSab() {
		return sab;
	}
	public void setSab(int sab) {
		this.sab = sab;
	}
	public String getClasse() {
		return classe;
	}

	
	public void atacar(Enemy e){
		int dano = e.getPvsEnemy() - ataque;
		e.setPvsEnemy(dano);
	}
	
	public String toString(){
		return "Nome: " + nome + "\n" +
				"Classe: " + classe + "\n" +
				"Força: " + forc + "\n" +
				"Agilidade: " + agi + "\n" +
				"Sabedoria: " + sab + "\n" +
				"Pontos de Vida: " + pv + "\n" +
				"Pontos de Magia: " + pm + "\n" ;				
	}


}


