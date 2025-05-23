package SmartLibrary.wishlistmanagement;

import SmartLibrary.wishlistmanagement.core.WishlistItemService;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

public class WishlistItemServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(WishlistItemServiceFactory.class.getName());

    public WishlistItemServiceFactory() {
    }

    public static WishlistItemService createWishlistItemService(String fullyQualifiedName, Object ... base) {
        WishlistItemService record = null;
        try {
            Class<?> clz = Class.forName(fullyQualifiedName);
            Constructor<?> constructor = clz.getDeclaredConstructors()[0];
            record = (WishlistItemService) constructor.newInstance(base);
        } 
        catch (IllegalArgumentException e) {
            LOGGER.severe("Failed to create instance of WishlistItemService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to run: Check your constructor argument");
            System.exit(20);
        }
        catch (ClassCastException e) {
            LOGGER.severe("Failed to create instance of WishlistItemService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Failed to cast the object");
            System.exit(30);
        }
        catch (ClassNotFoundException e) {
            LOGGER.severe("Failed to create instance of WishlistItemService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            LOGGER.severe("Decorator can't be applied to the object");
            System.exit(40);
        }
        catch (Exception e) {
            LOGGER.severe("Failed to create instance of WishlistItemService.");
            LOGGER.severe("Given FQN: " + fullyQualifiedName);
            System.exit(50);
        }
        return record;
    }
}