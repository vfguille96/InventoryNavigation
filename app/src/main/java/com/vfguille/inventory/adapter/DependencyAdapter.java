package com.vfguille.inventory.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.ivbaranov.mli.MaterialLetterIcon;
import com.vfguille.inventory.R;
import com.vfguille.inventory.data.model.Dependency;
import com.vfguille.inventory.data.repository.DependencyRepository;

import java.util.ArrayList;

public class DependencyAdapter extends RecyclerView.Adapter<DependencyAdapter.ViewHolder> {
    private ArrayList<Dependency> depencyList;
    //private OnDependencyClickListener onDependencyClickListener;
    private OnManageDependencyListener onManageDependencyListener;

    public interface OnManageDependencyListener{
        void onEditDependency(Dependency dependency);
        void onDeleteDependency(Dependency dependency);
    }

    // Los datos se obtienen desde el repository.
    public DependencyAdapter(){
        depencyList = (ArrayList<Dependency>) DependencyRepository.getInstance().getList();
    }

    @NonNull
    @Override
    public DependencyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dependency_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DependencyAdapter.ViewHolder holder, int position) {
        holder.icon.setLetter(depencyList.get(position).getName());
        holder.tvName.setText(depencyList.get(position).getName());
        /*if (onDependencyClickListener != null)
            holder.bind(position, onDependencyClickListener);*/
        holder.bind(depencyList.get(position), onManageDependencyListener);
    }

    /*public void setOnDependencyClickListener(OnDependencyClickListener onDependencyClickListener){
        this.onDependencyClickListener = onDependencyClickListener;
    }*/

    public void setOnManageDependencyClickListener(OnManageDependencyListener onManageDependencyClickListener){
        this.onManageDependencyListener = onManageDependencyClickListener;
    }

    @Override
    public int getItemCount() {
        return depencyList.size();
    }

    public interface OnDependencyClickListener {
        void onClick(Dependency dependency);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        MaterialLetterIcon icon;
        TextView tvName;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.ivIcon);
            tvName = itemView.findViewById(R.id.tvName);
        }

        /*void bind(final int position, final OnDependencyClickListener onDependencyClickListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onDependencyClickListener.onClick(depencyList.get(position));
                }
            });
        }*/

        void bind(final Dependency dependency, final OnManageDependencyListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onEditDependency(dependency);
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onDeleteDependency(dependency);
                    return true;
                }
            });
        }


    }
}