package Jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JTelaMenu extends JPanel {
		
	private static final long serialVersionUID = 1L;
		
		private FramePrincipal masterFrame;
		private JTextField personagemNome;
		private JButton btnOk;
		private final Action criarFicha = new SwingActionCriarFicha();
		private final Action jogarAventura = new SwingActionJogarAventura();
		private final Action ok = new SwingActionOk();
		
	public JTelaMenu(FramePrincipal master){
		//Setando o principal frame
		this.masterFrame = master;
		
		//Configurações do Painel (menu)
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		setBounds(90, 30, 400, 200);
		this.setBackground(Color.white);
		
		//Botão Criar Personagem
		JButton btnCriar = new JButton("Criar Ficha");
		btnCriar.setAction(criarFicha);
		btnCriar.setBounds(71, 42, 110, 25);
		this.add(btnCriar);
		
		//Botão Jogar Aventura
		JButton btnJogar = new JButton("Jogar Aventura");
		btnJogar.setAction(jogarAventura);
		btnJogar.setBounds(191, 42, 130, 25);
		this.add(btnJogar);
		
		//Label com mensagem inicial
		JLabel bemVindo = new JLabel("Seja Bem Vindo! Escolha uma das opções.");
		bemVindo.setBounds(76, 80, 246, 14);
		this.add(bemVindo);
		
		//Botão Ok, aparece após selecionar Jogar Aventura
		btnOk = new JButton("OK");
		btnOk.setAction(ok);
		btnOk.setBounds(242, 135, 80, 25);
		this.add(btnOk);
		btnOk.setVisible(false);
	}
		
	/**
	 * Botão para Criar Ficha.
	 */
	private class SwingActionCriarFicha extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public SwingActionCriarFicha() {
			putValue(NAME, "Criar Ficha");
			putValue(SHORT_DESCRIPTION, "Confirme");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JTelaCriarFicha telaFicha = new JTelaCriarFicha();
			telaFicha.setVisible(true);		
		}
	}
	
	/**
	 * Botão para Jogar Aventura.
	 */
	private class SwingActionJogarAventura extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public SwingActionJogarAventura() {
			putValue(NAME, "Jogar Aventura");
			putValue(SHORT_DESCRIPTION, "Confirme");
		}

		@Override
		public void actionPerformed(ActionEvent e) {	
			JLabel nomePersonagem = new JLabel("Com qual personagem deseja jogar?");
			nomePersonagem.setBounds(76, 105, 250, 14);
			add(nomePersonagem);
				
			nomePersonagem.setForeground(Color.blue);
			nomePersonagem.setBackground(Color.white);
				
			personagemNome = new JTextField(0);
			personagemNome.setBounds(76, 135, 160, 25);
			personagemNome.setFont(new Font("arial", Font.BOLD, 12));
			personagemNome.setHorizontalAlignment(JTextField.CENTER);
			add(personagemNome);
				
			personagemNome.setForeground(Color.blue);
			personagemNome.setBackground(Color.white);
			personagemNome.setBorder(BorderFactory.createLineBorder(Color.black));
				
			btnOk.setVisible(true);
		}
	}	
	
	/**
	* Botão OK, após personagem escolhido.
	*/
	private class SwingActionOk extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public SwingActionOk() {
			putValue(NAME, "OK");
			putValue(SHORT_DESCRIPTION, "Confirme");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String nome = personagemNome.getText();
			
			//Cria o personagem (temporário)
			Arma espada = new Arma("Espada", 8, 'c');
			Personagem player = new Personagem(nome, "Guerreiro", 3, 1, 4, espada);
			
			//Cria tela da Aventura
			setVisible(false);
			masterFrame.setBounds(300,120,750,400);
			
			JTelaAventura telaAventura = new JTelaAventura(player, masterFrame);
			telaAventura.setVisible(true);
			masterFrame.add(telaAventura);
			
			masterFrame.remove(masterFrame.pred);
			masterFrame.add(masterFrame.pred);
		}
				
	}			
			
}
