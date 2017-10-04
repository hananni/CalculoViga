package calculus;

//Realiza interpolação de variáveis
public class Interpolacao {


	
	public Interpolacao(Double valorAnterior, Double valor, Double valorPosterior,
			Double valorAnterior2, Double valorPosterior2) {
		super();
		this.valorAnterior = valorAnterior;
		this.valor = valor;
		this.valorPosterior = valorPosterior;
		this.valorAnterior2 = valorAnterior2;
		this.valorPosterior2 = valorPosterior2;
		
		this.valor2 = (valor - valorAnterior)/(valorPosterior-valorAnterior)*((valorPosterior2 - valorAnterior2)+(valorAnterior2));
		
	}
	
	Double valorAnterior;
	Double valor;
	Double valorPosterior;
	
	Double valorAnterior2;
	Double valor2;
	Double valorPosterior2;
	
	
	public Double getValorAnterior() {
		return valorAnterior;
	}
	public void setValorAnterior(Double valorAnterior) {
		this.valorAnterior = valorAnterior;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Double getValorPosterior() {
		return valorPosterior;
	}
	public void setValorPosterior(Double valorPosterior) {
		this.valorPosterior = valorPosterior;
	}
	public Double getValorAnterior2() {
		return valorAnterior2;
	}
	public void setValorAnterior2(Double valorAnterior2) {
		this.valorAnterior2 = valorAnterior2;
	}
	public Double getValor2() {
		return valor2;
	}
	public void setValor2(Double valor2) {
		this.valor2 = valor2;
	}
	public Double getValorPosterior2() {
		return valorPosterior2;
	}
	public void setValorPosterior2(Double valorPosterior2) {
		this.valorPosterior2 = valorPosterior2;
	}

	public Double interpolar(Double valorAnterior, Double valor, Double valorPosterior,
			Double valorAnterior2, Double valorPosterior2)
	{
		Double valor2 = this.valor2;
		valor2 = (valor - valorAnterior)/(valorPosterior-valorAnterior)*((valorPosterior2 - valorAnterior2)+(valorAnterior2));
		return valor2;
	}
}
