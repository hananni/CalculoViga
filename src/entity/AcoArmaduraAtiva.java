package entity;

public class AcoArmaduraAtiva {
	

		public AcoArmaduraAtiva(DiametroBarraAtivo diametroBarra, Integer numerosFrios, Double nominal, Double area,
			Double massa, Double fptk, Double fpyk, Double relaxacao, CombinacaoAcoes combinacaoAcoes, Double dMax,
			Double cobrimentoMinimo) {
		super();
		this.diametroBarra = diametroBarra;
		this.numerosFrios = numerosFrios;
		this.nominal = nominal;
		this.area = area;
		this.massa = massa;
		this.fptk = fptk;
		this.fpyk = fpyk;
		this.relaxacao = relaxacao;
		this.tensaoFptk = 0.77 * fptk;
		this.tensaoFpyk = relaxacao * fpyk;
		this.cobrimentoMinimo = cobrimentoMinimo;
		
		//Pega o menor valor gereado de tensão para multiplicar com a área
		if (tensaoFptk > tensaoFpyk){ 
			this.np0 = tensaoFpyk * area;
		} else {
			this.np0 = tensaoFptk * area;
		}
		
		//descobrir deformação para o calculo da tensão
		
//		this.tensao = 200 * Math.pow(10, 9)  ;
	
		this.pd = np0 * combinacaoAcoes.getGamaY();
		this.preAlongamento = ((pd * (1-0.25))/(200 * Math.pow(10, 9)) * area ) * 1000;
		if (2*(nominal*10) > 1.2*(dMax*10) && 2*(nominal*10) > 2){
			this.espMin = 2*(nominal*10);
		}
		else if (1.2*(dMax*10) > 2*(nominal*10) && 1.2*(dMax*10) > 2){
			this.espMin = 1.2*(dMax*10);
		}
		else{
			this.espMin = 2.0;
		}
	}

		private DiametroBarraAtivo diametroBarra;
	
		private Integer numerosFrios;
		
		private Double nominal;
		
		private Double area;
		
		private Double massa;
		
		//O da formula
		private Double tensaoFptk;
		
		private Double tensaoFpyk;
		
		//Ruptura por tração
		private Double fptk;
		
		//Limite de escoamento do aço
		private Double fpyk;
		
		//Muda apenas o fator de multiplicação da tensão fpyk 
		private Double relaxacao;
		
		//protenção inicial
		private Double np0;

		//tensão 
		private Double tensao;
		
		private Double pd;
		
		private CombinacaoAcoes combinacaoAcoes;
		
		//ERRO - falta parâmetros para calcular o preAlongamento
		//Pre-alongamento de armadura-ativa
		private Double preAlongamento;

		//Espaçamento da armadura ativa
		private Double espMin;
		
		//Diâmetro da brita (à verificar)
		private Double dMax;
		
		private Double cobrimentoMinimo;
		
		public DiametroBarraAtivo getDiametroBarra() {
			return diametroBarra;
		}

		public void setDiametroBarra(DiametroBarraAtivo diametroBarra) {
			this.diametroBarra = diametroBarra;
		}

		public Integer getNumerosFrios() {
			return numerosFrios;
		}

		public void setNumerosFrios(Integer numerosFrios) {
			this.numerosFrios = numerosFrios;
		}

		public Double getNominal() {
			return nominal;
		}

		public void setNominal(Double nominal) {
			this.nominal = nominal;
		}

		public Double getArea() {
			return area;
		}

		public void setArea(Double area) {
			this.area = area;
		}

		public Double getMassa() {
			return massa;
		}

		public void setMassa(Double massa) {
			this.massa = massa;
		}

		public Double getTensaoFptk() {
			return tensaoFptk;
		}

		public void setTensaoFptk(Double tensaoFptk) {
			this.tensaoFptk = tensaoFptk;
		}

		public Double getTensaoFpyk() {
			return tensaoFpyk;
		}

		public void setTensaoFpyk(Double tensaoFpyk) {
			this.tensaoFpyk = tensaoFpyk;
		}

		public Double getFptk() {
			return fptk;
		}

		public void setFptk(Double fptk) {
			this.fptk = fptk;
		}

		public Double getFpyk() {
			return fpyk;
		}

		public void setFpyk(Double fpyk) {
			this.fpyk = fpyk;
		}

		public Double getRelaxacao() {
			return relaxacao;
		}

		public void setRelaxacao(Double relaxacao) {
			this.relaxacao = relaxacao;
		}

		public Double getNp0() {
			return np0;
		}

		public void setNp0(Double np0) {
			this.np0 = np0;
		}

		public Double getTensao() {
			return tensao;
		}

		public void setTensao(Double tensao) {
			this.tensao = tensao;
		}

		public Double getPd() {
			return pd;
		}

		public void setPd(Double pd) {
			this.pd = pd;
		}

		public CombinacaoAcoes getCombinacaoAcoes() {
			return combinacaoAcoes;
		}

		public void setCombinacaoAcoes(CombinacaoAcoes combinacaoAcoes) {
			this.combinacaoAcoes = combinacaoAcoes;
		}

		public Double getPreAlongamento() {
			return preAlongamento;
		}

		public void setPreAlongamento(Double preAlongamento) {
			this.preAlongamento = preAlongamento;
		}

		public Double getEspMin() {
			return espMin;
		}

		public void setEspMin(Double espMin) {
			this.espMin = espMin;
		}

		public Double getdMax() {
			return dMax;
		}

		public void setdMax(Double dMax) {
			this.dMax = dMax;
		}

		public Double getCobrimentoMinimo() {
			return cobrimentoMinimo;
		}

		public void setCobrimentoMinimo(Double cobrimentoMinimo) {
			this.cobrimentoMinimo = cobrimentoMinimo;
		}
		
		
		

		
		
	
		
}
