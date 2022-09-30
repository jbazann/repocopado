package calculadora;

import javax.swing.JFrame;

public class Marco extends JFrame{
	
	public Marco() {
		
		setTitle("Calculadora");
		setBounds(100,100,360,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		LaminaDisplay display = new LaminaDisplay();
		add(display);
	}

}
