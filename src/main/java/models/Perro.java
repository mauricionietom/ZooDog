package models;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "perro")
@XmlAccessorType(XmlAccessType.FIELD)
public class Perro {
    private String puesto;
    private String raza;
    private String personalidad;
    private String energia;
    private String descripcion;

    public Perro(){};
    public Perro(String puesto, String raza, String personalidad, String energia, String descripcion) {
        this.puesto = puesto;
        this.raza = raza;
        this.personalidad = personalidad;
        this.energia = energia;
        this.descripcion = descripcion;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getPersonalidad() {
        return personalidad;
    }

    public void setPersonalidad(String personalidad) {
        this.personalidad = personalidad;
    }

    public String getEnergia() {
        return energia;
    }

    public void setEnergia(String energia) {
        this.energia = energia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
