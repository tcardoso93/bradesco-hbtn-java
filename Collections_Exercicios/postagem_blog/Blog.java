import java.util.*;

public class Blog {
    private Set<Post> posts;

    public Blog() {
        this.posts = new HashSet<>();
    }

    public void adicionarPostagem(Post post) {
        if (!posts.add(post)) {
            throw new IllegalArgumentException("Postagem jah existente");
        }
    }

    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<>();
        for (Post post : posts) {
            autores.add(post.getAutor());
        }
        return autores;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new TreeMap<>();
        for (Post post : posts) {
            contagem.merge(post.getCategoria(), 1, Integer::sum);
        }
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> postsAutor = new TreeSet<>();
        for (Post post : posts) {
            if (post.getAutor().equals(autor)) {
                postsAutor.add(post);
            }
        }
        return postsAutor;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> postsCategoria = new TreeSet<>();
        for (Post post : posts) {
            if (post.getCategoria() == categoria) {
                postsCategoria.add(post);
            }
        }
        return postsCategoria;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> postsPorCategoria = new TreeMap<>();
        for (Categorias categoria : Categorias.values()) {
            postsPorCategoria.put(categoria, new TreeSet<>());
        }

        for (Post post : posts) {
            postsPorCategoria.get(post.getCategoria()).add(post);
        }
        return postsPorCategoria;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> postsPorAutor = new TreeMap<>();
        for (Post post : posts) {
            postsPorAutor.computeIfAbsent(post.getAutor(), k -> new TreeSet<>()).add(post);
        }
        return postsPorAutor;
    }
}
