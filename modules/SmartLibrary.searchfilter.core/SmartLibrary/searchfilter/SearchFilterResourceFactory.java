package SmartLibrary.searchfilter;

import SmartLibrary.searchfilter.core.SearchFilterResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class SearchFilterResourceFactory{
    private static final Logger LOGGER = Logger.getLogger(SearchFilterFactory.class.getName());

    public SearchFilterResourceFactory()
    {

    }

    public static SearchFilterResource createSearchFilterResource(String fullyQualifiedName, Object ... base)
    {
        SearchFilterResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (SearchFilterResource) constructor.newInstance(base);
        } 
        catch (IllegalArgumentException e)
        {
            LOGGER.severe("Failed to create instance of SearchFilter.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            System.exit(20);
        }
        catch (ClassCastException e)
        {   LOGGER.severe("Failed to create instance of SearchFilter.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
            System.exit(30);
        }
        catch (ClassNotFoundException e)
        {
            LOGGER.severe("Failed to create instance of SearchFilter.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Decorator can't be applied to the object");
            System.exit(40);
        }
        catch (Exception e)
        {
            LOGGER.severe("Failed to create instance of SearchFilter.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(50);
        }
        return record;
    }

}
