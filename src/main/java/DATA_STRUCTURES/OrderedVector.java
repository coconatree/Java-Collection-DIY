package DATA_STRUCTURES;

import java.util.Arrays;
import java.util.LinkedList;

import static MATHEMATICS.BASIC.AbsoluteValue.abs;

public class OrderedVector<Type> extends VECTOR<Type>
{
    private final LinkedList<Type> ORDERED_LIST;

    public OrderedVector(Type ... x1) { this.ORDERED_LIST = new LinkedList(Arrays.asList(x1)); }

    public Type get(int index)
    {
        if(index < 0){ index = index_Converter(index); }
        return this.find(index);
    }

    public void add(Type value) { this.ORDERED_LIST.add(value); }

    private Type find(int index) { return this.ORDERED_LIST.get(index); }

    private int index_Converter(int index) { return this.ORDERED_LIST.size() - abs(index) - 1; }

    @Override
    public final LinkedList<Type> getAll() { return this.ORDERED_LIST; }

    @Override
    public int size() { return this.ORDERED_LIST.size(); }

    @Override
    public String toString()
    {
        return "Class : " + this.getClass() + " Items : \n" + this.ORDERED_LIST;
    }
}
