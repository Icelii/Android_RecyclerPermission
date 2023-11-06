package com.example.android_recyclerpermission.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_recyclerpermission.R;
import com.example.android_recyclerpermission.models.Permiso;

import java.util.List;

public class PermisosAdapter extends RecyclerView.Adapter<PermisosAdapter.ViewHolder> {

    private List<Permiso> LP;

    public PermisosAdapter(List<Permiso> lp) {
        this.LP = lp;
    }

    @NonNull
    @Override
    public PermisosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View ly = layoutInflater.inflate(R.layout.permisoitem, parent, false);
        return new ViewHolder(ly, (Activity) parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull PermisosAdapter.ViewHolder holder, int position) {
        Permiso permiso = LP.get(position);
        holder.setData(permiso);
    }

    @Override
    public int getItemCount() {
        return LP.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Permiso PermisoH;
        TextView txtPermiso;
        Switch swPermiso;
        Activity activity;

        public ViewHolder(@NonNull View itemView, Activity activity) {
            super(itemView);
            txtPermiso = itemView.findViewById(R.id.tvPermiso);
            swPermiso = itemView.findViewById(R.id.switch1);
            this.activity = activity;

            swPermiso.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Context context = itemView.getContext();
                        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CALL_PHONE}, 3321);
                        }

                        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CAMERA}, 1121);
                        }
                    } else {

                    }
                }
            });
        }

        public void Camara() {
            Intent intentCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            activity.startActivity(intentCamara);
        }

        public void llamar(){
            Intent intentcall = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 8714298679"));
            activity.startActivity(intentcall);
        }

        public void setData(Permiso permiso) {
            this.PermisoH = permiso;
            txtPermiso.setText(permiso.getDescripcion());
        }
    }
}
