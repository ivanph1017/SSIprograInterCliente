package beans;


public class Pais {
	
	private int id;	
	private String nombre;
	private int poblacion;
	private float pbi;

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

	public float getPbi() {
		return pbi;
	}

	public void setPbi(float pbi) {
		this.pbi = pbi;
	}

	public Pais(int id, String nombre, int poblacion, float pbi) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.pbi = pbi;
	}

	public Pais() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
