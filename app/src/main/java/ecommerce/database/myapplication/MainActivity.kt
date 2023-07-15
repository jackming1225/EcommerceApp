package ecommerce.database.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ecommerce.database.myapplication.retrofit.RetrofitApi
import ecommerce.database.myapplication.retrofit.RetrofitClient
import ecommerce.database.myapplication.retrofit.RetrofitRepository
import ecommerce.database.myapplication.viewmodel.HomeItemViewModel

class MainActivity : AppCompatActivity() {
    lateinit var homeItemViewModel: HomeItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofit = RetrofitApi.getInstance()
        val retrofitRepository = RetrofitRepository(retrofitCall = retrofit)



    }
}