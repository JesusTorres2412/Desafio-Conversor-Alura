package Conversor;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class conversor_monedas {

	public static double convertirMoneda(double valor, String moneda1, String moneda2) {
		double resultado = 0.0;
		if (moneda1.equals("Dolar")) {
			if (moneda2.equals("Euros")) {
				resultado = valor * 0.92;
			} else if (moneda2.equals("Libra esterlina")) {
				resultado = valor * 0.80;
			} else if (moneda2.equals("Franco Suizo")) {
				resultado = valor * 0.90;
			}
		} else if (moneda1.equals("Euros")) {
			if (moneda2.equals("Dolar")) {
				resultado = valor * 1.08;
			} else if (moneda2.equals("Libra esterlina")) {
				resultado = valor * 0.85;
			} else if (moneda2.equals("Franco Suizo")) {
				resultado = valor * 0.97;
			}
		} else if (moneda1.equals("Libra esterlina")) {
			if (moneda2.equals("Dolar")) {
				resultado = valor * 1.39;
			} else if (moneda2.equals("Euros")) {
				resultado = valor * 1.17;
			} else if (moneda2.equals("Franco Suizo")) {
				resultado = valor * 1.28;
			}
		} else if (moneda1.equals("Franco Suizo")) {
			if (moneda2.equals("Dolar")) {
				resultado = valor * 1.09;
			} else if (moneda2.equals("Euros")) {
				resultado = valor * 0.92;
			} else if (moneda2.equals("Libra esterlina")) {
				resultado = valor * 0.78;
			}
		}

		// Formatear el resultado a dos decimales

		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		String resultadoFormateado = decimalFormat.format(resultado);

		// Mostrar el resultado
		JOptionPane.showMessageDialog(null, valor + " " + moneda1 + " " + "es: " + resultadoFormateado + " " + moneda2);
		return resultado;
	}
}