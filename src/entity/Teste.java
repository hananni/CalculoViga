package entity;

import javax.swing.JOptionPane;

public class Teste {
	
	
	
	
	public Teste() {
		super();
		this.teste1 = Double.parseDouble(JOptionPane.showInputDialog("VALOR DO TESTE"));
		System.out.println(teste1);
		Concreto concreto = new Concreto(teste1, null, null);
		
}

	private Double teste1;
	
	
}
