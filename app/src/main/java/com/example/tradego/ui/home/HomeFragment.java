package com.example.tradego.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tradego.R;
import com.example.tradego.model.Carta;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        List<Carta> cartas = new ArrayList<>();

        Carta c1 = new Carta(8, "Terra", "Pedra", 2500, 1300, "Megalith Hagoth");
        Carta c2 = new Carta(7, "Terra", "Guerreiro", 2600, 2300, "Buster Blader");
        Carta c3 = new Carta(8, "Luz", "Psiquico", 2500, 2000, "Mekk-Knight Purple Fall");
        Carta c4 = new Carta(4, "Luz", "Psiquico", 1600, 1000, "Crusadia Maximus");
        Carta c5 = new Carta(10, "Terra", "Maquina", 3000, 3000, "Knight Express Night");
        Carta c6 = new Carta(10, "Luz", "Dinossauro", 3500, 3200, "Ultimate Tyranno Conductor");

        cartas.add(c1);
        cartas.add(c2);
        cartas.add(c3);
        cartas.add(c4);
        cartas.add(c5);
        cartas.add(c6);

        Gson gson = new Gson();

        SharedPreferences preferences = getActivity().getSharedPreferences("json", Context.MODE_PRIVATE);

        String json = gson.toJson(cartas);

        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("json", json);
        editor.commit();

        return root;
    }
}