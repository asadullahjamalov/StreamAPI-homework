package az.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        Person p1 = new Person(1, "Ali", "Aliyev", "27");
        Person p2 = new Person(2, "Vali", "Valiyev", "12");
        Person p3 = new Person(3, "Hasan", "Hasanli", "19");
        Person p4 = new Person(4, "Ugur", "Bedelov", "9");
        Person p5 = new Person(5, "Suleyman", "Memmedov", "18");
        Person p6 = new Person(6, "Tural", "Cemilli", "32");
        List<Person> personList = Arrays.asList(p1, p2, p3, p4, p5, p6);

        List<Person> listOfPeopleAbove18 = personList.stream()
                .filter(item -> Integer.parseInt(item.age) > 18)
                .collect(Collectors.toList());
        listOfPeopleAbove18.forEach(item -> System.out.println(item.toString()));


        double mean = personList.stream()
                .map(item -> Integer.parseInt(item.age))
                .reduce(0, Integer::sum).doubleValue() / personList.size();
        System.out.println(mean);


        int sum = personList.stream()
                .map(item -> Integer.parseInt(item.age))
                .filter(item -> item > 18)
                .reduce(0, (e1, e2) -> e1 + e2);
        System.out.println(sum);

    }
}
