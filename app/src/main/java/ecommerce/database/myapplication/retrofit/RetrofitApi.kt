package ecommerce.database.myapplication.retrofit

import ecommerce.database.myapplication.model.ItemInventory
import ecommerce.database.myapplication.model.OrderedItems
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitApi {

    @GET("fetchList/")
    suspend fun fetchItemList(): Response<List<ItemInventory>?>

    @GET("fetchItemData/")
    suspend fun fetchItemData(
        @Query("itemId") itemId: String
    ): Response<ItemInventory>

    @GET("fetchList/")
    suspend fun searchItemList(@Query("query") searchQuery: String): Response<List<ItemInventory>?>

    @POST("addToCart/")
    suspend fun addItemToCart(
        @Query("itemId") itemId: String,
        @Query("quantity") quantity: String): Response<Unit>


    @GET("fetchOrderHistory/")
    suspend fun fetchOrder(): Response<List<OrderedItems>>

    companion object {

        val baseURL = "sunny/"
        var retrofitApi: RetrofitApi? = null
        fun getInstance(): RetrofitApi {
            if(retrofitApi==null) {

                 val retrofit  = Retrofit.Builder().baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                retrofitApi = retrofit.create(RetrofitApi::class.java)
            }
            return retrofitApi!!
        }
    }

}