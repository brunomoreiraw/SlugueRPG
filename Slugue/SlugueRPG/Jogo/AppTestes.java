package Jogo;

import java.util.Random;

public class AppTestes {

	public static void main(String[] args) {
		Arma espadaC = new Arma("Espada Curta", 6, 'c');
		Personagem p = new Personagem("Bryan", "Clérigo", 3, 1, 3, espadaC);
		Enemy e = new Enemy("Aranha Gigante", 14, 4, 14);
		
		int o = p.getPv();
		int aux = e.d20();
		if(aux >= p.getDefesa());
		e.atacar(p); 
		o = p.getPv();
		
		Random rola = new Random();
		int damage = 0;
		
		int dado = rola.nextInt(e.getAtaque());
		if(p.getArma().getTipo() == 'c'){
			damage = p.getForc() + dado;
		}
		if(p.getArma().getTipo() == 'd'){
			damage = p.getAgi() + dado;
		}
		if(p.getArma().getTipo() == 'm'){
			damage = p.getSab() + dado;
		}	
	}

}
