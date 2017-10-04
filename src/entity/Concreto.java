package entity;

public class Concreto {

	
	public Concreto(Viga viga, Double classeCobrimentoNominal) {
		super();
		this.pesoConcreto = 25;
		this.qG1 = viga.getArea() * pesoConcreto;
		this.classeCobrimentoNominal = classeCobrimentoNominal;
	}

	//FIXO 25 KN/m³
	private Integer pesoConcreto;

	//Carga da viga
	private Double qG1;
	
	
	//Cobrimento Nominal
	private Double classeCobrimentoNominal;
	
	//pegar outros atributos/objetos
	
	
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
	
	
	
	
	
	
}
