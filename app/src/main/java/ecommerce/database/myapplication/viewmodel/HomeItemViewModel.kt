package ecommerce.database.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ecommerce.database.myapplication.model.ItemInventory
import ecommerce.database.myapplication.retrofit.RetrofitRepository
import io.reactivex.plugins.RxJavaPlugins
import kotlinx.coroutines.*

class HomeItemViewModel(val repository: RetrofitRepository): ViewModel() {

    val listItemData =  MutableLiveData<List<ItemInventory>>()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        RxJavaPlugins.onError(throwable)
    }
//    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
//        onError("Exception handled: ${throwable.localizedMessage}")
//    }
//    val loading = MutableLiveData<Boolean>()
     fun fetchItemList(){
       job =  CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val listItem = repository.fetchItemsList()
           withContext(Dispatchers.Main){
               if(listItem.isSuccessful){
                   listItemData.postValue(listItem.body())
               } else{
                   //
               }
           }
            //update the recycler
        }
    }

    fun search(query: String){
        job =  CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val listItem = repository.fetchSearchItemsList(searchQuery = query)
            withContext(Dispatchers.Main){
                if(listItem.isSuccessful){
                    listItemData.postValue(listItem.body())
                } else {

                }
            }
            //update the recycler
        }
    }

    fun addItemCart(itemId: String, quantity: String){
        job =  CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            //fetching the cart items
            val response = repository.addToCart(itemId, quantity)
            withContext(Dispatchers.Main){
                if(response.isSuccessful){
//                    listItemData.postValue(listItem.body())
                } else{
                    //stores itemid quantity
                }
            }
            //update the recycler
        }
    }
}