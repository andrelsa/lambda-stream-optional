package method_reference;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Java8_Method_Reference {
    public static void main(String[] args) {

        // Quando temos dois ponto (::) é o Method Reference
        // O metodo é referenciado diretamente, pois não esta sendo passado argumento
        // O Method Reference é uma outra maneira de representar a função lambda

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println("====================COM METHOD REFERENCE====================");
        list.stream()
                .forEach(System.out::println);

        System.out.println("====================SEM METHOD REFERENCE====================");
        list.stream()
                .forEach((n) -> System.out.println(n));

        System.out.println("========================================METHOD REFERENCE COM METODOS ESTATICOS========================================");
        System.out.println("====================SEM METHOD REFERENCE====================");
        list.stream()
                .map((n) -> multipliquePorDois(n))
                .forEach(System.out::println);

        System.out.println("====================COM METHOD REFERENCE====================");
        list.stream()
                .map(Java8_Method_Reference::multipliquePorDois)
                .forEach(System.out::println);

        System.out.println("========================================METHOD REFERENCE PARA CONSTRUTORES========================================");
        System.out.println("====================SEM METHOD REFERENCE====================");
        list.stream()
                .map((n) -> new BigDecimal(n))
                .forEach(System.out::println);

        System.out.println("====================COM METHOD REFERENCE====================");
        list.stream()
                .map(BigDecimal::new)
                .forEach(System.out::println);

        System.out.println("========================================METHOD REFERENCE PARA VÁRIAS INSTÂNCIAS========================================");
        System.out.println("====================SEM METHOD REFERENCE====================");
        // São varias instâncias, porque esta sendo chamado várias vezes ao percorrer os dados da Stream
        list.stream()
                .map((n) -> n.doubleValue())
                .forEach(System.out::println);

        System.out.println("====================COM METHOD REFERENCE====================");
        list.stream()
                .map(Integer::doubleValue)
                .forEach(System.out::println);

        System.out.println("========================================METHOD REFERENCE PARA ÚNICA INSTÂNCIA========================================");
        System.out.println("====================SEM METHOD REFERENCE====================");
        BigDecimal dois = new BigDecimal(2);
        list.stream()
                .map(BigDecimal::new)
                .map((b) -> dois.multiply(b))
                .forEach(System.out::println);

        System.out.println("====================COM METHOD REFERENCE====================");
        list.stream()
                .map(BigDecimal::new)
                .map(dois::multiply)
                .forEach(System.out::println);
    }

    private static Integer multipliquePorDois(Integer i) {
        return i * 2;
    }
}
