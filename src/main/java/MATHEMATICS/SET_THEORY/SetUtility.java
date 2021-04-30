package MATHEMATICS.SET_THEORY;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SetUtility<Type>
{
    private static SetUtility INSTANCE = null;

    private SetUtility(){}

    public static SetUtility getInstance()
    {
        if(INSTANCE == null)
            INSTANCE = new SetUtility();
        return INSTANCE;
    }

    public Set<Type> getSet(Type... x1){ return Arrays.stream(x1).collect(Collectors.toSet()); }
}
