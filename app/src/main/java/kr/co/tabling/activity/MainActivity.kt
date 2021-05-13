package kr.co.tabling.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kr.co.tabling.R
import kr.co.tabling.adapter.ItemAdapter
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
        val listView = findViewById<ListView>(R.id.list_view)
        val request = RetroFitBuilder.service.getItemList();
        request.enqueue(object : Callback<List<Item>> {

            override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                var itemList = response.body();
                val itemAdapter = itemList?.let { ItemAdapter(applicationContext, it) }
                listView.setAdapter(itemAdapter)
                listView.setOnItemClickListener { parent, view, position, id ->
                    val item = itemList?.get(position)
                    val intent = Intent(applicationContext, DetailImageActivity::class.java)
                    if (item != null) {
                        intent.putExtra("imageUrl", item.downloadUrl)
                        intent.putExtra("width", item.width)
                        intent.putExtra("height", item.height)
                    }
                    startActivity(intent)
                }
            }


            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                Log.d("throw ", t.toString())
            }
        })
    }


}