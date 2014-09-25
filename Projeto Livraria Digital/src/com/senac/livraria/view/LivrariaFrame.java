package com.senac.livraria.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.annotation.processing.FilerException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.senac.livraria.dao.LivrariaDAO;
import com.senac.livraria.model.Livro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.CardLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class LivrariaFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tituloField;
	private JTextField autorField;
	private JTextField editorField;
	private JTextField dataLancamentoField;
	
	
	private LivrariaDAO dao;
	private Livro[] livros;
	
	private Object[][] tableObjects = new Object[][] {
			{null, null, null, null},
			{null, null, null, null},
			{null, null, null, null},
			{null, null, null, null},
			{null, null, null, null},
			{null, null, null, null},
			{null, null, null, null},
			{null, null, null, null},
			{null, null, null, null},
			{null, null, null, null},
			{null, null, null, null},
			{null, null, null, null},
			{null, null, null, null},
		};
	private String[] tableLabels = new String[]{"Título","Autor","Editora","Data Lançamento"};
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LivrariaFrame frame = new LivrariaFrame();
					frame.setVisible(true);
					frame.events();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LivrariaFrame() {
		
		setTitle("PENG Books");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelAdicionarLivro = new JPanel();
		panelAdicionarLivro.setBorder(new TitledBorder(null, "Adicionar Livro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.addTab("Adicionar Livro", null, panelAdicionarLivro, null);
		panelAdicionarLivro.setLayout(null);
		
		JPanel panelFormularioLivro = new JPanel();
		panelFormularioLivro.setBounds(10, 22, 599, 222);
		panelAdicionarLivro.add(panelFormularioLivro);
		panelFormularioLivro.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo");
		panelFormularioLivro.add(lblTitulo, "4, 4, right, default");
		
		tituloField = new JTextField();
		panelFormularioLivro.add(tituloField, "6, 4, left, default");
		tituloField.setColumns(30);
		
		JLabel lblAutor = new JLabel("Autor");
		panelFormularioLivro.add(lblAutor, "4, 6, right, default");
		
		autorField = new JTextField();
		autorField.setColumns(30);
		panelFormularioLivro.add(autorField, "6, 6, left, default");
		
		JLabel lblEditor = new JLabel("Editor");
		panelFormularioLivro.add(lblEditor, "4, 8, right, default");
		
		editorField = new JTextField();
		editorField.setColumns(30);
		panelFormularioLivro.add(editorField, "6, 8, left, default");
		
		JLabel lblDataDeLanamento = new JLabel("Data de Lan\u00E7amento");
		panelFormularioLivro.add(lblDataDeLanamento, "4, 10, right, default");
		
		dataLancamentoField = new JTextField();
		dataLancamentoField.setColumns(10);
		panelFormularioLivro.add(dataLancamentoField, "6, 10, left, default");
		
		JPanel panelFormularioBotoes = new JPanel();
		panelFormularioBotoes.setBounds(10, 255, 599, 58);
		panelAdicionarLivro.add(panelFormularioBotoes);
		panelFormularioBotoes.setLayout(null);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String messageError = "";
				Livro livro = null;
				
				messageError = "".equals( tituloField.getText().trim() ) ? "Campo Título do Livro esta em Branco!\n" : "";
				messageError += "".equals( autorField.getText().trim() ) ? "Campo Autor do Livro esta em Branco!\n" : "";
				messageError += "".equals( editorField.getText().trim() ) ? "Campo Editor do Livro esta em Branco!\n" : "";
				messageError += "".equals( dataLancamentoField.getText().trim() ) ? "Campo Data do Livro esta em Branco!" : "";
					
				if( messageError.equals("") ){
					livro = new Livro();
					livro.setTitulo( tituloField.getText().trim() );
					livro.setAutor( autorField.getText().trim() );
					livro.setEditor( editorField.getText().trim() );
					livro.setDataLancamento( dataLancamentoField.getText().trim() );
					
					dao.inserirLivro(livro);
					limparOsCampos();
					preencherLista();
					JOptionPane.showMessageDialog(null, "Livro Adicionado com Sucesso!", "Mandou bem Malandro!", 1 );
				} else {
					JOptionPane.showMessageDialog(null, messageError, "Epa!!! tem campo vazio ai hein!", 2);
								
				}
				
			}
		});
		btnSalvar.setBounds(500, 18, 89, 23);
		panelFormularioBotoes.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				limparOsCampos();				
			}
		});
		btnLimpar.setBounds(401, 18, 89, 23);
		panelFormularioBotoes.add(btnLimpar);
		
		JPanel panelListarLivros = new JPanel();
		panelListarLivros.setBorder(new TitledBorder(null, "Listar Livros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.addTab("Listar Livros", null, panelListarLivros, null);
		panelListarLivros.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 25, 599, 229);
		panelListarLivros.add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 2, 599, 227);
		panel_4.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel( tableObjects, tableLabels) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(table);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 265, 599, 48);
		panelListarLivros.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnAtualizarLista = new JButton("Atualizar Lista");
		btnAtualizarLista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				preencherLista();
			}
		});
		btnAtualizarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAtualizarLista.setBounds(455, 11, 134, 23);
		panel_5.add(btnAtualizarLista);
	}
	
	public void events(){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				dao = new LivrariaDAO();
				preencherLista();
			}
		});
	}
	
	public void preencherLista(){
		DefaultTableModel modelo = new DefaultTableModel(this.tableLabels , 0);
		
		List<Livro> livros = dao.listarLivros();
		
		for (Livro livro : livros) {
			String[] line = new String[4];
			line[0] = livro.getTitulo();
			line[1] = livro.getAutor();
			line[2] = livro.getEditor();
			line[3] = livro.getDataLancamento();
			
			modelo.addRow( line );
		}
		
		table.setModel(modelo);
	}
	
	public void limparLista(){
         DefaultTableModel modelo = new DefaultTableModel(this.tableLabels, 0);
         modelo.setNumRows(0);
         table.setModel(modelo);
	}
	
	public void limparOsCampos(){
		this.tituloField.setText("");
		this.autorField.setText("");
		this.editorField.setText("");
		this.dataLancamentoField.setText("");
	}
}
