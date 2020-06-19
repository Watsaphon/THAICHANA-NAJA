package com.example.thaichana_naja

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import com.example.thaichana_naja.Database.JsonPlaceholderApi
import com.example.thaichana_naja.Database.ShopDao
import com.example.thaichana_naja.Database.ShopDatabase
import com.example.thaichana_naja.Database.ShopEntity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val newWordActivityRequestCode = 1
    val esso: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            val i = Intent(this, ScanActivity::class.java)
            startActivity(i)
        }


    }

    override fun onResume() {
        super.onResume()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        val sub_text = intent.getStringExtra("scannakub")
        val db = Room.databaseBuilder(applicationContext, ShopDatabase::class.java, "shop-list.db").build()

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {

            //Retrofit Builder
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api-customer.thaichana.com/shop/0001/")
                .build()
            //object to call method
            val jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi::class.java)
            val call: Call<ShopEntity> = jsonPlaceholderApi.getUser(sub_text)
            call.enqueue(object : Callback<ShopEntity> {
                override fun onResponse(call: Call<ShopEntity>, response: Response<ShopEntity>) {
                    val esso: ShopEntity = response.body()!!
                    Log.i("tag", esso.toString())
                    val shopDao: ShopDao
                    shopDao = db.ShopDao()
                val storedata = esso

                    shopDao.insertAll(storedata)


                }
                override fun onFailure(call: Call<ShopEntity>, t: Throwable) {
                    Log.e("ERROR", t.message.toString())
                }
            })

        }
        else{}
        }


    }











