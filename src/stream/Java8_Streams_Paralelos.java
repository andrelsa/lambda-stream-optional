package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8_Streams_Paralelos {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        // A diferença entre o parallelStream() e o parallel(), quando esta na lista é possivel chamar direto parallelStream()
        // qualquer outro Stream que não seja uma lista, é chamado primeiro o parallel(), logo após transformar em parallelStream()
        // Quando usar o Stream paralelo?
        // Quando esta precisando ganhar performance no algoritmo, é utilizado em coleções com grande volume, milhares/milhões de itens na lista

        System.out.println("=============parallel()===========");
        IntStream.range(0, 5).parallel().forEach(System.out::println);

        System.out.println("==========================parallelStream()======================");
        System.out.println("=============forEach()===========");
        //Não imprime os elementos da lista na ordem que esta declarada
        list.parallelStream().forEach(System.out::println);

        System.out.println("=============forEachOrdered()===========");
        // Imprime os elementos da lista na ordem que esta declarada
        list.parallelStream().forEachOrdered(System.out::println);

        System.out.println("=============findAny() parallelStream===========");
        // O findAny() retorna um Optional
        // cada vez que é executado, retorna um valor diferente, porque são várias threads tratando o stream ao mesmo tempo
        // o findAny() encontra o primeiro elemento que estiver pronto e fazer algo com esse elemento
        // a thread que terminar primeiro, será executado primeiro
        list.parallelStream()
                .findAny()
                .ifPresent(System.out::println);

        System.out.println("=========findAny() Stream===========");
        // Quando é utilizado o findAny() em um Stream sequencial ele retorna sempre o primeiro elemento da lista
        // pois há apenas uma thread tratando o elemento
        list.stream()
                .findAny()
                .ifPresent(System.out::println);

        System.out.println("=============unordered()===========");
        // O unordered() é utilizado quando for usado skip ou limit, o ideal é usar o metodo unordered()
        // o unordered() serve para que o skip e o limit não sejam aplicados a uma thread especifica
        list.parallelStream()
                .unordered()
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("=============reduce()===========");
        // O reduce() utiliza operações associativas
        // se estiver utilizando parallelStream() com operação não associativa o resultado será errado
        // se a operação não for associativa, não é possível saber qual o resultado será retornado, pois não sabemos como será agrupado os itens
        // isso ocorre por se tratar de uma operação com várias threads executando a mesma operação
        list.parallelStream()
                .reduce((n1, n2) -> n1 + n2)
                .ifPresent(System.out::println);

        System.out.println("=========toMap() Stream===========");
        // Quando esta sendo utilizado o parallelStream(), o metodo toMap() deve criar para cada thread um mapa, vai popular o resultado com a operação passada
        // e depois faz o merge do mapa de todas as threads, juntando tudo em um único mapa

        Map<Integer, Boolean> collect = list.stream()
                .collect(
                        Collectors
                                .toMap(n -> n, n -> n % 2 == 0)
                );
        System.out.println(collect);

        System.out.println("=========groupinBy() Stream===========");
        // O groupingBy() agrupa os elementos por alguma operação que foi passada no metodo
        // Quando esta sendo utilizado o parallelStream(), o metodo groupingBy() cria para cada thread um mapa, e no final agrupa o resultado em um único mapa
        Map<Boolean, List<Integer>> collect2 = list.stream()
                .collect(
                        Collectors
                                .groupingBy( n -> n % 2 == 0)
                );
        System.out.println(collect2);
    }
}
