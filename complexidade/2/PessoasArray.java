public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes = new String[] { "Amanda", "Beatriz", "Carlos", "Daniela", "Eduardo",
                "Fabio", "Gustavo", "Hingrid", "Isabela", "Joao", "Leise", "Maria",
                "Norberto", "Otavio", "Paulo", "Quirino", "Renata", "Sabata",
                "Tais", "Umberto", "Vanessa", "Xavier" };
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    // implementar o método de buscaBinaria
    public void buscaBinaria(String nome) {
        boolean encontrado = false;
        int inicioArray = 0;
        int fimArray = nomes.length - 1;
        System.out.printf("Procurando o nome: \"%s\"\n", nome);
        while (inicioArray <= fimArray) {
            int meioArray = (inicioArray + fimArray) / 2;
            int comparacao = nomes[meioArray].compareToIgnoreCase(nome);
            System.out.printf("Passando pelo indice: %d\n", meioArray);
            if (comparacao == 0) {
                System.out.printf("Nome %s encontrado na posição %d\n", nome, meioArray);
                encontrado = true;
                break;
            } else if (comparacao < 0) {
                inicioArray = meioArray + 1;
            } else {
                fimArray = meioArray - 1;
            }
        }
        if (!encontrado)
            throw new IllegalArgumentException("O nome " + nome + " não se encontra no array de nomes");
    }
}