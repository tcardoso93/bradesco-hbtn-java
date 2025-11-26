public class Midia {
    private String nome;

    public Midia() {
    }

    public Midia(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return String.format(String.format("Tipo: %s - Nome: %s", this.getClass().getName(), getNome()));
    }
}
