package FILE_UTILITY;

import CONFIGURATION.ConfigLine;
import LOGGER.Logger;
import LOGGER.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static LOGGER.Logger.Level.ERROR;

public class FileUtility
{
    private static Logger LOGGER = LoggerFactory.getLogger(FileUtility.class);

    public static Optional<List<ConfigLine>> openFile(String filename)
    {
        List<ConfigLine> LineList = new LinkedList<>();

        try
        {
            FileReader file_reader = new FileReader(filename);
            BufferedReader buffer = new BufferedReader(file_reader);

            String line;

            while ((line = buffer.readLine()) != null)
            {
                LineList.add(new ConfigLine(line));
            }
            buffer.close();
            return Optional.of(LineList.stream().collect(Collectors.toList()));
        }
        catch (FileNotFoundException e)
        {
            LOGGER.LOG(ERROR, e.getMessage());
            e.printStackTrace();
        }
        catch (IOException e)
        {
            LOGGER.LOG(ERROR, e.getMessage());
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
