package Jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class JTelaAventura extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel pane;
	private final Action actionEnter = new SwingActionEnter();
	private final Action actionFicha = new SwingActionFicha();
	private JTextArea campoMestre;
	private JTextField campoJogador;
	private Personagem player;

	public JTelaAventura(Personagem player){
		this.player = player;
		
		//Panel
		this.pane = new JPanel();
		pane.setBorder ( new TitledBorder ( new EtchedBorder(), "Aventura" ) );
		setContentPane(pane);
		setBounds(320, 130, 750, 400);
		setTitle("SlugueRPG - Aventura");
		setBackground(Color.DARK_GRAY);
		GroupLayout layout = new GroupLayout(pane);
		pane.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Button Enter e Ficha		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setAction(actionEnter);
		btnEnter.setBounds(521, 325, 100, 25);
		pane.add(btnEnter);
		
		JButton btnFicha = new JButton("Ficha");
		btnFicha.setAction(actionFicha);
		btnFicha.setBounds(626, 325, 100, 25);
		pane.add(btnFicha);
		
		//Campo Mestre
		campoMestre = new JTextArea("Seja Bem-Vindo ao SlugueRPG!\n");
		campoMestre.setBorder(new EmptyBorder(4, 4, 4, 4));
		campoMestre.setEnabled(false);
		campoMestre.setBackground(Color.black);
		campoMestre.setDisabledTextColor(Color.green);
		campoMestre.append("\n" + player.getNome() + ", � um " + player.getClasse() + " iniciante. Deseja iniciar a aventura?\n" );
		pane.add(campoMestre);
		
		//Barra de Rolagem
		JScrollPane scrollpane = new JScrollPane(campoMestre);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setBounds(6, 18, 720, 300);
		campoMestre.setCaretPosition(campoMestre.getDocument().getLength());
		pane.add(scrollpane);
		
		//Campo Jogador
		campoJogador = new JTextField(" ");
		campoJogador.setFont(new Font("arial", Font.BOLD, 12));
		campoJogador.setForeground(Color.blue);
		campoJogador.setBounds(6, 325, 511, 26);
		pane.add(campoJogador);
	}
	
	/**
	 * Bot�o Enter, a��o para o CampoJogador
	 */	
	private class SwingActionEnter extends AbstractAction {
		private static final long serialVersionUID = 1L;

		private int etapa;
		private int batalha;

		public SwingActionEnter() {
			putValue(NAME, "Enter");
			putValue(SHORT_DESCRIPTION, "Confirme");
			etapa = 0;
			batalha = 0;
		}

		public void actionPerformed(ActionEvent e) {
			String texto = campoJogador.getText();
			//String[] palavras = texto.split(" ");
			texto = texto.trim();
			if (etapa == 0) {
				if(texto.equalsIgnoreCase("Sim")){
					campoMestre.append("\nNeste momento voc� est� perdido em uma floresta das redondezas de Urboba, um grande vilarejo da Terra M�dia."
							+ "\nVoc� se v� em uma clareira, voltada por mata fechada, voc� pode seguir para norte ou sul, qual dire��o quer ir?\n");
					etapa++;
				}
				if(texto.equalsIgnoreCase("N�o")){
					campoMestre.append("\n" + player.getNome() + ", o tempo est� passando." + " Vamos iniciar a aventura?\n");
					etapa = 0;
				}
						
			} else if (etapa == 1) {
				campoMestre.append("\nVoc� segue pela trilha " + texto + ".\n");
				if (texto.equalsIgnoreCase("Norte")){
					campoMestre.append("\nA trilha � pouco iluminada e o terreno � acidentado. Voc� caminha por mais de 1km, onde as �rvores acabam\n"
								+ "e um grande campo verde est� a sua vis�o. A frente h� um po�o abandonado, deseja investigar ou seguir em frente?\n");
				} 
				if(texto.equalsIgnoreCase("Sul")){
					campoMestre.append("\nO caminho � largo e com bastante curvas, caminhando voc� v� que as �rvores est�o menos densas.\n"
								+ "A frente voc� enxerga um grande port�o, possivelmente de Urboba. Continua...");
				}
				etapa++;
			}else if (etapa == 2) {		
				if(texto.equalsIgnoreCase("Investigar po�o")){
					campoMestre.append("\nAo se aproximar do po�o, voc� ouve algo estranho, algo est� ecoando l� dentro."
							+ "\nNo momento em que voc� p�e sua cabe�a, voc� percebe algo subindo, "
							+ "\nUma Aranha gigante est� vindo em sua dire��o, verticalmente. Deseja sacar sua arma?\n");
					etapa = 3;
				}
				if(texto.equalsIgnoreCase("Seguir em frente")){
					campoMestre.append("\nAo passar pelo po�o, voc� caminha alguns metros e percebe um barulho as suas costas. "
							+ "\nUma Aranha gigante emerge do po�o em alta velocidade. Ela � repleta de p�los e possui grandes presas."
							+ "\nSeus olhos verdes percebem sua presen�a, ela vem at� voc�. Deseja sacar arma?\n");
					etapa++;
				}
			}
			else if (etapa == 3) {
				Enemy aranha = new Enemy("Aranha Gigante", 14, 4, 14);
				//BATALHA 00
				if(batalha == 0){
					
					if(texto.equalsIgnoreCase("Sim")){
						campoMestre.append("\nVoc� saca sua/seu " + player.getArma().getNome() + ". Rolando iniciativa...\n");
						int jogP = player.d20();
						int jogE = aranha.d20();
						campoMestre.append("\nSua rolagem: " + jogP + " | Rolagem do Inimigo: " + jogE + "\n");
						if(jogP > jogE){
							campoMestre.append("\nVoc� ganhou a iniciativa, o que quer fazer?\n");
							batalha++;
						}
						else {
							campoMestre.append("\nA Aranha gigante ganhou a iniciativa. ");
							if(aranha.d20() >= player.getDefesa()){
								aranha.atacar(player);
								if(player.getPv() == 0){
									campoMestre.append("\n" + player.getNome() + "a Aranha te atinge com um golpe mortal, voc� morre.");
									etapa = 0;
								} else campoMestre.append ("\nSeu inimigo consegue cravar as presas em seu bra�o, voc� acabou sofrendo dano.\nO que quer fazer?");
							} else {
								campoMestre.append("\nSeu inimigo tentou atacar voc�, com um r�pido reflexo conseguiu desviar."
										+ "\nO que quer fazer?");
							}
							batalha++;							
						}
					
					} else if (texto.equalsIgnoreCase("N�o")){
							if(aranha.d20() >= player.getDefesa()){
								aranha.atacar(player);
								if(player.getPv() == 0){
									campoMestre.append("\n" + player.getNome() + ", a Aranha te atinge com um golpe mortal, voc� morre.");
									etapa = 0;
								} else campoMestre.append("\nVoc� tomou um ataque surpresa, e acabou sofrendo dano.");
							} else {
								campoMestre.append("\nA Aranha tentou atacar voc�, com um r�pido reflexo conseguiu desviar.");
							}
						campoMestre.append("\nO que quer fazer?\n");
						batalha++;
					} 
				}
					//BATALHA 01
					else if(batalha == 1){
						if(texto.equalsIgnoreCase("Atacar")){
							int jogP = player.d20();
							campoMestre.append("\nSua rolagem: " + jogP + "\n");
							if(jogP > aranha.getDefesa()){
								player.atacar(aranha);
								if(aranha.getPvsEnemy() > 0){
								campoMestre.append("\nVoc� consegue desferir um ataque em seu Inimigo. Inflinge " + player.getArma().getDano() + " pontos de dano.\n");
								batalha++;
								} else if(aranha.getPvsEnemy() == 0) { 
									campoMestre.append("\nCom um ataque fatal, voc� atinge seu Inimigo, ele est� morto.");
									etapa++;
								}
							}
							else {
								campoMestre.append("\nVoc� desfere o ataque, mas a Aranha � mais r�pida e reflete.\n");
								batalha++;
							}
						} else if(texto.equalsIgnoreCase("Nada")){
							batalha++;
						}
					}
					//BATALHA 02
					else if(batalha == 2){
						int jogE = aranha.d20();
						if(jogE > player.getDefesa()){
							aranha.atacar(player);
							if(player.getPv() == 0){
								campoMestre.append("\n" + player.getNome() + ", a Aranha te atinge com um golpe mortal, voc� morre.\n");
								etapa = 0;
							} else campoMestre.append("\nA Aranha crava as presas em sua perna, voc� acabou sofrendo dano.\n"
									+ "\nO que deseja fazer?");
							
						} else campoMestre.append("\nA Aranha tenta cravar suas presas em sua perna, voc� consegue refletir.\n"
								+ "\nO que deseja fazer?");
							batalha = 1;
						}
				}
			campoJogador.setText("");
		}		
	}
	
	/**
	 * Bot�o para mostrar ficha do personagem
	 */
	private class SwingActionFicha extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public SwingActionFicha() {
			putValue(NAME, "Ficha");
			putValue(SHORT_DESCRIPTION, "Mostrar");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JVerFicha f = new JVerFicha(player);
			f.setVisible(true);	
		}
	}
		
}
