package ecommerce.database.myapplication.model

data class CartData(
    val items: List<ItemInventory>,
    val totalCartValue: String
)
