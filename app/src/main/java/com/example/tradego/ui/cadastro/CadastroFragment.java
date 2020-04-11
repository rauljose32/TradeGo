package com.example.tradego.ui.cadastro;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.tradego.MainActivity;
import com.example.tradego.R;
import com.example.tradego.model.Carta;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class CadastroFragment extends Fragment {

    private EditText nomeCarta;
    private EditText atributoCarta;
    private EditText tipoCarta;
    private EditText estrelasCarta;
    private EditText atkCarta;
    private EditText defCarta;
    private Button buttonCadastrar;
    private SharedPreferences preferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_cadastro, container, false);

        preferences = getActivity().getSharedPreferences("json", Context.MODE_PRIVATE);

        nomeCarta = root.findViewById(R.id.textNomeCarta);
        atributoCarta = root.findViewById(R.id.textAtributoCarta);
        tipoCarta = root.findViewById(R.id.textTipoCarta);
        estrelasCarta = root.findViewById(R.id.textEstrelas);
        atkCarta = root.findViewById(R.id.textAtaque);
        defCarta = root.findViewById(R.id.textDefesa);
        buttonCadastrar = root.findViewById(R.id.buttonCadastrar);


        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carta c = new Carta();

                String nome = nomeCarta.getText().toString();
                nomeCarta.setText("");
                c.setNome(nome);

                String atributo = atributoCarta.getText().toString();
                atributoCarta.setText("");
                c.setAtributo(atributo);

                String tipo = tipoCarta.getText().toString();
                tipoCarta.setText("");
                c.setTipo(tipo);

                int estrelas = Integer.parseInt(estrelasCarta.getText().toString());
                estrelasCarta.setText("");
                c.setEstrelas(estrelas);

                int atk = Integer.parseInt(atkCarta.getText().toString());
                atkCarta.setText("");
                c.setAtaque(atk);

                int def = Integer.parseInt(defCarta.getText().toString());
                defCarta.setText("");
                c.setDefesa(def);

                cadastrarCarta(c);

            }
        });

        return root;
    }

    public void cadastrarCarta(Carta c) {
        Gson gson = new Gson();
        SharedPreferences.Editor editor = preferences.edit();
        String json = preferences.getString("cartas", null);

        if (json == null) {

            json = gson.toJson(c);
            editor.putString("cartas", json);
            editor.commit();

            Toast.makeText(getActivity(), "Carta cadastrada", Toast.LENGTH_LONG).show();

        } else {
            List<Carta> cartas = new ArrayList();
            try {
                JSONArray array = new JSONArray(json);

                for (int i = 0; i < array.length(); i++) {
                    Carta c1 = gson.fromJson(String.valueOf(array.get(i)), Carta.class);
                    cartas.add(c1);
                }
                cartas.add(c);
                json = gson.toJson(cartas);
                editor.putString("cartas", json);
                editor.commit();
                Toast.makeText(getActivity(), "Carta cadastrada", Toast.LENGTH_LONG).show();

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getActivity(), "Erro ocorrido", Toast.LENGTH_LONG).show();
                System.err.println(e);
            }
        }
    }

}