package lambda;

import java.util.stream.IntStream;

public class Java8Lambda {
    public static void main(String[] args) {
        // Várias formas de se escrever uma função lambda no JAVA

        System.out.println("========================PARÊNTESES========================");
        // Usar o parênteses () na função lambda, é necessário quando for informado o tipo do parametro
        // Quando há 2 argumentos é necessário usar o parênteses ()
        // Quando colocar o tipo é necessário informar o tipo de todas as variaveis que estão sendo utilizadas na função
        // Quando o parênteses () esta vazio, não esta passando nenhum argumento na função lambda

        Runnable runnable = () -> System.out.println("Lorem Ipsum");

        IntStream.range(0, 5)
                .filter((int n) -> n % 2 == 0)
                .reduce((n1, n2) -> n1 + n2)
                .ifPresent(System.out::println);

        System.out.println("========================CHAVES========================");
        // Quando usar chaves {} é necessário colocar o return, se a expressão lambda retornar alguma coisa
        // Com as chaves {} é possível ter mais de uma expressão na função lambda
        IntStream.range(0, 5)
                .filter((int n) -> {
                    System.out.println("Lorem Ipsum");
                    return n % 2 == 0;
                })
                .forEach(System.out::println);
    }
}
