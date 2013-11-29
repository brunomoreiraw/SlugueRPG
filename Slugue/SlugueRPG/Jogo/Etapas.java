package Jogo;

import java.util.ArrayList;

public class Etapas {
	public ArrayList<String> batalha;
	
	public Etapas(){
		batalha = new ArrayList<String>();
		batalha.add("\n\nRolando Iniciativa...");//0
		batalha.add(". Voc� desferiu ");//1
		batalha.add(" pontos de dano.");//2
		batalha.add(" Voc� sofreu ");//3
		batalha.add(" pontos de dano.");//4
		batalha.add("\n\nVoc� saca seu/sua ");//5
		batalha.add("\n\nVoc� est� desarmado.");//6
		batalha.add("\n\nVoc� ganhou a iniciativa.");//7
		batalha.add("\n\nVoc� perdeu a iniciativa.");//8
		batalha.add(" O que deseja fazer?");//9
		batalha.add("\n\nVoc� errou o ataque.");//10
		batalha.add("\nVoc� refletiu o ataque.");//11
		batalha.add(" crava as presas em voc�.\n");//12
		batalha.add(" tenta desferir um ataque contra voc�.\n");//13
		batalha.add("\n\nVoc� consegue acertar a/o ");//14
	}
	
	//A��o para atacar um monstro
	public String pAtaque(Personagem p, Enemy e){
		if(p.d20() > e.getDefesa()){
			int d = p.atacar(e);
			return batalha.get(14) + e.getNome() + batalha.get(1) + d + (batalha.get(2)) + "\n"
					+ e.getNome() + " ainda possui " + e.getPvsEnemy() + " pontos de vida";
		}
		else return batalha.get(10);
	}
	
	//A��o para ser atacado
		public String eAtaque(Personagem p, Enemy e){
			if(e.d20() > p.getDefesa()){
				int d = e.atacar(p);
				return "\n\n" + e.getNome() + batalha.get(12) + batalha.get(3) + d + batalha.get(4);
			}
			else return "\n\n" + e.getNome() + batalha.get(13) + batalha.get(11);			
		}
	
	//A��o para Sacar a Arma.
	public String sacarArma(Personagem p){
		if(p.getArma().getNome().equals("Desarmado")){
			return batalha.get(6);
		}
		
		else return batalha.get(5) + p.getArma().getNome();	
	}
	
	//A��o para jogar dado de Iniciativa.
	public String rolaIniciativa(Personagem p, Enemy e){
		int jogP = p.d20();
		int jogE = e.d20();
		String aux = "\n\nSua rolagem: " + jogP + " | Rolagem do Inimigo: " + jogE;
		if(jogP > jogE) return aux + batalha.get(7) + batalha.get(9);
		else return "0";
	}
	
	
}
