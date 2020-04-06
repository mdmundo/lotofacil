import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class LayoutMatrizInicial {
	
	private JComboBox<Integer> comboBoxMax = new JComboBox<Integer>();
	private JComboBox<Integer> comboBoxMin = new JComboBox<Integer>();
	private JComboBox<Integer> comboBoxMin1 = new JComboBox<Integer>();
	private JComboBox<Integer> comboBoxMax1 = new JComboBox<Integer>();
	
	public static String[] tituloColunas;
	public static Object[][] bolas;
	
	public void JanelaP(final Object[][] bolas) throws IOException {
		
		//-------------------DECLARACOES DE OBJETOS E VARIÁVEIS----------------------------//
		String[] tituloColunas = {"Concurso","B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9","B10", "B11", "B12", "B13", "B14", "B15"};
		JFrame frameLotoFacil = new JFrame("Lotofacil");	
		JPanel painelTabela = new JPanel(); 												//Cria um JPanel para comportar um Scroll
		//JPanel panelOpcoes = new JPanel();													//Painel com as opcoes inferiores
		JBackgroundPanel panelOpcoes = new JBackgroundPanel("background.jpg");
		JPanel panelClassifica = new JPanel();
		JPanel panelClassificaBaixo = new JPanel();
		JPanel panelFrequencia = new JPanel();
		JPanel panelFrequenciaBaixo = new JPanel();
		JLabel frequenciaTitulo = new JLabel("Frequencia");
		JLabel classificaTitulo = new JLabel("Ordenar");
		JLabel labelMax = new JLabel("Até o Nº: ");
		JLabel labelMin = new JLabel("Do Nº: ");											//Adiciona as strings aos labels
		JLabel labelTitulo = new JLabel("Lotofacil");
		JTable tabelaPrincipal = new JTable(bolas, tituloColunas);							//Colocando as coisas na tabela
		JButton frequenciaMax = new JButton("Máxima");
		JButton frequenciaMin = new JButton("Mínima");
		JCheckBox check = new JCheckBox("Apenas uma linha?");
		check.setOpaque(false);
		JButton buttonOk = new JButton("Ordernar");
		final JTextField textFreqMax = new RoundJTextField(2);
		final JTextField textFreqMin = new RoundJTextField(2);
		textFreqMax.setEditable(false);
		textFreqMin.setEditable(false);
		//----------------------------------------------------------------------------------//
		
		
		
		//-----------------------------DEFINICOES DA TABELA---------------------------------//
		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();				//Cria um objeto centralizado
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);							//Define o objeto centralizado com coordenadas centrais
		
		for (int i = 0; i < 16; i++) {				
			tabelaPrincipal.getColumnModel().getColumn(i).setPreferredWidth(50);			//Define para cada coluna i um tamanho 
			tabelaPrincipal.getColumnModel().getColumn(i).setCellRenderer(centralizado);	//Centraliza cada coluna em i 
		}
		tabelaPrincipal.getColumnModel().getColumn(0).setPreferredWidth(140);				//Define o tamanho da coluna do concurso 
		tabelaPrincipal.getTableHeader().setResizingAllowed(false);							//Impede redimensionamento da tabela pelo usuario
		tabelaPrincipal.getTableHeader().setReorderingAllowed(false);						//Impede troca de posi��o das colunas da tabela pelo usuario
		tabelaPrincipal.setEnabled(false);													//Bloqueia a edi��o dos dados da tabela
		//----------------------------------------------------------------------------------//
		
		
		//-----------------------------DEFINICOES DO SCROLL---------------------------------//
		JScrollPane barraRolagem = new JScrollPane(tabelaPrincipal);						//Cria um Scroll Panel e coloca a tabela na barra de rolagem
		barraRolagem.setPreferredSize(new Dimension(700, 400));								//Seta as dimens�es da barra de rolagem
		//painelTabela.setBackground(new Color(0f, 0f, 0f, 0f));
		painelTabela.add(barraRolagem);														//Adiciona o Scroll a um painel
		//----------------------------------------------------------------------------------//
		
		
		//-----------------------------DEFINICOES DO TITULO---------------------------------//
		labelTitulo.setFont(new Font("System", Font.PLAIN, 30));							//Define a fonte do t�tulo
		labelTitulo.setHorizontalAlignment(JLabel.CENTER);									//Define a posi��o do titulo
		//----------------------------------------------------------------------------------//
		
		
		//----------------------------DEFINICOES DOS BOTOES---------------------------------//		
		buttonOk.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				MostraOrdem mostra = new MostraOrdem();
				Ordenar ordena = new Ordenar();
				if (check.isSelected()) {
					mostra.MostrarObj(ordena.Ordenacao(bolas, (comboBoxMax.getSelectedIndex()+1), (comboBoxMax.getSelectedIndex()+1)));
				} else {
					if (comboBoxMin.getSelectedIndex()+1 >= comboBoxMax.getSelectedIndex()+1) {
						JOptionPane.showMessageDialog(null, "O primeiro número deve ser menor que o segundo!");
					} else {
						mostra.MostrarObj(ordena.Ordenacao(bolas, (comboBoxMin.getSelectedIndex()+1), (comboBoxMax.getSelectedIndex()+1)));
					}
				}
				
			}
		});
		
		frequenciaMax.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBoxMin1.getSelectedIndex() >= comboBoxMax1.getSelectedIndex()) {
					JOptionPane.showMessageDialog(null, "O primeiro número deve ser menor que o segundo!");
				} else {
					ContaFreq frequencia = new ContaFreq();
					int[][] vet = new int[25][2];
					vet = frequencia.conta(bolas, comboBoxMin1.getSelectedIndex(), comboBoxMax1.getSelectedIndex());
					int tempBola, temp;
					for (int i = 0; i < vet.length; i++) {
						for (int j = 0; j < vet.length; j++) {
							if(vet[j][0] < vet[i][0]) {
								tempBola = vet[i][0];
								temp = vet[i][1];
								vet[i][0] = vet[j][0];
								vet[i][1] = vet[j][1];
								vet[j][0] = tempBola;
								vet[j][1] = temp;
							}
						}
					}
					textFreqMax.setText(String.valueOf(vet[0][1])+"-"+String.valueOf(vet[1][1])+"-"+String.valueOf(vet[2][1])+"-"+String.valueOf(vet[3][1])+"-"+String.valueOf(vet[4][1]));
				}
			}
		});
		
		frequenciaMin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBoxMin1.getSelectedIndex() >= comboBoxMax1.getSelectedIndex()) {
					JOptionPane.showMessageDialog(null, "O primeiro número deve ser menor que o segundo!");
				} else {
					ContaFreq frequencia = new ContaFreq();
					int[][] vet = new int[25][2];
					vet = frequencia.conta(bolas, comboBoxMin1.getSelectedIndex(), comboBoxMax1.getSelectedIndex());
					int tempBola, temp;
					for (int i = 0; i < vet.length; i++) {
						for (int j = 0; j < vet.length; j++) {
							if(vet[j][0] > vet[i][0]) {
								tempBola = vet[i][0];
								temp = vet[i][1];
								vet[i][0] = vet[j][0];
								vet[i][1] = vet[j][1];
								vet[j][0] = tempBola;
								vet[j][1] = temp;
							}
						}
					}
					textFreqMin.setText(String.valueOf(vet[0][1])+"-"+String.valueOf(vet[1][1])+"-"+String.valueOf(vet[2][1])+"-"+String.valueOf(vet[3][1])+"-"+String.valueOf(vet[4][1]));
				}
			}
		});
		
		check.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (check.isSelected()) {
					labelMax.setText("Número: ");
					labelMin.setText("");
					comboBoxMin.setEnabled(false);
				} else {
					labelMin.setText("Do Nº: ");
					labelMax.setText("Até o Nº: ");
					comboBoxMin.setEnabled(true);
				}
				
			}
		});
		
		//----------------------------------------------------------------------------------//
		
		//----------------------------DEFINICOES DOS COMBOBOX-------------------------------//
		for (int i = 0; i < bolas.length; i++) {
			comboBoxMax.addItem(new Integer(i+1));
			comboBoxMin.addItem(new Integer(i+1));
		}
		
		for (int i = 0; i < bolas.length; i++) {
			comboBoxMax1.addItem(new Integer(i+1));
			comboBoxMin1.addItem(new Integer(i+1));
		}
		//----------------------------------------------------------------------------------//
		
		//----------------------DEFINICOES DO PAINEL DE OPCOES------------------------------//
		
		//Painel Classifica
		panelClassificaBaixo = new JPanel();
		panelClassificaBaixo.setLayout(new GridLayout(3,4));
		panelClassificaBaixo.add(new JLabel(""));
		panelClassificaBaixo.add(labelMin);
		panelClassificaBaixo.add(comboBoxMin);
		panelClassificaBaixo.add(new JLabel(""));
		panelClassificaBaixo.add(new JLabel(""));
		panelClassificaBaixo.add(labelMax);
		panelClassificaBaixo.add(comboBoxMax);
		panelClassificaBaixo.add(new JLabel(""));
		panelClassificaBaixo.add(new JLabel(""));
		panelClassificaBaixo.add(check);
		panelClassificaBaixo.add(buttonOk);
		//panelClassificaBaixo.setBackground(new Color(0f, 0f, 0f, 0f));
	
		
		classificaTitulo.setFont(new Font("System", Font.PLAIN, 20));			
		classificaTitulo.setHorizontalAlignment(JLabel.CENTER);
		panelClassifica.setLayout(new GridLayout(2,1));
		panelClassifica.add(classificaTitulo);
		panelClassifica.add(panelClassificaBaixo);
		//panelClassifica.setBackground(new Color(0f, 0f, 0f, 0f));
		//-----------------
		
		//Painel Frequencia
		panelFrequenciaBaixo = new JPanel();
		panelFrequenciaBaixo.setLayout(new GridLayout(3,4));
		panelFrequenciaBaixo.add(new JLabel("De Nº e Até Nº:"));
		panelFrequenciaBaixo.add(comboBoxMin1);
		panelFrequenciaBaixo.add(comboBoxMax1);
		panelFrequenciaBaixo.add(new JLabel(""));
		panelFrequenciaBaixo.add(new JLabel(""));
		panelFrequenciaBaixo.add(frequenciaMax);
		panelFrequenciaBaixo.add(textFreqMax);
		panelFrequenciaBaixo.add(new JLabel(""));
		panelFrequenciaBaixo.add(new JLabel(""));
		panelFrequenciaBaixo.add(frequenciaMin);
		panelFrequenciaBaixo.add(textFreqMin);
		panelFrequenciaBaixo.add(new JLabel(""));
		//panelFrequenciaBaixo.setBackground(new Color(0f, 0f, 0f, 0f));
		
		frequenciaTitulo.setFont(new Font("system", Font.PLAIN, 20));
		frequenciaTitulo.setHorizontalAlignment(JLabel.CENTER);
		panelFrequencia = new JPanel();
		panelFrequencia.setLayout(new GridLayout(2,1));
		panelFrequencia.add(frequenciaTitulo);
		panelFrequencia.add(panelFrequenciaBaixo);
		//panelFrequencia.setBackground(new Color(0f, 0f, 0f, 0f));
		//------------------
		
		//Painel opcoes geral
		//panelOpcoes = new JPanel();
		panelOpcoes.setLayout(new GridLayout(1,2));
		panelOpcoes.add(panelClassifica);
		panelOpcoes.add(panelFrequencia);
		
		
		
		
		//------------------------------------------------
		frameLotoFacil.setContentPane(new MyPanel());
		frameLotoFacil.setLayout(new BorderLayout());
		frameLotoFacil.add(labelTitulo, BorderLayout.NORTH);
		frameLotoFacil.add(painelTabela, BorderLayout.CENTER);
		frameLotoFacil.add(panelOpcoes, BorderLayout.SOUTH);
		frameLotoFacil.pack();
		frameLotoFacil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLotoFacil.setVisible(true);
		frameLotoFacil.setLocationRelativeTo(null);
		frameLotoFacil.setResizable(false);
	}
}