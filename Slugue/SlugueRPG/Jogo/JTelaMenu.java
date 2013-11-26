package Jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		this.setBounds(90, 40, 400, 200);
		this.setBackground(new Color(29, 31, 36));
		
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
		bemVindo.setForeground(Color.white);
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
			//Cria tela da Criação de Ficha
			setVisible(false);
			masterFrame.setBounds(470, 170, 416, 268);
			
			JTelaCriarFicha telaFicha = new JTelaCriarFicha(masterFrame);
			telaFicha.setVisible(true);
			masterFrame.add(telaFicha);
			
			masterFrame.remove(masterFrame.pred);
			masterFrame.add(masterFrame.pred);	
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
			nomePersonagem.setForeground(Color.white);
			add(nomePersonagem);
								
			personagemNome = new JTextField(0);
			personagemNome.setBounds(76, 135, 160, 25);
			personagemNome.setFont(new Font("arial", Font.BOLD, 12));
			personagemNome.setHorizontalAlignment(JTextField.CENTER);
			add(personagemNome);
				
			personagemNome.setForeground(Color.green);
			personagemNome.setBackground(new Color(29, 31, 36));
			personagemNome.setBorder(BorderFactory.createLineBorder(Color.green));
				
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
			String p = personagemNome.getText();
			Boolean erroAtivo = true;
			if(p.equals("")){
				p = "nao existe";
			}
			Path path1 = Paths.get("Personagens\\" + p + ".txt");{	
			try (Scanner sc = new Scanner(Files.newBufferedReader(path1, Charset.defaultCharset()))){	
				//Criando variáveis para seta o player.
				sc.useDelimiter("[,]");
			    String nome = null;
			    String classe = null;
			    int forc = 0;
			    int agi = 0;
			    int sab = 0;
			    //Lendo e setando o player.
			    nome = sc.next();
			    classe = sc.next();
			    forc = Integer.parseInt(sc.next());
			    agi = Integer.parseInt(sc.next());
			    sab = Integer.parseInt(sc.next());
			    Personagem.player.setPersonagem(nome, classe, forc, agi, sab);
			    erroAtivo = false;          
			}catch (IOException x) {
				JOptionPane.showMessageDialog(null, "Este Personagem não existe.");
				erroAtivo = true;
				personagemNome.setText("");
			}}
			
			if(erroAtivo == false){
			//Cria tela da Aventura
			setVisible(false);
			masterFrame.setBounds(300,120,750,400);
			
			JTelaAventura telaAventura = new JTelaAventura(Personagem.player, masterFrame);
			telaAventura.setVisible(true);
			masterFrame.add(telaAventura);
			
			masterFrame.remove(masterFrame.pred);
			masterFrame.add(masterFrame.pred);
			}
		}
				
	}
	
	
			
}
