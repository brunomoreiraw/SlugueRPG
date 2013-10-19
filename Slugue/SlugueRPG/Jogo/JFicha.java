package Jogo;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class JFicha extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private Personagem player;

	public JFicha(Personagem p) {
		this.player = p;
		panel = new JPanel();
		setContentPane(panel);
		panel.setVisible(true);
		panel.setForeground(Color.black);
		panel.setBackground(Color.white);
		panel.setBorder ( new TitledBorder ( new EtchedBorder(), "Ficha " + player.getNome()));
		setBounds(1070, 130, 200, 400);

		JTextArea ficha = new JTextArea();
		ficha.setEnabled(false);
		ficha.setDisabledTextColor(Color.black);
		ficha.setBounds(0, 0, 200, 400);
		ficha.setBackground(Color.white);
		
		//StyledDocument doc = panel.getStyledDocument();
		//SimpleAttributeSet center = new SimpleAttributeSet();
		//StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		//doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		//Style style = panel.addStyle("Red", null);
	    //StyleConstants.setForeground(style, Color.red);
		
		panel.add(ficha);
		ficha.append(player.toString());
	}

}
