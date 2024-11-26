import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemDoPedido> itens = new ArrayList<>();

    public void adicionarItem(ItemDoPedido item) {
        itens.add(item);
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(ItemDoPedido::getValor).sum();
    }

    public String listarItens() {
        StringBuilder detalhes = new StringBuilder();
        for (ItemDoPedido item : itens) {
            detalhes.append(item.detalhes()).append("\n");
        }
        detalhes.append("Total do Pedido: R$ ").append(calcularTotal());
        return detalhes.toString();
    }
}
