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
import java.util.List;

public class DependencyAdapter extends RecyclerView.Adapter<DependencyAdapter.ViewHolder> {
    private ArrayList<Dependency> list;
    private OnDependencyClickListener onDependencyClickListener;
    private OnManageDependencyListener onManageDependencyListener;

    public void delete(Dependency deleted) {
        list.remove(deleted);
    }

    public interface OnManageDependencyListener{
        void onEditDependency(Dependency dependency);
        void onDeleteDependency(Dependency dependency);
    }

    // Los datos se obtienen desde el repository.
    public DependencyAdapter(){
        //list = DependencyRepository.getInstance().getList();
        list = new ArrayList<>();
    }

    public DependencyAdapter(OnManageDependencyListener listener){
        list = DependencyRepository.getInstance().getList();
        onManageDependencyListener = listener;

    }


    @NonNull
    @Override
    public DependencyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dependency_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DependencyAdapter.ViewHolder holder, int position) {
        holder.icon.setLetter(list.get(position).getName());
        holder.tvName.setText(list.get(position).getName());
        /*if (onDependencyClickListener != null)
            holder.bind(position, onDependencyClickListener);*/
        holder.bind(list.get(position), onManageDependencyListener);
    }

    /*public void setOnDependencyClickListener(OnDependencyClickListener onDependencyClickListener){
        this.onDependencyClickListener = onDependencyClickListener;
    }*/

    public void setOnManageDependencyClickListener(OnManageDependencyListener onManageDependencyClickListener){
        this.onManageDependencyListener = onManageDependencyClickListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnDependencyClickListener {
        void onClick(Dependency dependency);
    }

    public void clear() {
        list.clear();
    }

    public void load(List<Dependency> dependencyList) {
        list.addAll(dependencyList);
        notifyDataSetChanged();
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
                    onDependencyClickListener.onClick(list.get(position));
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