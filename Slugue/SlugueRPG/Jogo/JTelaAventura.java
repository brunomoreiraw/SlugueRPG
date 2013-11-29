package Jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
	private JVerFicha ficha;
	private JMenuItem escM1;
	private JMenuItem escM2;

	public JTelaAventura(Personagem player, FramePrincipal master){
		//Setando o principal frame
		this.player = player;
		this.masterFrame = master;
		
		//Configura��es do Painel (Tela Aventura)
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
		
		//Menu Op��es
		JMenu opcoesM = new JMenu("Op��es");
		opcoesM.setForeground(Color.white);
		barraMenu.add(opcoesM);
		
		//Menu Escolha 1 - Op��es
		escM1 = new JMenuItem("Sim");
		opcoesM.add(escM1);
				
		//Menu Escolha 2 - Op��es
		escM2 = new JMenuItem("N�o");
		opcoesM.add(escM2);
		
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
		campoMestre.append("\n" + player.getNome() + ", � um " + player.getClasse() + " iniciante. Deseja iniciar a aventura?\n" );
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
	 * Bot�o Enter, a��o para o CampoJogador
	 */	
	private class SwingActionEnter extends AbstractAction {
		private static final long serialVersionUID = 1L;

		private int etapa;
		private int batalha;
		private Etapas cpu;
		private String esc1;
		private String esc2;

		public SwingActionEnter() {
			putValue(NAME, "Enter");
			putValue(SHORT_DESCRIPTION, "Confirme");
			cpu = new Etapas();
			etapa = 0;
			batalha = 0;
		}

		public void actionPerformed(ActionEvent e) throws IllegalArgumentException{
			String texto = campoJogador.getText();
			texto = texto.trim();
			
			try {
				if (etapa == 0) {
					esc1 = "Sim";
					esc2 = "N�o";
					escM1.setText(esc1);
					escM2.setText(esc2);
					
					if(texto.equalsIgnoreCase(esc1)){
						campoMestre.append("\nNeste momento voc� est� perdido em uma floresta das redondezas de Urboba, um grande vilarejo da Terra M�dia."
								+ "\nVoc� se v� em uma clareira, voltada por mata fechada, voc� pode seguir para norte ou sul, qual dire��o quer ir?\n");
						etapa++;
					}
					else if(texto.equalsIgnoreCase(esc2)){
						campoMestre.append("\n" + player.getNome() + ", o tempo est� passando." + " Vamos iniciar a aventura?\n");
						etapa = 0;
					}
					else 
						throw new IllegalArgumentException();
					escM1.setText("Norte");
					escM2.setText("Sul");
					
				} else if (etapa == 1) {
					esc1 = "Norte";
					esc2 = "Sul";
					
					if (texto.equalsIgnoreCase(esc1)){
						campoMestre.append("\nVoc� segue pela trilha Norte." + "\n");
						campoMestre.append("\nA trilha � pouco iluminada e o terreno � acidentado. Voc� caminha por mais de 1km, onde as �rvores acabam\n"
									+ "e um grande campo verde est� a sua vis�o. A frente h� um po�o abandonado, deseja investigar ou seguir em frente?\n");
						etapa++;
					} 
					else if(texto.equalsIgnoreCase(esc2)){
						campoMestre.append("\nVoc� segue pela trilha Sul." + "\n");
						campoMestre.append("\nO caminho � largo e com bastante curvas, caminhando voc� v� que as �rvores est�o menos densas.\n"
									+ "A frente voc� enxerga um grande port�o, possivelmente de Urboba. Continua...");
						etapa++;
					}
					else 
						throw new IllegalArgumentException();
					escM1.setText("Investigar po�o");
					escM2.setText("Seguir em frente");
					
				}else if (etapa == 2) {		
					esc1 = "Investigar po�o";
					esc2 = "Seguir em frente";
					
					if(texto.equalsIgnoreCase(esc1)){
						campoMestre.append("\nAo se aproximar do po�o, voc� ouve algo estranho, algo est� ecoando l� dentro."
								+ "\nNo momento em que voc� p�e sua cabe�a, voc� percebe algo subindo, "
								+ "\nUma Aranha gigante est� vindo em sua dire��o, verticalmente. Deseja sacar sua arma?\n");
						etapa++;
					}
					else if(texto.equalsIgnoreCase(esc2)){
						campoMestre.append("\nAo passar pelo po�o, voc� caminha alguns metros e percebe um barulho as suas costas. "
								+ "\nUma Aranha gigante emerge do po�o em alta velocidade. Ela � repleta de p�los e possui grandes presas."
								+ "\nSeus olhos verdes percebem sua presen�a, ela vem at� voc�. Deseja sacar sua arma?");
						etapa++;
					}
					else 
						throw new IllegalArgumentException();
					escM1.setText("Sim");
					escM2.setText("N�o");
				}
				else if (etapa == 3) {
					Enemy aranha = new Enemy("Aranha Gigante", 14, 4, 14);
					
					//BATALHA 00
					if(batalha == 0){
						esc1 = "Sim";
						esc2 = "N�o";
						
						if(texto.equalsIgnoreCase(esc1)){
							campoMestre.append(cpu.sacarArma(player));
							String aux = cpu.rolaIniciativa(player, aranha);
							if(aux.equals("0")){
								campoMestre.append(cpu.batalha.get(8));
								campoMestre.append(cpu.eAtaque(player, aranha));
								campoMestre.append(cpu.batalha.get(9));
								batalha++;
							}
							else{
								campoMestre.append(aux);
								batalha++;
							}
						}
						else if (texto.equalsIgnoreCase(esc2)){
							campoMestre.append(cpu.eAtaque(player, aranha));
							campoMestre.append(cpu.batalha.get(9));
							batalha++;
						}
							else 
								throw new IllegalArgumentException();
						escM1.setText("Atacar");
						escM2.setText("Nada");
						
					}
					
					//BATALHA 01 - ATAQUE DO PERSONAGEM
					else if(batalha == 1){
						esc1 = "Atacar";
						esc2 = "Nada";
						
						if(texto.equalsIgnoreCase(esc1)){
							campoMestre.append(cpu.pAtaque(player, aranha));
							if(batalha == 4){
								campoMestre.append("\n\nO Jogo acabou, voc� derrotou o monstro.");
							}
							campoMestre.append(" Prosseguir?\n");
							batalha++;
						} 
						else if(texto.equalsIgnoreCase(esc2)){
							campoMestre.append(" Prosseguir?\n");
							batalha++;
						}
						else if(aranha.getPvsEnemy() <= 0){
							batalha = 4;
						}
						else 
							throw new IllegalArgumentException();
					}
					
					//BATALHA 02 - ATAQUE DO INIMIGO
					else if(batalha == 2){
						campoMestre.append(cpu.eAtaque(player, aranha));
						if(player.getPv() <= 0){
							batalha = 3;
						}
						campoMestre.append(cpu.batalha.get(9));
						batalha = 1;
						escM1.setText("Atacar");
						escM2.setText("Nada");
					}
					
					//BATALHA 03 - MORTE JOGADOR
					else if(batalha == 3){
						campoMestre.append("\n\nO Jogo acabou, voc� morreu.");
					}
					
					//BATALHA 04 - MORTE MONSTRO
					else if(batalha == 4){
						campoMestre.append("\n\nO Jogo acabou, voc� derrotou o monstro.");
					}
				}
			} catch (IllegalArgumentException ex) {
				JOptionPane.showMessageDialog(null, "Entrada inv�lida.\n" + "Verifique as possiveis escolhas no menu.");
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
			if(JVerFicha.etapa == 0){
				ficha = new JVerFicha(player);
				ficha.setVisible(true);
				JVerFicha.etapa = 1;
			}
			else if(JVerFicha.etapa == 1){
				ficha.setVisible(false);
				JVerFicha.etapa = 0;
			}
		}
	}
	
	/**
	 * Bot�o Sair no SubMenu do bot�o Arquivo.
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
	 * Bot�o Sobre no subMenu Ajuda.
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
													+ "       Vers�o 1.0 - Urboba City \n  Bruno Moreira e Luiz Eduardo" 
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
