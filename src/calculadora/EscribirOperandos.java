package calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class EscribirOperandos implements ActionListener{
	
	private static Double valorActual = 0.0;
	private JTextField display;
	private static Boolean operandoIngresado = false;
	private static String operacion;
	private static int cantidadOperadoresIngresados=0;
	
	public EscribirOperandos(JTextField display) {
		this.display=display;
	}

	public static Double getValorActual() {
		return valorActual;
	}
	
	public static void setValorActual(Double valor) {
		EscribirOperandos.valorActual=valor;
	}
	
	public static String getOperacion() {
		return operacion;
	}

	public static Boolean getOperandoIngresado() {
		return operandoIngresado;
	}

	public static void setOperandoIngresado(Boolean operandoIngresado) {
		EscribirOperandos.operandoIngresado = operandoIngresado;
	}
	
	public static void setcantidadOperadoresIngresados(int cantidadOperadoresIngresados) {
		EscribirOperandos.cantidadOperadoresIngresados=cantidadOperadoresIngresados;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		display.setFont(display.getFont().deriveFont(75f));
		
		if(cantidadOperadoresIngresados==0) {
			valorActual = Double.parseDouble(this.display.getText());
			cantidadOperadoresIngresados++;
		}
		else {
			
			switch(this.display.getText()) {
			
			case "+" : break;
			case "-" : break;
			case "x" : break;
			case "/" : break;
			default : switch(operacion) {
			
				case "suma": valorActual = valorActual + Double.parseDouble(this.display.getText()); break;
				case "resta": valorActual = valorActual - Double.parseDouble(this.display.getText()); break;
				case "multiplicacion": valorActual = valorActual * Double.parseDouble(this.display.getText()); break;
				case "division": valorActual = valorActual / Double.parseDouble(this.display.getText()); break;
				
				}
			
			}
		}
		
		String operando = e.getActionCommand();
		
		this.display.setText(operando);
		
		switch(operando) {
		
		case "+" : operacion = "suma"; break;
		case "-" : operacion = "resta"; break;
		case "x" : operacion = "multiplicacion"; break;
		case "/" : operacion = "division"; break;
		
		}
		
		EscribirOperandos.setOperandoIngresado(true);
		EscribirResultado.setIgualPresionado(false);
		EscribirNumeros.setPunto(false);
		EscribirNumeros.setIngreseSoloNumeros(false);
		EscribirNumeros.setCantidadNumerosIngresados(0);
		
	}
}
