package com.example.isvirin.cleanapp.presentation.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.isvirin.cleanapp.R;
import com.example.isvirin.cleanapp.presentation.model.AutoModel;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AutoListAdapter extends RecyclerView.Adapter<AutoListAdapter.AutoVieHolder> {
    private List<AutoModel> autoModels;
    private final LayoutInflater layoutInflater;

    @Inject
    public AutoListAdapter(Context context) {
        this.layoutInflater = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        autoModels = Collections.emptyList();
    }

    @NonNull
    @Override
    public AutoVieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.item_auto, parent, false);
        return new AutoVieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AutoVieHolder holder, int position) {
        final AutoModel autoModel= autoModels.get(position);
        holder.textViewManufacturer.setText(autoModel.getManufacturer());
        holder.textViewModel.setText(autoModel.getModel());
        holder.textViewPrice.setText(String.valueOf(autoModel.getPrice()));
    }

    @Override
    public int getItemCount() {
        return autoModels.size();
    }

    public void setData(Collection<AutoModel> autoModels){
        this.autoModels = (List<AutoModel>) autoModels;
        this.notifyDataSetChanged();
    }

    class AutoVieHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_model)
        TextView textViewModel;
        @BindView(R.id.tv_manufacturer)
        TextView textViewManufacturer;
        @BindView(R.id.tv_price)
        TextView textViewPrice;

        public AutoVieHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
