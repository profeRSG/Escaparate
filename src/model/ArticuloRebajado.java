package model;

import java.time.LocalDate;

/**
 * Clase utilizada representar un tipo especial de articulos, los cuales
 * tienen rebajas. Es por ello que hereda de Articulo, porque los Articulos Rebajados son
 * articulos, pero con mas información, y con un prefio final diferente.
 * 
 * @author Raul SG
 *
 */
public class ArticuloRebajado extends Articulo{

	//ATRIBUTOS
	private double descuento;//Valor que se decuenta
	private LocalDate fechaAplicacionDescuento;//Fecha en la que se aplica el descuento



	//METODOS

	//Constructor
	public ArticuloRebajado(String nombre, double precioBase, double descuento, LocalDate fechaAplicacionDescuento) {
		super(nombre, precioBase);
		this.descuento = descuento;
		this.fechaAplicacionDescuento = fechaAplicacionDescuento;
	}

	public ArticuloRebajado() {
		super();
		this.descuento = 0;
		this.fechaAplicacionDescuento = LocalDate.now();
	}

	//Setters y Getters
	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public LocalDate getFechaAplicacionDescuento() {
		return fechaAplicacionDescuento;
	}

	public void setFechaAplicacionDescuento(LocalDate fechaAplicacionDescuento) {
		this.fechaAplicacionDescuento = fechaAplicacionDescuento;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticuloRebajado other = (ArticuloRebajado) obj;
		return getNombre().equals(other.getNombre());
	}

	//ToString
	@Override
	public String toString() {
		String resultado=super.toString()+
				"\nDescuento: "+this.getDescuento()+"\n"+
				"Fecha de apliación del descuento: "+this.getFechaAplicacionDescuento()+"\n";
		return resultado;
	}

	/**
	 * Metodo que sobreescibre el metodo del padre. En este caso el precio final 
	 * de un articulo rebajado, va a ser igual al precio final de un
	 * articulo normal, excepto si nos encontramos
	 * en la fecha en la que se aplica el descuento, que en tal caso, seria igual
	 * al precio final menos el descuento.
	 * 
	 * @return double, precio final.
	 */
	@Override
	public double getPrecioFinal() {
		double resultado=super.getPrecioFinal();
		if(fechaAplicacionDescuento.equals(LocalDate.now())) {//Si la fecha coindice con la fecha del dia de hoy
			resultado=resultado-descuento;//Le quitamos el descuento
		}

		return resultado;
	}
}
