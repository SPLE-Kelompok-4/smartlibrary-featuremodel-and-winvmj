package SmartLibrary.communitycontent;

import SmartLibrary.communitycontent.core.CommunityContentResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;
import java.util.Arrays;

public class CommunityContentResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(CommunityContentFactory.class.getName());

    public CommunityContentResourceFactory() {

    }

    public static CommunityContentResource createCommunityContentResource(String fullyQualifiedName, Object... base) {
        CommunityContentResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?>[] constructorList = clz.getDeclaredConstructors();
            Constructor<?> constructor = null;

            for (int i = 0; i < constructorList.length; i++) {
                try {
                    constructor = constructorList[i];
                    System.out.println("Trying constructor: " + constructor.toString());
                    System.out.println("With arguments: " + Arrays.toString(base));
                    record = (CommunityContentResource) constructor.newInstance(base);
                    break; // success
                } catch (IllegalArgumentException e) {
                    if (i < constructorList.length - 1) {
                        System.out.println("Constructor doesn't match. Trying next...");
                        continue;
                    } else {
                        throw e;
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of CommunityContent.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            System.exit(20);
        } catch (ClassCastException e) {
            LOGGER.severe("Failed to create instance of CommunityContent.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
            System.exit(30);
        } catch (ClassNotFoundException e) {
            LOGGER.severe("Failed to create instance of CommunityContent.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Decorator can't be applied to the object");
            System.exit(40);
        } catch (Exception e) {
            LOGGER.severe("Failed to create instance of CommunityContent.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(50);
        }
        return record;
    }

}
