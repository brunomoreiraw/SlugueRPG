package Jogo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	private JTextArea campoMestre = new JTextArea("Seja Bem-Vindo ao SlugueRPG!\n");
	private JTextField campoJogador = new JTextField(0);
	
	JScrollPane scrollpane = new JScrollPane(campoMestre);
	
	/**
	 * Cria��o da Tela de Aventura
	 */
	public static void main(String[] args){
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTelaJogar tela = new JTelaJogar();
					tela.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JTelaJogar(){
		pane = new JPanel();
		pane.setBorder ( new TitledBorder ( new EtchedBorder(), "Aventura" ) );
		//pane.setBorder(new EmptyBorder(12, 5, 10, 10));
		campoMestre.setBorder(new EmptyBorder(2, 3, 5, 5));
		setContentPane(pane);
		
		setBounds(380, 130, 750, 400);
		setTitle("SlugueRPG - Aventura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setAction(actionEnter);
		
		campoMestre.setEnabled(false);
		campoMestre.append("\nDigite o nome do seu personagem:\n");
		
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
									GroupLayout.PREFERRED_SIZE, 600,
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
		// TODO: Arrumar texto e tamanho da tela bloqueada
		
	}
	
	private class SwingActionEnter extends AbstractAction {
		//TODO: Barra de Rolagem!
		private static final long serialVersionUID = 1L;
		private int etapa;
		private String temp;

		public SwingActionEnter() {
			putValue(NAME, "Enter");
			putValue(SHORT_DESCRIPTION, "Confirme");
			etapa = 0;
			temp = "Sem nome definido";
		}

		public void actionPerformed(ActionEvent e) {

			if (etapa == 0) {
				String texto = campoJogador.getText();
				campoJogador.setText("");
				
				String[] palavras = texto.split(" ");

				texto = palavras[0];
				campoMestre.append("Seu nome agora � " + texto + ".\n");
				campoMestre.append("\nQual classe voc� quer ser? \n");
				etapa++;
				temp = texto;
				
			} else if (etapa == 1) {
				String texto = campoJogador.getText();
				campoMestre.append(temp + ", � um " + texto + " iniciante.\n");
				campoMestre.append("\nAgora, voc� est� pronto para se aventurar!");
				campoMestre.append("\nNeste momento voc� est� perdido em uma floresta das redondezas de Urboba, um grande vilarejo da Terra M�dia.");
				campoMestre.append("\nVoc� se v� em uma clareira, voltada por mata fechada, voc� pode seguir para norte ou sul, qual dire��o quer ir?\n");
				campoJogador.setText(" ");
				etapa++;
			}

			else if (etapa == 2) {
				temp = campoJogador.getText();
				campoMestre.append("\nVoc� segue pela trilha" + temp + ".\n");
				campoJogador.setText("");
				if (temp.equals("norte")){
					campoMestre.append("\nA trilha � pouco iluminada e o terreno � acidentado. Voc� caminha por mais de 1km, onde as �rvores acabam\n"
							+ "e um grande campo verde est� a sua vis�o. A frente h� um po�o abandonado, deseja investigar?");
				} 
				if(temp.equals("sul")){
					campoMestre.append("\nO caminho � largo e com bastante curvas, caminhando voc� v� que as �rvores est�o menos densas.\n"
							+ "A frente voc� enxerga um grande port�o, possivelmente de Urboba.");
				}
				etapa++;
			}
			
		}
	}
		
}
