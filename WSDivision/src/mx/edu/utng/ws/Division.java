package mx.edu.utng.ws;

public class Division {
private int id;
private String nombre;
private String abreviatura;
private int activo;
private String unidadAcademica;


public Division(int id, String nombre, String abreviatura, int activo, String unidadAcademica) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.abreviatura = abreviatura;
	this.activo = activo;
	this.unidadAcademica = unidadAcademica;
}
public Division(){
	this(0,"","",0,"");
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
public String getAbreviatura() {
	return abreviatura;
}
public void setAbreviatura(String abreviatura) {
	this.abreviatura = abreviatura;
}
public int getActivo() {
	return activo;
}
public void setActivo(int activo) {
	this.activo = activo;
}
public String getUnidadAcademica() {
	return unidadAcademica;
}
public void setUnidadAcademica(String unidadAcademica) {
	this.unidadAcademica = unidadAcademica;
}
@Override
public String toString() {
	return "Division [id=" + id + ", nombre=" + nombre + ", abreviatura=" + abreviatura + ", activo=" + activo
			+ ", unidadAcademica=" + unidadAcademica + "]";
}


}
