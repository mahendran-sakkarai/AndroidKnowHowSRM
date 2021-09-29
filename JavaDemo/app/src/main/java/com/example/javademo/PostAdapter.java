package com.example.javademo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private ArrayList<Post> posts = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bindData(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setData(List<Post> postList) {
        this.posts.clear();
        this.posts.addAll(postList);
        this.notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView id;
        private final TextView userId;
        private final TextView title;
        private final TextView content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id_detail);
            userId = itemView.findViewById(R.id.user_id);
            title = itemView.findViewById(R.id.post_title);
            content = itemView.findViewById(R.id.post_content);
        }

        public void bindData(Post post) {
            id.setText("Id: " + post.getId());
            userId.setText("User Id: " + post.getUserId());
            title.setText(post.getTitle());
            content.setText(post.getBody());
        }
    }
}
