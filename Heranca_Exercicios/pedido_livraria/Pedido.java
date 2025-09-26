public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }
    
    public double calcularTotal() {
        double total = java.util.Arrays.stream(itens)
            .mapToDouble(item -> item.getQuantidade() * item.getProduto().obterPrecoLiquido())
            .sum();
        return total * (1 - percentualDesconto / 100.0);
    }
}
