package collect;

import java.util.ArrayList;
import java.util.HashMap;

public class Java8_Collections {
    public static void main(String[] args) {

        System.out.println("===============List()===============");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("===============forEach() - List===============");
        list.forEach(n -> System.out.println(n));

        System.out.println("===============removeIf()===============");
        // Recebe como parametro um Predicate
        // Será realizado um teste, caso passe o teste, será removido o(s) elemento(s) da lista
        // o removeIf remove todos os valores que atender a condição passada na função lambda
        list.removeIf(n -> n % 2 == 0);
        list.forEach(n -> System.out.println(n));

        System.out.println("===============replaceAll()===============");
        // Recebe como parametro um UnaryOperator (função que recebe um tipo e retorna o mesmo tipo)
        // Utilizado para alterar vários elementos da lista
        list.replaceAll(n -> n * 2);
        list.forEach(n -> System.out.println(n));

        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "Ariel");
        map.put(1, "Alan");
        map.put(2, "Pai");
        map.put(3, "Mãe");
        map.put(4, "Gabi");

        System.out.println("===============forEach() - Map===============");
        //O forEach() do Map implementa um BiConsumer, pois recebe 2 elementos chave e valor do mapa, diferente do forEach() do List que recebe apenas 1 elemento
        // Para cada elemento do mapa, será atribuido chave e valor
        map.forEach((k, v) -> System.out.println(k + v));

        System.out.println("===============compute() - Map===============");
        // O compute() é uma ação que será executada em algum elemento do mapa
        // irá fazer a alteração em 1 elemento especifico do mapa que tenha a chave
        map.compute(1, (k, v) -> v + " e André");
        map.forEach((k, v) -> System.out.println(k + v));

        System.out.println("===============merge() - Map===============");
        // O merge() recebe 3 argumentos chave, valor e expressão lambda
        // o primeiro valor v1 refere-se ao valor da chave o v2 o valor que será acrescentado
        // na expressão lambda foi realizdo a concatenação de v1 e v2
        map.merge(3, "<3", (v1, v2) -> v1 + v2);
        map.forEach((k, v) -> System.out.println(k + v));

        System.out.println("===============repleceAll() - Map===============");
        // O repleceAll() recebe todos os elementos, e há uma função que é aplicada em todos os elementos
        // A função recebe a chave e o valor, onde retorna um novo valor para cada elemento do mapa
        map.replaceAll((k, v) -> v + "!");
        map.forEach((k, v) -> System.out.println(k + v));
    }
}
