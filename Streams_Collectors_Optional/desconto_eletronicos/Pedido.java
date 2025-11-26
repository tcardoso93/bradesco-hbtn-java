import java.util.List;
import java.util.Locale;

public class Pedido {
    private long codigo;
    private List<Produto> produtos;
    private Cliente cliente;

    public Pedido(long codigo, List<Produto> produtos, Cliente cliente) {
        this.codigo = codigo;
        this.produtos = produtos;
        this.cliente = cliente;
    }

    public long getCodigo() {
        return codigo;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s", codigo, cliente.getNome());
    }
}
