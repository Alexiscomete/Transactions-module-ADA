package lapinousecond.transactions

import io.github.alexiscomete.lapinousecond.entity.Owner
import io.github.alexiscomete.lapinousecond.entity.Player
import io.github.alexiscomete.lapinousecond.messagesManager
import io.github.alexiscomete.lapinousecond.resources.Resource
import io.github.alexiscomete.lapinousecond.view.AnswerEnum
import org.javacord.api.entity.channel.TextChannel
import org.javacord.api.event.message.MessageCreateEvent
import org.javacord.api.interaction.MessageComponentInteraction

open class FullTransactionWithVerification(
    owner0: Owner,
    owner1: Owner?,
    amount0: Double?,
    ressource0: Resource?,
    amount1: Double?,
    ressource1: Resource?,
    isValid0: Boolean,
    isValid1: Boolean,
) : TransactionWithVerification(owner0, owner1, amount0, ressource0, amount1, ressource1, isValid0, isValid1) {

    fun askAmounts() {
        // si un montant est null, on demande le montant. Attention : l'owner doit être défini avant
    }

    fun askRessources() {

    }
}