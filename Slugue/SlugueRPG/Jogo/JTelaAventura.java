package Jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class JTelaAventura extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private FramePrincipal masterFrame;
	private final Action actionEnter = new SwingActionEnter();
	private final Action actionFicha = new SwingActionFicha();
	private final Action actionSobre = new SwingActionSobre();
	private final Action actionSair = new SwingActionSair();
	private JTextArea campoMestre;
	private JTextField campoJogador;
	private JMenuBar barraMenu;
	private Personagem player;
	private ArrayList<String> batalha;

	public JTelaAventura(Personagem player, FramePrincipal master){
		//Setando o principal frame
		this.player = player;
		this.masterFrame = master;
		
		//Configurações do Painel (Tela Aventura)
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		setBounds(0, 0, 750, 400);
		this.setBorder ( new TitledBorder ( new EtchedBorder(), "Slugue RPG" ) );
		
		/**
		 * Barra de Menus.
		 */
		barraMenu = new JMenuBar();
		barraMenu.setBounds(6, 18, 720, 25);
		barraMenu.setBackground(Color.DARK_GRAY);
		
		//Menu Arquivo
		JMenu arquivoM = new JMenu("Arquivo");
		arquivoM.setForeground(Color.white);
		barraMenu.add(arquivoM);
		
		//Menu Arquivo - Sair
		JMenuItem sair = new JMenuItem("Sair");
		sair.setAction(actionSair);
		arquivoM.add(sair);
		
		//Menu Opções
		JMenu opcoesM = new JMenu("Opções");
		opcoesM.setForeground(Color.white);
		barraMenu.add(opcoesM);
		
		//Menu Ajuda
		JMenu ajudaM = new JMenu("Ajuda");
		ajudaM.setForeground(Color.white);
		barraMenu.add(ajudaM);
		
		//Menu Sobre - Ajuda
		JMenuItem sobreM = new JMenuItem("Sobre");
		sobreM.setAction(actionSobre);
		ajudaM.add(sobreM);
		
		this.add(barraMenu);
		
		//Button Enter e Ficha		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setAction(actionEnter);
		btnEnter.setBounds(521, 325, 100, 25);
		masterFrame.getRootPane().setDefaultButton(btnEnter);
		this.add(btnEnter);
		     										
		JButton btnFicha = new JButton("Ficha");
		btnFicha.setAction(actionFicha);
		btnFicha.setBounds(626, 325, 100, 25);
		this.add(btnFicha);
		
		//Campo Mestre
		campoMestre = new JTextArea("Seja Bem-Vindo ao SlugueRPG!\n");
		campoMestre.setBorder(new EmptyBorder(4, 4, 4, 4));
		campoMestre.setEnabled(false);
		campoMestre.setBackground(Color.black);
		campoMestre.setDisabledTextColor(Color.green);
		campoMestre.append("\n" + player.getNome() + ", é um " + player.getClasse() + " iniciante. Deseja iniciar a aventura?\n" );
		this.add(campoMestre);
		
		//Barra de Rolagem
		JScrollPane scrollpane = new JScrollPane(campoMestre);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setBounds(6, 43, 720, 275);
		campoMestre.setCaretPosition(campoMestre.getDocument().getLength());
		this.add(scrollpane);
		
		//Campo Jogador
		campoJogador = new JTextField(" ");
		campoJogador.setFont(new Font("arial", Font.BOLD, 12));
		campoJogador.setForeground(Color.blue);
		campoJogador.setBounds(6, 325, 511, 26);
		this.add(campoJogador);
	}
	
	/**
	 * Botão Enter, ação para o CampoJogador
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
					campoMestre.append("\nNeste momento você está perdido em uma floresta das redondezas de Urboba, um grande vilarejo da Terra Média."
							+ "\nVocê se vê em uma clareira, voltada por mata fechada, você pode seguir para norte ou sul, qual direção quer ir?\n");
					etapa++;
				}
				if(texto.equalsIgnoreCase("Não")){
					campoMestre.append("\n" + player.getNome() + ", o tempo está passando." + " Vamos iniciar a aventura?\n");
					etapa = 0;
				}
						
			} else if (etapa == 1) {
				campoMestre.append("\nVocê segue pela trilha " + texto + ".\n");
				if (texto.equalsIgnoreCase("Norte")){
					campoMestre.append("\nA trilha é pouco iluminada e o terreno é acidentado. Você caminha por mais de 1km, onde as árvores acabam\n"
								+ "e um grande campo verde está a sua visão. A frente há um poço abandonado, deseja investigar ou seguir em frente?\n");
				} 
				if(texto.equalsIgnoreCase("Sul")){
					campoMestre.append("\nO caminho é largo e com bastante curvas, caminhando você vê que as árvores estão menos densas.\n"
								+ "A frente você enxerga um grande portão, possivelmente de Urboba. Continua...");
				}
				etapa++;
			}else if (etapa == 2) {		
				if(texto.equalsIgnoreCase("Investigar poço")){
					campoMestre.append("\nAo se aproximar do poço, você ouve algo estranho, algo está ecoando lá dentro."
							+ "\nNo momento em que você põe sua cabeça, você percebe algo subindo, "
							+ "\nUma Aranha gigante está vindo em sua direção, verticalmente. Deseja sacar sua arma?\n");
					etapa = 3;
				}
				if(texto.equalsIgnoreCase("Seguir em frente")){
					campoMestre.append("\nAo passar pelo poço, você caminha alguns metros e percebe um barulho as suas costas. "
							+ "\nUma Aranha gigante emerge do poço em alta velocidade. Ela é repleta de pêlos e possui grandes presas."
							+ "\nSeus olhos verdes percebem sua presença, ela vem até você. Deseja sacar arma?\n");
					etapa++;
				}
			}
			else if (etapa == 3) {
				Enemy aranha = new Enemy("Aranha Gigante", 14, 4, 14);
				//BATALHA 00
				if(batalha == 0){
					
					if(texto.equalsIgnoreCase("Sim")){
						campoMestre.append("\nVocê saca sua/seu " + player.getArma().getNome() + ". Rolando iniciativa...\n");
						int jogP = player.d20();
						int jogE = aranha.d20();
						campoMestre.append("\nSua rolagem: " + jogP + " | Rolagem do Inimigo: " + jogE + "\n");
						if(jogP > jogE){
							campoMestre.append("\nVocê ganhou a iniciativa, o que quer fazer?\n");
							batalha++;
						}
						else {
							campoMestre.append("\nA Aranha gigante ganhou a iniciativa. ");
							if(aranha.d20() >= player.getDefesa()){
								aranha.atacar(player);
								if(player.getPv() == 0){
									campoMestre.append("\n" + player.getNome() + "a Aranha te atinge com um golpe mortal, você morre.");
									etapa = 0;
								} else campoMestre.append ("\nSeu inimigo consegue cravar as presas em seu braço, você acabou sofrendo dano.\nO que quer fazer?");
							} else {
								campoMestre.append("\nSeu inimigo tentou atacar você, com um rápido reflexo conseguiu desviar."
										+ "\nO que quer fazer?");
							}
							batalha++;							
						}
					
					} else if (texto.equalsIgnoreCase("Não")){
							if(aranha.d20() >= player.getDefesa()){
								aranha.atacar(player);
								if(player.getPv() == 0){
									campoMestre.append("\n" + player.getNome() + ", a Aranha te atinge com um golpe mortal, você morre.");
									etapa = 0;
								} else campoMestre.append("\nVocê tomou um ataque surpresa, e acabou sofrendo dano.");
							} else {
								campoMestre.append("\nA Aranha tentou atacar você, com um rápido reflexo conseguiu desviar.");
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
								campoMestre.append("\nVocê consegue desferir um ataque em seu Inimigo. Inflinge " + player.getArma().getDano() + " pontos de dano.\n");
								batalha++;
								} else if(aranha.getPvsEnemy() == 0) { 
									campoMestre.append("\nCom um ataque fatal, você atinge seu Inimigo, ele está morto.");
									etapa++;
								}
							}
							else {
								campoMestre.append("\nVocê desfere o ataque, mas a Aranha é mais rápida e reflete.\n");
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
								campoMestre.append("\n" + player.getNome() + ", a Aranha te atinge com um golpe mortal, você morre.\n");
								etapa = 0;
							} else campoMestre.append("\nA Aranha crava as presas em sua perna, você acabou sofrendo dano.\n"
									+ "\nO que deseja fazer?");
							
						} else campoMestre.append("\nA Aranha tenta cravar suas presas em sua perna, você consegue refletir.\n"
								+ "\nO que deseja fazer?");
							batalha = 1;
						}
				}
			campoJogador.setText("");
		}		
	}
	
	/**
	 * Botão para mostrar ficha do personagem
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
	
	/**
	 * Botão Sair no SubMenu do botão Arquivo.
	 */
	private class SwingActionSair extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public SwingActionSair() {
			putValue(NAME, "Sair");
			putValue(SHORT_DESCRIPTION, "Sair");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			masterFrame.telaMenu.setVisible(true);
			masterFrame.setBounds(400,170,600,300);
			setVisible(false);
		}
	}
	
	/**
	 * Botão Sobre no subMenu Ajuda.
	 */
	private class SwingActionSobre extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public SwingActionSobre() {
			putValue(NAME, "Sobre");
			putValue(SHORT_DESCRIPTION, "Sobre");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame telaSobre = new JFrame();
			telaSobre.setBounds(470, 215, 400, 230);
			
			JPanel aux = new JPanel();
			aux.setBounds(0, 0, 400, 160);
			aux.setVisible(true);
			GroupLayout layout = new GroupLayout(aux);
			aux.setLayout(layout);
			aux.setBackground(Color.DARK_GRAY);
			telaSobre.add(aux);
			
			final JTextArea label = new JTextArea("    Slugue RPG - Jogo Textual" + "\n\n" 
													+ "       Versão 1.0 - Urboba City \n  Bruno Moreira e Luiz Eduardo" 
														+ "\n\n" + "(c)Todos os direitos reservados");  
			label.setEditable(false);  
			label.setLineWrap(true);
			label.setBackground(Color.DARK_GRAY);
			label.setForeground(Color.white);
			label.setBounds(110, 30, 260, 150);
			aux.add(label);
			
			telaSobre.setVisible(true);
		}
	}
		
}
