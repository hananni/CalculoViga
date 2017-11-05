package main;

import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import entity.Viga;
import javax.swing.JTable;

public class Resultados {

	private JFrame frame;
	private JTextField textFieldArea;
	private JTextField textFieldYCinf;
	private JTextField textFieldYCSup;
	private JTextField textFieldIcx;
	private JTextField textFieldWCInf;
	private JTextField textFieldWCSup;
	private JTextField textFieldKcInf;
	private JTextField textFieldKcSup;
	private JTextField textFieldDiametro;
	private JTextField textFieldArea_1;
	private JTextField textFieldMsd;
	private JTextField textFieldmGI;
	private JTextField textFieldMgiG1;
	private JTextField textFieldOpi;
	private JTextField textFieldNp0;
	private JTextField textFieldpreAlongamento;
	private JTextField textFieldY0;
	private JTextField textFieldDP;
	private JTextField textFieldK6;
	private JTextField textFieldBetaX;
	private JTextField textFieldBetaZ;
	private JTextField textFieldEcd;
	private JTextField textFieldDeltaEPd;
	private JTextField textFieldEpd;
	private JTextField textFieldRelaxacaoMilHoras;
	private JTextField textFieldtensaoProtensao;
	private JTextField textFieldperdaProtensaoRelaxacao;
	private JTextField textFieldhFicticio;
	private JTextField textFieldidadeFicticiaConcreto;
	private JTextField textFieldepsilon1S;
	private JTextField textFieldepsilon2S;
	private JTextField textFieldbeta1Infinito;
	private JTextField textFieldepsilonCS;
	private JTextField textFieldtensaoRetracaoInicial;
	private JTextField textFieldforcaRetracaoInicial;
	private JTextField textFieldforcaFinal1;
	private JTextField textFieldeLinhaP;
	private JTextField textFieldeCI;
	private JTextField textFielddeltaPP;
	private JTextField textFieldencurtamentoImediato;
	private JTextField textFieldporcentagemFinal2;
	private JTextField textFieldespMin;
	private JTextField textFieldespMin2;
	private JTextField textFielddiametroBarra;
	private JTextField textFieldarea;
	private JTextField textFieldespVertical;
	private JTextField textFieldespHorizontal;
	private JTextField textFieldcategoria;
	private JTextField textFieldtensaoAcoAtivo;
	private JTextField textFieldforcaTracao;
	private JTextField textFieldmCF;
	private JTextField textFieldmCQP;
	private JTextField textFieldnpinfinito;
	private JTextField textFieldfctkf;
	private JTextField textFieldtensaoFibraInferiorCF;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public Resultados(Viga viga) {
		initialize(viga);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Viga viga) {
		frame = new JFrame();
		frame.setBounds(100, 100, 796, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		DecimalFormat decimal = new DecimalFormat("0.00000");
		DecimalFormat decimal7Casas = new DecimalFormat("0.0000000");
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 780, 291);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Viga", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblrea = new JLabel("\u00C1rea:");
		lblrea.setBounds(10, 11, 38, 14);
		panel.add(lblrea);
		
		textFieldArea = new JTextField();
		textFieldArea.setBounds(58, 8, 86, 20);
		panel.add(textFieldArea);
		textFieldArea.setColumns(10);
		textFieldArea.setText(decimal.format(viga.getArea()).toString());
		textFieldArea.setEditable(false);
		
		JLabel lblYcinf = new JLabel("yCinf: ");
		lblYcinf.setBounds(10, 40, 46, 14);
		panel.add(lblYcinf);
		
		textFieldYCinf = new JTextField();
		textFieldYCinf.setBounds(58, 37, 86, 20);
		panel.add(textFieldYCinf);
		textFieldYCinf.setColumns(10);
		textFieldYCinf.setText(decimal.format(viga.getyCInf()).toString());
		textFieldYCinf.setEditable(false);
		
		JLabel lblYcsup = new JLabel("yCSup:");
		lblYcsup.setBounds(10, 73, 46, 14);
		panel.add(lblYcsup);
		
		textFieldYCSup = new JTextField();
		textFieldYCSup.setBounds(58, 70, 86, 20);
		panel.add(textFieldYCSup);
		textFieldYCSup.setColumns(10);
		textFieldYCSup.setText(decimal.format(viga.getyCsup()).toString());
		textFieldYCSup.setEditable(false);
		
		JLabel lblIcx = new JLabel("Icx:");
		lblIcx.setBounds(10, 104, 46, 14);
		panel.add(lblIcx);
		
		textFieldIcx = new JTextField();
		textFieldIcx.setBounds(58, 101, 86, 20);
		panel.add(textFieldIcx);
		textFieldIcx.setColumns(10);
		textFieldIcx.setText(decimal.format(viga.getInerciaX()).toString());
		textFieldIcx.setEditable(false);
		
		JLabel lblWcinf = new JLabel("Wc,inf:");
		lblWcinf.setBounds(10, 133, 46, 14);
		panel.add(lblWcinf);
		
		textFieldWCInf = new JTextField();
		textFieldWCInf.setBounds(58, 130, 86, 20);
		panel.add(textFieldWCInf);
		textFieldWCInf.setColumns(10);
		textFieldWCInf.setText(decimal.format(viga.getwCInf()).toString());
		textFieldWCInf.setEditable(false);
		
		JLabel label = new JLabel("Wc,sup: ");
		label.setBounds(10, 167, 46, 14);
		panel.add(label);
		
		textFieldWCSup = new JTextField();
		textFieldWCSup.setBounds(58, 164, 86, 20);
		panel.add(textFieldWCSup);
		textFieldWCSup.setColumns(10);
		textFieldWCSup.setText(decimal.format(viga.getwCSup()).toString());
		textFieldWCSup.setEditable(false);
		
		JLabel lblKcinf = new JLabel("Kc,inf:");
		lblKcinf.setBounds(10, 198, 46, 14);
		panel.add(lblKcinf);
		
		textFieldKcInf = new JTextField();
		textFieldKcInf.setBounds(58, 195, 86, 20);
		panel.add(textFieldKcInf);
		textFieldKcInf.setColumns(10);
		textFieldKcInf.setText(decimal.format(viga.getRaioCInf()).toString());
		textFieldKcInf.setEditable(false);
		
		JLabel lblKcsup = new JLabel("Kc,sup:");
		lblKcsup.setBounds(10, 227, 46, 14);
		panel.add(lblKcsup);
		
		textFieldKcSup = new JTextField();
		textFieldKcSup.setBounds(58, 226, 86, 20);
		panel.add(textFieldKcSup);
		textFieldKcSup.setColumns(10);
		textFieldKcSup.setText(decimal.format(viga.getRaioCSup()).toString());
		textFieldKcSup.setEditable(false);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Processo k6", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblY = new JLabel("y0:");
		lblY.setBounds(10, 11, 46, 14);
		panel_3.add(lblY);
		
		textFieldY0 = new JTextField();
		textFieldY0.setBounds(57, 8, 86, 20);
		panel_3.add(textFieldY0);
		textFieldY0.setColumns(10);
		textFieldY0.setText(decimal.format(viga.getY0()).toString());
		textFieldY0.setEditable(false);
		
		JLabel lblDp = new JLabel("dP:");
		lblDp.setBounds(10, 39, 46, 14);
		panel_3.add(lblDp);
		
		textFieldDP = new JTextField();
		textFieldDP.setBounds(57, 36, 86, 20);
		panel_3.add(textFieldDP);
		textFieldDP.setColumns(10);
		textFieldDP.setText(decimal.format(viga.getdP()).toString());
		textFieldDP.setEditable(false);
		
		JLabel lblK = new JLabel("K6:");
		lblK.setBounds(10, 67, 46, 14);
		panel_3.add(lblK);
		
		textFieldK6 = new JTextField();
		textFieldK6.setBounds(57, 64, 86, 20);
		panel_3.add(textFieldK6);
		textFieldK6.setColumns(10);
		textFieldK6.setEditable(false);
		textFieldK6.setText(decimal.format(viga.getK6()).toString());
		
		JLabel lblx = new JLabel("\u03B2x:");
		lblx.setBounds(10, 95, 46, 14);
		panel_3.add(lblx);
		
		textFieldBetaX = new JTextField();
		textFieldBetaX.setBounds(57, 92, 86, 20);
		panel_3.add(textFieldBetaX);
		textFieldBetaX.setColumns(10);
		textFieldBetaX.setText(decimal.format(viga.getBetaX()).toString());
		textFieldBetaX.setEditable(false);
		
		JLabel lblz = new JLabel("\u03B2z:");
		lblz.setBounds(10, 124, 46, 14);
		panel_3.add(lblz);
		
		textFieldBetaZ = new JTextField();
		textFieldBetaZ.setBounds(57, 121, 86, 20);
		panel_3.add(textFieldBetaZ);
		textFieldBetaZ.setColumns(10);
		textFieldBetaZ.setText(decimal.format(viga.getBetaZ()).toString());
		textFieldBetaZ.setEditable(false);
		
		JLabel lblcd = new JLabel("\u03B5cd:");
		lblcd.setBounds(10, 152, 46, 14);
		panel_3.add(lblcd);
		
		textFieldEcd = new JTextField();
		textFieldEcd.setBounds(57, 149, 86, 20);
		panel_3.add(textFieldEcd);
		textFieldEcd.setColumns(10);
		textFieldEcd.setText(decimal.format(viga.getEpsilonCD()).toString());
		textFieldEcd.setEditable(false);
		
		JLabel lblpd = new JLabel("\u2206\u03B5pd:");
		lblpd.setBounds(10, 183, 46, 14);
		panel_3.add(lblpd);
		
		textFieldDeltaEPd = new JTextField();
		textFieldDeltaEPd.setBounds(57, 180, 86, 20);
		panel_3.add(textFieldDeltaEPd);
		textFieldDeltaEPd.setColumns(10);
		textFieldDeltaEPd.setText(decimal.format(viga.getDefEpsilonPD()).toString());
		textFieldDeltaEPd.setEditable(false);
		
		JLabel lblpd_1 = new JLabel("\u03B5pd:");
		lblpd_1.setBounds(10, 211, 46, 14);
		panel_3.add(lblpd_1);
		
		textFieldEpd = new JTextField();
		textFieldEpd.setBounds(57, 208, 86, 20);
		panel_3.add(textFieldEpd);
		textFieldEpd.setColumns(10);
		textFieldEpd.setText(decimal.format(viga.getEpsilonPD()).toString());
		textFieldEpd.setEditable(false);
		
		JLabel lblpd_2 = new JLabel("\u03C3pd:");
		lblpd_2.setBounds(10, 236, 46, 14);
		panel_3.add(lblpd_2);
		
		textFieldtensaoAcoAtivo = new JTextField();
		textFieldtensaoAcoAtivo.setBounds(57, 233, 86, 20);
		panel_3.add(textFieldtensaoAcoAtivo);
		textFieldtensaoAcoAtivo.setColumns(10);
		textFieldtensaoAcoAtivo.setText(decimal.format(viga.getTensaoAcoAtivo()).toString());
		textFieldtensaoAcoAtivo.setEditable(false);
		
		JLabel lblNtd = new JLabel("Ntd:");
		lblNtd.setBounds(223, 11, 46, 14);
		panel_3.add(lblNtd);
		
		textFieldforcaTracao = new JTextField();
		textFieldforcaTracao.setBounds(272, 8, 86, 20);
		panel_3.add(textFieldforcaTracao);
		textFieldforcaTracao.setColumns(10);
		textFieldforcaTracao.setText(decimal.format(viga.getForcaTracao()).toString());
		textFieldforcaTracao.setEditable(false);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Perdas Iniciais", null, panel_4, null);
		panel_4.setLayout(null);
		
		textFieldRelaxacaoMilHoras = new JTextField();
		textFieldRelaxacaoMilHoras.setBounds(83, 39, 86, 20);
		panel_4.add(textFieldRelaxacaoMilHoras);
		textFieldRelaxacaoMilHoras.setColumns(10);
		textFieldRelaxacaoMilHoras.setText(decimal.format(viga.getRelaxacaoMilHoras2()).toString());
		textFieldRelaxacaoMilHoras.setEditable(false);
		
		JLabel lbltto = new JLabel("\u03A8(t,to)");
		lbltto.setBounds(10, 42, 46, 14);
		panel_4.add(lbltto);
		
		JLabel lblp = new JLabel("\u03C3P0:");
		lblp.setBounds(10, 11, 46, 14);
		panel_4.add(lblp);
		
		textFieldtensaoProtensao = new JTextField();
		textFieldtensaoProtensao.setBounds(83, 8, 86, 20);
		panel_4.add(textFieldtensaoProtensao);
		textFieldtensaoProtensao.setColumns(10);
		textFieldtensaoProtensao.setText(decimal.format(viga.getTensaoProtensao()).toString());
		textFieldtensaoProtensao.setEditable(false);
		
		JLabel lblpprx = new JLabel("\u2206Ppr,0(x):");
		lblpprx.setBounds(10, 74, 63, 14);
		panel_4.add(lblpprx);
		
		textFieldperdaProtensaoRelaxacao = new JTextField();
		textFieldperdaProtensaoRelaxacao.setBounds(83, 70, 86, 20);
		panel_4.add(textFieldperdaProtensaoRelaxacao);
		textFieldperdaProtensaoRelaxacao.setColumns(10);
		textFieldperdaProtensaoRelaxacao.setText(decimal.format(viga.getPerdaProtensaoRelaxacao()).toString());
		textFieldperdaProtensaoRelaxacao.setEditable(false);
		
		textFieldhFicticio = new JTextField();
		textFieldhFicticio.setBounds(83, 99, 86, 20);
		panel_4.add(textFieldhFicticio);
		textFieldhFicticio.setColumns(10);
		textFieldhFicticio.setText(decimal.format(viga.gethFicticio()).toString());
		textFieldhFicticio.setEditable(false);
		
		JLabel lblHfic = new JLabel("hfic:");
		lblHfic.setBounds(10, 102, 46, 14);
		panel_4.add(lblHfic);
		
		JLabel lblT = new JLabel("t:");
		lblT.setBounds(10, 133, 46, 14);
		panel_4.add(lblT);
		
		textFieldidadeFicticiaConcreto = new JTextField();
		textFieldidadeFicticiaConcreto.setBounds(83, 130, 86, 20);
		panel_4.add(textFieldidadeFicticiaConcreto);
		textFieldidadeFicticiaConcreto.setColumns(10);
		textFieldidadeFicticiaConcreto.setText(decimal.format(viga.getIdadeFicticiaConcreto()).toString());
		textFieldidadeFicticiaConcreto.setEditable(false);
		
		JLabel lbls = new JLabel("\u03B51s:");
		lbls.setBounds(10, 163, 46, 14);
		panel_4.add(lbls);
		
		textFieldepsilon1S = new JTextField();
		textFieldepsilon1S.setBounds(83, 160, 86, 20);
		panel_4.add(textFieldepsilon1S);
		textFieldepsilon1S.setColumns(10);
		textFieldepsilon1S.setText(decimal.format(viga.getEpsilon1S()).toString());
		textFieldepsilon1S.setEditable(false);
		
		JLabel lbls_1 = new JLabel("\u03B52s:");
		lbls_1.setBounds(10, 188, 46, 14);
		panel_4.add(lbls_1);
		
		textFieldepsilon2S = new JTextField();
		textFieldepsilon2S.setBounds(83, 185, 86, 20);
		panel_4.add(textFieldepsilon2S);
		textFieldepsilon2S.setColumns(10);
		textFieldepsilon2S.setText(decimal.format(viga.getEpsilon2S()).toString());
		textFieldepsilon2S.setEditable(false);
		
		JLabel lblAst = new JLabel("\t\u03B2s(t0):");
		lblAst.setBounds(10, 214, 46, 14);
		panel_4.add(lblAst);
		
		textFieldbeta1Infinito = new JTextField();
		textFieldbeta1Infinito.setBounds(83, 211, 86, 20);
		panel_4.add(textFieldbeta1Infinito);
		textFieldbeta1Infinito.setColumns(10);
		textFieldbeta1Infinito.setText(decimal.format(viga.getBeta1Infinito()).toString());
		textFieldbeta1Infinito.setEditable(false);
		
		JLabel lblcst = new JLabel("\u03B5cs(\u221Et0):");
		lblcst.setBounds(10, 239, 57, 14);
		panel_4.add(lblcst);
		
		textFieldepsilonCS = new JTextField();
		textFieldepsilonCS.setBounds(83, 236, 86, 20);
		panel_4.add(textFieldepsilonCS);
		textFieldepsilonCS.setColumns(10);
		textFieldepsilonCS.setText(decimal.format(viga.getEpsilonCS()).toString());
		textFieldepsilonCS.setEditable(false);
		
		JLabel lblpst = new JLabel("\u2206\u03C3ps(\u221E,t0):");
		lblpst.setBounds(244, 11, 63, 14);
		panel_4.add(lblpst);
		
		textFieldtensaoRetracaoInicial = new JTextField();
		textFieldtensaoRetracaoInicial.setBounds(322, 8, 86, 20);
		panel_4.add(textFieldtensaoRetracaoInicial);
		textFieldtensaoRetracaoInicial.setColumns(10);
		textFieldtensaoRetracaoInicial.setText(decimal.format(viga.getTensaoRetracaoInicial()).toString());
		textFieldtensaoRetracaoInicial.setEditable(false);
		
		JLabel lblppsx = new JLabel("\u2206Pps,0x:");
		lblppsx.setBounds(244, 42, 46, 14);
		panel_4.add(lblppsx);
		
		textFieldforcaRetracaoInicial = new JTextField();
		textFieldforcaRetracaoInicial.setBounds(322, 39, 86, 20);
		panel_4.add(textFieldforcaRetracaoInicial);
		textFieldforcaRetracaoInicial.setColumns(10);
		textFieldforcaRetracaoInicial.setText(decimal.format(viga.getForcaRetracaoInicial()).toString());
		textFieldforcaRetracaoInicial.setEditable(false);
		
		JLabel lblPx = new JLabel("P0(x):");
		lblPx.setBounds(244, 73, 46, 14);
		panel_4.add(lblPx);
		
		textFieldforcaFinal1 = new JTextField();
		textFieldforcaFinal1.setBounds(322, 68, 86, 20);
		panel_4.add(textFieldforcaFinal1);
		textFieldforcaFinal1.setColumns(10);
		textFieldforcaFinal1.setText(decimal.format(viga.getPorcentagemForçaFinal1()).toString() + "%");
		textFieldforcaFinal1.setEditable(false);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Perdas Imediatas", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblEp_1 = new JLabel("e'p:");
		lblEp_1.setBounds(10, 11, 46, 14);
		panel_5.add(lblEp_1);
		
		textFieldeLinhaP = new JTextField();
		textFieldeLinhaP.setBounds(55, 8, 86, 20);
		panel_5.add(textFieldeLinhaP);
		textFieldeLinhaP.setColumns(10);
		textFieldeLinhaP.setText(decimal.format(viga.geteLinhaP()).toString());
		textFieldeLinhaP.setEditable(false);
		
		JLabel lblEci = new JLabel("Eci:");
		lblEci.setBounds(10, 35, 46, 14);
		panel_5.add(lblEci);
		
		textFieldeCI = new JTextField();
		textFieldeCI.setBounds(55, 32, 86, 20);
		panel_5.add(textFieldeCI);
		textFieldeCI.setColumns(10);
		textFieldeCI.setText(decimal.format(viga.geteCI()).toString());
		textFieldeCI.setEditable(false);
		
		JLabel lblppx = new JLabel("\u2206Pp(x):");
		lblppx.setBounds(10, 96, 46, 14);
		panel_5.add(lblppx);
		
		textFielddeltaPP = new JTextField();
		textFielddeltaPP.setBounds(55, 93, 86, 20);
		panel_5.add(textFielddeltaPP);
		textFielddeltaPP.setColumns(10);
		textFielddeltaPP.setText(decimal.format(viga.getDeltaPP()).toString());
		textFielddeltaPP.setEditable(false);
		
		JLabel lblp_1 = new JLabel("\u0394\u03B6p:");
		lblp_1.setBounds(10, 60, 46, 14);
		panel_5.add(lblp_1);
		
		textFieldencurtamentoImediato = new JTextField();
		textFieldencurtamentoImediato.setBounds(55, 60, 86, 20);
		panel_5.add(textFieldencurtamentoImediato);
		textFieldencurtamentoImediato.setColumns(10);
		textFieldencurtamentoImediato.setText(decimal.format(viga.getEncurtamentoImediato()).toString());
		textFieldencurtamentoImediato.setEditable(false);
		
		JLabel lblPx_1 = new JLabel("P0(x):");
		lblPx_1.setBounds(10, 126, 46, 14);
		panel_5.add(lblPx_1);
		
		textFieldporcentagemFinal2 = new JTextField();
		textFieldporcentagemFinal2.setBounds(55, 123, 86, 20);
		panel_5.add(textFieldporcentagemFinal2);
		textFieldporcentagemFinal2.setColumns(10);
		textFieldporcentagemFinal2.setText(decimal.format(viga.getPorcentagemForçaFinal2()).toString() + "%");
		textFieldporcentagemFinal2.setEditable(false);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Perdas Progressivas", null, panel_6, null);
		panel_6.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Aço Ativo", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblDimetro = new JLabel("Di\u00E2metro:");
		lblDimetro.setBounds(10, 11, 57, 14);
		panel_1.add(lblDimetro);
		
		textFieldDiametro = new JTextField();
		textFieldDiametro.setBounds(77, 8, 86, 20);
		panel_1.add(textFieldDiametro);
		textFieldDiametro.setColumns(10);
		textFieldDiametro.setText(decimal.format(viga.getAcoArmaduraAtiva().getNominal()).toString());
		textFieldDiametro.setEditable(false);
		
		JLabel lblrea_1 = new JLabel("\u00C1rea:");
		lblrea_1.setBounds(10, 41, 46, 14);
		panel_1.add(lblrea_1);
		
		textFieldArea_1 = new JTextField();
		textFieldArea_1.setBounds(77, 38, 86, 20);
		panel_1.add(textFieldArea_1);
		textFieldArea_1.setColumns(10);
		textFieldArea_1.setText(decimal7Casas.format(viga.getAcoArmaduraAtiva().getArea()).toString());
		textFieldArea_1.setEditable(false);
		
		JLabel lblpi = new JLabel("\u03C3pi:");
		lblpi.setBounds(262, 11, 46, 14);
		panel_1.add(lblpi);
		
		textFieldOpi = new JTextField();
		textFieldOpi.setBounds(320, 8, 86, 20);
		panel_1.add(textFieldOpi);
		textFieldOpi.setColumns(10);
		Double tensao;
		if(viga.getAcoArmaduraAtiva().getTensaoFptk() < viga.getAcoArmaduraAtiva().getTensaoFpyk()){
			tensao = viga.getAcoArmaduraAtiva().getTensaoFptk();
		} else {
			tensao = viga.getAcoArmaduraAtiva().getTensaoFpyk();
		}
		textFieldOpi.setText(decimal.format(tensao).toString());
		textFieldOpi.setEditable(false);
		
		JLabel lblNp = new JLabel("Np0:");
		lblNp.setBounds(262, 41, 46, 14);
		panel_1.add(lblNp);
		
		textFieldNp0 = new JTextField();
		textFieldNp0.setBounds(320, 38, 86, 20);
		panel_1.add(textFieldNp0);
		textFieldNp0.setColumns(10);
		textFieldNp0.setText(decimal.format(viga.getAcoArmaduraAtiva().getNp0()).toString());
		textFieldNp0.setEditable(false);
		
		JLabel lblpi_1 = new JLabel("\u2206\u03B5pi:");
		lblpi_1.setBounds(262, 76, 46, 14);
		panel_1.add(lblpi_1);
		
		textFieldpreAlongamento = new JTextField();
		textFieldpreAlongamento.setBounds(320, 73, 86, 20);
		panel_1.add(textFieldpreAlongamento);
		textFieldpreAlongamento.setColumns(10);
		textFieldpreAlongamento.setText(decimal.format(viga.getAcoArmaduraAtiva().getPreAlongamento()).toString());
		textFieldpreAlongamento.setEditable(false);
		
		JLabel lblEspaamento = new JLabel("Espa\u00E7amento");
		lblEspaamento.setBounds(10, 66, 111, 29);
		panel_1.add(lblEspaamento);
		
		JLabel lblVertical = new JLabel("Vertical:");
		lblVertical.setBounds(10, 95, 46, 14);
		panel_1.add(lblVertical);
		
		JLabel lblHorizontal = new JLabel("Horizontal:");
		lblHorizontal.setBounds(10, 120, 57, 14);
		panel_1.add(lblHorizontal);
		
		textFieldespMin = new JTextField();
		textFieldespMin.setBounds(77, 92, 86, 20);
		panel_1.add(textFieldespMin);
		textFieldespMin.setColumns(10);
		textFieldespMin.setText(decimal.format(viga.getAcoArmaduraAtiva().getEspMin()).toString());
		textFieldespMin.setEditable(false);
		
		textFieldespMin2 = new JTextField();
		textFieldespMin2.setBounds(77, 117, 86, 20);
		panel_1.add(textFieldespMin2);
		textFieldespMin2.setColumns(10);
		textFieldespMin2.setText(decimal.format(viga.getAcoArmaduraAtiva().getEspMin()).toString());
		textFieldespMin2.setEditable(false);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Aço Passivo", null, panel_7, null);
		panel_7.setLayout(null);
		
		JLabel lblDimetro_1 = new JLabel("Di\u00E2metro:");
		lblDimetro_1.setBounds(10, 11, 80, 14);
		panel_7.add(lblDimetro_1);
		
		JLabel lblAs = new JLabel("As:");
		lblAs.setBounds(10, 36, 46, 14);
		panel_7.add(lblAs);
		
		textFielddiametroBarra = new JTextField();
		textFielddiametroBarra.setBounds(100, 8, 86, 20);
		panel_7.add(textFielddiametroBarra);
		textFielddiametroBarra.setColumns(10);
		textFielddiametroBarra.setText(decimal.format(viga.getAcoArmaduraPassiva().getDiametroBarra()).toString());
		textFielddiametroBarra.setEditable(false);
		
		textFieldarea = new JTextField();
		textFieldarea.setBounds(100, 33, 86, 20);
		panel_7.add(textFieldarea);
		textFieldarea.setColumns(10);
		textFieldarea.setText(decimal.format(viga.getAcoArmaduraPassiva().getArea()).toString());
		textFieldarea.setEditable(false);
		
		JLabel lblEspaamento_1 = new JLabel("Espa\u00E7amento:");
		lblEspaamento_1.setBounds(10, 66, 105, 14);
		panel_7.add(lblEspaamento_1);
		
		JLabel lblVertical_1 = new JLabel("Vertical:");
		lblVertical_1.setBounds(10, 88, 68, 14);
		panel_7.add(lblVertical_1);
		
		JLabel lblHorizontal_1 = new JLabel("Horizontal:");
		lblHorizontal_1.setBounds(10, 113, 80, 14);
		panel_7.add(lblHorizontal_1);
		
		textFieldespVertical = new JTextField();
		textFieldespVertical.setBounds(100, 85, 86, 20);
		panel_7.add(textFieldespVertical);
		textFieldespVertical.setColumns(10);
		textFieldespVertical.setText(decimal.format(viga.getAcoArmaduraPassiva().getEspVertical()).toString());
		textFieldespVertical.setEditable(false);
		
		textFieldespHorizontal = new JTextField();
		textFieldespHorizontal.setBounds(100, 110, 86, 20);
		panel_7.add(textFieldespHorizontal);
		textFieldespHorizontal.setColumns(10);
		textFieldespHorizontal.setText(decimal.format(viga.getAcoArmaduraPassiva().getEspHorizontal()).toString());
		textFieldespHorizontal.setEditable(false);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(253, 11, 80, 14);
		panel_7.add(lblCategoria);
		
		textFieldcategoria = new JTextField();
		textFieldcategoria.setBounds(356, 8, 86, 20);
		panel_7.add(textFieldcategoria);
		textFieldcategoria.setColumns(10);
		textFieldcategoria.setText(viga.getAcoArmaduraPassiva().getCategoria());
		textFieldcategoria.setEditable(false);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Ações", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblMsd = new JLabel("Msd:");
		lblMsd.setBounds(10, 11, 46, 14);
		panel_2.add(lblMsd);
		
		textFieldMsd = new JTextField();
		textFieldMsd.setBounds(69, 8, 86, 20);
		panel_2.add(textFieldMsd);
		textFieldMsd.setColumns(10);
		textFieldMsd.setText(decimal7Casas.format(viga.getmSD()).toString());
		textFieldMsd.setEditable(false);
		
		JLabel lblMgi = new JLabel("Mgi:");
		lblMgi.setBounds(10, 36, 46, 14);
		panel_2.add(lblMgi);
		
		textFieldmGI = new JTextField();
		textFieldmGI.setBounds(69, 33, 86, 20);
		panel_2.add(textFieldmGI);
		textFieldmGI.setColumns(10);
		textFieldmGI.setText(decimal7Casas.format(viga.getmGI()).toString());
		textFieldmGI.setEditable(false);
		
		JLabel lblMgig = new JLabel("Mgi -g1:");
		lblMgig.setBounds(10, 61, 46, 14);
		panel_2.add(lblMgig);
		
		textFieldMgiG1 = new JTextField();
		textFieldMgiG1.setBounds(69, 58, 86, 20);
		panel_2.add(textFieldMgiG1);
		textFieldMgiG1.setColumns(10);
		textFieldMgiG1.setText(decimal7Casas.format(viga.getmGiG1()).toString());
		textFieldMgiG1.setEditable(false);
		
		JPanel panel_8 = new JPanel();
		tabbedPane.addTab("ELS - Vigas", null, panel_8, null);
		panel_8.setLayout(null);
		
		JLabel lblMcf = new JLabel("MCF:");
		lblMcf.setBounds(10, 11, 46, 14);
		panel_8.add(lblMcf);
		
		JLabel lblMcqp = new JLabel("MCQP:");
		lblMcqp.setBounds(10, 36, 46, 14);
		panel_8.add(lblMcqp);
		
		textFieldmCF = new JTextField();
		textFieldmCF.setBounds(66, 8, 86, 20);
		panel_8.add(textFieldmCF);
		textFieldmCF.setColumns(10);
		textFieldmCF.setText(decimal.format(viga.getmCF()).toString());
		textFieldmCF.setEditable(false);
		
		textFieldmCQP = new JTextField();
		textFieldmCQP.setBounds(66, 36, 86, 20);
		panel_8.add(textFieldmCQP);
		textFieldmCQP.setColumns(10);
		textFieldmCQP.setText(decimal.format(viga.getmCQP()).toString());
		textFieldmCQP.setEditable(false);
		
		JLabel lblNp_1 = new JLabel("NP\u221E:");
		lblNp_1.setBounds(10, 70, 46, 14);
		panel_8.add(lblNp_1);
		
		textFieldnpinfinito = new JTextField();
		textFieldnpinfinito.setBounds(66, 67, 86, 20);
		panel_8.add(textFieldnpinfinito);
		textFieldnpinfinito.setColumns(10);
		textFieldnpinfinito.setText(decimal.format(viga.getNpinfinito()).toString());
		textFieldnpinfinito.setEditable(false);
		
		JLabel lblFctkf = new JLabel("fctk,f:");
		lblFctkf.setBounds(10, 105, 46, 14);
		panel_8.add(lblFctkf);
		
		textFieldfctkf = new JTextField();
		textFieldfctkf.setBounds(66, 102, 86, 20);
		panel_8.add(textFieldfctkf);
		textFieldfctkf.setColumns(10);
		textFieldfctkf.setText(decimal.format(viga.getFctkf()).toString());
		textFieldfctkf.setEditable(false);
		
		JLabel lblcinf = new JLabel("\u03C3c,inf:");
		lblcinf.setBounds(10, 130, 46, 14);
		panel_8.add(lblcinf);
		
		textFieldtensaoFibraInferiorCF = new JTextField();
		textFieldtensaoFibraInferiorCF.setBounds(66, 127, 86, 20);
		panel_8.add(textFieldtensaoFibraInferiorCF);
		textFieldtensaoFibraInferiorCF.setColumns(10);
		textFieldtensaoFibraInferiorCF.setText(decimal.format(viga.getTensaoFibraInferiorCF()).toString());
		textFieldtensaoFibraInferiorCF.setEditable(false);
		
		String resultado = "";
		
		if(viga.getTensaoFibraInferiorCF() <= viga.getFctkf()){
			resultado = "A fibra não foi fissurada!";
		} else {
			resultado = "A fibra foi fissurada!";
		}
			
			
		
		JLabel labelResultado = new JLabel(resultado);
		labelResultado.setBounds(72, 188, 238, 14);
		panel_8.add(labelResultado);
		
		frame.setVisible(true);
	}
}
