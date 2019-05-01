package escuela;

public class Alumno{

	private String nombre;
	private int edad;
	private String matricula;
	private String carrera;

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String a){
		nombre=a;
	}

	public String getMatricula(){
		return matricula;
	}

	public void setMatricula(String a){
		matricula=a;
	}

	public String getCarrera(){
		return carrera;
	}

	public void setCarrera(String a){
		carrera=a;
	}

	public int getEdad(){
		return edad;
	}

	public void setEdad(int a){
		edad=a;
	}

}
