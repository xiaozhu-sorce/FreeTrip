package com.example.freetrip.ui.tour.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freetrip.R;
import com.example.freetrip.ui.tour.bean.Blog;

import java.util.ArrayList;
import java.util.List;

public class BlogRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<Blog> blogArrayList;

    public BlogRecyclerViewAdapter() {
        this.blogArrayList = new ArrayList<Blog>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_blog,parent,false);
        return new BlogRecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Blog blog = blogArrayList.get(position);
        BlogRecyclerViewViewHolder viewHolder = (BlogRecyclerViewViewHolder) holder;
        viewHolder.name.setText(blog.getName());
        viewHolder.content.setText(blog.getContent());
    }

    @Override
    public int getItemCount() {
        return blogArrayList.size();
    }

    public void updateBlogList(final List<Blog> blogArrayList) {
        this.blogArrayList.clear();
        this.blogArrayList = blogArrayList;
        notifyDataSetChanged();
    }

    private class BlogRecyclerViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        TextView content;
        public BlogRecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.text_name);
            content = itemView.findViewById(R.id.text_content);
        }
    }
}
