public class Leccion {
    private String titulo;
    private String tema;
    private String nivel;

    public Leccion(){}

    public Leccion(String titulo, String tema, String nivel) {
        this.titulo = titulo;
        this.tema = tema;
        this.nivel = nivel;
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

}