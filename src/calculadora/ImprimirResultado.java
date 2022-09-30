package calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImprimirResultado implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(EscribirResultado.getIgualPresionado()) {
			System.out.println(EscribirOperandos.getValorActual().toString());
		}
		else {
			System.out.println("Todavia no se llegó al resultado");
		}
	}

}
