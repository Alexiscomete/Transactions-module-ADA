package lapinousecond.transactions

import io.github.alexiscomete.lapinousecond.entity.Player

class RessourceTransaction(
    addMoney: (Double) -> Unit,
    removeMoney: (Double) -> Unit,
    getMoney: () -> Double,
    player: Player,
    max: () -> Double,
) : FullTransaction(addMoney, removeMoney, getMoney, player, max) {
}