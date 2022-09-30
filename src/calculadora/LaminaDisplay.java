package calculadora;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LaminaDisplay extends JPanel{
	
	private GridBagConstraints gbc = new GridBagConstraints();
	
	public LaminaDisplay() {
		JTextField display = new JTextField("0");
		display.setEnabled(false);
		display.setFont(display.getFont().deriveFont(75f));
		display.setHorizontalAlignment(JTextField.RIGHT);
		JButton imprimirResultado = new JButton("Imprimir resultado");
		ImprimirResultado oyenteBotonImprimir = new ImprimirResultado();
		imprimirResultado.addActionListener(oyenteBotonImprimir);
		EscribirNumeros oyenteNumeros = new EscribirNumeros(display);
		EscribirOperandos oyenteOperandos = new EscribirOperandos(display);
		EscribirResultado oyenteResultado = new EscribirResultado(display);
		LaminaBotones botones = new LaminaBotones(oyenteNumeros, oyenteOperandos, oyenteResultado);
		setLayout(new GridBagLayout());
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.weightx=1;
		gbc.weighty=1;
		gbc.fill=GridBagConstraints.BOTH;
		this.add(display, gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.weightx=1;
		gbc.weighty=10;
		gbc.fill=GridBagConstraints.BOTH;
		this.add(botones, gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.weightx=1;
		gbc.weighty=1;
		gbc.fill=GridBagConstraints.BOTH;
		this.add(imprimirResultado, gbc);
		
	}

}
