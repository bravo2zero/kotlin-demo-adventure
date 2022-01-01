package adventure;

import adventure.ship.schooner.CabinBoyDuty;
import adventure.ship.schooner.CookDuty;
import adventure.ship.schooner.Schooner;
import adventure.ship.schooner.CaptainDuty;
import adventure.ship.schooner.DoctorDuty;
import adventure.ship.Sailor;

import java.util.Set;

import static java.util.Map.entry;
import static java.util.Map.ofEntries;

public class Adventure {
    public static void main(String[] args) {
        try {
            var ship = new Schooner("Hispaniola");
            ofEntries(
                    entry(new CaptainDuty(), new Sailor("Alexander", "Smollett", null, 42)),
                    entry(new DoctorDuty(), new Sailor("David", "Livesey", "Doc", 39)),
                    entry(new CookDuty(), new Sailor("John", "Silver", "Long", 59)),
                    entry(new CabinBoyDuty(), new Sailor("Jim", "Hawking", null, 16))
            ).forEach((duty, sailor) -> ship.getCrew().put(duty, sailor));

            ship.getProvisions().addAll(Set.of("🍺", "🍖", "🍏", "🍋"));
            ship.prepare();
            ship.sail("Kotlin island");

        } catch (AdventureException e) {
            System.out.println(e.getMessage());
        }
    }
}
