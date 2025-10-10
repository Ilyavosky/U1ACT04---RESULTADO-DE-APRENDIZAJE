package models;

import utils.Filtrable;

public class Post implements Comparable<Post>, Filtrable {
    private String titulo;
    private String contenido;
    private String categoria;
    private Integer id;
    private Integer likes;

    public Post() {}

    public Post(String titulo, String contenido, String categoria, Integer id, Integer likes) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.categoria = categoria;
        this.id = id;
        this.likes = likes != null ? likes : 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public boolean cumpleFiltro(String criterio) {
        if (criterio == null || criterio.trim().isEmpty()) {
            return true;
        }
        String criterioBusqueda = criterio.toLowerCase();
        return (titulo != null && titulo.toLowerCase().contains(criterioBusqueda)) ||
                (contenido != null && contenido.toLowerCase().contains(criterioBusqueda)) ||
                (categoria != null && categoria.toLowerCase().contains(criterioBusqueda));
    }

    @Override
    public int compareTo(Post otro) {
        return this.titulo.compareTo(otro.titulo);
    }

    @Override
    public String toString() {
        return this.titulo + " - " + this.categoria + " - " + this.id + " - Likes: " + this.likes;
    }
}