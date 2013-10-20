package Jogo;

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
	private int pv;
	private int pm;
	
	public Personagem(String nome, String classe, int forc, int agi, int sab){
		setNome(nome);
		this.classe = classe;
		setForc(forc);
		setAgi(agi);
		setSab(sab);
		setPm(sab);
		setAtaqueCC(forc);
		setAtaqueAD(agi);
		setAtaqueM(sab);		
		if(classe.equals("Guerreiro")){
			setAtaqueCC(forc + 2);
			setPv(forc + 10);
		}
		if(classe.equals("Ranger")){
			setAtaqueAD(agi + 2);
			setPv(forc + 8);
		}
		if(classe.equals("Mago")){
			setAtaqueM(sab + 2);
			setPm(sab + 10);
			setPv(forc + 4);
		}
		if(classe.equals("Clérigo")){
			setAtaqueCC(forc + 1);
			setAtaqueM(sab + 1);
			setPm(sab + 5);
			setPv(forc + 8);
		}
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
	public String getClasse() {
		return classe;
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

	
	public void atacar(Enemy e){
		int dano = e.getPvsEnemy() - ataqueCC;
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


