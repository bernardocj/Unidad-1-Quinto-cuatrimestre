package wsdivision.utng.edu.mx.wsdivision;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;


public class Division implements KvmSerializable {
    private int id;
    private String nombre;
    private String abreviatura;
    private int activo;
    private String unidadAcademica;

    public Division(int id, String nombre, String abreviatura, String unidadAcademica, int activo) {
        this.id = id;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.activo = activo;
        this.unidadAcademica = unidadAcademica;
    }

    public Division() {
        this(0,"","","",0);
    }

    @Override
    public Object getProperty(int i) {
        switch (i){
            case 0:
                return  id;
            case 1:
                return  nombre;
            case 2:
                return  abreviatura;
            case 3:
                return  unidadAcademica;
            case 4:
                return  activo;

        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 5;
    }

    @Override
    public void setProperty(int i, Object o) {
        switch (i){
            case 0:
                id= Integer.parseInt(o.toString());
                break;
            case 1:
                nombre=o.toString();
                break;
            case 2:
                abreviatura=o.toString();
                break;
            case 3:
                unidadAcademica= o.toString();
                break;
            case 4:
                activo= Integer.parseInt(o.toString());
                break;
            default:
                break;
        }

    }

    @Override
    public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo propertyInfo) {
        switch (i){
            case 0:
                propertyInfo.type=PropertyInfo.INTEGER_CLASS;
                propertyInfo.name="id";
                break;
            case 1:
                propertyInfo.type=PropertyInfo.STRING_CLASS;
                propertyInfo.name="nombre";
                break;
            case 2:
                propertyInfo.type=PropertyInfo.STRING_CLASS;
                propertyInfo.name="abreviatura";
                break;

            case 3:
                propertyInfo.type=Float.class;
                propertyInfo.name="unidadAcademica";
                break;
            case 4:
                propertyInfo.type=PropertyInfo.INTEGER_CLASS;
                propertyInfo.name="activo";
                break;

            default:
                break;
        }

    }
}
