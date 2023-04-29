package gestion;

/**
 * Clase princpal, con la que arranca el programa
 * y tiene la logica del menu principal.
 * 
 * @author Raul SG
 *
 */
public class Main {
	
	/**
	 * Metodo inicial del programa. 
	 * Segun las opciones que seleccione el usuario se relizara una
	 * opcion u otra.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		boolean salir=false;
		Tienda miTienda=new Tienda();
		//Creamos el menu principal del programa
		while(!salir) {
			int eleccion= menuPrincipal();//Variable para almacenar la opcion elegida por el usuario
			switch (eleccion) {//En funcion de la opcion elegida por el usuario
			case 1->miTienda.cargarPrueba1();
			case 2->miTienda.cargarPrueba2();
			case 3->{
				int numero1=menuIntercambiar();//Pedimos una posicion entre 1 y 5
				int numero2=menuIntercambiar();//Pedimos otra posicion entre 1 y 5
				miTienda.intercambiarPosiciones(numero1, numero2);
			}
			case 4-> System.out.println(miTienda.getArticulosMasCaro());
			case 5-> salir=true;//Hemos añadido esta opcion extra
			}
		}
	}

	/**
	 * Se le solicita al usuario un numero entre 1 y 5, el cual
	 * representa la posicion del objeto que se quiere intercambiar
	 * en la array.
	 * 
	 * @return int. Posicion entre 0 y 4, ya que se le resta uno a
	 * la opcion elegida por el usuario para que se pueda elegir en una array.
	 * 
	 */
	private static int menuIntercambiar() {
		int numero=MenuUsuario.elegirInt("Elige una posicion para intercambiar");
		while(numero<1 || numero>5) {//Si la opcion esta fuera del rango
			numero=MenuUsuario.elegirInt("Elige una posicion para intercambiar");
		}
		return numero-1;//Se pide al usuario una posicion empeando por el 1, por eso
		//luego se le resta 1, ya que las arrays empiezan en 0
	}

	/**
	 * Metodo que le muestra al usuario las opciones principales del programa, y 
	 * lee la opcion seleccionada.
	 * @return
	 */
	private static int menuPrincipal() {
		//Creamos el menu principal del programa
				MenuUsuario menuPrincipal=new MenuUsuario("¿Que desea realizar?");
				int eleccion;//Variable para almacenar la opcion elegida por el usuario
				menuPrincipal.addOpcion("Cargar datos de prueba 1");
				menuPrincipal.addOpcion("Cargar datos de prueba 2");
				menuPrincipal.addOpcion("Intercambiar articulos");
				menuPrincipal.addOpcion("Buscar el articulo mas caro");
				menuPrincipal.addOpcion("salir");//No se pide, pero lo hemos puesto
				eleccion=menuPrincipal.elegirOpcion();
				return eleccion;
	}

}
