package Jogo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class JTelaJogar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final Action actionEnter = new SwingActionEnter();
	private JTextArea textArea = new JTextArea(100, 100);
	private JTextField textField = new JTextField(200);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTelaJogar frame = new JTelaJogar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JTelaJogar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Dudu\\Desktop\\G12_RPG.png"));
		setTitle("Batalha SlugeMUD");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		textArea.append("\t Seja Bem-Vindo ao Jogo\n" + "\n");

		textArea.append("Digite o nome do seu personagem:\n");

		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setAction(actionEnter);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						Alignment.TRAILING,
						gl_contentPane
								.createSequentialGroup()
								.addComponent(textField,
										GroupLayout.DEFAULT_SIZE, 345,
										Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnNewButton,
										GroupLayout.PREFERRED_SIZE, 69,
										GroupLayout.PREFERRED_SIZE))
				.addGroup(
						gl_contentPane
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(textArea,
										GroupLayout.PREFERRED_SIZE, 404,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addComponent(textArea,
												GroupLayout.PREFERRED_SIZE,
												220, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED, 9,
												Short.MAX_VALUE)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textField,
																GroupLayout.PREFERRED_SIZE,
																21,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnNewButton))));
		contentPane.setLayout(gl_contentPane);
		// TODO: Arrumar texto e tamanho da tela bloqueada
		// textArea.setEnabled(false);

	}

	private class SwingActionEnter extends AbstractAction {
		/**
		 * Ação do botão Enter. Está incompleta 
		 * TODO: barra de rolagem no
		 * textArea. 
		 * TODO: continuar os dialogos...
		 */
		private static final long serialVersionUID = 1L;
		private int etapa;

		public SwingActionEnter() {
			putValue(NAME, "Enter");
			putValue(SHORT_DESCRIPTION, "Some short description");
			etapa = 0;
		}

		public void actionPerformed(ActionEvent e) {

			if (etapa == 0) {
				String texto = textField.getText();
				textArea.append(texto + "\n"); // acrescenta o conteúdo do
												// textField
												// no textArea.
				textField.setText("");

				String[] palavras = texto.split(" ");

				texto = palavras[0];
				textArea.append("Seu nome agora é " + texto + " \n");
				textArea.append("Qual classe você quer jogar? \n");
				etapa++;
			} else if (etapa == 1) {
				String texto = textField.getText();
				textArea.append(texto + "\n");

				textArea.append("Sua classe agora é " + texto + " \n");
				textArea.append("Agora, você está pronto para jogar\n");

				textArea.append("\n Neste momento você está localizado na região de Urboba, \n um grande centro de comércio do século XVIII");
				textArea.append("\n Quer andar para conhecer a região?");
				textField.setText(" ");
				etapa++;
			}

			else if (etapa == 2) {

				String texto = textField.getText();
				textArea.append(texto + "\n");

				textField.setText(" ");
				textField.setEnabled(false); // bloqueia o textField.

			}
		}
	}
}
