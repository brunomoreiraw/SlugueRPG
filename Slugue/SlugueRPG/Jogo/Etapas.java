package Jogo;

import java.util.ArrayList;

public class Etapas {
	public ArrayList<String> batalha;
	
	public Etapas(){
		batalha = new ArrayList<String>();
		batalha.add("\n\nRolando Iniciativa...");//0
		batalha.add("\n\nVocê desferiu dano. ");//1
		batalha.add(" pontos de dano inflingidos.");//2
		batalha.add("\n\nVocê sofreu dano. ");//3
		batalha.add(" pontos de dano sofridos.");//4
		batalha.add("\n\nVocê saca seu/sua ");//5
		batalha.add("\n\nVocê está desarmado.");//6
		batalha.add("\n\nVocê ganhou a iniciativa.");//7
		batalha.add("\n\nVocê perdeu a iniciativa.");//8
		batalha.add(" O que deseja fazer?");//9
		batalha.add("\n\nVocê errou o ataque.");//10
		batalha.add("\n\nVocê refletiu o ataque.");//11
	}
	
	//Ação para atacar um monstro
	public String pAtaque(Personagem p, Enemy e){
		if(p.d20() > e.getDefesa()){
			int d = p.atacar(e);
			return batalha.get(1) + d + (batalha.get(2));
		}
		else return batalha.get(10);
	}
	
	//Ação para ser atacado
		public String eAtaque(Personagem p, Enemy e){
			if(e.d20() > p.getDefesa()){
				int d = e.atacar(p);
				return batalha.get(3) + d + (batalha.get(4));
			}
			else return batalha.get(11) + batalha.get(9);			
		}
	
	//Ação para Sacar a Arma.
	public String sacarArma(Personagem p){
		if(p.getArma().getNome().equals("Desarmado")){
			return batalha.get(6);
		}
		
		else return batalha.get(5) + p.getArma().getNome();	
	}
	
	//Ação para jogar dado de Iniciativa.
	public String rolaIniciativa(Personagem p, Enemy e){
		int jogP = p.d20();
		int jogE = e.d20();
		String aux = "\n\nSua rolagem: " + jogP + " | Rolagem do Inimigo: " + jogE;
		if(jogP > jogE) return aux + batalha.get(7) + batalha.get(9);
		else return "0";
	}
	
	
}
