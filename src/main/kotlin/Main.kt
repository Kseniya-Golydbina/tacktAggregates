fun main(){
    val userRepository = UserRepository()
    val orderRepository = OrderRepository()

    val user = userRepository.getUserById(1)
    val order = orderRepository.getOrderById(1)

    val email = EmailAddress("kseniyaG@example.com")
    val userService=UserService()
    val isAuthenticated = userService.service(email)

    println("Покупатель: ${user.name}")
    println("Покупатель аутентифицирован: $isAuthenticated")
    println("ID покупателя: ${user.id}")
    println("Заказ №: ${order.id}")
    println("Статус заказа: ${order.orderStatus}")
    println("Способ оплаты: ${user.paymentMethod}")
    println("Тип карты: ${user.card}")
    println("Email: ${email.value}")
    println("Список продуктов: ")
    order.listProducts.forEach { product ->
        println("Название товара - ${product.name} (${product.description}), Цена товара: ${product.price}")
    }
    println("Адрес доставки: ")
    println("Улица - ${order.deliveryAddress.street}")
    println("Город - ${order.deliveryAddress.city}")
}