package entity;

import java.util.List;

public class Viga {
	
	public Viga(Double i, Double j, AcoArmaduraAtiva acoArmaduraAtiva) {
		super();
		this.base = i;
		this.altura = j;
		this.area = base * altura;
		this.yCInf = altura/2 ;
		this.yCsup = altura/2;
		this.inerciaX = base * Math.pow(altura, 3)/12;
		this.wCInf = inerciaX/yCInf;
		this.wCSup = inerciaX/yCsup;
		this.raioCInf = wCInf/area;
		this.raioCSup = wCSup/area;
		this.concreto = new Concreto(this);
		this.mG1 = concreto.getqG1() * Math.pow (base,2)/8;
		this.acoArmaduraAtiva = acoArmaduraAtiva;
	}

	private Double base;
	private Double altura;
	private Double area;
	
	//Distância do centro da seção da viga até a borda inferior;
	private Double yCInf;
	
	private Double yCsup;
	
	//Inercia da seção em relação ao eixo X
	private Double inerciaX;
	
	//Modulo resistente inferior
	private Double wCInf;
	
	private Double wCSup;
	
	//Raio resitente relativo à fibra infeior
	private Double raioCInf;
	
	private Double raioCSup;

	private Concreto concreto;
	
	//Momento causado pelo peso próprio
	private Double mG1;
	
	private AcoArmaduraAtiva acoArmaduraAtiva;
	
	private AcoArmaduraPassiva acoArmaduraPassiva;


	public Double getBase() {
		return base;
	}

	public void setBase(Double base) {
		this.base = base;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		
		this.area = area;
	}

	public Double getyCInf() {
		return yCInf;
	}

	public void setyCInf(Double yCInf) {
		this.yCInf = yCInf;
	}


	public Double getyCsup() {
		return yCsup;
	}

	public void setyCsup(Double yCsup) {
		this.yCsup = yCsup;
	}

	public Double getInerciaX() {
		return inerciaX;
	}

	public void setInerciaX(Double inerciaX) {
		this.inerciaX = inerciaX;
	}

	public Double getwCInf() {
		return wCInf;
	}

	public void setwCInf(Double wCInf) {
		this.wCInf = wCInf;
	}

	public Double getwCSup() {
		return wCSup;
	}

	public void setwCSup(Double wCSup) {
		this.wCSup = wCSup;
	}

	public Double getRaioCInf() {
		return raioCInf;
	}

	public void setRaioCInf(Double raioCInf) {
		this.raioCInf = raioCInf;
	}

	public Double getRaioCSup() {
		return raioCSup;
	}

	public void setRaioCSup(Double raioCSup) {
		this.raioCSup = raioCSup;
	}

	public AcoArmaduraAtiva getAcoArmaduraAtiva() {
		return acoArmaduraAtiva;
	}

	public void setAcoArmaduraAtiva(AcoArmaduraAtiva acoArmaduraAtiva) {
		this.acoArmaduraAtiva = acoArmaduraAtiva;
	}

	public AcoArmaduraPassiva getAcoArmaduraPassiva() {
		return acoArmaduraPassiva;
	}

	public void setAcoArmaduraPassiva(AcoArmaduraPassiva acoArmaduraPassiva) {
		this.acoArmaduraPassiva = acoArmaduraPassiva;
	}

	public Concreto getConcreto() {
		return concreto;
	}

	public void setConcreto(Concreto concreto) {
		this.concreto = concreto;
	}

	public Double getmG1() {
		return mG1;
	}

	public void setmG1(Double mG1) {
		this.mG1 = mG1;
	}
	
	
}
