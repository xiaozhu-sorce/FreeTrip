package com.example.freetrip.ui.mine.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freetrip.R;
import com.example.freetrip.ui.mine.model.MyBlog;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<MyBlog> blogArrayList;

    public RecyclerViewAdapter() {
        this.blogArrayList = new ArrayList<MyBlog>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mine_blog, parent, false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyBlog blog = blogArrayList.get(position);
        RecyclerViewViewHolder viewHolder = (RecyclerViewViewHolder) holder;
        viewHolder.content.setText(blog.getContent());
    }

    @Override
    public int getItemCount() {
        return blogArrayList.size();
    }

    public void updateBlogList(final List<MyBlog> blogArrayList) {
        this.blogArrayList.clear();
        this.blogArrayList = blogArrayList;
        notifyDataSetChanged();
    }

    private class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        TextView content;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.text_content);
        }
    }
}