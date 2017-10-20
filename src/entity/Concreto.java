package entity;

public class Concreto {

	
	public Concreto(Viga viga, Double classeCobrimentoNominal, Double fck, Double classeconcreto) {
		super();
		this.pesoConcreto = 25;
		this.qG1 = viga.getArea() * pesoConcreto;
		this.classeCobrimentoNominal = classeCobrimentoNominal;
		this.fck = fck;
		this.classeconcreto = classeconcreto;
		//gamac condicao pag 67
		if (classeconcreto >= 20 || classeconcreto <= 50){
			this.gamac = 0.85;
		} else if (classeconcreto > 50){
			this.gamac = 0.85*(1-((fck-50)/200 ));
		}
		
	}
	

	//FIXO 25 KN/m³
	private Integer pesoConcreto;

	//Carga da viga
	private Double qG1;
	
	
	//Cobrimento Nominal
	private Double classeCobrimentoNominal;
	
	//Ou MPA (Resistencia, característica a compreenssão)
	private Double fck;
	
	//gamac pag 67
	private Double gamac;
	
	//classeconcreto
	private Double classeconcreto;
	
	
		
	
	public Integer getPesoConcreto() {
		return pesoConcreto;
	}

	public void setPesoConcreto(Integer pesoConcreto) {
		this.pesoConcreto = pesoConcreto;
	}

	public Double getqG1() {
		return qG1;
	}

	public void setqG1(Double qG1) {
		this.qG1 = qG1;
	}

	public Double getClasseCobrimentoNominal() {
		return classeCobrimentoNominal;
	}

	public void setClasseCobrimentoNominal(Double classeCobrimentoNominal) {
		this.classeCobrimentoNominal = classeCobrimentoNominal;
	}

	public Double getFck() {
		return fck;
	}

	public void setFck(Double fck) {
		this.fck = fck;
	}

	public Double getGamac() {
		return gamac;
	}

	public void setGamac(Double gamac) {
		this.gamac = gamac;
	}

	public Double getClasseconcreto() {
		return classeconcreto;
	}

	public void setClasseconcreto(Double classeconcreto) {
		this.classeconcreto = classeconcreto;
	}
	
	

}
