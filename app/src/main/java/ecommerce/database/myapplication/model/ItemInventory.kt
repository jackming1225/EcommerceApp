package ecommerce.database.myapplication.model

data class ItemInventory(
    val itemId: String,
    val availableQuantity: String,
    val name: String,
    val price: String
)
