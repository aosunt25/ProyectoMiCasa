package proveedores;

public class Proveedor{


	private String nombre;
	private int id;
	private String telefono;

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

	public String getTelefono(){
		return telefono;
	}

	public void setTelefono(String tel){
		telefono = tel;
	}

}
