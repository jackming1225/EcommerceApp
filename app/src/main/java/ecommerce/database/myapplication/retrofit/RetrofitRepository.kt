package ecommerce.database.myapplication.retrofit

class RetrofitRepository(val retrofitCall: RetrofitApi) {

    suspend fun fetchItemsList() = retrofitCall.fetchItemList()
    suspend fun fetchSearchItemsList(searchQuery: String) = retrofitCall.searchItemList(searchQuery)
    suspend fun addToCart(itemId: String, quantity: String) = retrofitCall.addItemToCart(itemId, quantity)


}