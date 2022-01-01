package adventure.ship.schooner;

import adventure.AdventureException;
import adventure.ship.Sailor;

import static adventure.ship.Role.Doctor;

public class CabinBoyDuty extends SchoonerDuty {
    @Override
    public void carryOn(Schooner ship, Sailor sailor) throws AdventureException {
        if (!ship.getProvisions().contains("🍋")) {
            report(Doctor, sailor, "Sailors will get scurvy without lemons!");
        }
        say(Doctor, sailor, "I will be in my cabin");
    }
}
