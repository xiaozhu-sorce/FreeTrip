package com.example.freetrip.ui.home.view.route;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freetrip.R;
import com.example.freetrip.databean.Route;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Route> routes;

    public RecyclerViewAdapter() {
        this.routes = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_route, parent, false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Route route = routes.get(position);
        RecyclerViewViewHolder viewHolder = (RecyclerViewAdapter.RecyclerViewViewHolder) holder;
        viewHolder.line.setText(route.getLine());
        viewHolder.name.setText(route.getName() + "：");
        viewHolder.price.setText("¥" + route.getPrice());
    }

    @Override
    public int getItemCount() {
        return routes.size();
    }

    public void updateRouteList(final List<Route> routeList){
        this.routes.clear();
        this.routes = routeList;
        notifyDataSetChanged();
    }

    private class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        TextView name, line, price;

        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_route_name);
            line = itemView.findViewById(R.id.text_route_lines);
            price = itemView.findViewById(R.id.text_route_price);
        }
    }
}