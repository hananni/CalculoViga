package main;

import calculus.CalculosViga;
import calculus.Interpolacao;
import calculus.Verificacoes;
import entity.AcoArmaduraAtiva;
import entity.AcoArmaduraPassiva;
import entity.CombinacaoAcoes;
import entity.Concreto;
import entity.DiametroBarraAtivo;
import entity.DiametroBarraPassivo;
import entity.Viga;

public class main {

	public static void main(String[] args) {
		
		Viga viga;
		AcoArmaduraAtiva acoArmaduraAtiva = null;
		AcoArmaduraPassiva acoArmaduraPassiva = null;
		DiametroBarraAtivo diametroBarraAtivo = null;
		DiametroBarraPassivo diametroBarraPassivo = null;
		Concreto concreto = null;
		
		//Construtores da viga
		Double i = null, j = null, k = null, gamaS = null, betaX = null, betaZ = null, epsilonCD = null, deltaEpsilonPD = null,
				tensaoAcoAtivo = null, tensaoAcoPassivo = null, gamaFicticio = null, gamaEndurecimento = null,
				umidade = null, beta1Infinito = null, fcT0 = null, fcTInfinito = null, betaF0 = null, 
				mPermanentes = null, mAcidentais = null;
		Integer hipotese = null;
		
		//Construtores da armadura ativa
		Double nominal = null, pondPretacao = null, areaArmaduraAtiva = null, massa = null, fptk = null,
				fpyk = null, relaxacao = null, dMaxAtivo = null;
		Integer quantidadeCordoalhas = null, numerosFrios = null;
		
		//Construtores da armadura passiva
		Double limiteResistencia = null, a = null, dMaxPassivo = null;
		Integer fyk = null, alongamentoAposRuptura = null;
		String categoria = "";
		
		//Construtores do diametro barra ativo
		Double barras = null, nominalDiametroBarraAtivo = null, areaDiametroBarraAtivo = null,
				perimetroDiametroBarraAtivo = null;
		
		//Construtores do diametro barra passivo
		Double diametroBarra = null, massaNominal = null, areaSecao = null, perimetroDiametroBarraPassivo = null;
		
		//Construtores do concreto
		Double classeCobrimentoNominal = null, fck = null, classeconcreto = null;
		
		//Inicio Frontend
		
		//Fim Frontend
		
		// Inicializando classes
		viga = new Viga(i, j, k, hipotese, gamaS, acoArmaduraAtiva, acoArmaduraPassiva, betaX, betaZ,
				epsilonCD, deltaEpsilonPD, tensaoAcoAtivo, tensaoAcoPassivo, gamaFicticio,  gamaEndurecimento, umidade,
				beta1Infinito, fcT0, fcTInfinito, betaF0, mPermanentes, mAcidentais);
		
		acoArmaduraAtiva = new AcoArmaduraAtiva(diametroBarraAtivo, numerosFrios, nominal, areaArmaduraAtiva,
				massa, fptk, fpyk, relaxacao, null, dMaxAtivo,
				 pondPretacao, quantidadeCordoalhas);

		acoArmaduraPassiva = new AcoArmaduraPassiva(diametroBarraPassivo, categoria, fyk, limiteResistencia, 
				alongamentoAposRuptura, a, dMaxPassivo);
		
		diametroBarraAtivo = new DiametroBarraAtivo(barras, nominalDiametroBarraAtivo,
				areaDiametroBarraAtivo, perimetroDiametroBarraAtivo);
		
		diametroBarraPassivo = new DiametroBarraPassivo(diametroBarra, massaNominal, areaSecao, perimetroDiametroBarraPassivo);

		concreto = new Concreto(viga, classeCobrimentoNominal, fck, classeconcreto);
		
		Verificacoes ver = new Verificacoes();
		
		if (ver.condicaoUm(viga)== true && ver.condicaoDois(viga)== true && ver.condicaoTres(viga)== true && ver.condicaoQuarta(viga)== true)
		{
			
		}
		
		/*		
		Interpolacao interpolacao = new Interpolacao(area, area, area, area, area);
		Double valorAnterior = null;
		Double valorPosterior = null;
		Double valorPosterior2 = null;
		Double valor = null;
		Double valorAnterior2 = null;
		DiametroBarraAtivo dBA = new DiametroBarraAtivo(null, null, null, null);
		Viga viga = new Viga(valorAnterior2, valorAnterior2, valorAnterior2, null,
				valorAnterior2, null, null, valorAnterior2, valorAnterior2, valorAnterior2, 
				valorAnterior2, valorAnterior2, valorAnterior2, valorAnterior2, valorAnterior2,
				valorAnterior2, valorAnterior2, valorAnterior2, valorAnterior2, valorAnterior2,
				valorAnterior2, valorAnterior2);
		
*/		
//		DiametroBarraAtivo diametroBarraAtiva = new DiametroBarraAtivo(12.0, 13.0, 12.0, 13.0);
//		AcoArmaduraAtiva acoArmaduraAtiva = new AcoArmaduraAtiva(diametroBarraAtiva, 3, 12.0, 13.0, 12.0, 13.0, 12.0, 12.0);
//		
//		Viga viga = new Viga(12.0, 23.0, acoArmaduraAtiva);
		
//		viga.setArea(CalculosViga.calculoArea(viga.getBase(), viga.getAltura()));
//		viga.setyCInf(CalculosViga.calculoYC(viga.getAltura()));
//		viga.setyCsup(CalculosViga.calculoYC(viga.getAltura()));
//		viga.setInerciaX(CalculosViga.calculoInercia(viga.getBase(),viga.getAltura()));		
		/*
		dBA.setArea(area);
		c1.getPesoConcreto();
		c1.setPesoConcreto(25);
		System.out.println( 200 * Math.pow(10, 9));
		*/

	}

}
