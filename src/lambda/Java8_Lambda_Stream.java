package lambda;

import java.util.Arrays;
import java.util.List;

public class Java8_Lambda_Stream {
    public static void main(String[] args) {
        // JAVA 8: FUNÇÕES LAMBDA

        // API DE STREAM

        // O que é o stream? Fluxo de dados

        List<Integer> asList = Arrays.asList(1, 2, 3, 4);

        //Utilizado ate o JAVA 7
        for (Integer integer : asList) {
            System.out.println(integer);
        }

        System.out.println("====================================");

        // Utilizado a partir do JAVA 8
        asList.stream()
                .filter(e -> e % 2 == 0) // o metodo Filter, filtra os dados que estão chegando pelo Stream
                .forEach(e -> System.out.println(e));
    }
}
