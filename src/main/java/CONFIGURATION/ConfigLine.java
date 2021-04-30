package CONFIGURATION;

import DATA_STRUCTURES.OrderedVector;
import DATA_STRUCTURES.VECTOR;

import LOGGER.Logger;
import LOGGER.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

import static LOGGER.Logger.Level.ERROR;

public class ConfigLine
{
    Logger LOGGER = LoggerFactory.getLogger(ConfigLine.class);

    private String line;

    public ConfigLine(String line)
    {
        this.line = line;
    }

    public Set<OrderedVector<String>> parser(char ch)
    {
        Set<OrderedVector<String>> RETURN_VECTOR = new HashSet<>();

        OrderedVector<String> KEY = new OrderedVector<>();
        OrderedVector<String> VAL = new OrderedVector<>();

        String current_value = "";

        char curr;
        char next;

        int size = this.line.length();

        boolean validator = true;

        for(int i = 0; i < size; i++)
        {
            if(i == size - 1)
            {
                current_value += this.line.charAt(size - 1);
                this.validate_Reserved_Words(current_value);
                VAL.add(current_value);
                break;
            }

            curr = this.line.charAt(i);
            next = this.line.charAt(i);

            if(next == ch && 0 < current_value.length())
            {
                if(current_value.equals("Key") && validator)
                {
                    KEY.add(current_value);
                    validator = false;
                }
                else if(current_value.equals("Val") && validator)
                {
                    VAL.add(current_value);
                    validator = false;
                }
                else
                {
                    this.validate_Reserved_Words(current_value);
                    KEY.add(current_value);
                    validator = true;
                }
                current_value = "";
            }
            if(curr != ch)
                current_value += curr;
        }

        RETURN_VECTOR.add(KEY);
        RETURN_VECTOR.add(VAL);

        return RETURN_VECTOR;
    }

    private void validate_Reserved_Words(String value)
    {
        if(value.equals("Key") || value.equals("Val"))
        {
            LOGGER.LOG(ERROR, "Each Line of Configuration File Should Contain Only 1 Of Each 'Key - Val'");
            System.exit(-1);
        }
    }

    @Override
    public String toString()
    {
        return this.line;
    }
}
