public class PersonagemGame {
    private int saudeAtual;
    private String nome;
    private String status;

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {

        if (saudeAtual < 0) {
            saudeAtual = 0;
        } else if (saudeAtual > 100) {
            saudeAtual = 100;
        }

        if (saudeAtual == 0) {
            this.status = "morto";
        } else {
            this.status = "vivo";
        }

        this.saudeAtual = saudeAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void tomarDano(int quantidadeDeDano) {
        setSaudeAtual(getSaudeAtual() - quantidadeDeDano);
    }

    public void receberCura(int quantidadeDeCura) {
        setSaudeAtual(getSaudeAtual() + quantidadeDeCura);
    }

    public String getStatus() {
        return status;
    }
}
