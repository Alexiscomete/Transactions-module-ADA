package lapinousecond.transactions

import io.github.alexiscomete.lapinousecond.commands.CommandWithAccount
import io.github.alexiscomete.lapinousecond.entity.Player
import org.javacord.api.event.message.MessageCreateEvent

class Give : CommandWithAccount("description", "give", "totalDescription") {
    override fun execute(messageCreateEvent: MessageCreateEvent, content: String, args: Array<String>, p: Player) {
        TODO("not yet implemented")
    }
}