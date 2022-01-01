package adventure.ship.schooner;

import adventure.AdventureException;
import adventure.ship.Sailor;

import static adventure.ship.Role.Captain;

public class CaptainDuty extends SchoonerDuty {
    @Override
    public void carryOn(Schooner ship, Sailor sailor) throws AdventureException {
        if (ship.getCrew().keySet().stream().noneMatch(duty -> duty instanceof CabinBoyDuty)) {
            report(Captain, sailor, "I need a cabin boy in my crew!");
        }
        say(Captain, sailor, "All aboard!");
    }
}
