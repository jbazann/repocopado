package calculadora;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LaminaBotones extends JPanel{
	
	public LaminaBotones(EscribirNumeros oyenteNumeros, EscribirOperandos oyenteOperandos, EscribirResultado oyenteResultado) {
		
		GridLayout disposicion = new GridLayout(4,4); 
		
		JButton cero = new JButton("0");
		JButton uno = new JButton("1");
		JButton dos = new JButton("2");
		JButton tres = new JButton("3");
		JButton cuatro = new JButton("4");
		JButton cinco = new JButton("cinco");
		JButton seis = new JButton("6");
		JButton siete = new JButton("7");
		JButton ocho = new JButton("8");
		JButton nueve = new JButton("9");
		JButton suma = new JButton("+");
		JButton resta = new JButton("-");
		JButton division = new JButton("/");
		JButton multiplicacion = new JButton("x");
		JButton igual = new JButton("=");
		JButton punto = new JButton(".");
		
		setLayout(disposicion);
		
		add(uno);
		add(dos);
		add(tres);
		add(division);
		add(cuatro);
		add(cinco);
		add(seis);
		add(multiplicacion);
		add(siete);
		add(ocho);
		add(nueve);
		add(punto);
		add(cero);
		add(suma);
		add(resta);
		add(igual);
		
		cero.addActionListener(oyenteNumeros);
		uno.addActionListener(oyenteNumeros);
		dos.addActionListener(oyenteNumeros);
		tres.addActionListener(oyenteNumeros);
		cuatro.addActionListener(oyenteNumeros);
		cinco.addActionListener(oyenteNumeros);
		seis.addActionListener(oyenteNumeros);
		siete.addActionListener(oyenteNumeros);
		ocho.addActionListener(oyenteNumeros);
		nueve.addActionListener(oyenteNumeros);
		punto.addActionListener(oyenteNumeros);
		
		suma.addActionListener(oyenteOperandos);
		resta.addActionListener(oyenteOperandos);
		division.addActionListener(oyenteOperandos);
		multiplicacion.addActionListener(oyenteOperandos);
		
		igual.addActionListener(oyenteResultado);
		
	}

}
