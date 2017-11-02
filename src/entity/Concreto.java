package entity;

public class Concreto {

	
	public Concreto(Double areaViga, String classeconcreto, Integer fck) {
		super();
		this.pesoConcreto = 25;
		this.qG1 = areaViga * pesoConcreto;
		this.classeconcreto = classeconcreto;
		this.fck = fck;
		//gamac condicao pag 67
		if (fck >= 20 || fck <= 50){
			this.gamac = 0.85;
		} else if (fck > 50){
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
	private Integer fck;
	
	//gamac pag 67
	private Double gamac;
	
	//classeconcreto
	private String classeconcreto;
	
	
		
	
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

	public Integer getFck() {
		return fck;
	}

	public void setFck(Integer fck) {
		this.fck = fck;
	}

	public Double getGamac() {
		return gamac;
	}

	public void setGamac(Double gamac) {
		this.gamac = gamac;
	}

	public String getClasseconcreto() {
		return classeconcreto;
	}

	public void setClasseconcreto(String classeconcreto) {
		this.classeconcreto = classeconcreto;
	}
	
	

}
