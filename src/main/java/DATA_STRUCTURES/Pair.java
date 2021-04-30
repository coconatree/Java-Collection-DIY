package DATA_STRUCTURES;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Pair<Type_01, Type_02>
{
    @Getter
    private Type_01 x1;
    @Getter
    private Type_02 x2;
}
