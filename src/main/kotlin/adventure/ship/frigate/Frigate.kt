package adventure.ship.frigate

import adventure.AdventureException
import adventure.ship.Duty
import adventure.ship.Role
import adventure.ship.Sailor
import adventure.ship.Ship

class Frigate(
        private val name: String,
) : Ship {

    val crew by lazy { mutableMapOf<FrigateDuty, Sailor>() }
    val provisions by lazy { mutableSetOf<String>() }
    private var ready = false

    override fun prepare() {
        crew.ifEmpty { throw AdventureException("Ship has no crew!") }
        crew.forEach { (duty, sailor) ->
            duty.carryOn(this, sailor)
        }
        ready = true
    }

    override fun sail(course: String) {
        when {
            ready -> println("\nAye-aye, Captain! $name is sailing to $course")
            else -> throw AdventureException("Ship is not ready - you must prepare your ship first!")
        }
    }
}



sealed class FrigateDuty : Duty<Frigate> {

    object Captain : FrigateDuty() {
        private val role = Role.Captain
        override fun carryOn(ship: Frigate, sailor: Sailor) {
            when {
                ship.crew.containsKey(CabinBoy) -> say(role, sailor, "All board!")
                else -> report(role, sailor, "I need a cabin boy in my crew!")
            }
        }
    }

    object Cook : FrigateDuty() {
        private val role = Role.Cook
        override fun carryOn(ship: Frigate, sailor: Sailor) {
            when {
                ship.provisions.size >= 3 -> say(role, sailor, "Pint of grog to everyone!")
                else -> report(role, sailor, "Ship has not enough food!")
            }
        }
    }

    object Doctor : FrigateDuty() {
        private val role = Role.Doctor
        override fun carryOn(ship: Frigate, sailor: Sailor) {
            when {
                ship.provisions.contains("🍋") -> say(role, sailor, "I will be in my cabin")
                else -> report(role, sailor, "Sailors will get scurvy without lemons!")
            }
        }
    }

    object CabinBoy : FrigateDuty() {
        private val role = Role.CabinBoy
        override fun carryOn(ship: Frigate?, sailor: Sailor?) {
            say(role, sailor, "Fifteen men on the dead man’s chest")
        }
    }
}
