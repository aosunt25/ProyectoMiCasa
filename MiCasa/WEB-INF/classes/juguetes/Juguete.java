package juguetes;

public class Juguete{

	private String nombre;
	private String nombreProveedor;
	private int id;
	private String categoria;
	private String descripcion;
	private double precio_proveedor;
	private double precio;
	private int cantidad;
	//ID proveedor? private int id

	public double getPrecio_proveedor(){
		return precio_proveedor;
	}

	public void setPrecioProv(double preprov){
		precio_proveedor = preprov;
	}

	public double getPrecio(){
		return precio;
	}

	public void setPrecio(double pre){
		precio = pre;
	}
	
	public String getDescripcion(){
		return descripcion;
	}

	public void setDescripcion(String desc){
		descripcion = desc;
	}

	public String getCategoria(){
		return categoria;
	}

	public void setCategoria(String cat){
		categoria = cat;
	}

	public int getCantidad(){
		return cantidad;
	}

	public void setCantidad(int cant){
		cantidad = cant;
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String a){
		nombre=a;
	}

	public int getId(){
		return id;
	}

	public void setID(int i){
		id = i;
	}
	public void setNombreProveedor(String np){
		nombreProveedor=np;
	}
	public String getNombreProveedor(){
		return nombreProveedor;
	}


}
