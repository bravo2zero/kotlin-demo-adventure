package adventure.ship.schooner;

import adventure.AdventureException;
import adventure.ship.Sailor;
import adventure.ship.Ship;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Schooner implements Ship {

    private final String name;
    private Map<SchoonerDuty, Sailor> crew;
    private Set<String> provisions;
    private boolean readyToSail = false;

    public Schooner(String name) throws AdventureException {
        if (name == null) {
            throw new AdventureException("Schooner must have a name!");
        }
        this.name = name;
    }

    public Map<SchoonerDuty, Sailor> getCrew() {
        if (crew == null) {
            crew = new LinkedHashMap<>();
        }
        return crew;
    }

    public Set<String> getProvisions() {
        if (provisions == null) {
            provisions = new HashSet<>();
        }
        return provisions;
    }

    public boolean isReadyToSail() {
        return readyToSail;
    }

    @Override
    public void prepare() throws AdventureException {
        if (crew.isEmpty()) {
            throw new AdventureException("Ship has no crew!");
        }
        for (var entry : crew.entrySet()) {
            var duty = entry.getKey();
            var sailor = entry.getValue();
            if (duty != null && sailor != null) {
                duty.carryOn(this, sailor);
            } else {
                throw new AdventureException(String.format("We cannot go without %s", duty));
            }
        }
        readyToSail = true;
    }

    @Override
    public void sail(String course) throws AdventureException {
        if (course == null) {
            throw new AdventureException("Ship needs a course!");
        }
        if (!isReadyToSail()) {
            throw new AdventureException("Ship is not ready - you must prepare your ship first!");
        }
        System.out.printf("\nAye-aye, Captain! '%s' is sailing to %s%n", name, course);
    }
}

