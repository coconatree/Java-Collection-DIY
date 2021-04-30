package MATHEMATICS.SET_THEORY;

import DATA_STRUCTURES.Pair;

import java.util.Set;
import java.util.stream.Collectors;

public class Relation
{
    Set<Pair<Integer, Integer>> CROSS_PRODUCT;
    Set<Pair<Integer, Integer>> DOMAIN;
    RelationFunction<Integer> FUNCTION;

    public Relation()
    {
        CrossProduct<Integer, Integer> crossProduct = CrossProduct.getInstance();
        SetUtility<Integer> setUtility = SetUtility.getInstance();

        this.FUNCTION = (x1, x2) -> (x1 + 1) == (x2 + 3);

        this.CROSS_PRODUCT = crossProduct.cross_Product(setUtility.getSet(1, 2, 3, 4, 5), setUtility.getSet(1, 2, 3, 4, 5));
        this.DOMAIN = this.CROSS_PRODUCT.stream().filter(x -> this.FUNCTION.in_relation(x.getX1(), x.getX2())).collect(Collectors.toSet());

        this.DOMAIN.forEach(System.out::println);
    }

    public static void main(String[] args)
    {
        Relation relation = new Relation();
    }

}
