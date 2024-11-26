public class Paciente extends Pessoa {
    private String cpf;

    public Paciente(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
