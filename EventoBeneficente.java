public class EventoBeneficente extends EventoBase {
    private Medico medicoPresente;
    private ItemDoPedido pratoEscolhido;
    private int quantidadeMarmitas;

    public EventoBeneficente(String nome, String data, double valorIngresso, Medico medicoPresente, ItemDoPedido pratoEscolhido, int quantidadeMarmitas) {
        super(nome, data, valorIngresso);
        this.medicoPresente = medicoPresente;
        this.pratoEscolhido = pratoEscolhido;
        this.quantidadeMarmitas = quantidadeMarmitas;
    }

    @Override
    public double calcularReceita() {
        return pratoEscolhido.getValor() * quantidadeMarmitas;
    }

    public void mostrarDetalhes() {
        System.out.println("Evento Beneficente: " + getNome());
        System.out.println("Data: " + getData());
        System.out.println("Médico: " + medicoPresente.getNome() + " - " + medicoPresente.getEspecialidade());
        System.out.println("Prato Escolhido: " + pratoEscolhido.getNome());
        System.out.println("Quantidade de Marmitas: " + quantidadeMarmitas);
        System.out.println("Valor Total da Doação: R$ " + calcularReceita());
    }
}
