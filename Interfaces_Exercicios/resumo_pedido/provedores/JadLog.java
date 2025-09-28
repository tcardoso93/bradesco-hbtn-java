package provedores;

public class JadLog implements ProvedorFrete {
    @Override
    public Frete calcularFrete(double peso, double valor) {
        Frete frete = new Frete();
        frete.setValor(obterValorFreteJadLog(peso, valor));
        frete.setTipoProvedorFrete(obterTipoProvedorFrete());
        return frete;
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.JADLOG;
    }

    private double obterValorFreteJadLog(double peso, double valor) {
        return (peso > 2000.0) ? valor * 0.07 : valor * 0.045;
    }
    
}
