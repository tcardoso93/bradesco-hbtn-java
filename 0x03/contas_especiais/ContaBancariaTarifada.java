import exceptions.OperacaoInvalidaException;

public class ContaBancariaTarifada extends ContaBancariaBasica {
    public static final double TARIFA_POR_TRANSACAO = 0.10;
    private int quantidadeTransacoes;

    public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) throws Exception {
        super(numeracao, taxaJurosAnual);
        this.quantidadeTransacoes = 0;
    }

    @Override
    public void depositar(double valor) throws OperacaoInvalidaException {
        super.depositar(valor);
        descontarTarifaTransacao();
        this.quantidadeTransacoes++;
    }

    @Override
    public void sacar(double valor) throws OperacaoInvalidaException{
        super.sacar(valor);
        descontarTarifaTransacao();
        this.quantidadeTransacoes++;
    }

    private void descontarTarifaTransacao() throws OperacaoInvalidaException {
            super.sacar(TARIFA_POR_TRANSACAO);
    }
}
