package com.app4.cachoeirinha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FeirasMenuFragment extends Fragment {

    ImageButton botaofruta, botaoaco, botaogado, botaoqueijo;
    View minhaView;
    private FragmentManager fragmentManager;
    private FeiraAcoFragment feiraAco;
    private FeiraFrutaFragment feiraFruta;
    private FeiraQueijoFragment feiraQueijo;
    private FeiraGadoFragment feiraGado;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        minhaView= inflater.inflate(R.layout.content_feiras, container, false);
        botaofruta = minhaView.findViewById(R.id.fruta_id);
        botaoaco = minhaView.findViewById(R.id.aco_id);
        botaogado = minhaView.findViewById(R.id.gado_id);
        botaoqueijo = minhaView.findViewById(R.id.queijo_id);
        feiraAco = new FeiraAcoFragment();
        feiraFruta = new FeiraFrutaFragment();
        feiraQueijo = new FeiraQueijoFragment();
        feiraGado = new FeiraGadoFragment();
        fragmentManager = getActivity().getSupportFragmentManager();
        botaofruta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                moveToTelaFeiraFruta();
            }
        });

        botaoaco.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                moveToTelaFeiraAco();
            }
        });

        botaogado.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                moveToTelaFeiraGado();
            }
        });

        botaoqueijo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                moveToTelaFeiraQueijo();
            }
        });

        return minhaView;
    }

    private void moveToTelaFeiraFruta(){
        fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, feiraFruta).addToBackStack("feiraFruta").commit();
    }

    private void moveToTelaFeiraAco(){
        fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, feiraAco).addToBackStack("feiraAco").commit();
    }

    private void moveToTelaFeiraGado(){
        fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, feiraGado).addToBackStack("feiraGado").commit();
    }

    private void moveToTelaFeiraQueijo(){
        fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, feiraQueijo).addToBackStack("feiraQueijo").commit();
    }
}
