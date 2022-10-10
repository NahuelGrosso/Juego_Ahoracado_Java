package Main;

import java.util.Random;
import java.util.Scanner;

public class Ahorcado {

	public static void menu() {

		Scanner ingreso = new Scanner(System.in);

		boolean salir = false;

		int opcion;
		System.out.println(" ==================================================== ");
		System.out.println("||    ==> Bienvenido al juego del ahorcado <==      ||");
		System.out.println("||                                                  ||");
		System.out.println(" ==================================================== ");
		while (!salir) {
			System.out.println(" ====================================================");
			System.out.println("||                                                  ||");
			System.out.println("||                    1 - Jugar                     ||");
			System.out.println("||                    2 - Salir                     ||");
			System.out.println("||                                                  ||");
			System.out.println("||            Por favor ingrese la opcion:          ||");
			System.out.println(" ====================================================");
			opcion = ingreso.nextInt();

			switch (opcion) {
			case 1:
				iniciar();
				salir = true;
				break;
			case 2:
				System.out.println("                *******************");
				System.out.println("                * Salio del juego *");
				System.out.println("                *******************");
				salir = true;
				break;
			default:
				System.out.println("           *******************************");
				System.out.println("           * Ingrese una opcion correcta *");
				System.out.println("           *******************************");
				System.out.println(" ");

			}

		}
	}

	public static void iniciar() {
		Scanner ingreso = new Scanner(System.in);
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
		System.out.println(" ");
		System.out.println(" - Puede elegir entre estas dos opciones para que le asignemos el nombre de un vehiculo que usted debera descubrir.");
		System.out.println(" - Tendra 6 intentos para averiguarlo!");
		System.out.println(" - Si utiliza sus 6 intentos y no lo descubre habra perdido el juego!");

		System.out.println("\n" + "-------------------------------------------------------------------------------------------------------------------" + "\n");

		boolean salir = false;

		int opcion;

		while (!salir) {
			System.out.println("         =====================================");
			System.out.println("        || - Opcion 1 => Vehiculos Ford      ||");
			System.out.println("        || - Opcion 2 =>Vehiculos Chevrolet  ||");
			System.out.println("        || - Opcion 3 Volver al menu inicial ||");
			System.out.println("         =====================================");

			// System.out.println("\n" + "Por favor ingrese la opcion: ");
			opcion = ingreso.nextInt();

			switch (opcion) {
			case 1:
				iniciarFord();
				salir = true;
				break;
			case 2:
				iniciarChevrolet();
				salir = true;
				break;
			case 3:
				menu();
				salir = true;
				break;

			default:
				throw new IllegalArgumentException("** ==>or favor ingrese una opcion valida<== **");

			}

		}

	}

