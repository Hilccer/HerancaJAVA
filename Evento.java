import java.util.ArrayList;
import java.util.List;

public class Evento extends EventoBase {
    private Local local;
    private List<Participante> participantes;

    public Evento(String nome, String data, double valorIngresso, Local local) {
        super(nome, data, valorIngresso);
        this.local = local;
        this.participantes = new ArrayList<>();
    }

    public Local getLocal() {
        return local;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void adicionarParticipante(Participante participante) {
        participantes.add(participante);
        adicionarParticipantes(1); // Atualiza o total de participantes na classe base
    }

    @Override
    public double calcularReceita() {
        return getTotalParticipantes() * getValorIngresso();
    }

    @Override
    public String toString() {
        return "Evento: " + getNome() + "\n" +
               "Data: " + getData() + "\n" +
               "Local: " + local + "\n" +
               "Participantes: " + participantes.size() + "\n" +
               "Receita: R$ " + calcularReceita();
    }
}
