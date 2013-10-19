package Jogo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
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
		
		setBounds(480, 150, 400, 200);
		setTitle("SlugueRPG - Aventura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		paneMenu.setBackground(Color.white);
		
		JButton btnCriar = new JButton("Criar Ficha");
		btnCriar.setAction(criarFicha);
		paneMenu.add(btnCriar);
		
		JButton btnJogar = new JButton("Jogar Aventura");
		btnJogar.setAction(jogarAventura);
		paneMenu.add(btnJogar);
		
		JLabel bemVindo = new JLabel("Seja Bem Vindo! Escolha uma das opções.");
		bemVindo.setBounds(69, 50, 46, 14);
		paneMenu.add(bemVindo);
		
	}
		
	/**
	 * Botão para Criar Ficha
	 */
	private class SwingActionCriarFicha extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public SwingActionCriarFicha() {
			putValue(NAME, "Criar Ficha");
			putValue(SHORT_DESCRIPTION, "Confirme");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	
	/**
	 * Botão para Jogar Aventura
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
				nomePersonagem.setBounds(84, 75, 250, 14);
				paneMenu.add(nomePersonagem);
				
				nomePersonagem.setForeground(Color.blue);
				nomePersonagem.setBackground(Color.white);
				
				personagemNome = new JTextField();
				personagemNome.setBounds(84, 95, 150, 25);
				personagemNome.setFont(new Font("arial", Font.BOLD, 12));
				paneMenu.add(personagemNome);
				
				personagemNome.setForeground(Color.red);
				personagemNome.setBackground(Color.white);
				personagemNome.setBorder(BorderFactory.createLineBorder(Color.black));
				
				JButton btnOk = new JButton("OK");
				btnOk.setAction(ready);
				btnOk.setBounds(240, 95, 60, 25);
				paneMenu.add(btnOk);
			}
		}		
			/**
			 * Botão para Pronto para Jogo
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
					Personagem player = new Personagem(nome, "Guerreiro", 7, 6, 8);
					JTelaJogar telaJogar = new JTelaJogar(player);
					telaJogar.setVisible(true);					
				}
			}			
			
	}
