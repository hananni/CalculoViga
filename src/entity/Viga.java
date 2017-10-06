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
		// checar segundo par�metro.
		this.concreto = new Concreto(this, null, null);
		this.mG1 = concreto.getqG1() * Math.pow (l,2)/8;
		this.acoArmaduraAtiva = acoArmaduraAtiva;
		this.y0 = acoArmaduraAtiva.getCobrimentoMinimo() + (acoArmaduraAtiva.getDiametroBarra().getBarras()/2) ;
		this.dP = altura - this.y0;
		
		this.acoArmaduraPassiva = acoArmaduraPassiva;
//		this.mSD = ;
		this.tensaoAcoAtivo = tensaoAcoAtivo;
		this.areaAcoArmaduraAtiva = (mSD * Math.pow(10, 4))/ betaZ * dP * tensaoAcoAtivo;
		


		//Primeira hip�tese acontece quando o c�lculo for apenas da armadura ativa
		if(this.hipotese == 1) {
		

		
				//Esperando resposta do Jo�o Vitor � respeito do calculo de y0s
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
				//Se esses c�lculos n�o estiverem iguais, algo no c�lculo est� errado.
				if(ntd == ntd1){
					this.forcaTracao = ntd;
				} else {
					System.out.println("C�lculo Errado");
				}
				
				this.quantidadeAco = areaAcoArmaduraAtiva/acoArmaduraAtiva.getArea();
		
		} 
		// In�cio da segunda hip�tese, quando tiver a�o de armadura passiva.
		else if (this.hipotese == 2){
			if(acoArmaduraPassiva.getDiametroBarra().getDiametroBarra() != 0 && acoArmaduraAtiva.getDiametroBarra().getBarras() != 0){
				this.y0s =  acoArmaduraAtiva.getCobrimentoMinimo() + (acoArmaduraPassiva.getDiametroBarra().getDiametroBarra()/2);
				
				// DS
				this.dS = altura - this.y0;
				
				//Posi��o da linha neutra em rela��o a borda comprimida
				this.x = betaX * dP;
				
				//Deforma��o da armadura ativa
				this.epsilonSD = (dS - x/dP - x) * deltaEpsilonPD;
				this.tensaoAcoPassivo = tensaoAcoPassivo;
				this.areaAcoArmaduraPassiva = (mSD * Math.pow(10, 4))/ betaZ * dS * tensaoAcoPassivo;
				this.forcaTracao = areaAcoArmaduraAtiva * tensaoAcoAtivo + areaAcoArmaduraPassiva * tensaoAcoPassivo;
				
			}
			
			
		}
		//Fim segunda hip�tese
		
		this.tensaoAcoPd = acoArmaduraAtiva.getFpyk() / gamaS;
		this.tensaoAcoSd = acoArmaduraPassiva.getfyk() / gamaS;
		
		
		
		
		
	}

	private Double base;
	private Double altura;
	private Double area;
	
	//Largura da se��o
	private Double l;
	
	//Dist�ncia do centro da se��o da viga at� a borda inferior;
	private Double yCInf;
	
	private Double yCsup;
	
	//O usu�rio informa qual hip�tese do c�lculo. 1 para primeira condi��o e 2 para a segunda condi��o
	private Integer hipotese;
	
	//Inercia da se��o em rela��o ao eixo X
	private Double inerciaX;
	
	//Modulo resistente inferior
	private Double wCInf;
	
	private Double wCSup;
	
	//Raio resitente relativo � fibra infeior
	private Double raioCInf;
	
	private Double raioCSup;

	private Concreto concreto;
	
	//Momento causado pelo peso pr�prio
	private Double mG1;
	
	private AcoArmaduraAtiva acoArmaduraAtiva;
	
	private AcoArmaduraPassiva acoArmaduraPassiva;
	
	
	//Dimensionamento no ELU usando processo pr�tico k6
	private Double k6;
	
	//Momento solicitante de calculo
	private Double mSD;
	
	//posi��o m�nima do centro de gravidade da armadura ativa
	private Double y0;
	
	//posi��o m�nima do centro de gravidade da armadura passiva
	private Double y0s;
	
	//Altura �lil relativa ao centro de gravidade da armadura ativa
	private Double dP;
	
	
	//Altura �lil relativa ao centro de gravidade da armadura ativa
	private Double dS;
		
	
	
	//Inicio interpola��o
	//Posi��o da linha neutra
	private Double betaX;
	
	//Varia��o do bra�o de alavanca
	private Double betaZ;
	
	//Deforma��o m�xima do concreto na borda comprimida
	private Double epsilonCD;
	
	//Deforma��o da armadura ativa em conjunto com o concreto
	private Double deltaEpsilonPD;
	

	//Quinto resultado interpola��o
	private Double tensaoAcoAtivo;
	
	//Quinto resultado interpola��o
	private Double tensaoAcoPassivo;
	
	//Fim Interpola��o
	
	private Integer dominio;

	//C�lculo da deforma��o total da armadura ativa
	private Double epsilonPD;
	
	//�rea total do a�o de armadura Ativa
	private Double areaAcoArmaduraAtiva;

	//�rea total do a�o de armadura Ativa
	private Double areaAcoArmaduraPassiva;
	
	
	private Double forcaTracao;

	//Quantidade necess�ria de a�o
	private Double quantidadeAco;
	
	//Posi��o da linha neutra em rela��o a borda comprimida
	private Double x;
	
	private Double epsilonSD;
	
	//Fazer c�lculo depois
	private Double epsilonPyD;
	
	//Tens�o a�o ativo 2� calculo 
	private Double tensaoAcoPd;
	
	//Tens�o a�o ativo 2� calculo
	private Double tensaoAcoSd;

	//Coeficiente resistencia do a�o (Tabela 12)
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
