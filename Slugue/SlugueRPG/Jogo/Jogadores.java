package Jogo;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class Jogadores extends JFrame {
	
	private static final long serialVersionUID = 1L;
	static ArrayList<Personagem> listaJogadores = new ArrayList<Personagem>();
	private JTextArea jogs;
    private JPanel pane;
	
	public Jogadores() {
		//Configurações do Frame
		this.setBounds(1000, 170, 190, 300);		
				
		//Criação do Painel
		pane = new JPanel();
		TitledBorder titledBorder = BorderFactory.createTitledBorder(" Lista de Jogadores ");
		titledBorder.setTitleColor(Color.LIGHT_GRAY);
		pane.setBackground(Color.black);
		pane.setBorder(titledBorder);
		pane.setBounds(10, 10, 100, 100);
		pane.setVisible(true);
		this.add(pane);	
		
		//TextArea
		jogs = new JTextArea();
		jogs.setEnabled(false);
		jogs.setDisabledTextColor(Color.white);
		jogs.setBounds(9, 20, 170, 270);
		jogs.setBackground(Color.black);
		jogs.append(this.toString());
		pane.add(jogs);
	}
	
	public String toString(){
		String aux = null;
		for(int i = 0; i < listaJogadores.size(); i++){
			aux = aux + listaJogadores.get(i).getNome() + "\n";
		}
		return aux;
	}
	
	
}
