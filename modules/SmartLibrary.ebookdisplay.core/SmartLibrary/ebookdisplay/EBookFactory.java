package SmartLibrary.ebookdisplay;

import SmartLibrary.ebookdisplay.core.EBook;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;
import java.util.Arrays;

public class EBookFactory {
    private static final Logger LOGGER = Logger.getLogger(EBookFactory.class.getName());

    public EBookFactory() {
    }

    public static EBook createEBook(String fullyQualifiedName, Object... base) {
        EBook record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?>[] constructorList = clz.getDeclaredConstructors();
            Constructor<?> constructor = null;

            // Log what's being passed
            LOGGER.info("Creating EBook with parameters: " + Arrays.toString(base));
            
            // Try each constructor until one works
            for (int i = 0; i < constructorList.length; i++) {
                try {
                    constructor = constructorList[i];
                    LOGGER.info("Trying constructor: " + constructor.toString());
                    record = (EBook) constructor.newInstance(base);
                    break; // success
                } catch (IllegalArgumentException e) {
                    if (i < constructorList.length - 1) {
                        LOGGER.info("Constructor doesn't match. Trying next...");
                        continue;
                    } else {
                        throw e;
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of EBook.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            LOGGER.severe("Arguments: " + Arrays.toString(base));
            e.printStackTrace();
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to create instance of EBook.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Failed to create instance of EBook.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Decorator can't be applied to the object");
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Failed to create instance of EBook.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Exception: " + e.getMessage());
            e.printStackTrace();
            System.exit(50);
        }
        return record;
    }
}