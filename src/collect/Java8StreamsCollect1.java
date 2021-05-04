package collect;

import java.util.*;
import java.util.stream.Collectors;

public class Java8StreamsCollect1 {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Collect é utilizado com objetos mutaveis

        // primeiro argumento (fornecedor) -  segundo argumento (acumulação) - terceiro (combinação)
        ArrayList<Integer> collect = list.stream()
                .collect(
                        () -> new ArrayList<>(),
                        (l, e) -> l.add(e),
                        (l1, l2) -> l1.addAll(l2)
                );

        System.out.println(list);
        System.out.println(collect);

        System.out.println("==============toList()==========");
        List<Integer> collectToList = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(collectToList);

        System.out.println("==============toSet()==========");
        Set<Integer> collectToSet = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toSet());
        System.out.println(collectToSet);

        System.out.println("==============toCollection()==========");
        LinkedList<Integer> collectToCollection = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toCollection(() -> new LinkedList<>()));
        System.out.println(collectToCollection);

        System.out.println("==============joining()==========");
        String joining = list.stream()
                .map(n -> n.toString())
                .collect(Collectors.joining(";"));
        System.out.println(joining);

        System.out.println("==============averagingInt()==========");
        Double media = list.stream()
                .collect(Collectors.averagingInt(n -> n.intValue()));
        System.out.println(media);

        System.out.println("==============summingInt()==========");
        Integer soma = list.stream()
                .collect(Collectors.summingInt(n -> n.intValue()));
        System.out.println(soma);

        System.out.println("==============summarizingInt()==========");
        IntSummaryStatistics stats = list.stream()
                .collect(Collectors.summarizingInt(n -> n.intValue()));
        System.out.println("IntSummaryStatistics: ");
        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());
        System.out.println(stats.getMax());
        System.out.println(stats.getMin());
        System.out.println(stats.getSum());

        System.out.println("==============counting()==========");
        Long counting = list.stream()
                .collect(Collectors.counting());
        System.out.println(counting);

        System.out.println("==============maxBy()==========");
        list.stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);

        System.out.println("==============minBy()==========");
        list.stream()
                .collect(Collectors.minBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);

        System.out.println("==============groupingBy()==========");
        Map<Integer, List<Integer>> groupingBy = list.stream()
                .collect(Collectors.groupingBy((n) -> n % 3));
        System.out.println(groupingBy);

        System.out.println("==============partitioningBy()==========");
        Map<Boolean, List<Integer>> partitioningBy = list.stream()
                .collect(Collectors.partitioningBy((n) -> n % 3 == 0));
        System.out.println(partitioningBy);

        System.out.println("==============toMap()==========");
        Map<Integer, Integer> toMap = list.stream()
                .collect(Collectors.toMap(n -> n, n -> n * 2));
        System.out.println(toMap);

    }
}
