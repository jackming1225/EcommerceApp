package ecommerce.database.myapplication.model

data class OrderedItems(
    val orderId: String,
    val items: List<ItemInventory>,
    val totalOrderValue: String,
    val orderedDate: String
)
