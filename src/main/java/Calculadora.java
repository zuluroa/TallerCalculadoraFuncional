import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class Calculadora {

    static final IntBinaryOperator suma = (a, b) -> a + b;
    static final IntBinaryOperator resta = (a, b) -> a - b;
    static final IntBinaryOperator multiplicacion = (a, b)-> {
        return IntStream.range(0, Math.abs(b) + 1)
                .reduce((acomulado, numero) -> suma
                        .applyAsInt(Math.abs(a), acomulado))
                .getAsInt();


    };
    static final IntBinaryOperator division = (a,b) -> {
        return IntStream.range(0,Math.abs(a) )
                .reduce((acumulador, numero) ->
                        multiplicacion.applyAsInt(numero, b) <= a ? suma.applyAsInt(acumulador, 1) : acumulador).getAsInt();

    };

    public static void main(String[] args) {
        System.out.println(suma.applyAsInt(50,90));
        System.out.println(resta.applyAsInt(30,25));
        System.out.println(multiplicacion.applyAsInt(20,2));
        System.out.println(division.applyAsInt(60,5));
    }
}
