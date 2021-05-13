package kr.co.tabling.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kr.co.tabling.R
import kr.co.tabling.model.Item


class ItemAdapter(var mContext: Context, var itemList: List<Item>)
    : BaseAdapter() {

    override fun getCount(): Int {
        return itemList.size
    }

    override fun getItem(position: Int): Any {
        return itemList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view : View

        view = LayoutInflater.from(mContext).inflate(R.layout.item_adapter, null)
        val itemNameTextView = view.findViewById<TextView>(R.id.item_name)
        val itemImageView = view.findViewById<ImageView>(R.id.item_image_view)
        val item = itemList.get(position)
        Glide.with(mContext).load(item.downloadUrl).into(itemImageView);

        itemNameTextView.text = item.author

        return view;
    }
}