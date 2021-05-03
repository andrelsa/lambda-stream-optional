package optional;

import java.util.Optional;
import java.util.stream.Stream;

public class Java8Optional {
    public static void main(String[] args) {

        // Optional pode conter ou não um valor, por isso é chamado de Optional
        // No Optional o valor de retorno ele poderá existir ou não existir

        //String s = "ASDADASDASDS";
        String s = "1";

        Optional<Integer> numero = converteEmNumero(s);

        System.out.println("======================METODO isPresent()======================");
        // o metodo isPresent() verifica se o valor existe, retorna um booleano
        System.out.println(numero.isPresent());

        System.out.println("======================METODO get()======================");
        // o metodo get() pega o valor que esta armazenado dentro do Optional
        // senão tiver valor, será retornado uma exceção
        System.out.println(numero.get());

        System.out.println("======================METODO ifPresent()======================");
        // o metodo ifPresent() verificar se o valor esta presente
        // o metodo ifPresent() só executa a função lambda se tiver algum valor dentro do Optional
        converteEmNumero(s).ifPresent(n -> System.out.println(n));

        System.out.println("======================METODO orElse()======================");
        // o metodo orElse() retorna o valor default que esta sendo passado, caso não encontre o valor retornado no Optional
        Integer orElse = converteEmNumero(s).orElse(5);
        System.out.println(orElse);

        System.out.println("======================METODO orElseGet()======================");
        // o metodo orElseGet() pode ser utilizado uma função lambda, caso não receba um valor, será executado a expressão que esta na função lambda
        Integer orElseGet = converteEmNumero(s).orElseGet(() -> 5);
        System.out.println(orElseGet);

        System.out.println("======================METODO orElseThrow()======================");
        // o metodo orElseThrow() lança uma exceção caso o Optional esteja vazio, utilizado dentro de uma expressão lambda
        Integer orElseGetThrow = converteEmNumero(s).orElseThrow(() -> new NullPointerException("Valor vazio"));
        System.out.println(orElseGetThrow);

    }

    public static Optional<Integer> converteEmNumero(String numeroStr) {

        //Quando é utilizado o metodo Optional.of() o valor recebido nunca será null

        try {
            Integer integer = Integer.valueOf(numeroStr);
            return Optional.of(integer);
        } catch (Exception e) {
            // Se o valor não for encontrado retornara vazio
            return Optional.empty();
        }

    }
}
