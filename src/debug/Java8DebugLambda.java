package debug;

import java.util.Arrays;
import java.util.List;

public class Java8DebugLambda {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 5, 8, 9);

        System.out.println("================================DEBUGANDO FUNÇÃO LAMBDA SEM BLOCO================================");
        list.stream()
                .map((n) -> new StringBuilder().append(n).append("s").append("a"))
                .forEach(System.out::println);

        System.out.println("================================DEBUGANDO FUNÇÃO LAMBDA COM BLOCO================================");
        // Uma das estratégias para debugar a função lambada é transforma-la em uma função lambda com bloco
        // A função lambda com bloco fica entre os parênteses {}
        list.stream()
                .map((n) -> {
                    StringBuilder builder = new StringBuilder();
                    builder.append(n);
                    builder.append("s");
                    builder.append("a");
                    return builder;
                })
                .forEach(System.out::println);

        System.out.println("================================DEBUGANDO FUNÇÃO LAMBDA COM MÉTODO================================");
        list.stream()
                .map((n) -> converteParaStringBuilder(n))
                .forEach(System.out::println);

        System.out.println("================================DEBUGANDO FUNÇÃO LAMBDA COM MÉTODO PEEK================================");
        // O metodo peek() pode ser executado antes ou após cada método do Stream, realizado com várias operações
        list.stream()
                .peek(n -> System.out.println(n + "Números antes do Filter"))
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.println(n + "Números após o Filter"))
                .forEach(System.out::println);
    }

    private static StringBuilder converteParaStringBuilder(Integer n) {
        StringBuilder builder = new StringBuilder();
        builder.append(n);
        builder.append("s");
        builder.append("a");
        return builder;
    }
}
