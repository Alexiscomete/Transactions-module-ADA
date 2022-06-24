package lapinousecond.transactions

import io.github.alexiscomete.lapinousecond.entity.Owner
import io.github.alexiscomete.lapinousecond.resources.Resource

open class Transaction(var owner0: Owner, val owner1: Owner?, val amount0: Double?, val ressource0: Resource?, val amount1: Double?, val ressource1: Resource?) {
    open fun make() {
        if (owner1 == null || amount0 == null || ressource0 == null || amount1 == null || ressource1 == null) {
            throw IllegalArgumentException("Certains paramètres de la transaction sont invalides")
        } else {
            if (!transactionTwoDirections(owner0, owner1, amount0, ressource0, amount1, ressource1)) {
                throw IllegalStateException("Transaction impossible car les montants sont trop élevés")
            }
        }
    }
}