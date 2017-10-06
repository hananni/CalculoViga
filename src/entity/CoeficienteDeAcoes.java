package entity;

public class CoeficienteDeAcoes {
	
	
	public CoeficienteDeAcoes(Double cargaAcidental, Double vento, Double temperatura) {
		super();
		this.cargaAcidental = cargaAcidental;
		this.vento = vento;
		this.temperatura = temperatura;
	}
	
	private Double cargaAcidental;
	private Double vento;
	private Double temperatura;
	
	
	
	public Double getCargaAcidental() {
		return cargaAcidental;
	}
	public void setCargaAcidental(Double cargaAcidental) {
		this.cargaAcidental = cargaAcidental;
	}
	public Double getVento() {
		return vento;
	}
	public void setVento(Double vento) {
		this.vento = vento;
	}
	public Double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	
	

}
