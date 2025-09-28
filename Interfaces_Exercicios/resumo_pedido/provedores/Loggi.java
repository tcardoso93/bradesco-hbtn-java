package provedores;

public class Loggi implements ProvedorFrete {
    @Override
    public Frete calcularFrete(double peso, double valor) {
        Frete frete = new Frete();
        frete.setValor(obterValorFreteLoggi(peso, valor));
        frete.setTipoProvedorFrete(obterTipoProvedorFrete());
        return frete;
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.LOGGI;
    }

    private double obterValorFreteLoggi(double peso, double valor) {
        return (peso > 5000.0) ? valor * 0.12 : valor * 0.04;
    }
    
}
