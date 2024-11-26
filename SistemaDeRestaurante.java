import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaDeRestaurante {
    private List<ItemDoPedido> cardapio = new ArrayList<>();
    private Map<Integer, Mesa> mesas = new HashMap<>();

    public void adicionarItemAoCardapio(String nome, double valor) {
        cardapio.add(new ItemDoPedido(nome, valor));
    }

    public void exibirCardapio() {
        System.out.println("=== Cardápio ===");
        for (int i = 0; i < cardapio.size(); i++) {
            System.out.println((i + 1) + ". " + cardapio.get(i).detalhes());
        }
    }

    public ItemDoPedido getItemDoCardapio(int indice) {
        if (indice >= 0 && indice < cardapio.size()) {
            return cardapio.get(indice);
        }
        return null;
    }

    public void registrarPedido(int numeroMesa, Pedido pedido) {
        mesas.computeIfAbsent(numeroMesa, Mesa::new).adicionarPedido(pedido);
        System.out.println("Pedido registrado na mesa " + numeroMesa);
    }

    public void checarMesas() {
        if (mesas.isEmpty()) {
            System.out.println("Nenhuma mesa fez pedidos.");
            return;
        }
        System.out.println("=== Pedidos por Mesa ===");
        for (Mesa mesa : mesas.values()) {
            System.out.println(mesa.listarPedidosDaMesa());
        }
    }
}
