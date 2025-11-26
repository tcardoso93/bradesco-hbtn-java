import java.io.*;
import java.util.*;

public class Estoque {
    private List<Produto> produtos;
    private String fileName;

    public Estoque(String fileName) {
        this.fileName = fileName;
        if (produtos == null) {
            produtos = new ArrayList<>();
        }
        carregarDados();
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        int novoId = gerarNovoId();
        Produto produto = new Produto(novoId, nome, quantidade, preco);
        produtos.add(produto);
        salvarDados();
    }

    public boolean excluirProduto(int id) {
        boolean removido = produtos.removeIf(p -> p.getId() == id);
        if (removido) {
            salvarDados();
        }
        return removido;
    }

    public void atualizarQuantidade(int id, int novaQuantidade) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                salvarDados();
                return;
            }
        }
    }

    public void exibirEstoque() {
        produtos.forEach(System.out::println);
    }

    private int gerarNovoId() {
        if (produtos.isEmpty())
            return 1;
        return produtos.stream()
                .mapToInt(Produto::getId)
                .max()
                .getAsInt() + 1;
    }

    private void carregarDados() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                int quantidade = Integer.parseInt(dados[2]);
                double preco = Double.parseDouble(dados[3]);
                produtos.add(new Produto(id, nome, quantidade, preco));
            }
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado. Será criado um novo.");
        }
    }

    private void salvarDados() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Produto p : produtos) {
                bw.write(p.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }
}