import java.util.List;

public class ManipularArrayNumeros {
    public static int buscarPosicaoNumero(List<Integer> numeros, int numeroBuscado) {
        return numeros.indexOf(numeroBuscado);
    }

    public static void adicionarNumero(List<Integer> numeros, int numeroAdicionar) {
        if (buscarPosicaoNumero(numeros, numeroAdicionar) != -1) {
            throw new IllegalArgumentException("Numero jah contido na lista");
        }
        numeros.add(numeroAdicionar);
    }

    public static void removerNumero(List<Integer> numeros, int numeroRemover) {
        int posicao = buscarPosicaoNumero(numeros, numeroRemover);
        if (posicao == -1) {
            throw new IllegalArgumentException("Numero nao encontrado na lista");
        }
        numeros.remove(posicao);
    }

    public static void substituirNumero(List<Integer> numeros, int numeroSubstituir, int numeroSubstituto) {
        int posicao = buscarPosicaoNumero(numeros, numeroSubstituir);
        if (posicao == -1) {
            adicionarNumero(numeros, numeroSubstituto);
        } else {
            numeros.set(posicao, numeroSubstituto);
        }
    }
}
