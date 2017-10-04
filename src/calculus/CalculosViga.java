package calculus;

public interface CalculosViga {
	
	
	public static Double calculoArea(Double base, Double altura){
		return base * altura;
	}
	
	public static Double calculoYC(Double altura){
		return altura/2;
		
	}
	
	public static Double calculoInercia (Double base, Double altura){
		return base * Math.pow(altura, 3)/12;
	}
	
	public static Double modeloResistenteInferior (Double inercia, Double yCinf){
		return inercia/yCinf;
	}
	
	public static Double modeloResistenteSuperior (Double inercia, Double yCsup){
		return inercia/yCsup;
	}
	
	public static Double raioResistenteInferior (Double wCinf, Double area){
		return wCinf/area;
	}
	
	public static Double raioResistenteSuperior (Double wCsup, Double area){
		return wCsup/area;
	}
	
	


}