	public static void iniciarFord() {

		Scanner usuario = new Scanner(System.in);

		String autoSecreto = getAutoSecreto();

		char[] autoSecretoGuiones = getAutoSecretoGuiones(autoSecreto);

		boolean finDelJuego = false;
		int intentos = 6;
		
		System.out.println(" ===============================");
		System.out.println("|| ► A elegido la marca Ford ◄ ||");
		System.out.println(" ===============================");
		System.out.println(" ");
		
		System.out.println(" =========================================================================================");
		System.out.println("|| El nombre del vehiculo, del cual debe encontrar el nombre, tiene un total de "
				+ autoSecreto.length() + " letras ||");
		System.out.println(" =========================================================================================");
		System.out.println(" ");
		getAutoSecretoGuionesEspacios(                        autoSecreto                        );
		System.out.println(" ");
		

		do {
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ====================================================================");
			System.out.println("|| Tienes " + intentos + " intentos para encontrar las letras o adivinar el nombre ||");
			System.out.println("||                                                                  ||");
			System.out.print("|| El nombre del vehiculo es =>            ");
			System.out.print(autoSecretoGuiones);
			System.out.println(" ");
			System.out.println("_____________________________________________________________________ " + "\n");
			System.out.println(" =====================");
			System.out.println("||Ingrese una letra: ||");
			System.out.println(" =====================");
			System.out.println(" ");

			char letra = usuario.next().charAt(0);

			boolean letraAcertada = false;
			for (int i = 0; i < autoSecreto.length(); i++) {
				if (autoSecreto.charAt(i) == letra) {
					autoSecretoGuiones[i] = letra;
					letraAcertada = true;
				}
				
				System.out.print(autoSecretoGuiones[i] + "|");
			
			}
			if (!letraAcertada) {
				System.out.println(" ");
				System.out.println("*********************************************");
				System.out.println("* La letra '" + letra + "' no se encuentra en el nombre *");
				System.out.println("*********************************************");
				--intentos;
				getDibujo(intentos);
				if (intentos == 0) {
					System.out.println(" ");
					System.out.println("   ***********************************************");
					System.out.println("* Ya no tienes mas intentos! El nombre era: " + autoSecreto + "*");
					System.out.println("   ***********************************************");
					System.out.println(" ");
					System.out.println(" =======================");
					System.out.println("|| ¡Perdiste el juego! ||");
					System.out.println(" =======================");
					finDelJuego = true;
				}
			} else {
				boolean juegoTerminado = !quedanGuiones(autoSecretoGuiones);
				if (juegoTerminado) {
					System.out.println(" ===============================");
					System.out.print("|| El nombre del vehiculo es =>  ");
					System.out.println(autoSecreto + "   <=");
					System.out.println(" ");
					System.out.println(" *-*-*-*-*-*-*-*-*-*-*-* ");
					System.out.println("||  ¡¡FELICITACIONES!! ||");
					System.out.println("||   Ganaste el juego  || ");
					System.out.println(" *-*-*-*-*-*-*-*-*-*-*-*");
					finDelJuego = true;
				}
			}

		} while (!finDelJuego);

		boolean salir = false;

		int opcion;
		System.out.println(" ============================");
		System.out.println("|| ==> Termino el juego <== ||");
		System.out.println(" ============================");

		while (!salir) {
			System.out.println(" ===============================");
			System.out.println("|| Por favor ingrese la opcion ||");
			System.out.println("|| 1 - Para volver a jugar     ||");
			System.out.println("|| 2 - Para salir              ||");
			System.out.println(" ===============================");

			opcion = usuario.nextInt();

			switch (opcion) {
			case 1:
				iniciar();
				salir = true;
				break;
			case 2:
				System.out.println(" ===================");
				System.out.println("|| Salio del juego ||");
				System.out.println(" ===================");
				salir = true;
				break;
			default:
				System.out.println("###############################");
				System.out.println("# Ingrese una opcion correcta #");
				System.out.println("###############################");

			}
		}

	}

	static String getAutoSecreto() {

		String vehiculos[] = { "falcon", "f100", "sierra", "escort", "galaxy", "orion", "ranger", "f150", "f350",
				"f4000", "mondeo", "fiesta", "focus", "ka", "ecosport", "kuga", "maverik", "bronco", "territory" };

		Random eleccionAleatoria = new Random();

		int n = eleccionAleatoria.nextInt(vehiculos.length);

		return vehiculos[n];

	}

	static char[] getAutoSecretoGuiones(String vehiculos) {
		int numLetrasAutoSecreto = vehiculos.length();

		char[] autoSecretoGuiones = new char[numLetrasAutoSecreto];

		for (int i = 0; i < autoSecretoGuiones.length; i++) {
			autoSecretoGuiones[i] = '_';
		}

		return autoSecretoGuiones;

	}

	static boolean quedanGuiones(char[] busqueda) {
		for (char caracter : busqueda) {
			if (caracter == '_')
				return true;
		}
		return false;
	}

	static char[] getAutoSecretoGuionesEspacios(String vehiculos) {
		int numLetrasAutoSecreto = vehiculos.length();

		char[] autoSecretoGuionesEspacios = new char[numLetrasAutoSecreto];

		for (int i = 0; i < autoSecretoGuionesEspacios.length; i++) {
			autoSecretoGuionesEspacios[i] = '_';
		}

		for (int i = 0; i < autoSecretoGuionesEspacios.length; i++) {
			System.out.print(autoSecretoGuionesEspacios[i] + " ");
		}

		return autoSecretoGuionesEspacios;
	}

