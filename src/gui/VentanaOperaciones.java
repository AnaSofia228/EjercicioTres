package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class VentanaOperaciones extends JFrame {
	
	private JPanel PanelPrincipal;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtNombre;
	private JButton btnCalcular;
	private JButton btnResultados;
	private JLabel lblPromedio;
	private JLabel lblResultadoProm;
	
	ArrayList<Double> ListaNotasFinales;
	ArrayList<ArrayList<Double>>listaNotas;
	ArrayList<String> listaEstudiantes;
	int cantGanan=0, cantPierdenSinRecuperar=0, cantPuedenRecuperar=0, cantPierden=0 ,cantEstudiantesValidados=0;
	double promedioNotasFinales=0;	
	String nombre;


	public VentanaOperaciones() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(510, 315);
		setTitle("Calculo Notas");
		setLocationRelativeTo(null);
		setResizable(false);
		iniciarComponentes();
		
	}
	
	private void iniciarComponentes() {
		
		PanelPrincipal = new JPanel();
		PanelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PanelPrincipal);
		PanelPrincipal.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Promedio de Notas");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblTitulo.setBounds(110, 11, 215, 32);
		PanelPrincipal.add(lblTitulo);
		
		JLabel lblNota1 = new JLabel("Nota 1");
		lblNota1.setBounds(10, 109, 46, 14);
		PanelPrincipal.add(lblNota1);
		
		txtNota1 = new JTextField();
		txtNota1.setBounds(66, 106, 86, 20);
		PanelPrincipal.add(txtNota1);
		txtNota1.setColumns(10);
		
		JLabel lblNota2 = new JLabel("Nota 2");
		lblNota2.setBounds(10, 140, 46, 14);
		PanelPrincipal.add(lblNota2);
		
		txtNota2 = new JTextField();
		txtNota2.setBounds(66, 137, 86, 20);
		PanelPrincipal.add(txtNota2);
		txtNota2.setColumns(10);
		
		JLabel lblNota3 = new JLabel("Nota 3");
		lblNota3.setBounds(10, 173, 46, 14);
		PanelPrincipal.add(lblNota3);
		
		txtNota3 = new JTextField();
		txtNota3.setBounds(66, 170, 86, 20);
		PanelPrincipal.add(txtNota3);
		txtNota3.setColumns(10);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarDatos();
				validarNota();
			}
		});
		btnCalcular.setBounds(256, 227, 89, 23);
		PanelPrincipal.add(btnCalcular);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(31, 227, 69, 23);
		PanelPrincipal.add(btnSalir);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				txtNota1.setText("");
				txtNota2.setText("");
				txtNota3.setText("");
				txtNota1.requestFocus();
			}
		});
		btnNuevo.setBounds(355, 227, 69, 23);
		PanelPrincipal.add(btnNuevo);
		
		btnResultados = new JButton("Resultados");
		btnResultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimirResultados();
				System.out.println("-------------------------------------------------");
				imprimirEstudianteNota();
				System.out.println("-------------------------------------------------");
				imprimirListas();
			}
		});
		btnResultados.setBounds(110, 226, 136, 25);
		PanelPrincipal.add(btnResultados);
		
		JLabel lblProm = new JLabel("Promedio Final:");
		lblProm.setHorizontalAlignment(SwingConstants.CENTER);
		lblProm.setBounds(162, 109, 112, 14);
		PanelPrincipal.add(lblProm);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 66, 46, 14);
		PanelPrincipal.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 63, 86, 20);
		PanelPrincipal.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblPromedio = new JLabel("");
		lblPromedio.setBounds(284, 109, 140, 14);
		PanelPrincipal.add(lblPromedio);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(177, 140, 69, 14);
		PanelPrincipal.add(lblResultado);
		
		lblResultadoProm = new JLabel("");
		lblResultadoProm.setBounds(256, 140, 168, 14);
		PanelPrincipal.add(lblResultadoProm);
		
	}

	private void ingresarDatos() {
		listaEstudiantes= new ArrayList<String>();
		nombre = txtNombre.getText();
		listaEstudiantes.add(nombre);
		
	}
	
    public void imprimirEstudianteNota() {
		
		for (int i =0; i < listaEstudiantes.size(); i++) {
			System.out.println(listaEstudiantes.get(i) + " : " + ListaNotasFinales.get(i));
		}
	}
	
	 private void imprimirResultados() {
		 System.out.println("Cantidad de estudiantes validados : "+listaEstudiantes.size());
	        System.out.println("Cantidad de notas ingresadas es : "+listaEstudiantes.size()*3);
	        System.out.println("Cantidad de estudiantes que ganaron: "+cantGanan);
	        System.out.println("Cantidad de estudiantes que perdieron: "+cantPierden);
	        System.out.println("Cantidad de estudiantes que pueden recuperar: "+cantPuedenRecuperar);
	        System.out.println("Cantidad de estudiantes que perdieron sin recuperacion: "+cantPierdenSinRecuperar);
	        System.out.println("Promedio Notas finales : " + promedioNotasFinales);
		
	}
	 
	 private void imprimirListas() {
			System.out.println(listaEstudiantes.size());
			System.out.println(ListaNotasFinales);
			
		}

	private void validarNota() {
		double n1 =0;
		double n2 =0;
		double n3 =0;
		ListaNotasFinales=new ArrayList<Double>();
			
		
		n1 = Double.parseDouble(txtNota1.getText());
		if (n1<0 || n1>5) {
			JOptionPane.showMessageDialog(null, "La nota debe estar entre 0 y 5");
		}
		
		n2 = Double.parseDouble(txtNota2.getText());
		if (n2<0 || n2>5) {
			JOptionPane.showMessageDialog(null, "La nota debe estar entre 0 y 5");
		}
		
		n3 = Double.parseDouble(txtNota3.getText());
		if (n3<0 || n3>5) {
			JOptionPane.showMessageDialog(null, "La nota debe estar entre 0 y 5");
		}
		 
	   
	   double promedio = (n1+n2+n3)/3;	
	   ListaNotasFinales.add(promedio);
	   System.out.println(ListaNotasFinales);
	   
	   lblPromedio.setText(""+promedio);
	   
	   if (promedio>=3.5) {
		   lblResultadoProm.setText(" aprobo ");
		   lblResultadoProm.setForeground(Color.green);
           
           cantGanan++;
       }else{
    	   lblResultadoProm.setText(" reprobo ");
    	   lblResultadoProm.setForeground(Color.red);
		   cantPierdenSinRecuperar++;
       }
	   
	 //calcula los datos de quienes ganan,pierden,recuperan
	 		for(int i = 0; i < ListaNotasFinales.size(); i++) {
	 			if(ListaNotasFinales.get(i)>=3.5) {
	 				cantGanan++;
	 			}
	 			else {
	 				cantPierden++;
	 				if(ListaNotasFinales.get(i)>2) {
	 					cantPuedenRecuperar++;
	 				}
	 				else {
	 					cantPierdenSinRecuperar++;
	 				}
	 			}
	 		}
	 		
	 		//calcula el promedio total de notas obtenidas
			int suma = 0;
			for (int i = 0; i < ListaNotasFinales.size(); i++) {
				suma+=ListaNotasFinales.get(i);
			}
			promedioNotasFinales=suma/ListaNotasFinales.size();
		
	}

}
