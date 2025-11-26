public class Numero {

    public static void dividir(int a, int b) {
        int resultado = 0;

        try {
            if (b == 0) {
                throw new ArithmeticException("Nao eh possivel dividir por zero");
            }
            resultado = a / b;

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.printf("%d / %d = %d\n", a, b, resultado);
        }
    }
}