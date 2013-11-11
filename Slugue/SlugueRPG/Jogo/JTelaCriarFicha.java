package Jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class JTelaCriarFicha extends JPanel {
	private static final long serialVersionUID = 1L;
	private final Action actionSortear = new SwingActionSortear();
	private final Action actionCalcular = new SwingActionCalcular();
	private final Action actionVoltar = new SwingActionVoltar();
	private FramePrincipal masterFrame;
	private int etapa;
	// Início Ficha
	private JTextField rolagem1;
	private JTextField rolagem2;
	private JTextField rolagem3;
	private JTextField rolagem4;
	private JTextField rolagem5;
	private JTextField rolagem6;
	private JTextField nomeR;
	private JTextField ccR;
	private JTextField adR;
	private JTextField mR;
	private JTextField pvR;
	private JTextField pmR;
	private JTextField forcR;
	private JTextField agiR;
	private JTextField sabR;
	private JComboBox<String> classeR;

	// Fim Ficha

	public JTelaCriarFicha(FramePrincipal master) {
		// Setando MasterFrame
		this.masterFrame = master;

		// Configurações do Painel (Tela Criação de Ficha)
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		this.setBounds(0, 0, 400, 228);
		this.setBackground(new Color(29, 31, 36));
		TitledBorder titledBorder = BorderFactory
				.createTitledBorder("Criação de Ficha");
		titledBorder.setTitleColor(Color.green);
		this.setBorder(titledBorder);

		// Nome
		JLabel nome = new JLabel("Nome:");
		nome.setBounds(10, 25, 50, 25);
		nome.setForeground(Color.white);
		nomeR = new JTextField("");
		nomeR.setBounds(60, 25, 130, 25);
		nomeR.setBackground(new Color(27, 28, 31));
		nomeR.setForeground(Color.green);
		nomeR.setHorizontalAlignment(JTextField.CENTER);
		this.add(nomeR);
		this.add(nome);

		// Classe
		JLabel classe = new JLabel("Classe:");
		classe.setBounds(10, 60, 50, 25);
		classe.setForeground(Color.white);
		classeR = new JComboBox<String>();
		classeR.addItem("Guerreiro");
		classeR.addItem("Mago");
		classeR.addItem("Clérigo");
		classeR.addItem("Ranger");
		classeR.setBounds(60, 60, 130, 25);
		this.add(classeR);
		this.add(classe);

		// Botões
		JButton btnSortear = new JButton();
		btnSortear.setAction(actionSortear);
		btnSortear.setBounds(222, 24, 166, 25);
		this.add(btnSortear);

		JButton btnCalcular = new JButton();
		btnCalcular.setAction(actionCalcular);
		btnCalcular.setBounds(10, 195, 280, 25);
		this.add(btnCalcular);

		JButton btnVoltar = new JButton();
		btnVoltar.setAction(actionVoltar);
		btnVoltar.setBounds(298, 195, 91, 25);
		this.add(btnVoltar);

		// Rolagem 1
		rolagem1 = new JTextField(" A :");
		rolagem1.setBounds(222, 60, 50, 25);
		rolagem1.setEnabled(false);
		rolagem1.setBackground(Color.black);
		rolagem1.setDisabledTextColor(Color.green);
		rolagem1.setFont(new Font("Calibri", Font.BOLD, 14));
		this.add(rolagem1);

		// Rolagem 2
		rolagem2 = new JTextField(" B :");
		rolagem2.setBounds(280, 60, 50, 25);
		rolagem2.setEnabled(false);
		rolagem2.setBackground(Color.black);
		rolagem2.setDisabledTextColor(Color.green);
		rolagem2.setFont(new Font("Calibri", Font.BOLD, 14));
		this.add(rolagem2);

		// Rolagem 3
		rolagem3 = new JTextField(" C :");
		rolagem3.setBounds(338, 60, 50, 25);
		rolagem3.setEnabled(false);
		rolagem3.setBackground(Color.black);
		rolagem3.setDisabledTextColor(Color.green);
		rolagem3.setFont(new Font("Calibri", Font.BOLD, 14));
		this.add(rolagem3);

		// Modificadores
		JLabel mod = new JLabel("Modificadores de Atributos");
		mod.setForeground(new Color(176, 176, 176));
		mod.setBounds(227, 82, 160, 25);
		this.add(mod);

		// Rolagem 4
		rolagem4 = new JTextField("");
		rolagem4.setBounds(222, 104, 50, 25);
		rolagem4.setEnabled(false);
		rolagem4.setBackground(Color.black);
		rolagem4.setDisabledTextColor(Color.green);
		rolagem4.setFont(new Font("Calibri", Font.BOLD, 14));
		rolagem4.setHorizontalAlignment(JTextField.CENTER);
		this.add(rolagem4);

		// Rolagem 5
		rolagem5 = new JTextField("");
		rolagem5.setBounds(280, 104, 50, 25);
		rolagem5.setEnabled(false);
		rolagem5.setBackground(Color.black);
		rolagem5.setDisabledTextColor(Color.green);
		rolagem5.setFont(new Font("Calibri", Font.BOLD, 14));
		rolagem5.setHorizontalAlignment(JTextField.CENTER);
		this.add(rolagem5);

		// Rolagem 6
		rolagem6 = new JTextField("");
		rolagem6.setBounds(338, 104, 50, 25);
		rolagem6.setEnabled(false);
		rolagem6.setDisabledTextColor(Color.green);
		rolagem6.setBackground(Color.black);
		rolagem6.setFont(new Font("Calibri", Font.BOLD, 14));
		rolagem6.setHorizontalAlignment(JTextField.CENTER);
		this.add(rolagem6);

		// Pontos
		JLabel pv = new JLabel("Pontos de Vida");
		pv.setForeground(Color.white);
		pv.setBounds(222, 134, 160, 25);
		this.add(pv);

		JLabel pm = new JLabel("Pontos de Magia");
		pm.setForeground(Color.white);
		pm.setBounds(222, 161, 160, 25);
		this.add(pm);

		pvR = new JTextField();
		pvR.setBounds(330, 134, 58, 25);
		pvR.setBackground(new Color(27, 28, 31));
		pvR.setForeground(Color.green);
		pvR.setHorizontalAlignment(JTextField.CENTER);
		this.add(pvR);

		pmR = new JTextField();
		pmR.setBounds(330, 161, 58, 25);
		pmR.setBackground(new Color(27, 28, 31));
		pmR.setForeground(Color.green);
		pmR.setHorizontalAlignment(JTextField.CENTER);
		this.add(pmR);

		// Atributos
		JLabel atr = new JLabel("Atributos e Ataques:");
		atr.setForeground(new Color(176, 176, 176));
		atr.setBounds(10, 84, 160, 25);
		this.add(atr);

		JLabel forc = new JLabel("Força");
		forc.setForeground(Color.white);
		forc.setBounds(10, 107, 160, 25);
		forc.setForeground(Color.white);
		this.add(forc);

		JLabel agi = new JLabel("Agilidade");
		agi.setBounds(10, 134, 160, 25);
		agi.setForeground(Color.white);
		agi.setForeground(Color.white);
		this.add(agi);

		JLabel sab = new JLabel("Sabedoria");
		sab.setBounds(10, 161, 160, 25);
		sab.setForeground(Color.white);
		sab.setForeground(Color.white);
		this.add(sab);

		forcR = new JTextField();
		forcR.setBounds(74, 107, 35, 25);
		forcR.setBackground(new Color(27, 28, 31));
		forcR.setForeground(Color.green);
		forcR.setHorizontalAlignment(JTextField.CENTER);
		this.add(forcR);

		agiR = new JTextField();
		agiR.setBounds(74, 134, 35, 25);
		agiR.setBackground(new Color(27, 28, 31));
		agiR.setForeground(Color.green);
		agiR.setHorizontalAlignment(JTextField.CENTER);
		this.add(agiR);

		sabR = new JTextField();
		sabR.setBounds(74, 161, 35, 25);
		sabR.setBackground(new Color(27, 28, 31));
		sabR.setForeground(Color.green);
		sabR.setHorizontalAlignment(JTextField.CENTER);
		this.add(sabR);

		// Ataques
		JLabel cc = new JLabel("Atk CC");
		cc.setForeground(Color.white);
		cc.setBounds(117, 107, 160, 25);
		this.add(cc);

		JLabel ad = new JLabel("Atk AD");
		ad.setForeground(Color.white);
		ad.setBounds(117, 134, 160, 25);
		this.add(ad);

		JLabel m = new JLabel("Atk M");
		m.setForeground(Color.white);
		m.setBounds(117, 161, 160, 25);
		this.add(m);

		ccR = new JTextField();
		ccR.setBounds(159, 107, 35, 25);
		ccR.setBackground(new Color(27, 28, 31));
		ccR.setForeground(Color.green);
		ccR.setHorizontalAlignment(JTextField.CENTER);
		this.add(ccR);

		adR = new JTextField();
		adR.setBounds(159, 134, 35, 25);
		adR.setBackground(new Color(27, 28, 31));
		adR.setForeground(Color.green);
		adR.setHorizontalAlignment(JTextField.CENTER);
		this.add(adR);

		mR = new JTextField();
		mR.setBounds(159, 161, 35, 25);
		mR.setBackground(new Color(27, 28, 31));
		mR.setForeground(Color.green);
		mR.setHorizontalAlignment(JTextField.CENTER);
		this.add(mR);

	}

	/**
	 * Botão para Sortear
	 */
	private class SwingActionSortear extends AbstractAction {
		private static final long serialVersionUID = 1L;
		Random rola = new Random();
		
		
		public SwingActionSortear() {
			putValue(NAME, "Rolar 3 Dados");
			putValue(SHORT_DESCRIPTION, "Jogar!");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			//Rolagem de dados e atribuição dos modificadores.
			if (etapa == 0) {
				int numero = rola.nextInt(16) + 3;
				rolagem1.setText(" A :  " + numero);
				if (numero % 2 == 0 && numero > 11) {
					int temp = numero / 2 - 5;
					rolagem4.setText("" + temp);
				} else if (numero > 11) {
					int temp = (numero - 1) / 2 - 5;
					rolagem4.setText("" + temp);
				} else
					rolagem4.setText("" + 0);
				etapa++;
			} else if (etapa == 1) {
				int numero = rola.nextInt(16) + 3;
				rolagem2.setText(" B :  " + numero);
				if (numero % 2 == 0 && numero > 11) {
					int temp = numero / 2 - 5;
					rolagem5.setText("" + temp);
				} else if (numero > 11) {
					int temp = (numero - 1) / 2 - 5;
					rolagem5.setText("" + temp);
				} else
					rolagem5.setText("" + 0);
				etapa++;
			} else if (etapa == 2) {
				int numero = rola.nextInt(16) + 3;
				rolagem3.setText(" C :  " + numero);
				if (numero % 2 == 0 && numero > 11) {
					int temp = numero / 2 - 5;
					rolagem6.setText("" + temp);
				} else if (numero > 11) {
					int temp = (numero - 1) / 2 - 5;
					rolagem6.setText("" + temp);
				} else
					rolagem6.setText("" + 0);
				etapa++;
			}
		}
	}

	/**
	 * Botão para Atribuir Atributos, Ataques e Pontos de Vida/Magia.
	 */
	private class SwingActionCalcular extends AbstractAction {
		private static final long serialVersionUID = 1L;
		private boolean erroAtivo;
		
		public SwingActionCalcular() {
			putValue(NAME, "Calcular e Gravar Ficha");
			putValue(SHORT_DESCRIPTION, "Calcular e Gravar");
		}

		@Override
		public void actionPerformed(ActionEvent e) throws IllegalArgumentException, NullPointerException {
			String classe = (String) classeR.getSelectedItem();
			classe.trim();
			erroAtivo = false;
				
			try {
					//Validação nome do personagem
					nomeR.getText().trim();
					if(nomeR.getText().equals("")){
						throw new NullPointerException();
					}
					//Atribui Força
					if (forcR.getText().equalsIgnoreCase("A")) {
						forcR.setText(rolagem4.getText());
					} else if (forcR.getText().equalsIgnoreCase("B")) {
						forcR.setText(rolagem5.getText());
					} else if (forcR.getText().equalsIgnoreCase("C")) {
						forcR.setText(rolagem6.getText());
					} 
					//Atribui Agilidade
					if (agiR.getText().equalsIgnoreCase("A")) {
						agiR.setText(rolagem4.getText());
					} else if (agiR.getText().equalsIgnoreCase("B")) {
						agiR.setText(rolagem5.getText());
					} else if (agiR.getText().equalsIgnoreCase("C")) {
						agiR.setText(rolagem6.getText());
					}
					//Atribui Sabedoria
					if (sabR.getText().equalsIgnoreCase("A")) {
						sabR.setText(rolagem4.getText());
					} else if (sabR.getText().equalsIgnoreCase("B")) {
						sabR.setText(rolagem5.getText());
					} else if (sabR.getText().equalsIgnoreCase("C")) {
						sabR.setText(rolagem6.getText());
					}
					else 
						throw new IllegalArgumentException();
				}catch (NullPointerException ex2){
					erroAtivo = true;
					JOptionPane.showMessageDialog(null, "O nome não deve ficar vazio.");
				}catch (IllegalArgumentException ex){
					erroAtivo = true;
					forcR.setText("");
					agiR.setText("");
					sabR.setText("");
					JOptionPane.showMessageDialog(null, "Dados de entrada inválidos.\nDistribua as tags A, B e C nos atributos.");
					}
				
			//Após válidas as informações, seta a classe, para a Classe personagem fazer os cálculos.	
			if(erroAtivo == false){
				Personagem.player.setClasse(classe);
				
				pvR.setEnabled(false);
				pvR.setDisabledTextColor(Color.green);
				pmR.setEnabled(false);
				pmR.setDisabledTextColor(Color.green);
				ccR.setEnabled(false);
				ccR.setDisabledTextColor(Color.green);
				adR.setEnabled(false);
				adR.setDisabledTextColor(Color.green);
				mR.setEnabled(false);
				mR.setDisabledTextColor(Color.green);
				forcR.setEnabled(false);
				forcR.setDisabledTextColor(Color.green);
				agiR.setEnabled(false);
				agiR.setDisabledTextColor(Color.green);
				sabR.setEnabled(false);
				sabR.setDisabledTextColor(Color.green);
				classeR.setEnabled(false);
	
				// Gravação da Ficha
				Path path1 = Paths.get(nomeR.getText() + ".txt");
				try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.defaultCharset()))) {
					writer.println(Personagem.player.toString());
				} catch (IOException x) {
					System.err.format("Erro de E/S: %s%n", x);
				}
			}
		}
	}

	/**
	 * Botão Voltar para o Menu.
	 */
	private class SwingActionVoltar extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public SwingActionVoltar() {
			putValue(NAME, "Voltar");
			putValue(SHORT_DESCRIPTION, "Voltar");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			masterFrame.telaMenu.setVisible(true);
			masterFrame.setBounds(400, 170, 600, 300);
			setVisible(false);
		}
	}
}
