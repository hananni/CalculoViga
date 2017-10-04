package entity;

public class DiametroBarraPassivo {

	public DiametroBarraPassivo(Double diametroBarra, Double massaNominal, Double areaSecao, Double perimetro) {
		super();
		this.diametroBarra = diametroBarra;
		this.massaNominal = massaNominal;
		this.areaSecao = areaSecao;
		this.perimetro = perimetro;
	}
	
	private Double diametroBarra;
	private Double massaNominal;
	private Double areaSecao;
	private Double perimetro;
	
	public Double getDiametroBarra() {
		return diametroBarra;
	}
	public void setDiametroBarra(Double diametroBarra) {
		this.diametroBarra = diametroBarra;
	}
	public Double getMassaNominal() {
		return massaNominal;
	}
	public void setMassaNominal(Double massaNominal) {
		this.massaNominal = massaNominal;
	}
	public Double getAreaSecao() {
		return areaSecao;
	}
	public void setAreaSecao(Double areaSecao) {
		this.areaSecao = areaSecao;
	}
	public Double getPerimetro() {
		return perimetro;
	}
	public void setPerimetro(Double perimetro) {
		this.perimetro = perimetro;
	}
	
	
}
