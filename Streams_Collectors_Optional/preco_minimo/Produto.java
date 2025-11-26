import java.util.Locale;

public class Produto {
    private long codigo;
    private String nome;
    private CategoriaProduto categoria;
    private double preco;

    public Produto(long codigo, String nome, CategoriaProduto categoria, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        Locale.setDefault(new Locale("pt", "BR"));
        return String.format("[%d] %s %s R$ %.2f", codigo, nome, categoria, preco);
    }
}
