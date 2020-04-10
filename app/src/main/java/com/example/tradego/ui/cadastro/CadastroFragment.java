package com.example.tradego.ui.cadastro;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.tradego.R;

public class CadastroFragment extends Fragment {

    private EditText nomeCarta;
    private RadioButton radioButtonVento;
    private RadioButton radioButtonFogo;
    private RadioButton radioButtonAgua;
    private RadioButton radioButtonTerra;
    private RadioButton radioButtonLuz;
    private RadioButton radioButtonTrevas;
    private TextView estrelas;
    private RadioButton radioButtonGuerreiro;
    private RadioButton radioButtonMago;
    private RadioButton radioButtonFada;
    private RadioButton radioButtonDragao;
    private RadioButton radioButtonPsiquico;
    private RadioButton radioButtonBesta;
    private RadioButton radioButtonDinossauro;
    private RadioButton radioButtonReguladorV;
    private RadioButton radioButtonReguladorF;
    private RadioButton radioButtonEfeitoV;
    private RadioButton radioButtonEfeitoF;
    private EditText atk;
    private EditText def;
    private Button buttonCadastrar;
    private SharedPreferences preferences;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_cadastro, container, false);

        nomeCarta = root.findViewById(R.id.textNomeCarta);
        radioButtonVento = root.findViewById(R.id.radioButtonVento);
        radioButtonFogo = root.findViewById(R.id.radioButtonFogo);
        radioButtonAgua = root.findViewById(R.id.radioButtonAgua);
        radioButtonTerra = root.findViewById(R.id.radioButtonTerra);
        radioButtonLuz = root.findViewById(R.id.radioButtonLuz);
        radioButtonTrevas = root.findViewById(R.id.radioButtonTrevas);
        estrelas = root.findViewById(R.id.textEstrelas);
        radioButtonGuerreiro = root.findViewById(R.id.radioButtonGuerreiro);
        radioButtonMago = root.findViewById(R.id.radioButtonMago);
        radioButtonFada = root.findViewById(R.id.radioButtonFada);
        radioButtonDragao = root.findViewById(R.id.radioButtonDragao);
        radioButtonPsiquico = root.findViewById(R.id.radioButtonPsiquico);
        radioButtonBesta = root.findViewById(R.id.radioButtonBesta);
        radioButtonDinossauro = root.findViewById(R.id.radioButtonDinossauro);
        radioButtonReguladorV = root.findViewById(R.id.radioButtonReguladorVerdadeiro);
        radioButtonReguladorF = root.findViewById(R.id.radioButtonReguladorFalso);
        radioButtonEfeitoV = root.findViewById(R.id.radioButtonEfeitoVerdadeiro);
        radioButtonEfeitoF = root.findViewById(R.id.radioButtonEfeitoFalso);
        atk = root.findViewById(R.id.textAtaque);
        def = root.findViewById(R.id.textDefesa);
        buttonCadastrar = root.findViewById(R.id.buttonCadastrar);

        preferences = getActivity().getSharedPreferences("pref", Context.MODE_APPEND);

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




        return root;
    }
}