package entity;

public class AcoArmaduraPassiva {

	
	
	public AcoArmaduraPassiva( Double diametroBarra,  Double area, String categoria, Integer fyk) {
		super();
		this.diametroBarra = diametroBarra;
		this.area = area;
		this.categoria = categoria;
		this.dMax = 1.9;
		//De acordo com a categoria
		this.fyk = fyk;
		this.elasticidadeacopassivo = 210 * Math.pow(10, 3); //verificar unidade
		
		//Calculando o Espaçamento Horizontal
		if ((diametroBarra*10) > 1.2*(dMax*10) && 2*(diametroBarra*10) > 2){
			this.espHorizontal = diametroBarra*10;
		}
		else if (1.2*(dMax*10) > 2*(diametroBarra*10) && 1.2*(dMax*10) > 2){
			this.espHorizontal = 1.2*(dMax*10);
		}
		else{
			this.espHorizontal = 2.0;
		}
		
		//Calculando o Espaçamento Vertical
		if ((diametroBarra*10) > 0.5*(dMax*10) && 2*(diametroBarra*10) > 2){
			this.espVertical = diametroBarra*10;
		}
		else if (0.5*(dMax*10) > 2*(diametroBarra*10) && 0.5*(dMax*10) > 2){
			this.espVertical = 0.5*(dMax*10);
		}
		else{
			this.espVertical = 2.0;
		}
		
	}



	//VALORES FIXOS TABELA 7
//	private DiametroBarraPassivo diametroBarra;
	
	private Double diametroBarra;
	
	private String categoria;
	
	private Integer fyk;
	
	private Double limiteResistencia;
	
	private Integer alongamentoAposRuptura;
	

	
	private Double area;
	//Espaçamento Horizontal
	private Double espHorizontal;
	//Espaçamento Vertical
	private Double espVertical;
	
	//Diâmetro da brita (à verificar)
	private Double dMax;
	
	//Modulo elasticidade
	private Double elasticidadeacopassivo;
	

//	public DiametroBarraPassivo getDiametroBarra() {
//		return diametroBarra;
//	}
//
//	public void setDiametroBarra(DiametroBarraPassivo diametroBarra) {
//		this.diametroBarra = diametroBarra;
//	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getfyk() {
		return fyk;
	}

	public void setfyk(Integer fyk) {
		this.fyk = fyk;
	}

	public Double getLimiteResistencia() {
		return limiteResistencia;
	}

	public void setLimiteResistencia(Double limiteResistencia) {
		this.limiteResistencia = limiteResistencia;
	}

	public Integer getAlongamentoAposRuptura() {
		return alongamentoAposRuptura;
	}

	public void setAlongamentoAposRuptura(Integer alongamentoAposRuptura) {
		this.alongamentoAposRuptura = alongamentoAposRuptura;
	}

	public Double getEspHorizontal() {
		return espHorizontal;
	}

	public void setEspHorizontal(Double espHorizontal) {
		this.espHorizontal = espHorizontal;
	}

	public Double getEspVertical() {
		return espVertical;
	}

	public void setEspVertical(Double espVertical) {
		this.espVertical = espVertical;
	}

	public Double getdMax() {
		return dMax;
	}

	public void setdMax(Double dMax) {
		this.dMax = dMax;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}


	
	public Integer getFyk() {
		return fyk;
	}
	
	

	public void setFyk(Integer fyk) {
		this.fyk = fyk;
	}

	public Double getElasticidadeacopassivo() {
		return elasticidadeacopassivo;
	}

	public void setElasticidadeacopassivo(Double elasticidadeacopassivo) {
		this.elasticidadeacopassivo = elasticidadeacopassivo;
	}

	public Double getDiametroBarra() {
		return diametroBarra;
	}

	public void setDiametroBarra(Double diametroBarra) {
		this.diametroBarra = diametroBarra;
	}


	
	
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																					
	
}

