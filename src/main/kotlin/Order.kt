data class DeliveryAddress(val street: String, val city: String)

data class Product(
    val id: Int?,
    val name: String,
    val description: String,
    val price: Int
)

data class Order(
    val id: Int?,
    val orderStatus: String,
    val listProducts: List<Product>,
    val deliveryAddress: DeliveryAddress
){
    init {
        require(listProducts.isNotEmpty()){"Заказ должен содержать хотя бы один продукт"}
    }
}
object OrderStatus{
    const val DELIVERED = "Доставлен"
    const val RECEIVED = "В пути"
    const val CANCELED = "Отменен"
}

class OrderRepository{
    fun getOrderById (id: Int): Order{
        return Order(1, OrderStatus.DELIVERED, listOf(
            Product(1, "Шампунь", "Уход для ваших волос", 500),
            Product(2, "Крем для рук", "Увлажнение сухой кожи", 200)),
            DeliveryAddress("Kosmonavtov", "Moscow"))
    }
}

class OrderFactory{
    fun createOrder(id: Int, orderStatus: String, listProducts: List<Product>, deliveryAddress: DeliveryAddress): Order{
        return Order(id, orderStatus, listProducts, deliveryAddress)
    }
}

