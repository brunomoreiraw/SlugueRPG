package Jogo;

public class AppTestes {

	public static void main(String[] args) {
		Personagem Bruno = new Personagem("Bruno", "Guerreiro", 7, 6, 8);
		System.out.println(Bruno);
		Enemy Orc = new Enemy("Uruk");
		System.out.println(Orc);
		
		
		Bruno.atacar(Orc);
		Bruno.atacar(Orc);
		
		System.out.println(Orc);

	}

}
