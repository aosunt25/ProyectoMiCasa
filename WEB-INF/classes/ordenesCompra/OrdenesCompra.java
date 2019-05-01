package ordenesCompra;

public class OrdenesCompra{


	private String proveedor;
	private int id;
	private String usuario;
	private int cantidad_juguete;
	private double cantidad_total;
	private String fechaEntrega;
	private String fechaPedido;

	public String getProveedor(){
		return proveedor;
	}

	public void setProveedor(String a){
		proveedor=a;
	}

	public double getCantidad_total(){
		return cantidad_total;
	}

	public void setCantidadTotal(double can){
		cantidad_total=can;
	}

	public int getId(){
		return id;
	}

	public void setId(int i){
		id = i;
	}
	public int getCantidad_juguete(){
		return cantidad_juguete;
	}

	public void setCantidadJug(int cj){
		cantidad_juguete = cj;
	}

	public String getUsuario(){
		return usuario;
	}

	public void setUsuario(String us){
		usuario = us;
	}
	public String getFechaEntrega(){
		return fechaEntrega;
	}

	public void setFechaEntrega(String con){
		fechaEntrega = con;
	}
	public String getFechaPedido(){
		return fechaPedido;
	}

	public void setFechaPedido(String con){
		fechaPedido = con;
	}

}
