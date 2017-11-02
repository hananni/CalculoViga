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
	
//	public Boolean condicaoDois(Viga viga){
//		
//		if(viga.getEpsilonSD() >= viga.getEpsilonSYD() && viga.getEpsilonSD() <= 0.1) {
//			System.out.println("Domínio 3 foi confirmado");
//			return true;
//		} else {
//			System.out.println("Erro na condição Dois!!");
//			return false;
//		}
//		
//	}
	
	public Boolean condicaoTres(Viga viga){
		
		if(viga.getEpsilonPD() >= viga.getEpsilonPyD()) {
			System.out.println("Domínio 3 foi confirmado");
			return true;
		} else {
			System.out.println("Erro na condição Três!!");
			return false;
		}
		
	}
	
	public Boolean condicaoQuarta(Viga viga){
		
		if(viga.getDeltaEpsilonPD() <= 0.1) {
			System.out.println("Domínio 3 foi confirmado");
			return true;
		} else {
			System.out.println("Erro na condição Quatro!!");
			return false;
		}
		
	}
	
	//VERIFICAÇÃO NÍVEL 02 - PROTENÇÃO LIMITADA (PAGINA 72) 
	public void nv2ProtencaoLimitadaA (Viga viga){
		
		
	}

}
