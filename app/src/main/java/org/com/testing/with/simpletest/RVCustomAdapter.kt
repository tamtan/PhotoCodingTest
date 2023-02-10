package org.com.testing.with.simpletest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

/**
 * TODO: Implement the Adapter that will populate a RecyclerView using the information generated in ViewModel
 * */

class RVCustomAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val list = mutableListOf<Article>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_view_item, parent, false)
        return CustomeViewHolder(itemView = itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is CustomeViewHolder){
            holder.bind(list[position])
        }
    }

    fun setData(list: List<Article>){
        this.list.clear()
        this.list.addAll(list)
    }

}

class CustomeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val imageView: ImageView = itemView.findViewById<ImageView>(R.id.mImageViewCardViewItem)
    val title = itemView.findViewById<TextView>(R.id.mTextViewTitle)
    val content = itemView.findViewById<TextView>(R.id.mTextViewContent)
    fun bind(data: Article){
        Picasso.get().load(data.imageURL).into(imageView)
        title.text = data.title
        content.text = data.content
    }
}