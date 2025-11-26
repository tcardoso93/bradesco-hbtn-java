import java.util.ArrayList;
import java.util.Iterator;

public class Pedido {
    private ArrayList<PedidoCookie> cookies;

    public Pedido() {
        this.cookies = new ArrayList<>();
    }

    public void adicionarPedidoCookie(PedidoCookie pedido) {
        cookies.add(pedido);
    }

    public int obterTotalCaixas() {
        int total = 0;
        for (PedidoCookie pedido : cookies) {
            total += pedido.getQuantidadeCaixas();
        }
        return total;
    }

    public int removerSabor(String sabor) {
        int caixasRemovidas = 0;
        Iterator<PedidoCookie> iterator = cookies.iterator();

        while (iterator.hasNext()) {
            PedidoCookie pedido = iterator.next();
            if (pedido.getSabor().equals(sabor)) {
                caixasRemovidas += pedido.getQuantidadeCaixas();
                iterator.remove();
            }
        }

        return caixasRemovidas;
    }
}
