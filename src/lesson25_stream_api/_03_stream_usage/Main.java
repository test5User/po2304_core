package lesson25_stream_api._03_stream_usage;

import lesson24_lambda._00_brains.BrainCat;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        var cats = List.of(
                new BrainCat("Mur", 10),
                new BrainCat("Murka", 6),
                new BrainCat("Mashka", 2),
                new BrainCat("Vaska", 14)
        );

        System.out.println(cats.stream()
                .max(new FlatMapCatComparator()).get());

        //.filter
        var stream = cats.stream()
                .filter(cat -> cat.getAge() > 3)
                .filter(cat -> cat.getName().length() >= 5);
        //.map
        cats.stream()
                .map(BrainCat::getName);

        List.of(
                new FlatMapCat("cat1", 5, List.of("Mouse", "Ball")),
                new FlatMapCat("cat2", 5, List.of("Toy1", "Toy2"))
        ).stream().flatMap(cat -> cat.getToys().stream())
                .collect(Collectors.toList()).forEach(System.out::println);

        //.foreach
        System.out.println("_____Foreach_____");
        cats.forEach(System.out::println);

        //.sorted
        System.out.println("_____Sorted_____");
        cats.stream()
                .sorted()
                .forEach(it -> System.out.print(it + ", "));
        System.out.println();
        cats.stream()
                .sorted(new FlatMapCatComparator())
                .forEach(it -> System.out.print(it + ", "));
        System.out.println();
        //.concat
        System.out.println("_____Concat_____");
        var brainCatsStream = cats.stream();
        var flatMapCatsStream = List.of(
                new FlatMapCat("cat1", 5, List.of("Mouse", "Ball")),
                new FlatMapCat("cat2", 5, List.of("Toy1", "Toy2"))
        ).stream().map(cat -> new BrainCat(cat.getName(), cat.getAge()));
        Stream.concat(brainCatsStream, flatMapCatsStream).forEach(System.out::print);
        System.out.println();
        System.out.println("_____Distinct_____");
        var numbers = List.of(1,2,2,4,4,5,5);
        numbers.stream().distinct().forEach(System.out::print);
        System.out.println();
        System.out.println("_____Skip&limit_____");
        var numbers1 = List.of(1,2,3,4,5,6,7);
        numbers1.stream().skip(2).limit(3).forEach(System.out::print);
        System.out.println();

        //count
        System.out.println("_____Count_____");
        System.out.println(cats.stream().count());

        //findFirst
        System.out.println("_____findFirst_____");
        System.out.println(cats.stream().findFirst().get());

        //findAny
        System.out.println("_____findAny_____");
        System.out.println(cats.stream().findAny().get());

        //allMatch
        System.out.println("_____allMatch_____");
        System.out.println(cats.stream().allMatch(it-> it.getName().length()>=3));
        System.out.println(cats.stream().allMatch(it-> it.getAge() > 5));

        //anyMatch
        System.out.println("_____anyMatch_____");
        System.out.println(cats.stream().anyMatch(it-> it.getAge() > 5));

        //noneMatch
        System.out.println("_____noneMatch_____");
        System.out.println(cats.stream().noneMatch(it-> it.getAge() < 1));

        //max
        System.out.println("_____max_____");
        System.out.println(cats.stream()
                .max(new FlatMapCatComparator()).get());

        //min
        System.out.println("_____min_____");
        System.out.println(cats.stream()
                .min(new FlatMapCatComparator()).get());

        //reduce(BinaryOperator<T> accumulator)
        System.out.println("_____reduce1_____");
        System.out.println(Stream.of(1,2,3,4,5,-1,-2,-3,-4,-5).reduce((x, y) -> x + y).get());
        System.out.println(Stream.of(1,2,3,4,5,-1,-2,-3,-4,-5).reduce((x, y) -> x * y).get());

        //reduce(T identity, BinaryOperator<T> accumulator)
        System.out.println("_____reduce2_____");
        System.out.println(Stream.<Integer>empty().reduce(5, (x, y) -> x + y));
        System.out.println(Stream.of(1,2,3,4,5,-1,-2,-3,-4,-5).reduce(1, (x, y) -> x + y));
        System.out.println(Stream.of(1,2,3,4,5,-1,-2,-3,-4,-5).reduce(0, (x, y) -> x * y));

        //reduce3
        System.out.println("_____reduce3_____");
        Stream<BrainCat> catStream = Stream.of(
                new BrainCat("Cat1", 1),
                new BrainCat("Cat2", 5),
                new BrainCat("Cat3", 4),
                new BrainCat("Cat4", 2)
        );
        int sum = catStream.reduce(0,
                (x,y) -> {
                    if (y.getAge()<3) {
                        return x + y.getAge();
                    }
                    else
                        return x + 0;
                }, (x,y) -> x + y);
        System.out.println(sum);

        //collect
        System.out.println("_____collect_____");
        var adultCats = cats.stream()
                .filter(it -> it.getAge() > 5)
                .collect(Collectors.toList());
        System.out.println(adultCats.getClass().getName());
        adultCats.forEach(System.out::println);

        var adultCats1 = cats.stream()
                .filter(it -> it.getAge() > 5)
                .collect(Collectors.toSet());
        System.out.println(adultCats1.getClass().getName());
        adultCats1.forEach(System.out::println);

        Map<String, Integer> catsMap = cats.stream()
                .collect(Collectors.toMap(k -> k.getName(), v -> v.getAge()));
        catsMap.forEach((k, v) -> System.out.println(k + " " + v));

        cats.stream()
                .filter(it -> StringUtils.startsWith(it.getName(), "M"))
                .collect(Collectors.toCollection(LinkedList::new));

        //parallel
        var people = List.of("Tom", "Bob", "Sam", "Kate", "Tim", "Ann");
        people.stream().filter(p -> p.length() == 3).forEach(p -> System.out.print(p + ", "));
        System.out.println();
        people.parallelStream().filter(p -> p.length() == 3).forEach(p -> System.out.print(p + ", "));
    }
}
