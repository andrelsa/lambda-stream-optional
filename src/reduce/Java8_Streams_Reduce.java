package reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class Java8_Streams_Reduce {
    public static void main(String[] args) {
        String s = "Lorem Ipsum is simply dummy text";
        String[] split = s.split(" ");
        List<String> stringList = Arrays.asList(split);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        // O reduce ele pega todos os elementos de um Stream, agrupando de acordo com a função passada, e transforma todos os elementos em uma único elemento
        // Stream com vários elementos, transformando em uma única coisa, a operação utilizada pode variar, mas o resultado é sempre o mesmo
        // vários elementos transformado em um único elemento
        // A função de acumulação, deve ser uma função associativa, não é recomendado usar subtração
        // o Reduce trabalha com objetos mutaveis

        System.out.println("==============REDUCE SOMA==============");
        // Soma o primeiro elemento da lista com o segundo da lista, com isso teremos outro elemento
        // o resultado dessa função, transforma no primeiro elemento e posteriormente som com o próximo elemento
        // a partir desse momento vai somando com os demais elementos ate o último elemento da lista
        Optional<Integer> reduceSoma = list.stream()
                .reduce((n1, n2) -> n1 + n2);
        System.out.println(reduceSoma.get());

        System.out.println("==============REDUCE MULTIPLICACAO==============");
        Optional<Integer> reduceMultiplicacao = list.stream()
                .reduce((n1, n2) -> n1 * n2);
        System.out.println(reduceMultiplicacao.get());

        System.out.println("==============REDUCE CONCATENAÇÃO==============");
        Optional<String> reduceConcatenacao = stringList.stream()
                .reduce((s1, s2) -> s1.concat(s2));
        System.out.println(reduceConcatenacao.get());

        System.out.println("==============REDUCE SUBTRACAO (NÃO UTILIZE)==============");
        // A subtração não é associativa
        Optional<Integer> reduceSubtracao = list.stream()
                .reduce((n1, n2) -> n1 - n2);
        System.out.println(reduceSubtracao.get());

        System.out.println("==============REDUCE SOMA PASSANDO O VALOR IDENTIDADE==============");
        // A diferença do Reduce passando 1 argumento para o que esta passando 2 argumentos é o valor Identidade
        // Na soma o valor identidade será sempre o 0 (zero), somando o valor da identidade mas o argumento que esta sendo passado
        Integer reduceSoma2 = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(reduceSoma2);

        System.out.println("==============REDUCE MULTIPLICACAO PASSANDO O VALOR IDENTIDADE==============");
        // Na multiplicação o valor identidade será sempre o 1 (um), somando o valor da identidade mas o argumento que esta sendo passado
        Integer reduceMultiplicacao2 = list.stream()
                .reduce(1, (n1, n2) -> n1 * n2);
        System.out.println(reduceMultiplicacao2);

        System.out.println("==============REDUCE CONCATENANDO PASSANDO O VALOR IDENTIDADE==============");
        // Na concatenção o valor identidade será sempre uma String vazia(""), somando o valor da identidade mas o argumento que esta sendo passado
        String reduceConcatenacao2 = stringList.stream()
                .reduce("", (s1, s2) -> s1.concat(s2));
        System.out.println(reduceConcatenacao2);

        System.out.println("==============REDUCE FUNÇÃO DE MENOR VALOR==============");
        OptionalDouble reduce = DoubleStream.of(1.5, 2.5, 6.7)
                .reduce((d1, d2) -> Math.min(d1, d2));
        System.out.println(reduce.getAsDouble());

        System.out.println("==============REDUCE FUNÇÃO DE COMBINAÇÃO DE VALOR==============");
        Integer reduceCombinacaoValor = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2, (n1, n2) -> n1 + n2);
        System.out.println(reduceCombinacaoValor);

        System.out.println("==============REDUCE MAP + FUNÇÃO DE COMBINAÇÃO DE VALOR==============");
        Optional<String> reduceMapCombinacaoValor = list.stream()
                .map(n1 -> n1.toString())
                .reduce((n1, n2) -> n1.concat(n2));
        System.out.println(reduceMapCombinacaoValor.get());
    }
}
