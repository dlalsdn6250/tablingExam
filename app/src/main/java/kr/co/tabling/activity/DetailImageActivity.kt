package kr.co.tabling.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kr.co.tabling.R

class DetailImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_image)

        val imageView = findViewById<ImageView>(R.id.detail_image_view)

        val imageUrl = intent.getStringExtra("imageUrl")
        val width = intent.getIntExtra("width", 0)
        val height = intent.getIntExtra("height",0)

        Glide.with(applicationContext)
            .load(imageUrl)
            .apply(RequestOptions().override(width, height))
            .into(imageView);
    }
}