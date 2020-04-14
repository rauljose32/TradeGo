package com.example.tradego.ui.itens;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.tradego.R;
import com.example.tradego.model.Carta;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItensFragment extends Fragment {

    SharedPreferences preferences;
    ListView listView;
    private List<HashMap<String, String>> cartas;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_itens, container, false);

        cartas = new ArrayList();
        preferences = getContext().getSharedPreferences("json", Context.MODE_PRIVATE);
        listView = root.findViewById(R.id.listViewCartas);
        String json = preferences.getString("json", null);
        gerarJson(json);

        return root;
    }

    private void gerarJson(String json) {
        Gson gson = new Gson();
        try {

            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                Carta c = gson.fromJson(String.valueOf(array.getJSONObject(i)), Carta.class);

                HashMap<String, String> list = new HashMap<>();
                list.put("nome", c.getNome());
                list.put("atributo", c.getAtributo());
                list.put("estrelas", String.valueOf(c.getEstrelas()));
                list.put("tipo", c.getTipo());
                list.put("atk", String.valueOf(c.getAtaque()));
                list.put("def", String.valueOf(c.getDefesa()));

                cartas.add(list);
            }
            criarLista();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void criarLista() {
        ListAdapter adapter = new SimpleAdapter(
                getContext(),
                cartas,
                R.layout.item_list,
                new String[]{"nome", "atributo", "estrelas", "tipo", "atk", "def"},
                new int[]{R.id.textViewNome, R.id.textViewAtributo, R.id.textViewEstrelas, R.id.textViewTipo, R.id.textViewAtk, R.id.textViewDef});
        listView.setAdapter(adapter);
    }
}
