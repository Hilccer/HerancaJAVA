import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private int numero;
    private List<Pedido> pedidos = new ArrayList<>();

    public Mesa(int numero) {
        this.numero = numero;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public String listarPedidosDaMesa() {
        StringBuilder detalhes = new StringBuilder("Mesa " + numero + ":\n");
        for (Pedido pedido : pedidos) {
            detalhes.append(pedido.listarItens()).append("\n");
        }
        return detalhes.toString();
    }
}
