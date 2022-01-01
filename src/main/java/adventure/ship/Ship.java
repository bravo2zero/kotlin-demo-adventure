package adventure.ship;

import adventure.AdventureException;

public interface Ship {

    void prepare() throws AdventureException;

    void sail(String course) throws AdventureException;
}