	static void getDibujo(int intentos) {

		switch (intentos) {
		case 6:
			System.out.println("\r\n" + "			 **************\r\n" + "			 **************\r\n"
					+ "			 **	      *\r\n" + "			 **\r\n" + "			 **\r\n" + "			 **\r\n"
					+ "		         **\r\n" + "		         **\r\n" + "		    **************\r\n"
					+ "		    ************** ");

			break;
		case 5:
			System.out.println("\r\n" + "		        **************\r\n" + "      	   	        **************\r\n"
					+ "			**	     *\r\n" + "			**	     Ｏ\r\n" + "			**\r\n" + "			**	\r\n"
					+ "	     	        **\r\n" + "		    	**\r\n" + "		 ***************\r\n"
					+ "		 ***************");

			break;
		case 4:
			System.out.println("\r\n" + "		        **************\r\n" + "      	   	        **************\r\n"
					+ "			**	     *\r\n" + "			**	     Ｏ\r\n" + "			**          [|]\r\n"
					+ "			**	\r\n" + "	     	        **\r\n" + "		    	**\r\n"
					+ "		 ***************\r\n" + "		 ***************");

			break;
		case 3:
			System.out.println("\r\n" + "		        **************\r\n" + "      	   	        **************\r\n"
					+ "			**	     *\r\n" + "			**	     Ｏ\r\n" + "			**        _/[|]\r\n"
					+ "			**	\r\n" + "	     	        **\r\n" + "		    	**\r\n"
					+ "		 ***************\r\n" + "		 ***************");

			break;
		case 2:
			System.out.println("\r\n" + "		        **************\r\n" + "      	   	        **************\r\n"
					+ "			**	     *\r\n" + "			**	     Ｏ\r\n" + "			**        _/[|]\\_\r\n"
					+ "			**	\r\n" + "	     	        **\r\n" + "		    	**\r\n"
					+ "		 ***************\r\n" + "		 ***************");

			break;
		case 1:
			System.out.println("\r\n" + "		        **************\r\n" + "      	   	        **************\r\n"
					+ "			**	     *\r\n" + "			**	     Ｏ\r\n" + "			**        _/[|]\\_\r\n"
					+ "			**	    /\r\n" + "	     	        **          |\r\n" + "		    	**\r\n"
					+ "		 ***************\r\n" + "		 ***************");

			break;
		case 0:
			System.out.println("\r\n" + "		        **************\r\n" + "      	   	        **************\r\n"
					+ "			**	     *\r\n" + "			**	     Ｏ\r\n" + "			**        _/[|]\\_\r\n"
					+ "			**	    / \\\r\n" + "	     	        **          | |\r\n" + "		    	**\r\n"
					+ "		 ***************\r\n" + "		 ***************");

			break;

		default:
			System.out.println(
					"Las mujeres son como un refrigerador, de 1.70 de alto, hacen hielo, no, mejor las mujeres son como una cerveza, huelen bien, saben bien, y no puedes tener solo una. ¡Quiero otra mujer!");
			System.out.println(
					"...y entonces le dije... si quieres tu dinero... pues ven por el porque yo no se dondÃ© estÃ¡ la brusela cumache este que... aghh!!!");
			System.out.println(
					"Tal vez habla la cerveza, Marge, pero tienes un cuerpo de lujo! Aquí venden unos bocadillos deliciosos, pero.. ¿Qué? ¿5 dólares? ¡Que se vayan al diablo!!!");
		}

	}

