public class Participante extends Pessoa {
    private String tipoIngresso;

    public Participante(String nome, String tipoIngresso) {
        super(nome);
        this.tipoIngresso = tipoIngresso;
    }

    public String getTipoIngresso() {
        return tipoIngresso;
    }

    @Override
    public String toString() {
        return "Participante: " + getNome() + ", Tipo de Ingresso: " + tipoIngresso;
    }
}
