package adventure

import adventure.ship.Sailor
import adventure.ship.frigate.FrigateDuty.*
import adventure.ship.frigate.buildFrigate
import adventure.ship.frigate.enlist
import adventure.ship.frigate.load
import adventure.ship.frigate.toDuty

fun main() {
    val ship = buildFrigate("Belly-of-Tea") {
        enlist(
                Sailor("Alexander", "Smollett", null, 42) toDuty Captain,
                Sailor("David", "Livesey", "Doc", 39) toDuty Doctor,
                Sailor("John", "Silver", "Long", 59) toDuty Cook,
                Sailor("Jim", "Hawking", null, 16) toDuty CabinBoy
        )
        load("🍋", "🍎", "🍺", "🥩")
    }
    runCatching {
        ship.prepare()
        ship.sail("Java island")
    }.onFailure { println(it.message) }
}

// delegated properties -> Frigate lazy crew init
// infix functions -> map sailors to roles
// operator overloading -> add to provisions list
// exceptions -> no checked
// higher order functions -> lambdas with receivers, scope functions
// varargs -> add crew
// sealed classes and when
// data classes -> sailor
// return value from control statements (if/when) -> Sailor.toString

// smart casting
// destructuring
// collections & sequences
// generics
// coroutines
// testing & mocking
