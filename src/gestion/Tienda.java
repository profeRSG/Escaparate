package gestion;

import java.time.LocalDate;

import model.Articulo;
import model.ArticuloRebajado;

/**
 * Clase utilizada para gestionar una tienda con un esparate.
 * 
 * @author Raul SG
 *
 */
public class Tienda {
	
	//ATRIBUTOS
	private Articulo[] escaparate;//Ya que tenemos solo una tienda,
	//se podria haber hecho tambien, que el atributo fuera estatico. era
	//otra opcion.

	//METODOS

	//Constructores
	public Tienda() {
		escaparate=new Articulo[5];
	}

	/**
	 * Metodo que intercambia los articulos que se encuentra en la posicion 1
	 * y posicion2
	 * 
	 * @param posicion1 indice del primer objeto que se quiere intercambiar
	 * @param posicion2 indice del segundo objeto que se quiere intercambiar
	 */
	public void intercambiarPosiciones(int posicion1,int posicion2) {
		Articulo auxiliar=escaparate[posicion1];//Guardamos 
		//en una variable auxiliar el articulo de la posocion 1, ya que
		//sino se perderia su valor
		escaparate[posicion1]=escaparate[posicion2];//En la posocion1 guardamos lo
		//que hay en la posicion2. Notese que ahora hay lo mismo
		//En la poscion 1 y 2
		escaparate[posicion2]=auxiliar;//En la poscion2 guardamos lo que habia
		//al principio en la posicion1
	}

	/**
	 * Metodo que devuelve el articulo mas caro
	 * 
	 * @return articulo con el precioFinal mas elevado
	 */
	public Articulo getArticulosMasCaro() {
		Articulo articuloMasCaro=null;//Inicialmente el precio mas caro es ninguno (null)
		double precioMasCaro=-1;//Partimo de un precio negativo
		for(Articulo a:escaparate) {//Recorremos todo los articulos del escaparate con un for each
			if(a!=null) {//Si no es un hueco
				double precioFinalArticulo=a.getPrecioFinal();//Obtenemos su precio final
				if(precioFinalArticulo>precioMasCaro) {//Si este es mayor que lo que llevamos hasta ahora
					articuloMasCaro=a;//El articulo pasa a ser el articulo mas caro
					precioMasCaro=precioFinalArticulo;//Su precio es ahora el mas caro detectado hasta el momento.
				}
			}
		}
		return articuloMasCaro;//Devolvemos el articulo detectado como el mas caro
	}

	/**
	 * Cargamos los datos de prueba 1
	 */
	public void cargarPrueba1() {
		escaparate[0]=new Articulo("Gorra",120);//Posicion primera
		escaparate[1]=new Articulo("Casco Kri",200);
		escaparate[2]=new Articulo("Ventilador 12",45);
		escaparate[3]=null;
		escaparate[4]=new ArticuloRebajado("Colonia HGM", 120, 50, LocalDate.of(2023, 4, 24));
	}

	/**
	 * Cargamos los datos de prueba 2
	 */
	public void cargarPrueba2() {
		escaparate[0]=new ArticuloRebajado("Colonia HGM", 120, 60, LocalDate.of(2023, 4, 24));
		//Posicion primera
		escaparate[1]=null;
		escaparate[2]=new ArticuloRebajado("Botella Deluxe Edition", 200, 10, LocalDate.of(2025, 4, 23));
		escaparate[3]=new ArticuloRebajado("Lavabo RTD", 300, 60, LocalDate.of(2023, 4, 18));
		escaparate[4]=null;
	}

}
