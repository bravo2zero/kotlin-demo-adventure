package adventure.ship.frigate

import adventure.ship.Sailor


fun buildFrigate(name: String, init: Frigate.() -> Unit): Frigate {
    val frigate = Frigate(name)
    frigate.init()
    return frigate
}

fun Frigate.enlistCrew(vararg members: Pair<FrigateDuty, Sailor>) {
    this.crew.putAll(members)
}

fun Frigate.loadSupplies(vararg supplies: String) {
    this.provisions.addAll(supplies)
}

infix fun Sailor.toDuty(duty: FrigateDuty): Pair<FrigateDuty, Sailor> = Pair(duty, this)
