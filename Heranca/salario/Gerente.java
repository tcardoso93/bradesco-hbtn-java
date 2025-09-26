public class Gerente extends Empregado {

    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    @Override
    public double calcularBonus(Departamento departamento) {
        return departamento.alcancouMeta()
                ? (getSalarioFixo() * 0.20)
                        + ((departamento.getValorAtingidoMeta() - departamento.getValorMeta()) * 0.01)
                : 0.0;
    }

}
