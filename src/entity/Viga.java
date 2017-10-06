package entity;

import java.util.List;

public class Viga {
	
	public Viga(Double i, Double j, Double k, Integer hipotese, Double gameS, AcoArmaduraAtiva acoArmaduraAtiva, AcoArmaduraPassiva acoArmaduraPasiva, Double betaX, Double betaZ,
			Double epsilonCD, Double deltaEpsilonPD, Double tensaoAcoAtivo, Double tensaoAcoPassivo) {
		super();
		this.base = i;
		this.altura = j;
		this.hipotese = hipotese;
		this.l = k;
		this.area = base * altura;
		this.gamaS = gamaS;
		this.yCInf = altura/2 ;
		this.yCsup = altura/2;
		this.inerciaX = base * Math.pow(altura, 3)/12;
		this.wCInf = inerciaX/yCInf;
		this.wCSup = inerciaX/yCsup;
		this.raioCInf = wCInf/area;
		this.raioCSup = wCSup/area;
		// checar segundo parâmetro.
		this.concreto = new Concreto(this, null, null);
		this.mG1 = concreto.getqG1() * Math.pow (l,2)/8;
		this.acoArmaduraAtiva = acoArmaduraAtiva;
		this.y0 = acoArmaduraAtiva.getCobrimentoMinimo() + (acoArmaduraAtiva.getDiametroBarra().getBarras()/2) ;
		this.dP = altura - this.y0;
		
		this.acoArmaduraPassiva = acoArmaduraPassiva;
//		this.mSD = ;
		this.tensaoAcoAtivo = tensaoAcoAtivo;
		this.areaAcoArmaduraAtiva = (mSD * Math.pow(10, 4))/ betaZ * dP * tensaoAcoAtivo;
		


		//Primeira hipótese acontece quando o cálculo for apenas da armadura ativa
		if(this.hipotese == 1) {
		

		
				//Esperando resposta do João Vitor à respeito do calculo de y0s
				this.k6 = (base - Math.pow(dP, 2))/this.mSD;
				
				if(deltaEpsilonPD == 0.1 && (epsilonCD >= 0.035 && epsilonCD > 0))
				{
					this.dominio = 2;
				}
				else if(epsilonCD == 0.035 && (deltaEpsilonPD <= 0.1 && deltaEpsilonPD > 0))
				{
					this.dominio = 3;
				}
				
				this.epsilonPD = acoArmaduraAtiva.getPreAlongamento() + deltaEpsilonPD;
				
				
				
				Double ntd = mSD/ (betaZ * dP);
				Double ntd1 = areaAcoArmaduraAtiva * tensaoAcoAtivo;
				//Se esses cálculos não estiverem iguais, algo no cálculo está errado.
				if(ntd == ntd1){
					this.forcaTracao = ntd;
				} else {
					System.out.println("Cálculo Errado");
				}
				
				this.quantidadeAco = areaAcoArmaduraAtiva/acoArmaduraAtiva.getArea();
		
		} 
		// Início da segunda hipótese, quando tiver aço de armadura passiva.
		else if (this.hipotese == 2){
			if(acoArmaduraPassiva.getDiametroBarra().getDiametroBarra() != 0 && acoArmaduraAtiva.getDiametroBarra().getBarras() != 0){
				this.y0s =  acoArmaduraAtiva.getCobrimentoMinimo() + (acoArmaduraPassiva.getDiametroBarra().getDiametroBarra()/2);
				
				// DS
				this.dS = altura - this.y0;
				
				//Posição da linha neutra em relação a borda comprimida
				this.x = betaX * dP;
				
				//Deformação da armadura ativa
				this.epsilonSD = (dS - x/dP - x) * deltaEpsilonPD;
				this.tensaoAcoPassivo = tensaoAcoPassivo;
				this.areaAcoArmaduraPassiva = (mSD * Math.pow(10, 4))/ betaZ * dS * tensaoAcoPassivo;
				this.forcaTracao = areaAcoArmaduraAtiva * tensaoAcoAtivo + areaAcoArmaduraPassiva * tensaoAcoPassivo;
				
			}
			
			
		}
		//Fim segunda hipótese
		
		this.tensaoAcoPd = acoArmaduraAtiva.getFpyk() / gamaS;
		this.tensaoAcoSd = acoArmaduraPassiva.getfyk() / gamaS;
		
		
		
		
		
	}

	private Double base;
	private Double altura;
	private Double area;
	
	//Largura da seção
	private Double l;
	
	//Distância do centro da seção da viga até a borda inferior;
	private Double yCInf;
	
	private Double yCsup;
	
	//O usuário informa qual hipótese do cálculo. 1 para primeira condição e 2 para a segunda condição
	private Integer hipotese;
	
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
	
	//posição mínima do centro de gravidade da armadura passiva
	private Double y0s;
	