	public static void iniciarChevrolet() {
		Scanner usuario = new Scanner(System.in);

		String autoSecretoC = getAutoSecretoC();

		char[] autoSecretoGuionesC = getAutoSecretoGuionesC(autoSecretoC);

		boolean finDelJuego = false;
		int intentosC = 6;

		System.out.println(" ====================================");
		System.out.println("|| ► A elegido la marca Chevrolet ◄ ||");
		System.out.println(" ====================================");
		System.out.println(" ");
		
		System.out.println(" =========================================================================================");
		System.out.println("|| El nombre del vehiculo, del cual debe encontrar el nombre, tiene un total de "
				+ autoSecretoC.length() + " letras ||");
		System.out.println(" =========================================================================================");
		System.out.println(" ");
		getAutoSecretoGuionesEspaciosC(autoSecretoC);
		System.out.println(" ");
		
		do {
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ====================================================================");
			System.out.println("|| Tienes " + intentosC + " intentos para encontrar las letras o adivinar el nombre:");
			System.out.println("||                                                                  ||");
			System.out.print("El nombre del vehiculo es => ");
			System.out.print(autoSecretoGuionesC);
			System.out.println(" ");
			System.out.println("______________________________________________ " + "\n");
			System.out.println(" =====================");
			System.out.println("||Ingrese una letra: ||");
			System.out.println(" =====================");
			System.out.println(" ");

			char letra = usuario.next().charAt(0);

			boolean letraAcertadaC = false;
			for (int i = 0; i < autoSecretoC.length(); i++) {
				if (autoSecretoC.charAt(i) == letra) {
					autoSecretoGuionesC[i] = letra;
					letraAcertadaC = true;
				}
				
				System.out.print(autoSecretoGuionesC[i] + "|");
				
			}
			if (!letraAcertadaC) {
				System.out.println(" ");
				System.out.println("*********************************************");
				System.out.println("* La letra '" + letra + "' no se encuentra en el nombre *");
				System.out.println("*********************************************");
				--intentosC;
				getDibujoC(intentosC);
				if (intentosC == 0) {
					System.out.println(" ");
					System.out.println("   ***********************************************");
					System.out.println("* Ya no tienes mas intentos! El nombre era: " + autoSecretoC + "*");
					System.out.println("   ***********************************************");
					System.out.println(" ");
					System.out.println(" =======================");
					System.out.println("|| ¡Perdiste el juego! ||");
					System.out.println(" =======================");
					finDelJuego = true;
				}
			} else {
				boolean juegoTerminado = !quedanGuionesC(autoSecretoGuionesC);
				if (juegoTerminado) {
					System.out.println(" ===============================");
					System.out.print("|| El nombre del vehiculo es =>  ");
					System.out.println(autoSecretoC + "   <=");
					System.out.println(" ");
					System.out.println(" *-*-*-*-*-*-*-*-*-*-*-* ");
					System.out.println("||  ¡¡FELICITACIONES!! ||");
					System.out.println("||   Ganaste el juego  || ");
					System.out.println(" *-*-*-*-*-*-*-*-*-*-*-*");
					finDelJuego = true;
				}
			}

		} while (!finDelJuego);

		boolean salir = false;

		int opcion;
		System.out.println(" ============================");
		System.out.println("|| ==> Termino el juego <== ||");
		System.out.println(" ============================");

		while (!salir) {
			System.out.println(" ===============================");
			System.out.println("|| Por favor ingrese la opcion ||");
			System.out.println("|| 1 - Para volver a jugar     ||");
			System.out.println("|| 2 - Para salir              ||");
			System.out.println(" ===============================");


			opcion = usuario.nextInt();

			switch (opcion) {
			case 1:
				iniciar();
				salir = true;
				break;
			case 2:
				System.out.println(" ===================");
				System.out.println("|| Salio del juego ||");
				System.out.println(" ===================");
				salir = true;
				break;
			default:
				System.out.println("###############################");
				System.out.println("# Ingrese una opcion correcta #");
				System.out.println("###############################");
			}
		}

		usuario.close();

	}

	static String getAutoSecretoC() {

		String vehiculosC[] = { "c10", "d20", "c20", "silverado", "corsa", "tracker", "onix", "aveo", "spark", "cruce",
				"captiva", "prisma", "blazer", "meriva", "montana", "sonic", "spin", "\r\n" + "trailblazer", "vectra",
				"zafira" };
		Random eleccionAleatoriaC = new Random();

		int n = eleccionAleatoriaC.nextInt(vehiculosC.length);

		return vehiculosC[n];

	}

	static char[] getAutoSecretoGuionesC(String vehiculosC) {
		int numLetrasAutoSecretoC = vehiculosC.length();

		char[] autoSecretoGuionesC = new char[numLetrasAutoSecretoC];

		for (int i = 0; i < autoSecretoGuionesC.length; i++) {
			autoSecretoGuionesC[i] = '_';
		}

		return autoSecretoGuionesC;

	}

	static boolean quedanGuionesC(char[] busquedaC) {
		for (char caracterC : busquedaC) {
			if (caracterC == '_')
				return true;
		}
		return false;
	}

