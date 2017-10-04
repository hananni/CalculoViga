package entity;

public class DiametroBarraAtivo {
	
	
	public DiametroBarraAtivo(Double barras, Double nominal, Double area, Double perimetro) {
		super();
		this.barras = barras;
		this.nominal = nominal;
		this.area = area;
		this.perimetro = perimetro;
	}

	private Double barras;
	
	private Double nominal;
	
	private Double area;
	
	private Double perimetro;
	
	
	public Double getBarras() {
		return barras;
	}

	public void setBarras(Double barras) {
		this.barras = barras;
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

	public Double getPerimetro() {
		return perimetro;
	}

	public void setPerimetro(Double perimetro) {
		this.perimetro = perimetro;
	}
	
	
	
	
}
