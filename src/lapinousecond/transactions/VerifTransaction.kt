package lapinousecond.transactions

import io.github.alexiscomete.lapinousecond.buttonsManager
import io.github.alexiscomete.lapinousecond.entity.Player
import io.github.alexiscomete.lapinousecond.save.SaveLocation
import io.github.alexiscomete.lapinousecond.save.generateUniqueID
import io.github.alexiscomete.lapinousecond.view.AnswerEnum
import org.javacord.api.entity.channel.TextChannel
import org.javacord.api.entity.message.MessageBuilder
import org.javacord.api.entity.message.component.ActionRow
import org.javacord.api.entity.message.component.Button
import org.javacord.api.entity.message.embed.EmbedBuilder
import org.javacord.api.event.interaction.MessageComponentCreateEvent
import java.awt.Color

open class VerifTransaction(
    addMoney: (Double) -> Unit,
    removeMoney: (Double) -> Unit,
    getMoney: () -> Double,
    val p: Player
) : Transaction(addMoney, removeMoney, getMoney) {
    fun askVerif(quantity: Double, textChannel: TextChannel?) {
        val id = generateUniqueID()
        val embedBuilder = EmbedBuilder()
            .setTitle(p.getAnswer(AnswerEnum.CONFIRMATION, true))
            .setColor(Color.BLUE)
            .setDescription(p.getAnswer(AnswerEnum.MONTANT_TR, true, quantity.toString()))
        val messageBuilder = MessageBuilder()
            .addEmbed(embedBuilder)
            .addComponents(ActionRow.of(Button.success(id.toString(), "Valider")))
        messageBuilder.send(textChannel)
        buttonsManager.addButton(id) { messageComponentCreateEvent: MessageComponentCreateEvent ->
            if (messageComponentCreateEvent.messageComponentInteraction.user.id == p.id) {
                make(
                    quantity,
                    p,
                    { str: String? ->
                        messageComponentCreateEvent.messageComponentInteraction.createImmediateResponder()
                            .setContent(str).respond()
                    }) { str: String? ->
                    messageComponentCreateEvent.messageComponentInteraction.createImmediateResponder().setContent(str)
                        .respond()
                }
            }
        }
    }
}