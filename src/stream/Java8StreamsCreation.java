package stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8StreamsCreation {
    public static void main(String[] args) throws IOException {

        System.out.println("====================Collection====================");
        // Qualquer classe que extends ou implements Collection terá o metodo stream e parallelStream
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.stream().forEach(System.out::println);

        System.out.println("====================Arrays====================");
        // A classe Arrays possuí o metodo stream, com isso pode ser convertido o Array em Stream
        Integer[] intArray = new Integer[]{1, 2, 3, 4};
        Arrays
                .stream(intArray)
                .forEach(System.out::println);

        System.out.println("====================Stream.of()====================");
        // No metodo Stream.of, podemos passar qualquer tipo de objeto, que será transformado em um Stream do objeto passado
        // Podemos criar um Stream de qualquer tipo de objeto, qualquer valor
        Stream
                .of("Lorem", "Ipsum", "simply", "dummy")
                .forEach(System.out::println);

        System.out.println("====================IntStream.range()====================");
        // No metodo IntStream.range, são passados 2 números, o primeiro número é o inicio do Stream e o segundo número é o fim do Stream
        // o primeiro número é inclusivo, mas o último número é exclusivo
        IntStream
                .range(0, 5)
                .forEach(System.out::println);

        System.out.println("====================IntStream.rangeClosed()====================");
        // No metodo IntStream.rangeClosed, são passados 2 números, o primeiro número é o inicio do Stream e o segundo número é o fim do Stream
        // o primeiro e o segundo número são inclusivos
        IntStream
                .rangeClosed(0, 5)
                .forEach(System.out::println);

        System.out.println("====================Stream.iterate()====================");
        // No metodo Stream.iterate, são passados 2 números, o primeiro é o valor inicial, o segundo número é a transformação que será aplicada no valor inicial
        // o Stream.iterate cria um Stream infinito
        Stream
                .iterate(5, n -> n * 2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("====================BufferedReader====================");
        // No metodo BufferedReader, é possível ler as linhas de um arquivo como Stream
        // streams.txt - 11, 12, 13
        File file = new File("C:/streams.txt");
        FileReader in = new FileReader(file);
        BufferedReader br = new BufferedReader(in);
        br.lines().forEach(System.out::println);


        System.out.println("====================Files====================");
        // No metodo Files.list(), é repassado um path (caminho) e retorna um Stream de outros paths (caminhos)
        // é possível obter um stream de todos os paths que estão dentro de outros paths, ou seja, temos todos os subdiretorios do diretório
        Path p = Paths.get("");
        Files.list(p).forEach(System.out::println);

        System.out.println("====================Random====================");
        // Com o metodo Random.ints() é possível criar Stream de números inteiros aleatórios
        // gera uma stream infinita de números randomicos
        new Random()
                .ints()
                .limit(10)
                .forEach(System.out::println);

        System.out.println("====================Pattern====================");
        // O metodo Pattern é utilizado em expressões regulares (regex)
        // podemos passar uma String e será feito um split na String e será repassado como Stream
        String s = "Lorem Ipsum is simply dummy text of the printing and typesetting industry";
        Pattern pattern = Pattern.compile(" ");
        pattern.splitAsStream(s).forEach(System.out::println);


    }
}
