package main;

import calculus.CalculosViga;
import calculus.Interpolacao;
import entity.AcoArmaduraAtiva;
import entity.Concreto;
import entity.DiametroBarraAtivo;
import entity.Viga;

public class main {

	public static void main(String[] args) {
		
		//Exemplo João Vitor
		Double area = null;
		
		Interpolacao interpolacao = new Interpolacao(area, area, area, area, area);
		Concreto c1 = new Concreto(null, null);
		Double valorAnterior = null;
		Double valorPosterior = null;
		Double valorPosterior2 = null;
		Double valor = null;
		Double valorAnterior2 = null;
		DiametroBarraAtivo dBA = new DiametroBarraAtivo(null, null, null, null);
		//
		Viga viga = new Viga(area, area, area, null, 
				interpolacao.interpolar(valorAnterior, valor, valorPosterior, valorAnterior2, valorPosterior2), 
				interpolacao.interpolar(valorAnterior, valor, valorPosterior, valorAnterior2, valorPosterior2), 
				interpolacao.interpolar(valorAnterior, valor, valorPosterior, valorAnterior2, valorPosterior2), 
				interpolacao.interpolar(valorAnterior, valor, valorPosterior, valorAnterior2, valorPosterior2));
		
//		DiametroBarraAtivo diametroBarraAtiva = new DiametroBarraAtivo(12.0, 13.0, 12.0, 13.0);
//		AcoArmaduraAtiva acoArmaduraAtiva = new AcoArmaduraAtiva(diametroBarraAtiva, 3, 12.0, 13.0, 12.0, 13.0, 12.0, 12.0);
//		
//		Viga viga = new Viga(12.0, 23.0, acoArmaduraAtiva);
		
//		viga.setArea(CalculosViga.calculoArea(viga.getBase(), viga.getAltura()));
//		viga.setyCInf(CalculosViga.calculoYC(viga.getAltura()));
//		viga.setyCsup(CalculosViga.calculoYC(viga.getAltura()));
//		viga.setInerciaX(CalculosViga.calculoInercia(viga.getBase(),viga.getAltura()));		
		
		dBA.setArea(area);
		c1.getPesoConcreto();
		c1.setPesoConcreto(25);
		System.out.println( 200 * Math.pow(10, 9));

	}

}
