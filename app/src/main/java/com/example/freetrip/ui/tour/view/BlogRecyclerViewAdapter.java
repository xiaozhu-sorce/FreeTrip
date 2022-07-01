package com.example.freetrip.ui.tour.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freetrip.R;
import com.example.freetrip.databean.Blog;

import java.util.ArrayList;
import java.util.List;

public class BlogRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Blog> blogArrayList;
    AdapterCallBack adapterCallBack;

    public BlogRecyclerViewAdapter(AdapterCallBack adapterCallBack) {
        this.adapterCallBack = adapterCallBack;
        this.blogArrayList = new ArrayList<Blog>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_blog, parent, false);
        return new BlogRecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Blog blog = blogArrayList.get(position);
        BlogRecyclerViewViewHolder viewHolder = (BlogRecyclerViewViewHolder) holder;
        viewHolder.name.setText(blog.getUser_name());
        viewHolder.content.setText(blog.getContent());
        viewHolder.time.setText(blog.getBuild_time());
        viewHolder.pra.setText(blog.getPraise());

        viewHolder.thumb.setOnClickListener(v -> {
            int num = Integer.parseInt(blog.getPraise());
            adapterCallBack.dianzan(blog.getId());
            viewHolder.thumb.setBackgroundResource(R.drawable.ic_baseline_star_24);
            viewHolder.pra.setText(String.valueOf(num+1));
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

    private class BlogRecyclerViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,time;
        TextView content,pra;
        ImageButton thumb;

        public BlogRecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.text_name);
            time = itemView.findViewById(R.id.text_time);
            content = itemView.findViewById(R.id.text_content);
            pra = itemView.findViewById(R.id.text_pra);
            thumb = itemView.findViewById(R.id.ib_pra);
        }
    }
}
