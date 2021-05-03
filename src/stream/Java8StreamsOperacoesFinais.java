package stream;

import java.util.*;
import java.util.stream.Collectors;

public class Java8StreamsOperacoesFinais {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1, 5, 8, 9, 1, 4, 7, 6, 6, 9, 9);

        // JAVA 8: STREAMS
        // stream = fluxo de dados

        // Por que usar Stream?
        // Stream são loops implicitos
        //  for - while - do while = são loops explicitos

        // Nas operações finais, o Stream esta fechado, não consigo fazer outra operação com o Stream
        // o forEach é uma operação terminal, portanto, após ser executado, não poderá ser realizado outras operações

        System.out.println("==============METODO FOREACH==============");
        lista.stream()
                .limit(3)
                .map(e -> e * 2)
                .forEach(e -> System.out.println(e));

        System.out.println("==============METODO COUNT==============");
        // Count
        // retorna um número, a quantidade de itens do Stream
        // no exemplo, o método Count retorna a quantidade de elementos que são pares
        long count = lista.stream()
                .filter(e -> e % 2 == 0)
                .count();
        System.out.println(count);

        System.out.println("==============METODO MIN==============");
        // Min
        // retorna o menor valor do Stream
        // no Min é necessário passar um comparador
        // no exemplo, o método Min irá retornar o menor valor par do Stream
        Optional<Integer> min = lista.stream()
                .filter(e -> e % 2 == 0)
                .min(Comparator.naturalOrder());
        System.out.println(min.get());

        System.out.println("==============METODO MAX==============");
        // Max
        // retorna o menor valor do Stream
        // no Max é necessário passar um comparador
        // no exemplo, o método Max irá retornar o maior valor par do Stream
        Optional<Integer> max = lista.stream()
                .filter(e -> e % 2 == 0)
                .max(Comparator.naturalOrder());
        System.out.println(max.get());

        System.out.println("==============METODO COLLECT (TOLIST)==============");
        // Collect (toList)
        // pega o resultado do Stream e armazena em uma lista
        // no exemplo, o método Collectors.toList() irá retornar uma nova lista de números pares multiplicados por 3
        List<Integer> novaLista = lista.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 3)
                .collect(Collectors.toList());
        System.out.println(novaLista);

        System.out.println("==============METODO COLLECT (GROUPINGBY)==============");
        // Collect (groupingBy)
        // criar um mapa por alguma critério utilizado
        // no exemplo, o método Collectors.groupingBy irá retornar no mapa, uma nova lista de números multiplicados por 3 e agrupados por pares e impares
        Map<Boolean, List<Integer>> mapa = lista.stream()
                .map(e -> e * 3)
                .collect(Collectors.groupingBy(e -> e % 2 == 0));
        System.out.println(mapa);

        System.out.println("==============METODO COLLECT (JOINING)==============");
        // Collect (joining)
        // o joining só trabalha com Strings
        // no exemplo, o método Collectors.joining irá retornar um Stream de Strings, transformou os números em String seperado por ponto e vírgula
        String collect = lista.stream()
                .map(e -> String.valueOf(e))
                .collect(Collectors.joining(";"));
        System.out.println(collect);

    }
}
