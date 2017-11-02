package calculus;

import entity.Viga;

public class Verificacoes {
	
	//Condi��es para verificar o dom�nio tr�s para o estado limite �ltimo (ELU)
	
	//P�gina 65
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
	
//	public Boolean condicaoDois(Viga viga){
//		
//		if(viga.getEpsilonSD() >= viga.getEpsilonSYD() && viga.getEpsilonSD() <= 0.1) {
//			System.out.println("Dom�nio 3 foi confirmado");
//			return true;
//		} else {
//			System.out.println("Erro na condi��o Dois!!");
//			return false;
//		}
//		
//	}
	
	public Boolean condicaoTres(Viga viga){
		
		if(viga.getEpsilonPD() >= viga.getEpsilonPyD()) {
			System.out.println("Dom�nio 3 foi confirmado");
			return true;
		} else {
			System.out.println("Erro na condi��o Tr�s!!");
			return false;
		}
		
	}
	
	public Boolean condicaoQuarta(Viga viga){
		
		if(viga.getDeltaEpsilonPD() <= 0.1) {
			System.out.println("Dom�nio 3 foi confirmado");
			return true;
		} else {
			System.out.println("Erro na condi��o Quatro!!");
			return false;
		}
		
	}
	
	//VERIFICA��O N�VEL 02 - PROTEN��O LIMITADA (PAGINA 72) 
	public void nv2ProtencaoLimitadaA (Viga viga){
		
		
	}

}
