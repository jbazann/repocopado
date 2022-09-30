package calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class EscribirResultado implements ActionListener{

	private JTextField display;
	private Double resultado;
	private static Boolean igualPresionado = false;
	
	public EscribirResultado(JTextField display) {
		this.display=display;
	}
	
	public static Boolean getIgualPresionado() {
		return igualPresionado;
	}

	public static void setIgualPresionado(Boolean igualPresionado) {
		EscribirResultado.igualPresionado = igualPresionado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(EscribirOperandos.getOperandoIngresado()) {
			resultado=EscribirOperandos.getValorActual();
			EscribirOperandos.setcantidadOperadoresIngresados(0);
			EscribirNumeros.setCantidadNumerosIngresados(0);
		}
		else {
			if(EscribirNumeros.getIngreseSoloNumeros() || EscribirResultado.getIgualPresionado()) {
				resultado = Double.parseDouble(display.getText());
			}
			else {
				switch(EscribirOperandos.getOperacion()) {
				
				case "suma": resultado = EscribirOperandos.getValorActual() + Double.parseDouble(this.display.getText()); break;
				case "resta": resultado = EscribirOperandos.getValorActual() - Double.parseDouble(this.display.getText()); break;
				case "multiplicacion": resultado = EscribirOperandos.getValorActual() * Double.parseDouble(this.display.getText()); break;
				case "division": resultado = EscribirOperandos.getValorActual() / Double.parseDouble(this.display.getText()); break;
				
				}
				EscribirOperandos.setValorActual(resultado);
			}
			
			EscribirOperandos.setcantidadOperadoresIngresados(0);
			EscribirResultado.setIgualPresionado(true);
			EscribirNumeros.setPunto(false);
			EscribirNumeros.setIngreseSoloNumeros(false);
			EscribirNumeros.setCantidadNumerosIngresados(0);
		}
		switch (resultado.toString().length()) {
		case 1,2,3,4,5,6,7: display.setFont(display.getFont().deriveFont(75f)); break;
		case 8: display.setFont(display.getFont().deriveFont(67.5f)); break;
		case 9: display.setFont(display.getFont().deriveFont(60f)); break;
		case 10,11: display.setFont(display.getFont().deriveFont(52.5f)); break;
		case 12,13: display.setFont(display.getFont().deriveFont(45f)); break;
		case 14,15: display.setFont(display.getFont().deriveFont(37.5f)); break;
		case 16,17,18,19: display.setFont(display.getFont().deriveFont(30f)); break;
		case 20,21,22,23,24,25: display.setFont(display.getFont().deriveFont(22.5f)); break;
		case 26,27,28,29,30,31,32: display.setFont(display.getFont().deriveFont(15f)); break;
		}
		display.setText(resultado.toString());
	}
}
