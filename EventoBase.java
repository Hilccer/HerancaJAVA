public abstract class EventoBase {
    private String nome;
    private String data;
    private double valorIngresso;
    private int totalParticipantes;

    public EventoBase(String nome, String data, double valorIngresso) {
        this.nome = nome;
        this.data = data;
        this.valorIngresso = valorIngresso;
        this.totalParticipantes = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public double getValorIngresso() {
        return valorIngresso;
    }

    public int getTotalParticipantes() {
        return totalParticipantes;
    }

    public void adicionarParticipantes(int quantidade) {
        this.totalParticipantes += quantidade;
    }

    public abstract double calcularReceita();
}
