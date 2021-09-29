package com.example.kotlindemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class PostAdapter : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    private val posts = ArrayList<Post>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.bindData(post)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun setData(postList: List<Post>?) {
        posts.clear()
        posts.addAll(postList!!)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val id: TextView
        private val userId: TextView
        private val title: TextView
        private val content: TextView
        fun bindData(post: Post) {
            id.text = "Id: ${post.id}"
            userId.text = "User Id: ${post.userId}"
            title.text = post.title
            content.text = post.body
        }

        init {
            id = itemView.findViewById(R.id.id_detail)
            userId = itemView.findViewById(R.id.user_id)
            title = itemView.findViewById(R.id.post_title)
            content = itemView.findViewById(R.id.post_content)
        }
    }
}