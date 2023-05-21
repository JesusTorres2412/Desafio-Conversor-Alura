package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conversor.conversor_longitud;
import Conversor.conversor_monedas;
import Conversor.conversor_temperatura;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class frmConversor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmConversor frame = new frmConversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	};

	/**
	 * Create the frame.
	 */
	public frmConversor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Conversor de monedas", "Conversor de temperatura", "Conversor de longitud" }));
		comboBox.setToolTipText("");
		comboBox.setMaximumRowCount(10);
		comboBox.setBounds(144, 52, 165, 22);
		contentPane.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(144, 100, 64, 22);
		contentPane.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(262, 100, 102, 22);
		contentPane.add(comboBox_2);

		JLabel lblNewLabel = new JLabel("VALOR:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 94, 95, 30);
		contentPane.add(lblNewLabel);

		// Array de tipos de temperatura
		String[] tiposTemperatura = { "Celsius", "Fahrenheit", "Kelvin" };
		String[] tiposMoneda = { "Dolar", "Euros", "Libra esterlina", "Franco Suizo" };
		String[] tiposLongitud = { "Km", "m", "cm ", "yarda","pie" };

		// ActionListener del JComboBox principal
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedOption = (String) comboBox.getSelectedItem();
				if (selectedOption.equals("Conversor de temperatura")) {
					comboBox_1.setModel(new DefaultComboBoxModel(tiposTemperatura));
					comboBox_2.setModel(new DefaultComboBoxModel(tiposTemperatura));

					// Mostrar campos de conversión de temperatura
					comboBox_1.setVisible(true);
					comboBox_2.setVisible(true);
				} if (selectedOption.equals("Conversor de moneda")) {
					comboBox_1.setModel(new DefaultComboBoxModel(tiposMoneda));
					comboBox_2.setModel(new DefaultComboBoxModel(tiposMoneda));

					// Mostrar campos de conversión de moneda
					comboBox_1.setVisible(true);
					comboBox_2.setVisible(true);
					
				}else if (selectedOption.equals("Conversor de longitud"))
					comboBox_1.setModel(new DefaultComboBoxModel(tiposLongitud));
					comboBox_2.setModel(new DefaultComboBoxModel(tiposLongitud));

					// Mostrar campos de conversión de moneda
					comboBox_1.setVisible(true);
					comboBox_2.setVisible(true);
				} 
			}
		);

		JButton btnNewButton = new JButton("CALCULAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				double valor;
				String valorTexto = textField.getText();
				try {
					valor = Double.parseDouble(valorTexto);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido");
					return; // Salir del método si el valor ingresado no es válido
				}

				String selectedOption = (String) comboBox.getSelectedItem();
				if (selectedOption.equals("Conversor de monedas")) {
					// Realizar la conversión de monedas
					String moneda1 = (String) comboBox_1.getSelectedItem();
					String moneda2 = (String) comboBox_2.getSelectedItem();
					double resultado = conversor_monedas.convertirMoneda(valor, moneda1, moneda2);
					
				} if (selectedOption.equals("Conversor de temperatura")) {
					// Realizar la conversión de temperatura
					String temperatura1 = (String) comboBox_1.getSelectedItem();
					String temperatura2 = (String) comboBox_2.getSelectedItem();
					double resultado = conversor_temperatura.convertirTemperatura(valor, temperatura1, temperatura2);
					
				} 
				if (selectedOption.equals("Conversor de longitud")) {
					// Realizar la conversión de temperatura
					String longitud1 = (String) comboBox_1.getSelectedItem();
					String longitud2 = (String) comboBox_2.getSelectedItem();
					double resultado = conversor_longitud.convertirLongitud(valor, longitud1, longitud2);
					
				} 

			}
		}

		);
		btnNewButton.setBounds(119, 198, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("SALIR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION,
						JOptionPane.ERROR_MESSAGE);
				if (resp == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Programa terminado");
					System.exit(0);
				} else if (resp == JOptionPane.NO_OPTION) {
					// Realizar alguna acción adicional si se selecciona "No"
					// O simplemente no hacer nada y continuar en el programa
				}
			}

		});
		btnNewButton_1.setBounds(262, 198, 89, 23);
		contentPane.add(btnNewButton_1);

		textField = new JTextField();
		textField.setBounds(74, 101, 67, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("CONVERSOR");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(151, 11, 130, 30);
		contentPane.add(lblNewLabel_1);
	}
};
