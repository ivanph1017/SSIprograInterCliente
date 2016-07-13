package beans;


public class Distrito {
	
	private int id;
	private String nombre;
	private int poblacion;
	private Provincia provincia;

	public Distrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Distrito(int id, String nombre, int poblacion, Provincia provincia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.provincia = provincia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	
}
