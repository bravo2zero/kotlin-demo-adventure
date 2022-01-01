package adventure

import adventure.ship.Sailor
import adventure.ship.frigate.FrigateDuty.*
import adventure.ship.frigate.buildFrigate
import adventure.ship.frigate.enlistCrew
import adventure.ship.frigate.loadSupplies
import adventure.ship.frigate.toDuty

fun main() {
    val ship = buildFrigate("Belly-of-Tea") {
        enlistCrew(
                Sailor("Alexander", "Smollett", null, 42) toDuty Captain,
                Sailor("David", "Livesey", "Doc", 39) toDuty Doctor,
                Sailor("John", "Silver", "Long", 59) toDuty Cook,
                Sailor("Jim", "Hawking", null, 16) toDuty CabinBoy
        )
        loadSupplies("🍋", "🍎", "🍺", "🥩")
    }
    runCatching {
        ship.prepare()
        ship.sail("Java island")
    }.onFailure { println(it.message) }
}
