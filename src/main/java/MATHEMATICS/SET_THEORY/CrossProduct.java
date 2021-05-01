package MATHEMATICS.SET_THEORY;

import DATA_STRUCTURES.Pair;

import java.util.Set;
import java.util.stream.Collectors;

public class CrossProduct<Type_01, Type_02>
{
    private static CrossProduct INSTANCE = null;

    private CrossProduct(){}

    public static CrossProduct getInstance()
    {
        if(INSTANCE == null)
            INSTANCE = new CrossProduct();
        return INSTANCE;
    }

    public Set<Pair<Type_01, Type_02>> cross_Product(Set<Type_01> SET01, Set<Type_02> SET02)
    {
        return SET01
                .stream()
                .map(x1 -> generate_Row(x1, SET02))
                .flatMap(row -> row.stream())
                .collect(Collectors.toSet());
    }

    private Set<Pair<Type_01, Type_02>> generate_Row(Type_01 x1, Set<Type_02> SET02)
    {
        return SET02.stream().map(x2 -> new Pair<>(x1, x2)).collect(Collectors.toSet());
    }

    public static void main(String[] args)
    {
        SetUtility<Integer> setUtility = SetUtility.getInstance();
        CrossProduct<Integer, Integer> crossProduct = CrossProduct.getInstance();

        Set<Integer> SET01 = setUtility.getSet(1, 2, 3, 4, 5);

        crossProduct.cross_Product(SET01, SET01).forEach(System.out::println);
    }
}
