import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {
    private String numeracao;
    private double saldo;
    private double taxaJurosAnual;

    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) throws Exception {
        this.numeracao = numeracao;
        this.saldo = 0.0;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void depositar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
        } else if (valor > this.saldo) {
            throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
        }
        this.saldo -= valor;
    }

    public void aplicarAtualizacaoMensal() {
        double tarifaMensal = calcularTarifaMensal();
        double jurosMensal = calcularJurosMensal();
        this.saldo -= tarifaMensal;   
        this.saldo += jurosMensal;
    }

    private double calcularTarifaMensal() {
        return Math.min(10.0, this.saldo * 0.10);
    }

    private double calcularJurosMensal() {
        return (this.saldo < 0) ? 0.0 : obterVlrJurosMensal();
    }

    private double obterVlrJurosMensal() {
        return this.saldo * (this.taxaJurosAnual / 12.0 / 100.0);
    }
}
