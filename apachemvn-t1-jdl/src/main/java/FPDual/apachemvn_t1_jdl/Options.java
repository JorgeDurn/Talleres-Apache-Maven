package FPDual.apachemvn_t1_jdl;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

/**
 * Clase que contienes las opcines para generar el código QR
 */
public class Options {

	// Variable privada para guardar el escaner
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Metodo para imprimir el menu de opciones
	 */
	public void options() {

		// variable que controla las opciones del switch y do-while
		int option;

		do {
			System.out.println("Opción 0 - Salir");
			System.out.println("Opción 1 - Generar QR por defecto");
			System.out.println("Opción 2 - Generar QR con nuevos datos \n");
			option = sc.nextInt();

			switch (option) {
			case 0:
				System.out.println("\nAdióss");
				break;
			case 1:
				createQr("Jorge Durán Librero");
				break;
			case 2:
				newName();
				break;
			default:
				System.out.println("\nNúmero incorrecto\n");
				break;
			}

		} while (option != 0);
	}

	/**
	 * Metodo para generar un QR a partir de nuevos datos
	 */
	public static void newName() {

		System.out.println("\n¿Que quieres poner? \n");

		String name = sc.next();

		createQr(name);
	}

	/**
	 * Genera el codigo qr y lo transfiere a una imagen
	 * 
	 * @param data - recibe los datos que tendra el QR
	 */
	public static void createQr(String data) {

		// Codifica la variable data en un BitMatrix que representa el código QR y
		// escribe el BitMatrix en un archivo de imagen con formato png en la ruta
		// indicada, controlando las excepciones WriterException y IOException

		try {
			BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, 500, 500);
			MatrixToImageWriter.writeToPath(matrix, "png", Paths.get("./qr.png"));

			System.out.println("\nCódigo QR generado correctamente. \n");

		} catch (WriterException | IOException e) {

			System.out.println(e);

		}
	}
}
