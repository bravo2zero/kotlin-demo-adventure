package adventure.ship.schooner;

import adventure.AdventureException;
import adventure.ship.Sailor;

import static adventure.ship.Role.Cook;

public class CookDuty extends SchoonerDuty {
    @Override
    public void carryOn(Schooner ship, Sailor sailor) throws AdventureException {
        if (ship.getProvisions().size() > 2) {
            say(Cook, sailor, "Pint of grog to everyone!");
        }else{
            report(Cook, sailor, "Ship has not enough food!");
        }
    }
}
