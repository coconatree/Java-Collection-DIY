package MATHEMATICS.SET_THEORY;

@FunctionalInterface
public interface RelationFunction<Type>
{
    boolean in_relation(Type x1, Type x2);
}
