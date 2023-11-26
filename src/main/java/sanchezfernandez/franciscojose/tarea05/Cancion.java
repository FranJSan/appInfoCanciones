package sanchezfernandez.franciscojose.tarea05;

/**
 * La clase Canción contiene los atributos necesarios para toda la información requerida para la tarea.
 * También contiene los métodos getters y setters y los constructores.
 */
public class Cancion {
    private String titulo;
    private String autor;
    private String disco;
    private String url;
    private String urlYT;
    private int year;
    private int codigo;
    private int foto;

    public Cancion() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Cancion(String titulo, String autor, String disco, String url, String urlYT, int year, int codigo, int foto) {
        this.titulo = titulo;
        this.autor = autor;
        this.disco = disco;
        this.url = url;
        this.urlYT = urlYT;
        this.year = year;
        this.codigo = codigo;
        this.foto = foto;
    }

    public String getUrlYT() {
        return urlYT;
    }

    public void setUrlYT(String urlYT) {
        this.urlYT = urlYT;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
