import java.util.ArrayList;
import java.util.List;

public class ProcessadorVideo {
    private final List<CanalNotificacao> canais = new ArrayList<>();

    public void registrarCanal(CanalNotificacao canal) {
        if (canal != null) {
            canais.add(canal);
        }
    }

    public void processar(Video video) {
        if (video == null || canais.isEmpty()) {
            return;
        }
        String texto = video.getArquivo() + " - " + video.getFormato();
        Mensagem mensagem = new Mensagem(texto, TipoMensagem.LOG);
        for (CanalNotificacao canal : canais) {
            canal.notificar(mensagem);
        }
    }
}