	//Altura úlil relativa ao centro de gravidade da armadura ativa
	private Double dP;
	
	
	//Altura úlil relativa ao centro de gravidade da armadura ativa
	private Double dS;
		
	
	
	//Inicio interpolação
	//Posição da linha neutra
	private Double betaX;
	
	//Variação do braço de alavanca
	private Double betaZ;
	
	//Deformação máxima do concreto na borda comprimida
	private Double epsilonCD;
	
	//Deformação da armadura ativa em conjunto com o concreto
	private Double deltaEpsilonPD;
	

	//Quinto resultado interpolação
	private Double tensaoAcoAtivo;
	
	//Quinto resultado interpolação
	private Double tensaoAcoPassivo;
	
	//Fim Interpolação
	
	private Integer dominio;

	//Cálculo da deformação total da armadura ativa
	private Double epsilonPD;
	
	//Área total do aço de armadura Ativa
	private Double areaAcoArmaduraAtiva;

	//Área total do aço de armadura Ativa
	private Double areaAcoArmaduraPassiva;
	
	
	private Double forcaTracao;

	//Quantidade necessária de aço
	private Double quantidadeAco;
	
	//Posição da linha neutra em relação a borda comprimida
	private Double x;
	
	private Double epsilonSD;
	
	//Fazer cálculo depois
	private Double epsilonPyD;
	
	//Tensão aço ativo 2º calculo 
	private Double tensaoAcoPd;
	
	//Tensão aço ativo 2º calculo
	private Double tensaoAcoSd;

	//Coeficiente resistencia do aço (Tabela 12)
	private Double gamaS;
	
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

	public Double getBetaZ() {
		return betaZ;
	}

	public void setBetaZ(Double betaZ) {
		this.betaZ = betaZ;
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

	public Double getEpsilonPD() {
		return epsilonPD;
	}

	public void setEpsilonPD(Double epsilonPD) {
		this.epsilonPD = epsilonPD;
	}

	public Integer getDominio() {
		return dominio;
	}

	public void setDominio(Integer dominio) {
		this.dominio = dominio;
	}

	public Double getAreaAcoArmaduraAtiva() {
		return areaAcoArmaduraAtiva;
	}

	public void setAreaAcoArmaduraAtiva(Double areaAcoArmaduraAtiva) {
		this.areaAcoArmaduraAtiva = areaAcoArmaduraAtiva;
	}

	public Double getY0s() {
		return y0s;
	}

	public void setY0s(Double y0s) {
		this.y0s = y0s;
	}

	public Double getdS() {
		return dS;
	}

	public void setdS(Double dS) {
		this.dS = dS;
	}

	public Double getTensaoAcoAtivo() {
		return tensaoAcoAtivo;
	}

	public void setTensaoAcoAtivo(Double tensaoAcoAtivo) {
		this.tensaoAcoAtivo = tensaoAcoAtivo;
	}

	public Double getTensaoAcoPassivo() {
		return tensaoAcoPassivo;
	}

	public void setTensaoAcoPassivo(Double tensaoAcoPassivo) {
		this.tensaoAcoPassivo = tensaoAcoPassivo;
	}

	public Double getAreaAcoArmaduraPassiva() {
		return areaAcoArmaduraPassiva;
	}

	public void setAreaAcoArmaduraPassiva(Double areaAcoArmaduraPassiva) {
		this.areaAcoArmaduraPassiva = areaAcoArmaduraPassiva;
	}

	public Double getForcaTracao() {
		return forcaTracao;
	}

	public void setForcaTracao(Double forcaTracao) {
		this.forcaTracao = forcaTracao;
	}

	public Double getQuantidadeAco() {
		return quantidadeAco;
	}

	public void setQuantidadeAco(Double quantidadeAco) {
		this.quantidadeAco = quantidadeAco;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getEpsilonSD() {
		return epsilonSD;
	}

	public void setEpsilonSD(Double epsilonSD) {
		this.epsilonSD = epsilonSD;
	}

	public Double getEpsilonPyD() {
		return epsilonPyD;
	}

	public void setEpsilonPyD(Double epsilonPyD) {
		this.epsilonPyD = epsilonPyD;
	}

	public Integer getHipotese() {
		return hipotese;
	}

	public void setHipotese(Integer hipotese) {
		this.hipotese = hipotese;
	}

	public Double getTensaoAcoPd() {
		return tensaoAcoPd;
	}

	public void setTensaoAcoPd(Double tensaoAcoPd) {
		this.tensaoAcoPd = tensaoAcoPd;
	}

	public Double getTensaoAcoSd() {
		return tensaoAcoSd;
	}

	public void setTensaoAcoSd(Double tensaoAcoSd) {
		this.tensaoAcoSd = tensaoAcoSd;
	}

	public Double getGamaS() {
		return gamaS;
	}

	public void setGamaS(Double gamaS) {
		this.gamaS = gamaS;
	}	
	
	
}
