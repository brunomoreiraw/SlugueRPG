package Jogo;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class Jogadores extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Map<String, Personagem> listaJogadores = new HashMap<String, Personagem> ();
    private JPanel pane = new JPanel();
    private JTextArea areaJogadores;
    File f = new File("Personagens");
    File[] paths;
    static int etapa;
    static String jogadores;
    
	
	public Jogadores() {
		this.setBounds(1000, 170, 190, 300);
		TitledBorder titledBorder = BorderFactory.createTitledBorder(" Lista de Jogadores ");
		titledBorder.setTitleColor(Color.LIGHT_GRAY);
		pane.setBackground(Color.black);
		pane.setBorder(titledBorder);
		pane.setBounds(10, 10, 100, 100);
		pane.setVisible(true);
		this.add(pane);	
				
		//TextArea
		areaJogadores = new JTextArea();
		areaJogadores.setEnabled(false);
		areaJogadores.setDisabledTextColor(Color.white);
		areaJogadores.setBounds(9, 20, 170, 270);
		areaJogadores.setBackground(Color.black);
		pane.add(areaJogadores);
	}

	//Método que grava todos o jogadores existentes na pasta Personagens
	public void gravarJogadores(){
		Path path1 = Paths.get("Lista_Jogadores.txt");
		paths = f.listFiles();
		try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path1, Charset.defaultCharset()))) {
			for(File path:paths){
	            writer.print(path + ",");
	         }
		} catch (IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}
	}
	
	//Método que lê todos os Personagens gravados no arquivo Lista_Jogadores.txt
	public void lerJogadores(Jogadores jog){
		String jogadores[] = new String[10];
		int i = 0;
		
		//Criando lista com os pesonagens do documento Lista_Jogadores.txt
		Path path1 = Paths.get("Lista_Jogadores.txt");{	
			try (Scanner sc = new Scanner(Files.newBufferedReader(path1, Charset.defaultCharset()))){					
				sc.useDelimiter("[,]");
				while (sc.hasNext()) {
					String s = sc.next();
			        jogadores[i] = s;
			        i++;
			    }
			}catch (IOException x) {
				System.err.format("Erro de E/S: %s%n", x);
			}}
		
		//Criando objetos personagens para dentro do Dicionário.
		for(int p = 0; p < i; p++){
			String personagem = jogadores[p];
			Path path2 = Paths.get(personagem);{	
				try (Scanner scs = new Scanner(Files.newBufferedReader(path2, Charset.defaultCharset()))){	
					scs.useDelimiter("[,]");
				    String nome = scs.next();
				    String classe = scs.next();
				    int forc = Integer.parseInt(scs.next());
				    int agi = Integer.parseInt(scs.next());
				    int sab = Integer.parseInt(scs.next());
				    Personagem aux = new Personagem(nome, classe, forc, agi, sab, new Arma("Desarmado", 2, 't'));
				    jog.listaJogadores.put(nome, aux);
				}catch (IOException x) {
					System.err.format("Erro de E/S: %s%n", x);
				}
			}
		}
		areaJogadores.append(toString());		
	}
	
	public void limpaCampo(){
		areaJogadores.setText("");
	}
	
	public String toString(){
		return listaJogadores.keySet().toString().replace('[', ' ').replace(',', '\n').replace(']', ' ');
	}
}
