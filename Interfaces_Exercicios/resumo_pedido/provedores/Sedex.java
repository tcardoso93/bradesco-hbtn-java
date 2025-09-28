package provedores;

public class Sedex implements ProvedorFrete {
    @Override
    public Frete calcularFrete(double peso, double valor) {
        Frete frete = new Frete();
        frete.setValor(obterValorFreteSedex(peso, valor));
        frete.setTipoProvedorFrete(obterTipoProvedorFrete());
        return frete;
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.SEDEX;
    }

    private double obterValorFreteSedex(double peso, double valor) {
        return (peso > 1000.0) ? valor * 0.10 : valor * 0.05;
    }
}
