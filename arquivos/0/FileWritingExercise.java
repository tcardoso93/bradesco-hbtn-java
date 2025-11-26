import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWritingExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome do arquivo
        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            System.out.println("Digite as linhas de texto (digite 'sair' para finalizar):");

            while (true) {
                String linha = scanner.nextLine();
                if (linha.equalsIgnoreCase("sair")) {
                    break;
                }
                writer.write(linha);
                writer.newLine();
            }

            System.out.printf("Arquivo %s criado e conteudo salvo com sucesso!", fileName);

        } catch (IOException e) {
            System.out.printf("Erro ao escrever no arquivo: %s \n", e.getMessage());
        }

        scanner.close();
    }
}