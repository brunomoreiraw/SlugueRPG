package Jogo;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class FramePrincipal extends JFrame {
	

	private static final long serialVersionUID = 1L;
	public JPanel pred;
	public JTelaMenu telaMenu;
	
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
		this.setBounds(400,170,600,300);
		
		
		//Criação do primeiro Painel (Menu)
		telaMenu = new JTelaMenu(this);
		telaMenu.setBorder ( new TitledBorder ( new EtchedBorder(), "Slugue RPG" ) );
		telaMenu.setVisible(true);
		this.add(telaMenu);
		
		
		//Painel base para os outros (Sempre deve ser o último do código)
		pred = new JPanel();
		pred.setVisible(true);
		pred.setBackground(Color.white);
		this.add(pred);	
		
	}
}
