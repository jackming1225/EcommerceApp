package ecommerce.database.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import ecommerce.database.myapplication.model.ItemInventory
import ecommerce.database.myapplication.retrofit.RetrofitRepository
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

internal class HomeItemViewModelTest {


    @Mock
    val repository: RetrofitRepository = Mockito.mock(RetrofitRepository::class.java)

    fun getListItemData() {
    }

    fun getJob() {
    }

    fun setJob() {
    }

    fun getExceptionHandler() {
    }

    @Test
    fun search() {
        val query = "item"

    }

    fun getRepository() {
    }
}