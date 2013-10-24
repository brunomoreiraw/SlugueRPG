package Jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class JTelaCriarFicha extends JFrame{
	private static final long serialVersionUID = 1L;
	private final Action actionSortear = new SwingActionSortear();
	private final Action actionCalcular = new SwingActionCalcular();
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
	//Fim Ficha
	private JPanel paneFicha;
	private int etapa;
	
	public JTelaCriarFicha(){
		this.paneFicha = new JPanel();
		setTitle("SlugueRPG - Ficha");
		
		//Panel
		paneFicha.setBorder ( new TitledBorder ( new EtchedBorder(), "Ficha" ) );
		setContentPane(paneFicha);
		setBounds(470, 130, 416, 268);
		GroupLayout layout = new GroupLayout(paneFicha);
		paneFicha.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		//Nome
		JLabel nome = new JLabel("Nome:");
		nome.setBounds(10, 25, 50, 25);
		nomeR = new JTextField();
		nomeR.setBounds(60, 25, 130, 25);
		nomeR.setHorizontalAlignment(JTextField.CENTER);
		paneFicha.add(nomeR);
		paneFicha.add(nome);
		
		//Classe
		JLabel classe = new JLabel("Classe:");
		classe.setBounds(10, 60, 50, 25);
		classeR = new JComboBox<String>();
		classeR.addItem("Guerreiro");
		classeR.addItem("Mago"); 
		classeR.addItem("Clérigo");
		classeR.addItem("Ranger"); 
		classeR.setBounds(60, 60, 130, 25);
		paneFicha.add(classeR);
		paneFicha.add(classe);
		
		//Botões
		JButton btnSortear = new JButton();
		btnSortear.setAction(actionSortear);
		btnSortear.setBounds(222, 24, 166, 25);
		paneFicha.add(btnSortear);
		
		JButton btnCalcular = new JButton();
		btnCalcular.setAction(actionCalcular);
		btnCalcular.setBounds(10, 195, 377, 25);
		paneFicha.add(btnCalcular);
		
		//Rolagem 1
		rolagem1 = new JTextField(" A :");
		rolagem1.setBounds(222, 60, 50, 25);
		rolagem1.setEnabled(false);
		rolagem1.setBackground(Color.black);
		rolagem1.setDisabledTextColor(Color.green);
		rolagem1.setFont(new Font("Calibri", Font.BOLD, 14));
		paneFicha.add(rolagem1);
		
		//Rolagem 2
		rolagem2 = new JTextField(" B :");
		rolagem2.setBounds(280, 60, 50, 25);
		rolagem2.setEnabled(false);
		rolagem2.setBackground(Color.black);
		rolagem2.setDisabledTextColor(Color.green);
		rolagem2.setFont(new Font("Calibri", Font.BOLD, 14));
		paneFicha.add(rolagem2);
		
		//Rolagem 3
		rolagem3 = new JTextField(" C :");
		rolagem3.setBounds(338, 60, 50, 25);
		rolagem3.setEnabled(false);
		rolagem3.setBackground(Color.black);
		rolagem3.setDisabledTextColor(Color.green);
		rolagem3.setFont(new Font("Calibri", Font.BOLD, 14));
		paneFicha.add(rolagem3);
		
		//Modificadores
		JLabel mod = new JLabel("Modificadores de Atributos");
		mod.setBounds(227, 82, 160, 25);
		paneFicha.add(mod);
		
		//Rolagem 4
		rolagem4 = new JTextField("");
		rolagem4.setBounds(222, 104, 50, 25);
		rolagem4.setEnabled(false);
		rolagem4.setBackground(Color.black);
		rolagem4.setDisabledTextColor(Color.green);
		rolagem4.setFont(new Font("Calibri", Font.BOLD, 14));
		rolagem4.setHorizontalAlignment(JTextField.CENTER);
		paneFicha.add(rolagem4);
		
		//Rolagem 5
		rolagem5 = new JTextField("");
		rolagem5.setBounds(280, 104, 50, 25);
		rolagem5.setEnabled(false);
		rolagem5.setBackground(Color.black);
		rolagem5.setDisabledTextColor(Color.green);
		rolagem5.setFont(new Font("Calibri", Font.BOLD, 14));
		rolagem5.setHorizontalAlignment(JTextField.CENTER);
		paneFicha.add(rolagem5);
		
		//Rolagem 6
		rolagem6 = new JTextField("");
		rolagem6.setBounds(338, 104, 50, 25);
		rolagem6.setEnabled(false);
		rolagem6.setDisabledTextColor(Color.green);
		rolagem6.setBackground(Color.black);
		rolagem6.setFont(new Font("Calibri", Font.BOLD, 14));
		rolagem6.setHorizontalAlignment(JTextField.CENTER);
		paneFicha.add(rolagem6);
		
		//Pontos
		JLabel pv = new JLabel("Pontos de Vida");
		pv.setBounds(222, 134, 160, 25);
		paneFicha.add(pv);

		JLabel pm = new JLabel("Pontos de Magia");
		pm.setBounds(222, 161, 160, 25);
		paneFicha.add(pm);
		
		pvR = new JTextField();
		pvR.setBounds(330, 134, 58, 25);
		pvR.setHorizontalAlignment(JTextField.CENTER);
		paneFicha.add(pvR);
		
		pmR = new JTextField();
		pmR.setBounds(330, 161, 58, 25);
		pmR.setHorizontalAlignment(JTextField.CENTER);
		paneFicha.add(pmR);
		
		//Atributos
		JLabel atr = new JLabel("Atributos e Ataques:");
		atr.setBounds(10, 82, 160, 25);
		paneFicha.add(atr);
		
		JLabel forc = new JLabel("Força");
		forc.setBounds(10, 107, 160, 25);
		forc.setForeground(Color.blue);
		paneFicha.add(forc);
		
		JLabel agi = new JLabel("Agilidade");
		agi.setBounds(10, 134, 160, 25);
		agi.setForeground(Color.blue);
		paneFicha.add(agi);
		
		JLabel sab = new JLabel("Sabedoria");
		sab.setBounds(10, 161, 160, 25);
		sab.setForeground(Color.blue);
		paneFicha.add(sab);
		
		forcR = new JTextField();
		forcR.setBounds(74, 107, 35, 25);
		forcR.setHorizontalAlignment(JTextField.CENTER);
		paneFicha.add(forcR);
		
		agiR = new JTextField();
		agiR.setBounds(74, 134, 35, 25);
		agiR.setHorizontalAlignment(JTextField.CENTER);
		paneFicha.add(agiR);
		
		sabR = new JTextField();
		sabR.setBounds(74, 161, 35, 25);
		sabR.setHorizontalAlignment(JTextField.CENTER);
		paneFicha.add(sabR);
		
		//Ataques
		JLabel cc = new JLabel("Atk CC");
		cc.setBounds(117, 107, 160, 25);
		paneFicha.add(cc);
		
		JLabel ad = new JLabel("Atk AD");
		ad.setBounds(117, 134, 160, 25);
		paneFicha.add(ad);
		
		JLabel m = new JLabel("Atk M");
		m.setBounds(117, 161, 160, 25);
		paneFicha.add(m);
		
		ccR = new JTextField();
		ccR.setBounds(159, 107, 35, 25);
		ccR.setHorizontalAlignment(JTextField.CENTER);
		paneFicha.add(ccR);
		
		adR = new JTextField();
		adR.setBounds(159, 134, 35, 25);
		adR.setHorizontalAlignment(JTextField.CENTER);
		paneFicha.add(adR);
		
		mR = new JTextField();
		mR.setBounds(159, 161, 35, 25);
		mR.setHorizontalAlignment(JTextField.CENTER);
		paneFicha.add(mR);
	
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
			if(etapa == 0){
				int numero = rola.nextInt(16) + 3;
				rolagem1.setText(" A :  " + numero);
				if(numero%2 == 0 && numero>11){
					int temp =  numero/2 - 5;
					rolagem4.setText("" + temp);
				} else if (numero>11) {
					int temp = (numero-1)/2 - 5;
					rolagem4.setText("" + temp);
				} else rolagem4.setText("" + 0);
				etapa ++;
			}
			else if (etapa == 1){
				int numero = rola.nextInt(16) + 3;
				rolagem2.setText(" B :  " + numero);
				if(numero%2 == 0 && numero>11){
					int temp =  numero/2 - 5;
					rolagem5.setText("" + temp);
				} else if (numero>11) {
					int temp = (numero-1)/2 - 5;
					rolagem5.setText("" + temp);
				} else rolagem5.setText("" + 0);
				etapa ++;
			}
			else if (etapa == 2){
				int numero = rola.nextInt(16) + 3;
				rolagem3.setText(" C :  " + numero);
				if(numero%2 == 0 && numero>11){
					int temp =  numero/2 - 5;
					rolagem6.setText("" + temp);
				} else if (numero>11) {
					int temp = (numero-1)/2 - 5;
					rolagem6.setText("" + temp);
				} else rolagem6.setText("" + 0);
				etapa ++;
			}
		}
	}
	
	/**
	 * Botão para Calcular
	 */
	private class SwingActionCalcular extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		public SwingActionCalcular() {
			putValue(NAME, "Calcular e Gravar Ficha");
			putValue(SHORT_DESCRIPTION, "Calcular e Gravar");
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String classe = (String)classeR.getSelectedItem();
			classe.trim();
			
			if(forcR.getText().equalsIgnoreCase("A")){
				forcR.setText(rolagem4.getText());
			} else if(forcR.getText().equalsIgnoreCase("B")){
				forcR.setText(rolagem5.getText());
			} else if(forcR.getText().equalsIgnoreCase("C")){
				forcR.setText(rolagem6.getText());
			}
			
			if(agiR.getText().equalsIgnoreCase("A")){
				agiR.setText(rolagem4.getText());
			}else if(agiR.getText().equalsIgnoreCase("B")){
				agiR.setText(rolagem5.getText());
			}else if(agiR.getText().equalsIgnoreCase("C")){
				agiR.setText(rolagem6.getText());
			}
			
			if(sabR.getText().equalsIgnoreCase("A")){
				sabR.setText(rolagem4.getText());
			}else if(sabR.getText().equalsIgnoreCase("B")){
				sabR.setText(rolagem5.getText());
			}else if(sabR.getText().equalsIgnoreCase("C")){
				sabR.setText(rolagem6.getText());
			}
			
			int forcS = Integer.parseInt(forcR.getText());
			int agiS = Integer.parseInt(agiR.getText());
			int sabS = Integer.parseInt(sabR.getText());
			
			if(classe.equalsIgnoreCase("Guerreiro")){
				ccR.setText("" + (forcS + 2));
				adR.setText("" + (agiS));
				mR.setText("" + (sabS));
				pmR.setText("" + (sabS));
				pvR.setText("" + (10 + forcS));
			}
			if(classe.equalsIgnoreCase("Ranger")){
				ccR.setText("" + (forcS));
				adR.setText("" + (agiS + 2));
				mR.setText("" + (sabS));
				pmR.setText("" + (sabS));
				pvR.setText("" + (8 + forcS));
			}
			if(classe.equalsIgnoreCase("Mago")){
				ccR.setText("" + (forcS));
				adR.setText("" + (agiS));
				mR.setText("" + (sabS + 2));
				pmR.setText("" + (10 + sabS));
				pvR.setText("" + (4 + forcS));
			}
			if(classe.equalsIgnoreCase("Clérigo")){
				ccR.setText("" + (forcS + 1));
				adR.setText("" + (agiS));
				mR.setText("" + (sabS + 1));
				pmR.setText("" + (5 + sabS));
				pvR.setText("" + (8 + forcS));
			}
			pvR.setEnabled(false);
			pvR.setDisabledTextColor(Color.black);
			pmR.setEnabled(false);
			pmR.setDisabledTextColor(Color.black);
			ccR.setEnabled(false);
			ccR.setDisabledTextColor(Color.black);
			adR.setEnabled(false);
			adR.setDisabledTextColor(Color.black);
			mR.setEnabled(false);
			mR.setDisabledTextColor(Color.black);
			forcR.setEnabled(false);
			forcR.setDisabledTextColor(Color.black);
			agiR.setEnabled(false);
			agiR.setDisabledTextColor(Color.black);
			sabR.setEnabled(false);
			sabR.setDisabledTextColor(Color.black);
			classeR.setEnabled(false);
			//classeR.getSelectedItem().setF(Color.black);
		}
	}
}
