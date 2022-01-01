package adventure.ship;

import adventure.AdventureException;

@FunctionalInterface
public interface Duty<T extends Ship> {

    void carryOn(T ship, Sailor sailor) throws AdventureException;

    default void say(Role role, Sailor sailor, String message) {
        if (role != null && sailor != null) {
            System.out.println(role + " " + sailor + " says: " + message);
        }
    }

    default void report(Role role, Sailor sailor, String message) throws AdventureException {
        if (role != null && sailor != null) {
            throw new AdventureException(role + " " + sailor + " reports: " + message);
        }
    }

}
