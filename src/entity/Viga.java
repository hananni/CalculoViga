package entity;

import java.util.List;

public class Viga {
	
	public Viga(Double i, Double j, Double k, AcoArmaduraAtiva acoArmaduraAtiva, Double betaX, Double deltaZ,
			Double epsilonCD, Double deltaEpsilonPD) {
		super();
		this.base = i;
		this.altura = j;
		this.l = k;
		this.area = base * altura;
		this.yCInf = altura/2 ;
		this.yCsup = altura/2;
		this.inerciaX = base * Math.pow(altura, 3)/12;
		this.wCInf = inerciaX/yCInf;
		this.wCSup = inerciaX/yCsup;
		this.raioCInf = wCInf/area;
		this.raioCSup = wCSup/area;
		// checar segundo parâmetro.
		this.concreto = new Concreto(this, null);
		this.mG1 = concreto.getqG1() * Math.pow (l,2)/8;
		this.acoArmaduraAtiva = acoArmaduraAtiva;
		//Checando calculo para o mSD (falta terminar)
		if (acoArmaduraAtiva.getArea() != 0 && acoArmaduraPassiva.getArea() == 0)
		{
			this.mSD =;
		}
		

		//Esperando resposta do João Vitor à respeito do calculo de y0s
		this.y0 = acoArmaduraAtiva.getCobrimentoMinimo + ;
		this.dP = altura - this.y0;
		this.k6 = (base - Math.pow(dP, 2))/this.mSD;
		
		if(deltaEpsilonPD == 0.1 && (epsilonCD >= 0.035 && epsilonCD > 0))
		{
			this.dominio = 2;
		}
		else if(epsilonCD == 0.035 && (deltaEpsilonPD <= 0.1 && deltaEpsilonPD > 0))
		{
			this.dominio = 3;
		}
	}

	private Double base;
	private Double altura;
	private Double area;
	
	//Largura da seção
	private Double l;
	
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
	
	
	//Dimensionamento no ELU usando processo prático k6
	private Double k6;
	
	//Momento solicitante de calculo
	private Double mSD;
	
	//posição mínima do centro de gravidade da armadura ativa
	private Double y0;
	
	//Altura úlil relativa ao centro de gravidade da armadura ativa
	private Double dP;
	
	//Inicio interpolação
	//Posição da linha neutra
	private Double betaX;
	
	//Variação do braço de alavanca
	private Double deltaZ;
	
	//Deformação máxima do concreto na borda comprimida
	private Double epsilonCD;
	
	//Deformação da armadura ativa em conjunto com o concreto
	private Double deltaEpsilonPD;
	//Fim Interpolação

	private Integer dominio;
	
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

	public Double getL() {
		return l;
	}

	public void setL(Double l) {
		this.l = l;
	}

	public Double getK6() {
		return k6;
	}

	public void setK6(Double k6) {
		this.k6 = k6;
	}

	public Double getmSD() {
		return mSD;
	}

	public void setmSD(Double mSD) {
		this.mSD = mSD;
	}

	public Double getY0() {
		return y0;
	}

	public void setY0(Double y0) {
		this.y0 = y0;
	}

	public Double getdP() {
		return dP;
	}

	public void setdP(Double dP) {
		this.dP = dP;
	}

	public Double getBetaX() {
		return betaX;
	}

	public void setBetaX(Double betaX) {
		this.betaX = betaX;
	}

	public Double getDeltaZ() {
		return deltaZ;
	}

	public void setDeltaZ(Double deltaZ) {
		this.deltaZ = deltaZ;
	}

	public Double getEpsilonCD() {
		return epsilonCD;
	}

	public void setEpsilonCD(Double epsilonCD) {
		this.epsilonCD = epsilonCD;
	}

	public Double getDeltaEpsilonPD() {
		return deltaEpsilonPD;
	}

	public void setDeltaEpsilonPD(Double deltaEpsilonPD) {
		this.deltaEpsilonPD = deltaEpsilonPD;
	}
	
	
	
	
	
	
}
