package adventure.ship.schooner;

import adventure.AdventureException;
import adventure.ship.Role;
import adventure.ship.Sailor;

import static adventure.ship.Role.Doctor;

public class CabinBoyDuty extends SchoonerDuty {
    @Override
    public void carryOn(Schooner ship, Sailor sailor) throws AdventureException {
        say(Role.CabinBoy, sailor, "Fifteen men on the dead man’s chest!");
    }
}
