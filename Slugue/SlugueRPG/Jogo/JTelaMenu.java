package Jogo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

	public class JTelaMenu extends JFrame {
		private static final long serialVersionUID = 1L;
		private JPanel paneMenu;
		private final Action criarFicha = new SwingActionCriarFicha();
		private final Action jogarAventura = new SwingActionJogarAventura();
		private final Action ready = new SwingActionReady();
		private JTextField personagemNome;
		private JButton btnOk;
		
	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTelaMenu telaMenu = new JTelaMenu();
					telaMenu.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JTelaMenu(){
		paneMenu = new JPanel();
		paneMenu.setBorder ( new TitledBorder ( new EtchedBorder(), "Slugue RPG" ) );
		setContentPane(paneMenu);
		GroupLayout layout = new GroupLayout(paneMenu);
		paneMenu.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		setBounds(480, 150, 400, 200);
		setTitle("SlugueRPG - Aventura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		paneMenu.setBackground(Color.white);
		
		JButton btnCriar = new JButton("Criar Ficha");
		btnCriar.setAction(criarFicha);
		btnCriar.setBounds(69, 22, 110, 25);
		paneMenu.add(btnCriar);
		
		JButton btnJogar = new JButton("Jogar Aventura");
		btnJogar.setAction(jogarAventura);
		btnJogar.setBounds(189, 22, 130, 25);
		paneMenu.add(btnJogar);
		
		JLabel bemVindo = new JLabel("Seja Bem Vindo! Escolha uma das op��es.");
		bemVindo.setBounds(74, 60, 246, 14);
		paneMenu.add(bemVindo);
		
		btnOk = new JButton("OK");
		btnOk.setAction(ready);
		btnOk.setBounds(240, 115, 80, 25);
		paneMenu.add(btnOk);
		btnOk.setVisible(false);
	}
		
	/**
	 * Bot�o para Criar Ficha
	 */
	private class SwingActionCriarFicha extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public SwingActionCriarFicha() {
			putValue(NAME, "Criar Ficha");
			putValue(SHORT_DESCRIPTION, "Confirme");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JTelaFicha telaFicha = new JTelaFicha();
			telaFicha.setVisible(true);	
			
		}
	}
	
	/**
	 * Bot�o para Jogar Aventura
	 */
			private class SwingActionJogarAventura extends AbstractAction {
			//TODO: Barra de Rolagem!
			private static final long serialVersionUID = 1L;

			public SwingActionJogarAventura() {
				putValue(NAME, "Jogar Aventura");
				putValue(SHORT_DESCRIPTION, "Confirme");
			}

			@Override
			public void actionPerformed(ActionEvent e) {	
				JLabel nomePersonagem = new JLabel("Com qual personagem deseja jogar?");
				nomePersonagem.setBounds(74, 95, 250, 14);
				paneMenu.add(nomePersonagem);
				
				nomePersonagem.setForeground(Color.blue);
				nomePersonagem.setBackground(Color.white);
				
				personagemNome = new JTextField(0);
				personagemNome.setBounds(74, 115, 160, 25);
				personagemNome.setFont(new Font("arial", Font.BOLD, 12));
				personagemNome.setHorizontalAlignment(JTextField.CENTER);
				paneMenu.add(personagemNome);
				
				personagemNome.setForeground(Color.blue);
				personagemNome.setBackground(Color.white);
				personagemNome.setBorder(BorderFactory.createLineBorder(Color.black));
				
				btnOk.setVisible(true);
			}
		}		
			/**
			 * Bot�o para Pronto para Jogo
			 */
			private class SwingActionReady extends AbstractAction {
				private static final long serialVersionUID = 1L;

				public SwingActionReady() {
					putValue(NAME, "OK");
					putValue(SHORT_DESCRIPTION, "Confirme");
				}

				@Override
				public void actionPerformed(ActionEvent e) {
					String nome = personagemNome.getText();
					Arma espada = new Arma("Espada", 8, 'c');
					Personagem player = new Personagem(nome, "Guerreiro", 3, 1, 4, espada);
					JTelaJogar telaJogar = new JTelaJogar(player);
					telaJogar.setVisible(true);					
				}
				
			}			
			
	}
