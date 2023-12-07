data class EmailAddress(val value: String)

data class User(
    val id: Int?,
    val name: String,
    val email: EmailAddress,
    val card: String,
    val paymentMethod: String
)
{
    init{
        require(name.isNotBlank()) {"Имя не должно быть пустым"}
        require(email.value.isNotBlank()) {"Адрес электронной почты не может быть пустым"}
    }
}

object Card{
    const val VISA = "VISA"
    const val MASTERCARD = "MASTERCARD"
    const val QIWI = "QIWI"
}

object PaymentMethod{
    const val CASH = "CASH"
    const val CARD = "CARD"
    const val ONLINE_PAY = "ONLINE_PAY"
}


class UserService{
    fun service(email: EmailAddress): Boolean{
        return true
    }
}
class UserRepository{
    fun getUserById(id: Int): User{
        return User(1, "Kseniya", EmailAddress("kseniyaG@example.com"),  Card.VISA, PaymentMethod.CARD)
    }
}

class UserFactory{
    fun createOrder(id:Int?, name: String, email: EmailAddress, card: String, paymentMethod: String): User{
        return User(id, name, email, card, paymentMethod)
    }
}