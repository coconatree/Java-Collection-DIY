package MATHEMATICS.BASIC;

public class AbsoluteValue
{
    protected AbsoluteValue() {}

    public static int abs(int x)
    {
        return (x < 0) ? x * - 1 : x;
    }
}
