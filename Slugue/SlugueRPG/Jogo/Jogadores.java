package Jogo;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class Jogadores extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Map<String, Personagem> listaJogadores = new HashMap<String, Personagem> ();
    private JPanel pane = new JPanel();
    static Jogadores jog = new Jogadores();
    static JTextArea jogs = new JTextArea();;
    static int etapa;
    static String jogadores;
	
	public Jogadores() {
		
	}
	
	public void criarTelaJogadores(){
		//Configurações do Frame
		this.setBounds(1000, 170, 190, 300);		
						
		//Criação do Painel
		TitledBorder titledBorder = BorderFactory.createTitledBorder(" Lista de Jogadores ");
		titledBorder.setTitleColor(Color.LIGHT_GRAY);
		pane.setBackground(Color.black);
		pane.setBorder(titledBorder);
		pane.setBounds(10, 10, 100, 100);
		pane.setVisible(true);
		this.add(pane);	
				
		//TextArea
		jogs.setEnabled(false);
		jogs.setDisabledTextColor(Color.white);
		jogs.setBounds(9, 20, 170, 270);
		jogs.setBackground(Color.black);
		jogs.append(jogadores);
		pane.add(jogs);
	}
	
	public Map<String, Personagem> getLista(){
		return listaJogadores;
	}
	
	public void gravarJogadores(){
		Path path1 = Paths.get("Lista_Jogadores.txt");
		try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.defaultCharset()))) {
			writer.print(jog.toString());
		} catch (IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}
	}
	
	public void limparTelaJogadores(){
		jogs.setText("");
	}
	
	public String toString(){
		return listaJogadores.keySet().toString().replace('[', ' ').replace(',', '\n').replace(']', ' ');
	}
}
