public class Post implements Comparable<Post> {
    private Autor autor;
    private String titulo;
    private String conteudo;
    private Categorias categoria;

    public Post(Autor autor, String titulo, String conteudo, Categorias categoria) {
        this.autor = autor;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return titulo;
    }

    @Override
    public int compareTo(Post outro) {
        return this.titulo.compareTo(outro.titulo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Post post = (Post) o;
        return autor.equals(post.autor) && titulo.equals(post.titulo);
    }

    @Override
    public int hashCode() {
        return 31 * autor.hashCode() + titulo.hashCode();
    }

    public Autor getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public Categorias getCategoria() {
        return categoria;
    }
}
