package designPatterns

enum class NotificationType {
    EMAIL,
    SMS,
    PUSH,
}

abstract class NotificationService(){
    abstract fun send(message: String): Boolean
}

class EmailNotification: NotificationService() {
    override fun send(message: String): Boolean {
        println("Email notification sent...")
        return true
    }
}

class SMSNotification: NotificationService() {
    override fun send(message: String): Boolean {
        println("SMS notification sent...")
        return true
    }
}

class PushNotification: NotificationService() {
    override fun send(message: String): Boolean {
        println("Push notification sent...")
        return true
    }
}

class NotificationFactory {
    companion object {
        fun getNotificationService(type: NotificationType): NotificationService = when (type) {
            NotificationType.EMAIL -> EmailNotification()
            NotificationType.SMS -> SMSNotification()
            NotificationType.PUSH -> PushNotification()
        }
    }
}

data class UserInfo(val email: String, val phone: String? = null, val authToken: String? = null)

fun main() {
    val user1 = UserInfo("sabari@gmail.com", "9944955911", "token@@@%%end")
    // Send Notification
    NotificationFactory.getNotificationService(NotificationType.EMAIL).send("message")

    if (user1.phone != null)
        NotificationFactory.getNotificationService(NotificationType.SMS).send("message")

    user1.authToken?.let {
        NotificationFactory.getNotificationService(NotificationType.PUSH).send("message")
    }
}