import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors; 

public class ClinicaMedica {
    private List<Paciente> pacientes = new ArrayList<>();
    private List<Medico> medicos = new ArrayList<>();
    private List<Consulta> consultas = new ArrayList<>();


    public void cadastrarPaciente(String nome, String cpf) {
        pacientes.add(new Paciente(nome, cpf));
    }

    public void cadastrarMedico(String nome, String especialidade) {
        medicos.add(new Medico(nome, especialidade));
    }

    public Paciente buscarPaciente(String cpf) {
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }

    public List<Paciente> buscarPaciente(String nome, String cpf) {
        return pacientes.stream()
            .filter(p -> p.getNome().equalsIgnoreCase(nome) || p.getCpf().equals(cpf))
            .collect(Collectors.toList()); 
    }

    public Medico buscarMedicoDisponivel(String especialidade) {
        return medicos.stream()
            .filter(m -> m.getEspecialidade().equalsIgnoreCase(especialidade) && m.isDisponivel())
            .findFirst().orElse(null);
    }

    public List<Medico> getMedicos() {
        return medicos;
    }
    
    public void agendarConsulta(String cpfPaciente, String especialidade, String data) {
        Paciente paciente = buscarPaciente(cpfPaciente);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }
    
        Medico medico = buscarMedicoDisponivel(especialidade);
        if (medico == null) {
            System.out.println("Nenhum médico disponível para a especialidade: " + especialidade);
            return;
        }
    
        // Criar a consulta
        Consulta consulta = new Consulta(paciente, medico, data);
        consultas.add(consulta);
    
        // Marcar o médico como indisponível
        medico.setDisponivel(false);
    
        System.out.println("Consulta agendada com sucesso:");
        System.out.println(consulta);
    }
    
    public void listarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
    
        System.out.println("=== Consultas Agendadas ===");
        for (Consulta consulta : consultas) {
            System.out.println(consulta);
        }
    }


}