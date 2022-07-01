package com.example.freetrip.ui.mine.view.myblog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freetrip.R;
import com.example.freetrip.databean.Blog;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Blog> blogArrayList ;
    private MyBlogAdapterCallBack adapterCallBack;

    public RecyclerViewAdapter(MyBlogAdapterCallBack adapterCallBack) {
        this.adapterCallBack = adapterCallBack;
        this.blogArrayList = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mine_blog, parent, false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Blog blog = blogArrayList.get(position);
        RecyclerViewViewHolder viewHolder = (RecyclerViewViewHolder) holder;
        viewHolder.content.setText(blog.getContent());
        viewHolder.time.setText(blog.getBuild_time());
        viewHolder.del.setOnClickListener(v -> {
            adapterCallBack.deleleBlog(String.valueOf(blog.getId()));
        });
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

    private class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        TextView time;
        TextView content;
        Button del;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.text_content);
            time = itemView.findViewById(R.id.text_time);
            del = itemView.findViewById(R.id.bt_del);
        }
    }
}