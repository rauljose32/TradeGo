package com.example.tradego.ui.busca;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.example.tradego.MainActivity;
import com.example.tradego.R;
import com.example.tradego.model.Carta;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import static com.example.tradego.MainActivity.*;

public class BuscaFragment extends Fragment {

    SharedPreferences preferences;
    EditText textNivel;
    EditText textAtributo;
    EditText textTipo;
    Button buttonBuscar;
    private static final String CHANNEL_ID = "22";
    private int notificationId = 1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_busca, container, false);
        criarCanalNotificacao();

        preferences = getContext().getSharedPreferences("json", Context.MODE_PRIVATE);

        textNivel = root.findViewById(R.id.textPerguntaNivel);
        textAtributo = root.findViewById(R.id.textPerguntaAtributo);
        textTipo = root.findViewById(R.id.textPerguntaTipo);
        buttonBuscar = root.findViewById(R.id.buttonBuscar);

        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String atributo = textAtributo.getText().toString();
                textAtributo.setText("");

                int nivel = Integer.parseInt(textNivel.getText().toString());
                textNivel.setText("");

                String tipo = textTipo.getText().toString();
                textTipo.setText("");

                buscarCartas(atributo, nivel, tipo);

            }
        });


        return root;
    }

    private void buscarCartas(String atributo, int nivel, String tipo) {
        String json = preferences.getString("json", null);
        Gson gson = new Gson();
        List<Carta> cartasList = new ArrayList<>();
        List<Carta> cartas = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                Carta c = gson.fromJson(String.valueOf(array.get(i)), Carta.class);
                cartasList.add(c);
            }

            for (int i = 0; i < cartasList.size(); i++) {
                Carta c = cartasList.get(i);
                if ((c.getAtributo().equalsIgnoreCase(atributo))
                        & (c.getEstrelas() == nivel)
                        & (c.getTipo().equalsIgnoreCase(tipo))) {
                    cartas.add(c);
                }
            }
            gerar(cartas);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void gerar(List<Carta> cartas) {

        String cartasEncontradas = null;

        for (int i = 0; i < cartas.size(); i++) {
            cartasEncontradas += cartas.get(i).toString();
        }

        if (cartasEncontradas != null) {
            Notification builder = new NotificationCompat.Builder(getContext(), CHANNEL_ID)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("TradeGo")
                    .setContentText("Conteudo")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText("Cartas: " + cartasEncontradas))
                    .build();

            NotificationManagerCompat nm = NotificationManagerCompat.from(getContext());
            nm.notify(notificationId, builder);
        } else {

            Notification builder = new NotificationCompat.Builder(getContext(), CHANNEL_ID)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("TradeGo")
                    .setContentText("Nada foi encontrado")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setStyle(new NotificationCompat.BigTextStyle())
                    .build();

            NotificationManagerCompat nm = NotificationManagerCompat.from(getContext());
            nm.notify(notificationId, builder);
        }

    }

    private void criarCanalNotificacao() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "canal22";
            String description = "Descrição";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager manager = getContext().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

}