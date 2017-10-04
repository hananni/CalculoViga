package entity;

public class AcoArmaduraPassiva {

	
	
	public AcoArmaduraPassiva(DiametroBarraPassivo diametroBarra, String categoria, Integer resistenciaEscoamento,
			Double limiteResistencia, Integer alongamentoAposRuptura, Double dMax) {
		super();
		this.diametroBarra = diametroBarra;
		this.categoria = categoria;
		this.resistenciaEscoamento = resistenciaEscoamento;
		this.limiteResistencia = limiteResistencia;
		this.alongamentoAposRuptura = alongamentoAposRuptura;
		
		//Calculando o Espaçamento Horizontal
		if ((diametroBarra.getDiametroBarra()*10) > 1.2*(dMax*10) && 2*(diametroBarra.getDiametroBarra()*10) > 2){
			this.espHorizontal = diametroBarra.getDiametroBarra()*10;
		}
		else if (1.2*(dMax*10) > 2*(diametroBarra.getDiametroBarra()*10) && 1.2*(dMax*10) > 2){
			this.espHorizontal = 1.2*(dMax*10);
		}
		else{
			this.espHorizontal = 2.0;
		}
		//Calculando o Espaçamento Vertical
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

	//VALORES FIXOS TABELA 7
	private DiametroBarraPassivo diametroBarra;
	
	private String categoria;
	
	private Integer resistenciaEscoamento;
	
	private Double limiteResistencia;
	
	private Integer alongamentoAposRuptura;
	
	//Espaçamento Horizontal
	private Double espHorizontal;
	//Espaçamento Vertical
	private Double espVertical;
	
	//Diâmetro da brita (à verificar)
	private Double dMax;

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

	public Integer getResistenciaEscoamento() {
		return resistenciaEscoamento;
	}

	public void setResistenciaEscoamento(Integer resistenciaEscoamento) {
		this.resistenciaEscoamento = resistenciaEscoamento;
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

	
	 
	
	
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																					
	
}

