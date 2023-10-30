package com.example.android_recyclerpermission;

import static android.Manifest.*;
import static android.Manifest.permission.*;

import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.os.Bundle;

import com.example.android_recyclerpermission.models.Permiso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Permiso> ListaPermisos = new ArrayList<>();
        ListaPermisos.add(new Permiso(Manifest.permission.CALL_PHONE,"Llamar"));
        ListaPermisos.add(new Permiso(Manifest.permission.CAMERA,"Camara"));
    }
}