package model;

import java.util.Objects;

/**
 * Clase para representar los articulos de la tienda
 * 
 * @author Raul SG
 *
 */
public class Articulo {

	//ATRIBUTOS
	private String nombre;//Nombre del articulo
	private double precioBase;//Precio sin IVA del articulo
	//El precio final es un atributo derivado
	//por lo que no tiene que estar aqui
	public static final double IVA = 0.21; //Constante. Un 21%
	
	//METODOS
	
	//Constructores
	
	/**
	 * Constructor con parametros
	 * 
	 * @param nombre Nombre del articulo
	 * @param precioBase Precio base del articulo
	 */
	public Articulo(String nombre, double precioBase) {
		this.nombre=nombre;
		this.precioBase=precioBase;
	}
	
	public Articulo() {
		this.nombre="Articulo de prueba";
		this.precioBase=0;
	}

	//Setters y Getters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	//Equals
	@Override
	public boolean equals(Object obj) { //un articulo se considera igual a otro
		//si tiene el mismo codigo
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	//ToString
	@Override
	public String toString() {
		String resultado="Nombre: "+this.getNombre()+"\n"+
				"Precio Base: "+this.getPrecioBase()+"\n"+
				"Precio Final: "+this.getPrecioFinal();
		return resultado;
	}
	
	/**
	 * Metodo para calcular el precio final del articulo. El precio final
	 * es un atributo derivado, que depende del precio base, por ello
	 * solo tiene un metodo get.
	 * 
	 * @return el precio base mas el IVA
	 */
	public double getPrecioFinal() {
		return precioBase+precioBase*IVA; //El precio final es el precio base, mas su 21%.

	} 
	
	
	
}
