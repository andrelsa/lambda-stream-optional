package interfaces_funcionais;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Java8_Built_In_Functional_Interfaces {
    public static void main(String[] args) {

        System.out.println("========================SUPPLIER========================");
        // O Supplier é uma interface que irá entregar algum dado (valor), mas não recebe nenhum parametro
        // O Metodo generate() recebe como parametro Supplier
        Stream.generate(() -> new Random().nextInt())
                .limit(5)
                .forEach(System.out::println);

        System.out.println("========================CONSUMER========================");
        // Recebe apenas 1 valor
        // O Consumer é uma interface, oposto do Supplier, não retornada nenhuma dado (valor), mas recebe 1 parametro
        // o Metodo forEach() recebe um Consumer
        Stream.generate(() -> new Random().nextInt())
                .limit(5)
                .forEach((e) -> System.out.println(e));

        System.out.println("========================BICONSUMER========================");
        // Recebe 2 valores
        // O BiConsumer é uma interface, semelhante ao Consumer, não retornada nenhuma dado (valor), mas recebe 2 parametros
        Stream.generate(() -> new Random().nextInt())
                .limit(5)
                .forEach((e) -> System.out.println(e));

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("========================PREDICATE========================");
        // Recebe apenas 1 valor
        // O Predicate é uma interface, contém uma função que recebe 1 valor e retorna um booleano, retornando o resultado de alguma comparação, verdadeir ou falso
        // O método filter() recebe como parâmetro Predicate
        list.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);

        System.out.println("========================BIPREDICATE========================");
        // Recebe 2 valores
        // O BiPredicate é uma interface, é semelhante ao Predicate, contém uma função que recebe 2 valores e retorna um booleano, retornando o resultado de alguma comparação, verdadeir ou falso
        list.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);

        System.out.println("========================FUNCTION========================");
        // Recebe apenas 1 valor
        // O Function é uma interface generica, recebe 1 valor e retorna 1 valor
        // O método map() recebe como parâmetro Function, pois recebe um valor do Stream e retorna outro valor, o tipo que ele recebe não tem relação com o que é retornado
        // podendo ser tipos diferentes
        list.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e.doubleValue())
                .forEach(System.out::println);

        System.out.println("========================BIFUNCTION========================");
        // Recebe 2 valores
        // O BiFunction é uma interface generica, semelhante a Function, recebe 2 valores e retorna apenas 1 valor
        list.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e.doubleValue())
                .forEach(System.out::println);

        System.out.println("========================UNARYOPERATOR========================");
        // UnaryOperator operator é um interface que extends Function
        // No UnaryOperator, tanto a entrada quanto a saída devem conter os mesmos valores
        list.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e.doubleValue())
                .forEach(System.out::println);

        System.out.println("========================BINARYOPERATOR========================");
        // BinaryOperator operator é um interface que extends BiFunction
        // No BinaryOperator, tanto a entrada quanto a saída devem conter os mesmos valores
        // o metodo reduce() recebe como parametro o BinaryOperator
        list.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e.doubleValue())
                .reduce((e1, e2) -> e1 + e2)
                .ifPresent(System.out::println);
    }
}
