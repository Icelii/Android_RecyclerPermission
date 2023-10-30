package com.example.android_recyclerpermission.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_recyclerpermission.R;
import com.example.android_recyclerpermission.models.Permiso;

import java.util.List;

public class PermisosAdapter extends RecyclerView.Adapter<PermisosAdapter.ViewHolder> {

    private List<Permiso> LP;

    public PermisosAdapter(List<Permiso> lp) {
        LP = lp;
    }

    @NonNull
    @Override
    public PermisosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View ly = layoutInflater.inflate(R.layout.permisoitem, parent, false);
        return new ViewHolder(ly);
    }

    @Override
    public void onBindViewHolder(@NonNull PermisosAdapter.ViewHolder holder, int position) {
        Permiso permiso = Permiso.get(position);
        holder.setData(permiso);
    }

    @Override
    public int getItemCount() {
       return Permiso.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Permiso PermisoH;
        TextView txtPermiso;
        Switch swPermiso;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPermiso = itemView.findViewById(R.id.tvPermiso);
            swPermiso = itemView.findViewById(R.id.switch1);
        }

        public void setData(Permiso permiso) {
            this.PermisoH = permiso;
        }
    }
}
