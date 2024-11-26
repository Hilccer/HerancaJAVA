import java.util.ArrayList;
import java.util.List;

public class SistemaDeEventos {
    private List<Evento> eventos;

    public SistemaDeEventos() {
        this.eventos = new ArrayList<>();
    }

    public void registrarEvento(String nome, String data, double valorIngresso, Local local) {
        Evento evento = new Evento(nome, data, valorIngresso, local);
        eventos.add(evento);
        System.out.println("Evento registrado com sucesso: " + nome);
    }

    public Evento buscarEventoPorNome(String nome) {
        for (Evento evento : eventos) {
            if (evento.getNome().equalsIgnoreCase(nome)) {
                return evento;
            }
        }
        return null;
    }

    public void adicionarParticipante(String nomeEvento, Participante participante) {
        Evento evento = buscarEventoPorNome(nomeEvento);
        if (evento != null) {
            evento.adicionarParticipante(participante);
            System.out.println("Participante adicionado ao evento: " + nomeEvento);
        } else {
            System.out.println("Evento não encontrado: " + nomeEvento);
        }
    }

    public void listarEventos() {
        System.out.println("=== Lista de Eventos ===");
        for (Evento evento : eventos) {
            System.out.println(evento);
        }
    }
}
