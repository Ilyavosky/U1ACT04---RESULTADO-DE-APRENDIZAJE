package models;

public class Leccion implements Comparable<Leccion> {
    private String titulo;
    private String tema;
    private String nivel;
    private Integer id;
    private Character clasificacion;

    public Leccion(){}

    public Leccion(String titulo, String tema, String nivel, Integer id, Character clasificacion) {
        this.titulo = titulo;
        this.tema = tema;
        this.nivel = nivel;
        this.id = id;
        this.clasificacion = clasificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Character clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Override
    public String toString() {
        return this.titulo + " - " + this.tema + " - " + this.nivel + " - " + this.id + " - " + this.clasificacion;
    }

    @Override
    public int compareTo(Leccion otraLeccion) {
        return this.titulo.compareTo(otraLeccion.titulo);
    }
}