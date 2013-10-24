package Jogo;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class JVerFicha extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private final Action actionAtualizar = new SwingActionAtualizar();
	private JPanel panel;
	private JTextArea ficha;
	private Personagem player;

	public JVerFicha(Personagem p) {
		this.player = p;
		
		//Panel
		panel = new JPanel();
		setContentPane(panel);
		panel.setVisible(true);
		panel.setForeground(Color.white);
		panel.setBackground(Color.black);
		TitledBorder b = new TitledBorder ( new EtchedBorder(Color.DARK_GRAY, Color.LIGHT_GRAY), " Ficha " + player.getNome() + " ");
		b.setTitleColor(Color.green);
		panel.setBorder (b);
		setBounds(1070, 130, 200, 400);
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		//TextArea
		ficha = new JTextArea();
		ficha.setEnabled(false);
		ficha.setDisabledTextColor(Color.white);
		ficha.setBounds(9, 20, 165, 330);
		ficha.setBackground(Color.black);
		ficha.append(player.toString());
		panel.add(ficha);
		
		//Botões
		JButton btnAtualizar = new JButton();
		btnAtualizar.setAction(actionAtualizar);
		btnAtualizar.setBounds(12, 300, 140, 25);
		btnAtualizar.setBackground(Color.BLACK);
	    btnAtualizar.setForeground(Color.GREEN);
		ficha.add(btnAtualizar);
		
		
	}
	
	/**
	 * Botão para Atualizar
	 */
	private class SwingActionAtualizar extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		public SwingActionAtualizar() {
			putValue(NAME, "Atualizar");
			putValue(SHORT_DESCRIPTION, "Atualizar");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			ficha.setText(null);
			ficha.append(player.toString());
		}
	}
}
