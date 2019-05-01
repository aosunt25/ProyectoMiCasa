package ventas;

public class Venta{
	private String fecha;
	private String hora;
	private int id;
	private double precioTot;

	public String getFecha(){
		return fecha;
	}

	public void setFecha(String fech ){
		fecha=fech;
	}
		
	public String getHora(){
		return hora;
	}

	public void setHora(String tim ){
		hora=tim;
	}

	public int getId(){
		return id;
	}

	public void setId(int i){
		id = i;
	}
		
	public double getPrecioTot(){
		return precioTot;
	}

	public void setPrecioTot(double i){
		precioTot = i;
	}
}