	static char[] getAutoSecretoGuionesEspaciosC(String vehiculosC) {
		int numLetrasAutoSecretoC = vehiculosC.length();

		char[] autoSecretoGuionesEspaciosC = new char[numLetrasAutoSecretoC];

		for (int i = 0; i < autoSecretoGuionesEspaciosC.length; i++) {
			autoSecretoGuionesEspaciosC[i] = '_';
		}

		for (int i = 0; i < autoSecretoGuionesEspaciosC.length; i++) {
			System.out.print(autoSecretoGuionesEspaciosC[i] + " ");
		}

		return autoSecretoGuionesEspaciosC;
	}

	static void getDibujoC(int intentosC) {

		switch (intentosC) {
		case 6:
			System.out.println("\r\n" + "			 **************\r\n" + "			 **************\r\n"
					+ "			 **	      *\r\n" + "			 **\r\n" + "			 **\r\n" + "			 **\r\n"
					+ "		         **\r\n" + "		         **\r\n" + "		    **************\r\n"
					+ "		    ************** ");

			break;
		case 5:
			System.out.println("\r\n" + "		        **************\r\n" + "      	   	        **************\r\n"
					+ "			**	     *\r\n" + "			**	     Ｏ\r\n" + "			**\r\n" + "			**	\r\n"
					+ "	     	        **\r\n" + "		    	**\r\n" + "		 ***************\r\n"
					+ "		 ***************");

			break;
		case 4:
			System.out.println("\r\n" + "		        **************\r\n" + "      	   	        **************\r\n"
					+ "			**	     *\r\n" + "			**	     Ｏ\r\n" + "			**          [|]\r\n"
					+ "			**	\r\n" + "	     	        **\r\n" + "		    	**\r\n"
					+ "		 ***************\r\n" + "		 ***************");

			break;
		case 3:
			System.out.println("\r\n" + "		        **************\r\n" + "      	   	        **************\r\n"
					+ "			**	     *\r\n" + "			**	     Ｏ\r\n" + "			**        _/[|]\r\n"
					+ "			**	\r\n" + "	     	        **\r\n" + "		    	**\r\n"
					+ "		 ***************\r\n" + "		 ***************");

			break;
		case 2:
			System.out.println("\r\n" + "		        **************\r\n" + "      	   	        **************\r\n"
					+ "			**	     *\r\n" + "			**	     Ｏ\r\n" + "			**        _/[|]\\_\r\n"
					+ "			**	\r\n" + "	     	        **\r\n" + "		    	**\r\n"
					+ "		 ***************\r\n" + "		 ***************");

			break;
		case 1:
			System.out.println("\r\n" + "		        **************\r\n" + "      	   	        **************\r\n"
					+ "			**	     *\r\n" + "			**	     Ｏ\r\n" + "			**        _/[|]\\_\r\n"
					+ "			**	    /\r\n" + "	     	        **          |\r\n" + "		    	**\r\n"
					+ "		 ***************\r\n" + "		 ***************");

			break;
		case 0:
			System.out.println("\r\n" + "		        **************\r\n" + "      	   	        **************\r\n"
					+ "			**	     *\r\n" + "			**	     Ｏ\r\n" + "			**        _/[|]\\_\r\n"
					+ "			**	    / \\\r\n" + "	     	        **          | |\r\n" + "		    	**\r\n"
					+ "		 ***************\r\n" + "		 ***************");

			break;

		default:
			System.out.println(
					"Las mujeres son como un refrigerador, de 1.70 de alto, hacen hielo, no, mejor las mujeres son como una cerveza, huelen bien, saben bien, y no puedes tener solo una. ¡Quiero otra mujer!");
			System.out.println(
					"...y entonces le dije... si quieres tu dinero... pues ven por el porque yo no se dondÃ© estÃ¡ la brusela cumache este que... aghh!!!");
			System.out.println(
					"Tal vez habla la cerveza, Marge, pero tienes un cuerpo de lujo! Aquí venden unos bocadillos deliciosos, pero.. ¿Qué? ¿5 dólares? ¡Que se vayan al diablo!!!");
		}

	}

	public static void main(String[] args) {

		menu();
		iniciar();
		iniciarFord();
		iniciarChevrolet();

	}

}
