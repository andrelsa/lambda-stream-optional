package stream;

import java.util.Arrays;
import java.util.List;

public class Java8StreamsOperacoesIntermediarias {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1, 5, 8, 9, 1, 4, 7, 6, 6, 9, 9);

        // JAVA 8: STREAMS
        // stream = fluxo de dados

        // Skip
        // operação intermediária - é possível ser várias operações antes de fechar o stream
        // no exemplo, o método Skip pula ou ignora os 2 primeiros dados do Stream
        System.out.println("==============METODO SKIP==============");
        lista.stream()
                .skip(2)
                .forEach(e -> System.out.println(e));

        // Limit
        // operação intermediária - é possível ser várias operações antes de fechar o stream
        // no exemplo, o método Limit filtra os elementos do stream, quantos elementos será processado
        System.out.println("==============METODO LIMIT==============");
        lista.stream()
                .limit(2)
                .forEach(e -> System.out.println(e));

        // Distinct
        // operação intermediária - é possível ser várias operações antes de fechar o stream
        // no exemplo, o método Distinct não permite que o stream processe elementos repetidos
        System.out.println("==============METODO DISTINCT==============");
        lista.stream()
                .distinct() // utiliza a comparação do equals e hashcode para fazer a comparação
                .forEach(e -> System.out.println(e));

        // Os metodos também podem ser utilizados em conjunto
        // no exemplo, foi utilizado o método Skip e limit
        System.out.println("==============METODOS SKIP, LIMIT E DISTINCT==============");
        lista.stream()
                .skip(2)
                .limit(3)
                .distinct()
                .forEach(e -> System.out.println(e));

        // Filter
        // operação intermediária - é possível ser várias operações antes de fechar o stream
        // no exemplo, o método Filter permite que seja implementado o filtro que for desejado
        System.out.println("==============METODO FILTER==============");
        lista.stream()
                .filter(e -> e % 2 == 0)
                .forEach(e -> System.out.println(e));

        // Map
        // a lista original não é modificada
        // operação intermediária - é possível ser várias operações antes de fechar o stream
        // no exemplo, o método Map realiza a transformação dos dados da lista
        System.out.println("==============METODO MAP==============");
        lista.stream()
                .map(e -> e * 2)
                .forEach(e -> System.out.println(e));

        // Antes de utilizar o Map, o ideal é utilizar os filtros, após filtrar, poderá ser trabalhado no(s) elemento(s) da lista
        // As operações podem ser utilizadas quantas vezes forem necessárias
        // no exemplo, foi utilizado um filtro antes, o método Map realiza a transformação dos dados da lista
        System.out.println("==============METODOS DE FILTORS ANTES DE UTILIZAR O METODO MAP==============");
        lista.stream()
                .limit(3)
                .map(e -> e * 2)
                .skip(2)
                .distinct()
                .forEach(e -> System.out.println(e));

        System.out.println("==============JAVA 5 EXEMPLO==============");

        // JAVA 5
        for (Integer integer : lista) {
            System.out.println(integer);
        }

    }
}
