package SmartLibrary.wishlistmanagement;

import SmartLibrary.wishlistmanagement.core.WishlistItemResource;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class WishlistItemResourceFactory {
    private static final Logger LOGGER = Logger.getLogger(WishlistItemResourceFactory.class.getName());

    public WishlistItemResourceFactory() {
    }

    public static WishlistItemResource createWishlistItemResource(String fullyQualifiedName, Object ... base) {
        WishlistItemResource record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (WishlistItemResource) constructor.newInstance(base);
        } 
        catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of WishlistItemResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            System.exit(20);
        }
        catch (ClassCastException e) {
            LOGGER.severe("Failed to create instance of WishlistItemResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
            System.exit(30);
        }
        catch (ClassNotFoundException e) {
            LOGGER.severe("Failed to create instance of WishlistItemResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Decorator can't be applied to the object");
            System.exit(40);
        }
        catch (Exception e) {
            LOGGER.severe("Failed to create instance of WishlistItemResource.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(50);
        }
        return record;
    }
}