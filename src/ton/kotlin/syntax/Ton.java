package ton.kotlin.syntax;

import ton.kotlin.syntax.book.Cow;
import ton.kotlin.syntax.book.FunctionExtensionKt;
import ton.kotlin.syntax.book.GlobalVariablesKt;
import ton.kotlin.syntax.book.HierarchyKt;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//ctrl+alt+shift+K to move ot kotlin
public class Ton {

    public final String name;

    public Ton(String name) {
        this.name = name;
    }

    public String getName() {

        final ArrayList<Integer> objects = new ArrayList<>();

        final Map<String, Set<Integer>> collect = objects.stream().collect(Collectors.groupingBy(v -> v.toString(), Collectors.toSet()));


        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        HierarchyKt.testAnimal(new Cow());
        FunctionExtensionKt.kolyas();
        FunctionExtensionKt.priseTheSun(12);
        GlobalVariablesKt.getAgeOfEmpire();
        System.out.println(GlobalVariablesKt.tatrin);
        return name;
    }
}
