package entity;

public class AcoArmaduraPassiva {

	
	
	public AcoArmaduraPassiva( DiametroBarraPassivo diametroBarra, String categoria, Integer fyk,
			Double limiteResistencia, Integer alongamentoAposRuptura, Double a, Double dMax) {
		super();
		this.diametroBarra = diametroBarra;
		this.categoria = categoria;
		this.fyk = fyk;
		this.limiteResistencia = limiteResistencia;
		this.alongamentoAposRuptura = alongamentoAposRuptura;
		this.area = a;
		this.elasticidadeacopassivo = 210 * Math.pow(10, 3); //verificar unidade
		
		//Calculando o Espa�amento Horizontal
		if ((diametroBarra.getDiametroBarra()*10) > 1.2*(dMax*10) && 2*(diametroBarra.getDiametroBarra()*10) > 2){
			this.espHorizontal = diametroBarra.getDiametroBarra()*10;
		}
		else if (1.2*(dMax*10) > 2*(diametroBarra.getDiametroBarra()*10) && 1.2*(dMax*10) > 2){
			this.espHorizontal = 1.2*(dMax*10);
		}
		else{
			this.espHorizontal = 2.0;
		}
		
		//Calculando o Espa�amento Vertical
		if ((diametroBarra.getDiametroBarra()*10) > 0.5*(dMax*10) && 2*(diametroBarra.getDiametroBarra()*10) > 2){
			this.espVertical = diametroBarra.getDiametroBarra()*10;
		}
		else if (0.5*(dMax*10) > 2*(diametroBarra.getDiametroBarra()*10) && 0.5*(dMax*10) > 2){
			this.espVertical = 0.5*(dMax*10);
		}
		else{
			this.espVertical = 2.0;
		}
		
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

	//VALORES FIXOS TABELA 7
	private DiametroBarraPassivo diametroBarra;
	
	private String categoria;
	
	private Integer fyk;
	
	private Double limiteResistencia;
	
	private Integer alongamentoAposRuptura;
	

	
	private Double area;
	//Espa�amento Horizontal
	private Double espHorizontal;
	//Espa�amento Vertical
	private Double espVertical;
	
	//Di�metro da brita (� verificar)
	private Double dMax;
	
	//Modulo elasticidade
	private Double elasticidadeacopassivo;
	

	public DiametroBarraPassivo getDiametroBarra() {
		return diametroBarra;
	}

	public void setDiametroBarra(DiametroBarraPassivo diametroBarra) {
		this.diametroBarra = diametroBarra;
	}

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


	
	 
	
	
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																					
	
}

