package calculus;

import entity.Viga;

public class Verificacoes {
	
	//Condições para verificar o domínio três para o estado limite último (ELU)
	
	//Página 65
	public Boolean condicaoUm (Viga viga){
		
		Double epsilonCu = null;
		
		if(viga.getConcreto().getFck() >= 10 || viga.getConcreto().getFck() <= 50){
			epsilonCu = viga.getEpsilonCD();
		} else if(viga.getConcreto().getFck() >= 55){
			epsilonCu = 0.026 + (0.35 * ( ( Math.pow((90 - viga.getConcreto().getFck())/100, 4))));
		}
		
		if(viga.getEpsilonCD() == epsilonCu){
			return true;
		} else {
			return false;
		}

	}
	
	public Boolean condicaoDois(Viga viga){
		
		if(viga.getEpsilonSD() >= viga.getEpsilonPyD() && viga.getEpsilonSD() <= 0.1) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public Boolean condicaoTres(Viga viga){
		
		if(viga.getEpsilonPD() >= viga.getEpsilonPyD()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public Boolean condicaoQuarta(Viga viga){
		
		if(viga.getDeltaEpsilonPD() <= 0.1) {
			return true;
		} else {
			return false;
		}
		
	}

}
