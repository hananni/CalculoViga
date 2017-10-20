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
		// checar segundo parâmetro.
		this.concreto = new Concreto(this, null, null,null);
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
		//INICIO DA VERIFICACAO DOMINIO 3 ELU
		//tensão aço armadura ativa
		this.tensaoAcoPd = acoArmaduraAtiva.getFpyk() / gamaS;
		//tensão aço armadura passiva
		this.tensaoAcoSd = acoArmaduraPassiva.getfyk() / gamaS;
		// JV CONTINUAÇÂO
		//Calculo das forças de tracao
		//FORÇA de Tração na armadura ativa
		this.forcatracaoativo = acoArmaduraAtiva.getArea() * tensaoAcoPd;
		//Força de tração na armadura passiva
		this.forcatracaopassivo = acoArmaduraPassiva.getArea() * tensaoAcoSd;
		//Força de tração total NTD
		this.forcatracaototal = forcatracaoativo + forcatracaopassivo;
		//PAG 67 Equilibrio: Tracao = Compressao NCD
		this.forcacompressaocomprimida = forcatracaototal;
		//PG 67 Tensao no concreto (realizar o calculo"IF")
		
		//PG68 Aréa comprimida (Acc)
		this.areacomprimida = forcacompressaocomprimida/tensaocd;
		
		//pg68 altura diagrama compressao
		this.yalturadiagramacompressao = areacomprimida/base;
		
		//pg68 Posicao linha Neuta X OBS: Criar o lambaconcreto
		this.posicaolinhaneutra = yalturadiagramacompressao/lambdaconcreto;
		
		//pg68 LAMBA CONCRETO????
		
		//PG69 INICIO DEFORMAÇÕES ARMADURAS ATIVAS
		this.deltaepsilonPD = ((dP - x )/x)*epsilonCU;
		
		//EPSLONCU ????
		this.epsilonCU = epsilonCU;
		
		//PG69 EpsilonPD
		this.defepsilonPD = acoArmaduraAtiva.getPreAlongamento() + deltaepsilonPD;
		
		//pg69 EpsilonPyD
		this.epsilonPyD = tensaoAcoPd/acoArmaduraAtiva.getElasticidadeacoativo();
		
		//COM OS RESULTADOS ACIMA, E FEITO A VERIFICACAO DOS ITENS C e D da verficiacao ELU dominio3 
		//Inicio das deformações das armaduras passivas
		//pg69 Deformação A.Ativa
		this.defepsilonSD = ((dS - x)/x)*epsilonCU;
		
		//Deformaçao simplificada A.Ativa
		this.epsilonYD = tensaoAcoSd / acoArmaduraPassiva.getElasticidadeacopassivo();
		//COM ESSES RESULTADOS VERIFICA-SE CONDICAO B ELU DOMINIO 3
		//pg69 Posição do CG da área comprimida de altura y com tensão uniforme do concreto
		this.ylinha = yalturadiagramacompressao / 2;
		
		//pg70
		this.zs = dS - ylinha;
		this.zp = dP - ylinha;
		//pg70 Momento resistente de cálculo
		this.MRD = (forcatracaopassivo * zs) + (forcatracaoativo * zp);
		if(!(MRD >= mSD))
			System.out.println("Momento resistente de cálculo não atende as solicitações");
		
		//FIM DA VERIFICAÇÃO DO ESTADO LIMITE ÚLTIMO
		
		if(concreto.getClasseconcreto() > 20 && concreto.getClasseconcreto() < 50){
			this.fctm = 0.3 * Math.pow(concreto.getFck() , 2/3); 
		} else {
			this.fctm = 2.12 * Math.log(1+(0.11 * concreto.getFck()));
		}
		
		this.fctkf = 1.428 * 0.7 * fctm;
		
		this.npinfinito = areaAcoArmaduraAtiva * acoArmaduraAtiva.getPreAlongamento() * acoArmaduraAtiva.getElasticidadeacoativo();
		
		
		this.ep = (altura/2) - y0;
		
		//Verifciar qual cálculo
		this.mCQP = null;
		this.mCF = null;
		
		this.tensaoFibraSuperiorCF = npinfinito/area + (npinfinito * ep)/wCSup + mCF/wCSup;
		
		this.tensaoFibraInferiorCF = npinfinito/area + (npinfinito * ep)/wCInf + mCF/wCInf;
		
		this.tensaoFibraSuperiorCQP = npinfinito/area + (npinfinito * ep)/wCSup + mCQP/wCSup;
	
		this.tensaoFibraInferiorCQP = npinfinito/area + (npinfinito * ep)/wCInf + mCQP/wCInf;
		
		
		
		//Verificação pagina 72
		
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
		//Se passar todos os testes de fissura (quatro condições acima)
		System.out.println("Como não houve fissuração, o estádio 1 foi confirmado.");
		}
		
		//Verificação página 79
		
	
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
	
	//pg69 o calculo
	private Double epsilonPyD;
	
	//pg69 deformação simplificada A.Passivo
	private Double epsilonYD;
	
	
	//Tensão aço ativo 2º calculo 
	private Double tensaoAcoPd;
	
	//Tensão aço ativo 2º calculo
	private Double tensaoAcoSd;

	//Coeficiente resistencia do aço (Tabela 12)
	private Double gamaS;
	
	//Força tração aço ativo
	private Double forcatracaoativo;
	
	//Força tração aço passivo
	private Double forcatracaopassivo;
	
	//Força tração total
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
	
	//pg69 Deformação armadura ativa DELTAPD
	private Double deltaepsilonPD;
	
	//pg69 Fazer EPSILONCU que está em verificações
	private Double epsilonCU;
	
	//pg69 Deformação A.Ativa EpsilonPD
	private Double defepsilonPD;
	
	//pg69 Deformação A.Passiva
	private Double defepsilonSD;
	
	//pg69 Posição do CG da área comprimida de altura y com tensão uniforme do concreto
	private Double ylinha;
	
	//pg70 Braços de alavanca da armadura ativa (zp) e da armadura passiva (zs):
	private Double zp;
	private Double zs;
	
	//pg70 Cálculo do momento resistente de cálculo MRd
	private Double MRD;
	private Double MRD1;
	
	//Resistencia à tração direta média do concreto
	private Double fctm;
	
	//Resistencia à tração na flexão do concreto
	private Double fctkf;
	
	
	//Força protenção para um tempo infinito
	private Double npinfinito;
	
	//Tensão fibra superior CQP
	private Double tensaoFibraSuperiorCQP;
	
	//Tensão fibra inferior CQP
	private Double tensaoFibraInferiorCQP;
	
	//Tensão fibra superior
	private Double tensaoFibraSuperiorCF;
	
	//Tensão fibra inferior
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
