package Jogo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class FramePrincipal extends JFrame {
	

	private static final long serialVersionUID = 1L;
	public JPanel pred;
	public JTelaMenu telaMenu;
	private JMenuBar barraMenu;
	private final Action actionSobre = new SwingActionSobre();
	private final Action actionJogadores = new SwingActionJogadores();
	private final Action actionSair = new SwingActionSair();
	
	public static void main(String[] args){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FramePrincipal frame = new FramePrincipal();
						frame.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
	public FramePrincipal(){
		//Configurações do Frame
		this.setBounds(400, 170, 600, 300);
		
		
		//Criação do primeiro Painel (Menu)
		telaMenu = new JTelaMenu(this);
		TitledBorder titledBorder = BorderFactory.createTitledBorder("Login do Personagem");
		titledBorder.setTitleColor(Color.green);
		telaMenu.setBorder(titledBorder);
		telaMenu.setVisible(true);
		this.add(telaMenu);
		
		
		//Painel base para os outros (Sempre deve ser o último do código)
		pred = new JPanel();
		GroupLayout layout = new GroupLayout(pred);
		pred.setLayout(layout);
		pred.setBorder(titledBorder);
		pred.setBackground(new Color(29, 31, 36));
		this.add(pred);
		
		/**
		 * Barra de Menus.
		 */
		barraMenu = new JMenuBar();
		barraMenu.setBounds(0, 0, 600, 25);
		barraMenu.setBackground(new Color(27, 28, 31));
		
		//Menu Arquivo
		JMenu arquivoM = new JMenu("Arquivo");
		arquivoM.setForeground(Color.white);
		barraMenu.add(arquivoM);
		
		//Menu Arquivo - Sair
		JMenuItem sair = new JMenuItem("Sair");
		sair.setAction(actionSair);
		arquivoM.add(sair);
		
		//Menu Jogadores
		JMenu jogadoresM = new JMenu("Jogadores");
		jogadoresM.setForeground(Color.white);
		barraMenu.add(jogadoresM);
		
		//Menu Jogadores - Visualizar
		JMenuItem visJogadores = new JMenuItem("Visualizar");
		visJogadores.setAction(actionJogadores);
		jogadoresM.add(visJogadores);
		
		//Menu Ajuda
		JMenu ajudaM = new JMenu("Ajuda");
		ajudaM.setForeground(Color.white);
		barraMenu.add(ajudaM);
		
		//Menu Sobre - Ajuda
		JMenuItem sobreM = new JMenuItem("Sobre");
		sobreM.setAction(actionSobre);
		ajudaM.add(sobreM);
		
		pred.add(barraMenu);
		
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
			System.exit(0);
		}
	}
	
	/**
	 * Botão Jogadores.
	 */
	private class SwingActionJogadores extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public SwingActionJogadores() {
			putValue(NAME, "Visualizar");
			putValue(SHORT_DESCRIPTION, "Visualizar");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Jogadores jog = new Jogadores();
			jog.setVisible(true);
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
			telaSobre.setBounds(500, 215, 400, 230);
			
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
