package lapinousecond.transactions

import io.github.alexiscomete.lapinousecond.entity.Owner
import io.github.alexiscomete.lapinousecond.resources.Resource

open class TransactionWithVerification(
    owner0: Owner, owner1: Owner?, amount0: Double?, ressource0: Resource?, amount1: Double?, ressource1: Resource?, var isValid0: Boolean, var isValid1: Boolean
) : Transaction(
    owner0, owner1, amount0, ressource0, amount1, ressource1
) {

}