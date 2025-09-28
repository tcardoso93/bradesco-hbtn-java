public class Mensagem {
    private final String texto;
    private final TipoMensagem tipoMensagem;

    public Mensagem(String texto, TipoMensagem tipoMensagem) {
        this.texto = texto;
        this.tipoMensagem = tipoMensagem;
    }

    public String getTexto() {
        return texto;
    }

    public TipoMensagem getTipoMensagem() {
        return tipoMensagem;
    }
}
