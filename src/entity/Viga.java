package entity;

import java.util.List;

public class Viga {
	
	public Viga(Double i, Double j, Double k, Integer hipotese, Double gamaS, AcoArmaduraAtiva acoArmaduraAtiva, AcoArmaduraPassiva acoArmaduraPassiva, Double betaX, Double betaZ,
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
		this.concreto = new Concreto(this, null, null,null);
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
		//INICIO DA VERIFICACAO DOMINIO 3 ELU
		//tens�o a�o armadura ativa
		this.tensaoAcoPd = acoArmaduraAtiva.getFpyk() / gamaS;
		//tens�o a�o armadura passiva
		this.tensaoAcoSd = acoArmaduraPassiva.getfyk() / gamaS;
		// JV CONTINUA��O
		//Calculo das for�as de tracao
		//FOR�A de Tra��o na armadura ativa
		this.forcatracaoativo = acoArmaduraAtiva.getArea() * tensaoAcoPd;
		//For�a de tra��o na armadura passiva
		this.forcatracaopassivo = acoArmaduraPassiva.getArea() * tensaoAcoSd;
		//For�a de tra��o total NTD
		this.forcatracaototal = forcatracaoativo + forcatracaopassivo;
		//PAG 67 Equilibrio: Tracao = Compressao NCD
		this.forcacompressaocomprimida = forcatracaototal;
		//PG 67 Tensao no concreto (realizar o calculo"IF")
		
		//PG68 Ar�a comprimida (Acc)
		this.areacomprimida = forcacompressaocomprimida/tensaocd;
		
		//pg68 altura diagrama compressao
		this.yalturadiagramacompressao = areacomprimida/base;
		
		//pg68 Posicao linha Neuta X OBS: Criar o lambaconcreto
		this.posicaolinhaneutra = yalturadiagramacompressao/lambdaconcreto;
		
		//pg68 LAMBA CONCRETO????
		
		//PG69 INICIO DEFORMA��ES ARMADURAS ATIVAS
		this.deltaepsilonPD = ((dP - x )/x)*epsilonCU;
		
		//EPSLONCU ????
		this.epsilonCU = epsilonCU;
		
		//PG69 EpsilonPD
		this.defepsilonPD = acoArmaduraAtiva.getPreAlongamento() + deltaepsilonPD;
		
		//pg69 EpsilonPyD
		this.epsilonPyD = tensaoAcoPd/acoArmaduraAtiva.getElasticidadeacoativo();
		
		//COM OS RESULTADOS ACIMA, E FEITO A VERIFICACAO DOS ITENS C e D da verficiacao ELU dominio3 
		//Inicio das deforma��es das armaduras passivas
		//pg69 Deforma��o A.Ativa
		this.defepsilonSD = ((dS - x)/x)*epsilonCU;
		
		//Deforma�ao simplificada A.Ativa
		this.epsilonYD = tensaoAcoSd / acoArmaduraPassiva.getElasticidadeacopassivo();
		//COM ESSES RESULTADOS VERIFICA-SE CONDICAO B ELU DOMINIO 3
		//pg69 Posi��o do CG da �rea comprimida de altura y com tens�o uniforme do concreto
		this.ylinha = yalturadiagramacompressao / 2;
		
		//pg70
		this.zs = dS - ylinha;
		this.zp = dP - ylinha;
		//pg70 Momento resistente de c�lculo
		this.MRD = (forcatracaopassivo * zs) + (forcatracaoativo * zp);
		if(!(MRD >= mSD))
			System.out.println("Momento resistente de c�lculo n�o atende as solicita��es");
		
		//FIM DA VERIFICA��O DO ESTADO LIMITE �LTIMO
		
		if(concreto.getClasseconcreto() > 20 && concreto.getClasseconcreto() < 50){
			this.fctm = 0.3 * Math.pow(concreto.getFck() , 2/3); 
		} else {
			this.fctm = 2.12 * Math.log(1+(0.11 * concreto.getFck()));
		}
		
		this.fctkf = 1.428 * 0.7 * fctm;
		
		this.npinfinito = areaAcoArmaduraAtiva * acoArmaduraAtiva.getPreAlongamento() * acoArmaduraAtiva.getElasticidadeacoativo();
		
		
		this.ep = (altura/2) - y0;
		
		//Verifciar qual c�lculo
		this.mCQP = null;
		this.mCF = null;
		
		this.tensaoFibraSuperiorCF = npinfinito/area + (npinfinito * ep)/wCSup + mCF/wCSup;
		
		this.tensaoFibraInferiorCF = npinfinito/area + (npinfinito * ep)/wCInf + mCF/wCInf;
		
		this.tensaoFibraSuperiorCQP = npinfinito/area + (npinfinito * ep)/wCSup + mCQP/wCSup;
	
		this.tensaoFibraInferiorCQP = npinfinito/area + (npinfinito * ep)/wCInf + mCQP/wCInf;
		
		
		
		//Verifica��o pagina 72
		
		if( ! (tensaoFibraInferiorCF <= fctkf)){
			System.out.println("A fibra foi fissurada");
		}
		
		else if( !(tensaoFibraSuperiorCF <= Math.abs(0.6 * concreto.getFck()) )){
			System.out.println("A fibra foi fissurada");
		}
		
	
		
		else if(! (tensaoFibraInferiorCQP <= 0)){
			System.out.println("A fibra foi fissurada");
		}
		
		
		else if( !(tensaoFibraSuperiorCQP <= Math.abs(0.6 * concreto.getFck()))){
			System.out.println("A fibra  foi fissurada");
		}
		else{
		//Se passar todos os testes de fissura (quatro condi��es acima)
		System.out.println("Como n�o houve fissura��o, o est�dio 1 foi confirmado.");
		}
		
		//Verifica��o p�gina 79
		
	
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
	
	//pg69 o calculo
	private Double epsilonPyD;
	
	//pg69 deforma��o simplificada A.Passivo
	private Double epsilonYD;
	
	
	//Tens�o a�o ativo 2� calculo 
	private Double tensaoAcoPd;
	
	//Tens�o a�o ativo 2� calculo
	private Double tensaoAcoSd;

	//Coeficiente resistencia do a�o (Tabela 12)
	private Double gamaS;
	
	//For�a tra��o a�o ativo
	private Double forcatracaoativo;
	
	//For�a tra��o a�o passivo
	private Double forcatracaopassivo;
	
	//For�a tra��o total
	private Double forcatracaototal;
	
	//Equilibrio Tracao = Compressao pag67
	private Double forcacompressaocomprimida;
	
	//pg 67 tensao no concreto
	private Double tensaocd;
	
	//pg 67 Area comprimida Acc
	private Double areacomprimida;
	
	//pg67 altura do diagrama compressao
	private Double yalturadiagramacompressao;
	
	//pg67 Posicao linha Neuta X
	private Double posicaolinhaneutra;
	
	//pg68 Lambda concreto
	private Double lambdaconcreto;
	
	//pg69 Deforma��o armadura ativa DELTAPD
	private Double deltaepsilonPD;
	
	//pg69 Fazer EPSILONCU que est� em verifica��es
	private Double epsilonCU;
	
	//pg69 Deforma��o A.Ativa EpsilonPD
	private Double defepsilonPD;
	
	//pg69 Deforma��o A.Passiva
	private Double defepsilonSD;
	
	//pg69 Posi��o do CG da �rea comprimida de altura y com tens�o uniforme do concreto
	private Double ylinha;
	
	//pg70 Bra�os de alavanca da armadura ativa (zp) e da armadura passiva (zs):
	private Double zp;
	private Double zs;
	
	//pg70 C�lculo do momento resistente de c�lculo MRd
	private Double MRD;
	private Double MRD1;
	
	//Resistencia � tra��o direta m�dia do concreto
	private Double fctm;
	
	//Resistencia � tra��o na flex�o do concreto
	private Double fctkf;
	
	
	//For�a proten��o para um tempo infinito
	private Double npinfinito;
	
	//Tens�o fibra superior CQP
	private Double tensaoFibraSuperiorCQP;
	
	//Tens�o fibra inferior CQP
	private Double tensaoFibraInferiorCQP;
	
	//Tens�o fibra superior
	private Double tensaoFibraSuperiorCF;
	
	//Tens�o fibra inferior
	private Double tensaoFibraInferiorCF;
		
	//Valor da excentricidade
	private Double ep;
	
	//Verificar calculo - (MOMENTO)
	private Double mCQP;
	
	//Verificar calculo - (MOMENTO)
	private Double mCF;
	
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

	public Double getForcatracaoativo() {
		return forcatracaoativo;
	}

	public void setForcatracaoativo(Double forcatracaoativo) {
		this.forcatracaoativo = forcatracaoativo;
	}

	public Double getForcatracaopassivo() {
		return forcatracaopassivo;
	}

	public void setForcatracaopassivo(Double forcatracaopassivo) {
		this.forcatracaopassivo = forcatracaopassivo;
	}

	public Double getForcatracaototal() {
		return forcatracaototal;
	}

	public void setForcatracaototal(Double forcatracaototal) {
		this.forcatracaototal = forcatracaototal;
	}

	public Double getForcacompressaocomprimida() {
		return forcacompressaocomprimida;
	}

	public void setForcacompressaocomprimida(Double forcacompressaocomprimida) {
		this.forcacompressaocomprimida = forcacompressaocomprimida;
	}

	public Double getTensaocd() {
		return tensaocd;
	}

	public void setTensaocd(Double tensaocd) {
		this.tensaocd = tensaocd;
	}

	public Double getAreacomprimida() {
		return areacomprimida;
	}

	public void setAreacomprimida(Double areacomprimida) {
		this.areacomprimida = areacomprimida;
	}

	public Double getYalturadiagramacompressao() {
		return yalturadiagramacompressao;
	}

	public void setYalturadiagramacompressao(Double yalturadiagramacompressao) {
		this.yalturadiagramacompressao = yalturadiagramacompressao;
	}

	public Double getPosicaolinhaneutra() {
		return posicaolinhaneutra;
	}

	public void setPosicaolinhaneutra(Double posicaolinhaneutra) {
		this.posicaolinhaneutra = posicaolinhaneutra;
	}

	public Double getLambdaconcreto() {
		return lambdaconcreto;
	}

	public void setLambdaconcreto(Double lambdaconcreto) {
		this.lambdaconcreto = lambdaconcreto;
	}

	public Double getDeltaepsilonPD() {
		return deltaepsilonPD;
	}

	public void setDeltaepsilonPD(Double deltaepsilonPD) {
		this.deltaepsilonPD = deltaepsilonPD;
	}

	public Double getEpsilonCU() {
		return epsilonCU;
	}

	public void setEpsilonCU(Double epsilonCU) {
		this.epsilonCU = epsilonCU;
	}

	public Double getDefepsilonPD() {
		return defepsilonPD;
	}

	public void setDefepsilonPD(Double defepsilonPD) {
		this.defepsilonPD = defepsilonPD;
	}

	public Double getEpsilonYD() {
		return epsilonYD;
	}

	public void setEpsilonYD(Double epsilonYD) {
		this.epsilonYD = epsilonYD;
	}

	public Double getDefepsilonSD() {
		return defepsilonSD;
	}

	public void setDefepsilonSD(Double defepsilonSD) {
		this.defepsilonSD = defepsilonSD;
	}

	public Double getYlinha() {
		return ylinha;
	}

	public void setYlinha(Double ylinha) {
		this.ylinha = ylinha;
	}

	public Double getZp() {
		return zp;
	}

	public void setZp(Double zp) {
		this.zp = zp;
	}

	public Double getZs() {
		return zs;
	}

	public void setZs(Double zs) {
		this.zs = zs;
	}

	public Double getMRD() {
		return MRD;
	}

	public void setMRD(Double mRD) {
		MRD = mRD;
	}

	public Double getMRD1() {
		return MRD1;
	}

	public void setMRD1(Double mRD1) {
		MRD1 = mRD1;
	}

	
	
}
