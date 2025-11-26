import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {
    public static void main(String[] args) {
        String fileName = "funcionarios.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                System.out.printf("Funcionário: %s\n", dados[0]);
                System.out.printf("Idade: %s\n", dados[1]);
                System.out.printf("Departamento: %s\n", dados[2]);
                System.out.printf("Salarial: %s\n", dados[3]);
                System.out.println("------------------------");
            }
            System.out.println("Leitura do arquivo concluída.");
            reader.close();
        } catch (IOException e) {
            System.out.printf("Erro ao ler o arquivo: %s \n", e.getMessage());
        }

    }
}