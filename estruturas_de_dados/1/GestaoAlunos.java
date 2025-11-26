import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {
    private List<Aluno> alunos;

    public GestaoAlunos() {
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(String nome, int idade) {
        Aluno aluno = new Aluno(nome, idade);
        alunos.add(aluno);
        System.out.printf("Aluno %s adicionado\n", nome);
    }

    public void excluirAluno(String nome) {
        System.out.println("Vai excluir o aluno: " + nome);

        boolean removido = alunos.removeIf(aluno -> aluno.getNome().equals(nome));
        if (removido) {
            System.out.printf("Aluno %s removido\n", nome);
        } else {
            System.out.printf("Aluno %s nao encontrado\n", nome);
        }
    }

    public void buscarAluno(String nome) {
        System.out.println("Vai buscar o aluno: " + nome);

        Aluno alunoEncontrado = alunos.stream()
                .filter(aluno -> aluno.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);

        if (alunoEncontrado != null) {
            System.out.println("Aluno encontrado: " + alunoEncontrado);
        } else {
            System.out.printf("Aluno %s nao encontrado\n", nome);
        }
    }

    public void listarAlunos() {
        System.out.println("\nListando todos os alunos:");

        if (alunos.isEmpty()) {
            System.out.println("Lista de alunos vazia");
            return;
        }

        System.out.println("Lista de alunos:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }   
    }

    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();

        gestao.adicionarAluno("Laura", 5);
        gestao.adicionarAluno("Beatriz", 2);
        gestao.adicionarAluno("Livia", 1);

        gestao.listarAlunos();

        gestao.buscarAluno("Livia");

        gestao.excluirAluno("Beatriz");
        gestao.excluirAluno("Ana");

        gestao.buscarAluno("Laura");
    }
}
