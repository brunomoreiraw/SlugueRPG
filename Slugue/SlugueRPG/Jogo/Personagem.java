package Jogo;

import java.util.Random;

public class Personagem {
	
	private String nome;
	private String classe;
	//private String raca; //TODO
	private int forc;
	private int agi;
	private int sab;
	private int ataqueCC;
	private int ataqueAD;
	private int ataqueM;
	private int defesa;
	private int pv;
	private int pm;
	private Arma arma;
	
	public Personagem(String nome, String classe, int forc, int agi, int sab, Arma arma){
		setNome(nome);
		setClasse(classe);
		setForc(forc);
		setAgi(agi);
		setSab(sab);
		setPm(sab);
		setAtaqueCC(forc);
		setAtaqueAD(agi);
		setAtaqueM(sab);
		setDefesa(agi);
		setArma(arma);
	}
	
	//Get & Sets
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setClasse(String classe){
		this.classe = classe;
	}
	public String getClasse(){
		return classe;
	}
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
	public int getPm() {
		return pm;
	}
	public void setPm(int pm) {
		this.pm = pm;
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
	public int getAtaqueCC() {
		return ataqueCC;
	}
	public void setAtaqueCC(int ataqueCC) {
		this.ataqueCC = ataqueCC;
	}
	public int getAtaqueAD() {
		return ataqueAD;
	}
	public void setAtaqueAD(int ataqueAD) {
		this.ataqueAD = ataqueAD;
	}
	public int getAtaqueM() {
		return ataqueM;
	}
	public void setAtaqueM(int ataqueM) {
		this.ataqueM = ataqueM;
	}
	public int getDefesa() {
		return defesa;
	}
	public void setDefesa(int def) {
		this.defesa = 14 + forc;
	}
	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma a) {
		this.arma = a;
	}
	//Get & Sets
	
	Random rola = new Random();
	
	public int d20(){
		int d20 = rola.nextInt(20);
		
		if(arma.getTipo() == 'c'){
			d20 = d20 + ataqueCC;
		}
		if(arma.getTipo() == 'd'){
			d20 = d20 + ataqueAD;
		}
		if(arma.getTipo() == 'm'){
			d20 = d20 + ataqueM;
		}
		
		return d20;
	}
	
	public void atacar(Enemy e){
			int d = e.getPvsEnemy() - arma.danoInf(this);
			
			if(d > 0) {
				e.setPvsEnemy(d);
			}else e.setPvsEnemy(0);
	}
	
	public String toString(){
		
		return  "\n" +
				" Nome: " + nome + "\n" +
				" Classe: " + classe + "\n\n" +
				" Força: " + forc + "\n" +
				" Agilidade: " + agi + "\n" +
				" Sabedoria: " + sab + "\n\n" +
				" Pontos de Vida: " + pv + "\n" +
				" Pontos de Magia: " + pm + "\n\n" +
				" Ataque Curto: " + ataqueCC + "\n" +
				" Ataque Distante: " + ataqueAD + "\n" +
				" Ataque Mágico: " + ataqueM + "\n" +
				" Defesa: " + defesa + "\n\n" +
				" Arma: " + arma.getNome() + "\n" +
				" Dano: 1d" + arma.getDano() + "\n";
	}
}


