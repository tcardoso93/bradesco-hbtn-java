import java.util.Arrays;

public class Pedido {
    public static final String SEPARATOR = "----------------------------";
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");
        Arrays.stream(itens)
                .forEach(item -> System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n",
                        item.getProduto().getClass().getSimpleName(),
                        item.getProduto().getTitulo(),
                        item.getProduto().obterPrecoLiquido(),
                        item.getQuantidade(),
                        calcularTotalProduto(item)));
        System.out.println(SEPARATOR);
        System.out.printf("DESCONTO: %.2f\n", calcularDesconto(calcularTotalPedido()));
        System.out.printf("TOTAL PRODUTOS: %.2f\n", calcularTotalPedido());
        System.out.println(SEPARATOR);
        System.out.printf("TOTAL PEDIDO: %.2f\n", calcularTotalPedido() - calcularDesconto(calcularTotalPedido()));
        System.out.println(SEPARATOR);
    }

    private double calcularTotalProduto(ItemPedido item) {
        return item.getQuantidade() * item.getProduto().obterPrecoLiquido();
    }

    public double calcularDesconto(Double totalProdutos) {
        return totalProdutos * (percentualDesconto / 100);
    }

    public double calcularTotalPedido() {
        return Arrays.stream(itens)
                .mapToDouble(item -> calcularTotalProduto(item))
                .sum();
    }
}
