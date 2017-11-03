package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import calculus.Interpolacao;
import entity.AcoArmaduraAtiva;
import entity.AcoArmaduraPassiva;
import entity.Teste;
import entity.Viga;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Panel;

public class CalculoViga extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldBase;
	private JTextField textFieldAltura;
	private JTextField textFieldComprimento;
	private JTextField textFieldFpyk;
	private JTextField textFieldFptk;
	private JTextField textFieldQtCordoalhas;
	private JComboBox comboBoxCategoria;
	private JTextField textFieldMPermanente;
	private JTextField textFieldMAcidentais;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculoViga frame = new CalculoViga();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculoViga() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel infoViga = DefaultComponentFactory.getInstance().createLabel("Informa\u00E7\u00F5es da Viga");
		infoViga.setBounds(10, 11, 148, 14);
		contentPane.add(infoViga);
		
		JLabel lblBase = DefaultComponentFactory.getInstance().createLabel("Base:");
		lblBase.setBounds(10, 36, 47, 14);
		contentPane.add(lblBase);
		
		textFieldBase = new JTextField();
		textFieldBase.setBounds(97, 33, 86, 20);
		contentPane.add(textFieldBase);
		textFieldBase.setColumns(10);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setBounds(97, 61, 86, 20);
		contentPane.add(textFieldAltura);
		textFieldAltura.setColumns(10);
		
		JLabel lblAltura = DefaultComponentFactory.getInstance().createLabel("Altura:");
		lblAltura.setBounds(10, 64, 92, 14);
		contentPane.add(lblAltura);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 121, 647, 232);
		contentPane.add(tabbedPane);
		
		JPanel panelAcoArmaduraAtiva = new JPanel();
		tabbedPane.addTab("Aço Armadura Ativa", null, panelAcoArmaduraAtiva, null);
		panelAcoArmaduraAtiva.setLayout(null);
		
		JComboBox comboBoxAcoArmaduraAtiva = new JComboBox();
		comboBoxAcoArmaduraAtiva.setBounds(110, 11, 199, 20);
		comboBoxAcoArmaduraAtiva.addItem("3 fios de 3,0 mm - 6,5 mm");
		comboBoxAcoArmaduraAtiva.addItem("3 fios de 3,0 mm - 7,6  mm");
		comboBoxAcoArmaduraAtiva.addItem("3 fios de 3,0 mm - 8,8 mm");
		comboBoxAcoArmaduraAtiva.addItem("3 fios de 3,0 mm - 9,6 mm");
		comboBoxAcoArmaduraAtiva.addItem("3 fios de 3,0 mm - 11,1 mm");
		comboBoxAcoArmaduraAtiva.addItem("7 fios - 9,5 mm");
		comboBoxAcoArmaduraAtiva.addItem("7 fios - 12,7 mm");
		comboBoxAcoArmaduraAtiva.addItem("7 fios - 15,2 mm");


		panelAcoArmaduraAtiva.add(comboBoxAcoArmaduraAtiva);
		
		JLabel lblAoAtivoCp = new JLabel("Aço ativo:");
		lblAoAtivoCp.setBounds(10, 14, 90, 14);
		panelAcoArmaduraAtiva.add(lblAoAtivoCp);
		
		JLabel lblFpyk = new JLabel("FPYK");
		lblFpyk.setBounds(10, 73, 46, 14);
		panelAcoArmaduraAtiva.add(lblFpyk);
		
		textFieldFpyk = new JTextField();
		textFieldFpyk.setBounds(110, 70, 86, 20);
		panelAcoArmaduraAtiva.add(textFieldFpyk);
		textFieldFpyk.setColumns(10);
		
		JLabel lblFptk = new JLabel("FPTK");
		lblFptk.setBounds(10, 45, 46, 14);
		panelAcoArmaduraAtiva.add(lblFptk);
		
		textFieldFptk = new JTextField();
		textFieldFptk.setBounds(110, 42, 86, 20);
		panelAcoArmaduraAtiva.add(textFieldFptk);
		textFieldFptk.setColumns(10);
		
		JLabel lblQuantidadeCordoalhas = new JLabel("Qt Cordoalhas");
		lblQuantidadeCordoalhas.setBounds(10, 104, 143, 14);
		panelAcoArmaduraAtiva.add(lblQuantidadeCordoalhas);
		
		textFieldQtCordoalhas = new JTextField();
		textFieldQtCordoalhas.setBounds(110, 101, 86, 20);
		panelAcoArmaduraAtiva.add(textFieldQtCordoalhas);
		textFieldQtCordoalhas.setColumns(10);
		
		JPanel panelAcoArmaduraPassiva = new JPanel();
		tabbedPane.addTab("Aço Armadura Passiva", null, panelAcoArmaduraPassiva, null);
		panelAcoArmaduraPassiva.setLayout(null);
		
		JComboBox comboBoxArmaduraPassiva = new JComboBox();
		comboBoxArmaduraPassiva.setBounds(117, 11, 173, 20);
		comboBoxArmaduraPassiva.addItem("6,3 mm"); // se for 6,3 area = 31,2
		comboBoxArmaduraPassiva.addItem("8,0 mm");	//area = 50,3
		comboBoxArmaduraPassiva.addItem("10,0 mm"); //area = 78,5
		comboBoxArmaduraPassiva.addItem("12,5 mm"); //area = 122,7
		comboBoxArmaduraPassiva.addItem("16,0 mm"); //area = 201,1
		comboBoxArmaduraPassiva.addItem("20,0 mm"); //area = 314,2
		comboBoxArmaduraPassiva.addItem("22,0 mm"); //area = 380,1
		comboBoxArmaduraPassiva.addItem("25,0 mm"); //area = 490,9
		comboBoxArmaduraPassiva.addItem("32,0 mm"); //area = 804,2


		panelAcoArmaduraPassiva.add(comboBoxArmaduraPassiva);
		
		JLabel lblAoPassivo = new JLabel("A\u00E7o Passivo");
		lblAoPassivo.setBounds(10, 14, 75, 14);
		panelAcoArmaduraPassiva.add(lblAoPassivo);
		
		JComboBox comboCategoria;
		comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setBounds(117, 42, 173, 20);
		comboBoxCategoria.addItem("CA 25"); // se for 25 fyk = 250
		comboBoxCategoria.addItem("CA 50"); // se for 50 fyk = 500
		panelAcoArmaduraPassiva.add(comboBoxCategoria);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 45, 75, 14);
		panelAcoArmaduraPassiva.add(lblCategoria);
		
		JPanel panelConcreto = new JPanel();
		tabbedPane.addTab("Concreto", null, panelConcreto, null);
		panelConcreto.setLayout(null);
		
		JLabel lblClasseConcreto = new JLabel("Classe Concreto:");
		lblClasseConcreto.setBounds(10, 11, 114, 14);
		panelConcreto.add(lblClasseConcreto);
		
		JComboBox comboBoxClasseConcreto = new JComboBox();
		comboBoxClasseConcreto.setBounds(134, 8, 130, 20);
		comboBoxClasseConcreto.addItem("C30"); // se for 25 fck = 30
		comboBoxClasseConcreto.addItem("C35"); // se for 50 fck = 35
		comboBoxClasseConcreto.addItem("C40"); // se for 25 fck = 40
		comboBoxClasseConcreto.addItem("C45"); // se for 50 fck = 45
		comboBoxClasseConcreto.addItem("C50"); // se for 25 fck = 50
		panelConcreto.add(comboBoxClasseConcreto);
		
		Panel panel = new Panel();
		tabbedPane.addTab("Ambiente de Construção", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblUmidade = new JLabel("Umidade");
		lblUmidade.setBounds(10, 11, 65, 14);
		panel.add(lblUmidade);
		
		JComboBox comboBoxUmidade = new JComboBox();
		comboBoxUmidade.setBounds(133, 8, 96, 20);
		comboBoxUmidade.addItem("40%"); // 0.4
		comboBoxUmidade.addItem("70%"); // 0.7
		comboBoxUmidade.addItem("90%"); // 0.9
		
		panel.add(comboBoxUmidade);
		
		JLabel lblFatorEndurecimento = new JLabel("Fator Endurecimento");
		lblFatorEndurecimento.setBounds(10, 36, 119, 14);
		panel.add(lblFatorEndurecimento);
		
		JComboBox comboBoxFatorEndurecimento = new JComboBox();
		comboBoxFatorEndurecimento.setBounds(133, 33, 96, 20);
		comboBoxFatorEndurecimento.addItem("1"); // 1
		comboBoxFatorEndurecimento.addItem("2"); // 2
		comboBoxFatorEndurecimento.addItem("3"); // 3
		panel.add(comboBoxFatorEndurecimento);
		
		JLabel lblComprimento = new JLabel("Comprimento:");
		lblComprimento.setBounds(10, 92, 110, 14);
		contentPane.add(lblComprimento);
		
		textFieldComprimento = new JTextField();
		textFieldComprimento.setBounds(97, 90, 86, 20);
		contentPane.add(textFieldComprimento);
		textFieldComprimento.setColumns(10);
		
		JButton calcular = new JButton("Calcular");
		calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				//----------- CONSTRUTOR ARMADURA ATIVA -----------
				
				Integer numFios;
				Double nominal, area, massa;
				if(comboBoxAcoArmaduraAtiva.getSelectedIndex() == 0){
					numFios = 3;
					nominal = 6.5;
					area = 0.218;
					massa = 0.171;
				} else if (comboBoxAcoArmaduraAtiva.getSelectedIndex() == 1){
					numFios = 3;
					nominal = 7.6;
					area = 0.303;
					massa = 0.238;
				} else if (comboBoxAcoArmaduraAtiva.getSelectedIndex() == 2){
					numFios = 3;
					nominal = 8.8;
					area = 0.387;
					massa = 0.304;
				} else if (comboBoxAcoArmaduraAtiva.getSelectedIndex() == 3){
					numFios = 3;
					nominal = 9.6;
					area = 0.466;
					massa = 0.366;
				} else if (comboBoxAcoArmaduraAtiva.getSelectedIndex() == 4){
					numFios = 3;
					nominal = 11.1;
					area = 0.662;
					massa = 0.52;
				} else if (comboBoxAcoArmaduraAtiva.getSelectedIndex() == 5){
					numFios = 7;
					nominal = 9.5;
					area = 0.562;
					massa = 0.441;
				} else if (comboBoxAcoArmaduraAtiva.getSelectedIndex() == 6){
					numFios = 7;
					nominal = 12.7;
					area = 1.009;
					massa = 0.792;
				}  else {
					numFios = 7;
					nominal = 15.2;
					area = 1.434;
					massa = 1.126;
				}
				
				AcoArmaduraAtiva ativa = new AcoArmaduraAtiva(numFios, nominal, area, massa, Double.parseDouble(textFieldFptk.getText()), 
						Double.parseDouble(textFieldFpyk.getText()), Integer.parseInt(textFieldQtCordoalhas.getText()));
			
				
				//------------ CONSTRUTOR OBJETO AÇO ARMADURA PASSIVA ------------
				Double diametroBarra, areaPassiva;
				String categoria;
				Integer fyk;
				
				if(comboBoxArmaduraPassiva.getSelectedIndex() == 0){
					diametroBarra = 6.3;
					areaPassiva = 31.2;
				} else if(comboBoxArmaduraPassiva.getSelectedIndex() == 1){
					diametroBarra = 8.0;
					areaPassiva = 50.3;
				} else if(comboBoxArmaduraPassiva.getSelectedIndex() == 2){
					diametroBarra = 10.0;
					areaPassiva = 78.5;
				} else if(comboBoxArmaduraPassiva.getSelectedIndex() == 3){
					diametroBarra = 12.5;
					areaPassiva = 122.7;
				} else if(comboBoxArmaduraPassiva.getSelectedIndex() == 4){
					diametroBarra = 16.0;
					areaPassiva = 201.1;
				} else if(comboBoxArmaduraPassiva.getSelectedIndex() == 5){
					diametroBarra = 20.0;
					areaPassiva = 314.2;
				} else if(comboBoxArmaduraPassiva.getSelectedIndex() == 6){
					diametroBarra = 22.0;
					areaPassiva = 380.1;
				} else if(comboBoxArmaduraPassiva.getSelectedIndex() == 7){
					diametroBarra = 25.0;
					areaPassiva = 490.9;
				} else {
					diametroBarra = 32.0;
					areaPassiva = 804.2;
				}
				
				if(comboBoxCategoria.getSelectedIndex() == 0 ){
					fyk = 250;
				} else {
					fyk = 500;
				}
				
				categoria = (String) comboBoxCategoria.getSelectedItem();
				
				AcoArmaduraPassiva passiva = new AcoArmaduraPassiva(diametroBarra, areaPassiva, categoria, fyk);
				
				
				// ------------------- CONSTRUTOR CLASSE CONCRETO ---------------------
				Integer fck;
				
				if(comboBoxClasseConcreto.getSelectedIndex() == 0){
					fck = 30;
				} else if(comboBoxClasseConcreto.getSelectedIndex() == 1){
					fck = 35;
				} else if(comboBoxClasseConcreto.getSelectedIndex() == 2){
					fck = 40;
				} else if(comboBoxClasseConcreto.getSelectedIndex() == 3){
					fck = 45;
				} else {
					fck = 50;
				}
				
				String classeconcreto = (String) comboBoxClasseConcreto.getSelectedItem();
				
				// ---------------- CONSTRUTOR VIGA -------------
				
				Double i = Double.parseDouble(textFieldBase.getText()),
						   j = Double.parseDouble(textFieldAltura.getText()),
						   l = Double.parseDouble(textFieldComprimento.getText()), 
						   gamaS = 1.15, umidade, fatorEndurecimento, 
						   mPermanentes = Double.parseDouble(textFieldMPermanente.getText()),
						   mAcidentais = Double.parseDouble(textFieldMAcidentais.getText());
				
				if(comboBoxUmidade.getSelectedIndex() == 0){
					umidade = 0.4;
				} else if(comboBoxUmidade.getSelectedIndex() == 1){
					umidade = 0.7;
				} else {
					umidade = 0.9;
				}
				
				fatorEndurecimento = Double.parseDouble((String) comboBoxFatorEndurecimento.getSelectedItem());
				
				
				
				Viga viga = null;
				try {
					viga = new Viga(i, j, l, gamaS, ativa, passiva, classeconcreto, fck, umidade,
							fatorEndurecimento, mPermanentes, mAcidentais);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				System.out.println(viga);

				
				
			}
		});
		calcular.setBounds(568, 364, 89, 23);
		contentPane.add(calcular);
		
		JLabel lblMPermanente = new JLabel("M Permanente: ");
		lblMPermanente.setBounds(193, 36, 110, 14);
		contentPane.add(lblMPermanente);
		
		textFieldMPermanente = new JTextField();
		textFieldMPermanente.setBounds(323, 33, 86, 20);
		contentPane.add(textFieldMPermanente);
		textFieldMPermanente.setColumns(10);
		
		JLabel lblMAcidentais = new JLabel("M Acidentais:");
		lblMAcidentais.setBounds(193, 64, 86, 14);
		contentPane.add(lblMAcidentais);
		
		textFieldMAcidentais = new JTextField();
		textFieldMAcidentais.setBounds(323, 61, 86, 20);
		contentPane.add(textFieldMAcidentais);
		textFieldMAcidentais.setColumns(10);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tabbedPane, infoViga, lblBase, textFieldBase, textFieldAltura, lblAltura}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, infoViga, lblBase, textFieldBase, tabbedPane, textFieldAltura, lblAltura}));
	}
	
	private Double getValorPhi(){
		return Double.parseDouble(JOptionPane.showInputDialog("Valor de PHI"));
	}
}