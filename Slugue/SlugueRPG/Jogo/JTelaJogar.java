package Jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//TODO import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class JTelaJogar extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel pane;
	private final Action actionEnter = new SwingActionEnter();
	private final Action actionFicha = new SwingActionFicha();
	private JTextArea campoMestre = new JTextArea("Seja Bem-Vindo ao SlugueRPG!\n");
	private JTextField campoJogador = new JTextField(0);
	private Personagem player;
	
	/**
	 * Cria��o da Tela de Aventura
	 */
		
	public JTelaJogar(Personagem player){
		this.player = player;
		this.pane = new JPanel();
		pane.setBorder ( new TitledBorder ( new EtchedBorder(), "Aventura" ) );
		campoMestre.setBorder(new EmptyBorder(2, 3, 5, 5));
		setContentPane(pane);
		
		//TODO JScrollPane scrollpane = new JScrollPane(pane);
		
		setBounds(320, 130, 750, 400);
		setTitle("SlugueRPG - Aventura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setAction(actionEnter);
		
		JButton btnFicha = new JButton("Ficha");
		btnFicha.setAction(actionFicha);
		btnFicha.setBounds(5, 328, 87, 25);
		pane.add(btnFicha);
		
		campoMestre.setEnabled(false);
		campoMestre.append("\n" + player.getNome() + ", � um " + player.getClasse() + " iniciante. Deseja iniciar a aventura?\n" );
		
		/**
		 * Formata��o Textos
		 */
		campoJogador.setFont(new Font("arial", Font.BOLD, 12));
		campoJogador.setForeground(Color.red);
		campoMestre.setBackground(Color.black);
		campoMestre.setDisabledTextColor(Color.green);
		
		GroupLayout aventura = new GroupLayout(pane);
		aventura.setHorizontalGroup(aventura
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						Alignment.TRAILING,
						aventura
							.createSequentialGroup()
							.addComponent(campoJogador,
									GroupLayout.PREFERRED_SIZE, 513,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEnter,
									GroupLayout.PREFERRED_SIZE, 100,
									GroupLayout.PREFERRED_SIZE))
				.addGroup(
						aventura
							.createSequentialGroup()
							.addContainerGap()
							.addComponent(campoMestre,
									GroupLayout.PREFERRED_SIZE, 700,
									GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE,
									Short.MAX_VALUE)));
		aventura.setVerticalGroup(aventura
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						aventura
							.createSequentialGroup()
							.addComponent(campoMestre,
									GroupLayout.PREFERRED_SIZE,
									300, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(
									ComponentPlacement.RELATED, 9,
									Short.MAX_VALUE)
							.addGroup(
									aventura
										.createParallelGroup(
												Alignment.BASELINE)
										.addComponent(
												campoJogador,
												GroupLayout.PREFERRED_SIZE,
												26,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(
												btnEnter))));
		pane.setLayout(aventura);
		
	}
	
	/**
	 * Bot�o Enter, a��o para o CampoJogador
	 */	
	private class SwingActionEnter extends AbstractAction {
		private static final long serialVersionUID = 1L;
		private int etapa;

		public SwingActionEnter() {
			putValue(NAME, "Enter");
			putValue(SHORT_DESCRIPTION, "Confirme");
			etapa = 0;
			//temp = "Sem nome definido";
		}

		public void actionPerformed(ActionEvent e) {
			String texto = campoJogador.getText();
			//String[] palavras = texto.split(" ");
			//texto = texto.trim();
			if (etapa == 0) {
				if(texto.equals("Sim")){
					campoMestre.append("\nNeste momento voc� est� perdido em uma floresta das redondezas de Urboba, um grande vilarejo da Terra M�dia."
							+ "\nVoc� se v� em uma clareira, voltada por mata fechada, voc� pode seguir para norte ou sul, qual dire��o quer ir?\n");
					etapa++;
				}
				if(texto.equals("N�o")){
					campoMestre.append("\n" + player.getNome() + ", o tempo est� passando." + " Vamos iniciar a aventura?\n");
					etapa = 0;
				}
						
			} else if (etapa == 1) {
				campoMestre.append("\nVoc� segue pela trilha " + texto + ".\n");
				if (texto.equals("Norte")){
					campoMestre.append("\nA trilha � pouco iluminada e o terreno � acidentado. Voc� caminha por mais de 1km, onde as �rvores acabam\n"
								+ "e um grande campo verde est� a sua vis�o. A frente h� um po�o abandonado, deseja investigar ou seguir em frente?\n");
				} 
				if(texto.equals("Sul")){
					campoMestre.append("\nO caminho � largo e com bastante curvas, caminhando voc� v� que as �rvores est�o menos densas.\n"
								+ "A frente voc� enxerga um grande port�o, possivelmente de Urboba.");
				}
				etapa++;
			}else if (etapa == 2) {
				if(texto.equals("Investigar po�o")){
					campoMestre.append("\nAo se aproximar do po�o, voc� ouve algo estranho, algo est� ecoando l� dentro."
							+ "\nNo momento em que voc� p�e sua cabe�a, voc� percebe algo subindo, "
							+ "Uma Aranha gigante est� vindo em sua dire��o, verticalmente.\n");
					etapa++;
				}
				if(texto.equals("Seguir em frente")){
					campoMestre.append("\nAo passar pelo po�o, voc� caminha alguns metros e percebe um barulho as suas costas. "
							+ "\nUma Aranha gigante emerge do po�o em alta velocidade. Ela � repleta de p�los e possui grandes presas. \nSeus olhos verdes percebem sua presen�a.\n");
					etapa++;
				}
			}
			else if (etapa == 3){
				campoMestre.append(player.toString());
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
			JFicha f = new JFicha(player);
			f.setVisible(true);	
		}
	}
		
}
