package usuarios;

public class Usuario{


	private String nombre;
	private int id;
	private String usuario;
	private String contraseña;

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String a){
		nombre=a;
	}

	public int getID(){
		return id;
	}

	public void setID(int i){
		id = i;
	}

	public String getUsuario(){
		return usuario;
	}

	public void setUsuario(String us){
		usuario = us;
	}
	public String getContraseña(){
		return contraseña;
	}

	public void setContraseña(String con){
		contraseña = con;
	}

}
