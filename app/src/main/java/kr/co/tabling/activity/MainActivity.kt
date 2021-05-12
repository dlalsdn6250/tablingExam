package kr.co.tabling.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.co.tabling.R
import kr.co.tabling.builder.RetroFitBuilder
import kr.co.tabling.model.Item
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getItemList()
    }

    private fun getItemList() {

        val request = RetroFitBuilder.service.getItemList();
        request.enqueue(object : Callback<List<Item>> {

            override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                var itemList = response.body();
                Log.d("response", response.toString())
                Log.d("result", itemList.toString())

                if (itemList != null) {
                    for (item in itemList) {
                        Log.d("downloadUrl", item.downloadUrl);
                    }
                }

            }


            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                Log.d("throw ", t.toString())
            }
        })
    }


}