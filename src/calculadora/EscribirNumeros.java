package calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class EscribirNumeros implements ActionListener{
	
	private JTextField display;
	private Integer incrementador=0;
	private static boolean ingrseUnPunto=false;
	private static boolean ingreseSoloNumeros=true;
	private static Integer cantidadNumerosIngresados=0;
	
	public EscribirNumeros(JTextField display) {
		this.display=display;
	}
	
	public static void setPunto(boolean punto) {
		EscribirNumeros.ingrseUnPunto=punto;
	}
	
	public static boolean getIngreseSoloNumeros() {
		return ingreseSoloNumeros;
	}

	public static void setIngreseSoloNumeros(boolean ingreseSoloNumeros) {
		EscribirNumeros.ingreseSoloNumeros = ingreseSoloNumeros;
	}
	
	public static Integer getCantidadNumerosIngresados() {
		return cantidadNumerosIngresados;
	}

	public static void setCantidadNumerosIngresados(Integer cantidadNumerosIngresados) {
		EscribirNumeros.cantidadNumerosIngresados = cantidadNumerosIngresados;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(cantidadNumerosIngresados==0) {
			incrementador=0;
		}
		
		EscribirNumeros.cantidadNumerosIngresados++;
		
		if ((EscribirNumeros.cantidadNumerosIngresados > 7 && EscribirNumeros.cantidadNumerosIngresados < 11)
				|| (EscribirNumeros.cantidadNumerosIngresados > 11 && EscribirNumeros.cantidadNumerosIngresados < 13)
				|| (EscribirNumeros.cantidadNumerosIngresados > 13 && EscribirNumeros.cantidadNumerosIngresados < 15)
				|| (EscribirNumeros.cantidadNumerosIngresados > 15 && EscribirNumeros.cantidadNumerosIngresados < 17)
				|| (EscribirNumeros.cantidadNumerosIngresados > 19 && EscribirNumeros.cantidadNumerosIngresados < 21)
				|| (EscribirNumeros.cantidadNumerosIngresados > 25 && EscribirNumeros.cantidadNumerosIngresados < 27)) {
			incrementador++;
			display.setFont(display.getFont().deriveFont(75f - incrementador * 7.5f));
		}
		
		String numeroBoton = e.getActionCommand();
		
		if(EscribirOperandos.getOperandoIngresado() || EscribirResultado.getIgualPresionado()) {
			if(numeroBoton.equals(".")) {
				EscribirNumeros.ingrseUnPunto=true;
				display.setText("0" + numeroBoton);
			}
			else {
				display.setText(numeroBoton);
			}
			
			if(EscribirResultado.getIgualPresionado()) {
				EscribirNumeros.ingreseSoloNumeros = true;
				EscribirResultado.setIgualPresionado(false);
			}
			EscribirOperandos.setOperandoIngresado(false);
		}
		else {
			if(numeroBoton.equals(".")) {
				if(ingrseUnPunto) {
					display.setText(display.getText());
				}
				else {
					display.setText(display.getText() + numeroBoton);
				}
				EscribirNumeros.ingrseUnPunto=true;
			}
			else {
				if(display.getText().equals("0")) {
					display.setText(numeroBoton);
				}
				else {
					display.setText(display.getText() + numeroBoton);
				}
			}
		}
		
	}
}
