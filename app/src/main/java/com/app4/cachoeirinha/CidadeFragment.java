package com.app4.cachoeirinha;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class CidadeFragment extends Fragment {
    View minhaView;
    ImageButton botaoHistoria, botaoFeiras, botaoGeografia, botaoEconomia, botaoChegar, botaoTour;
    HistoriaFragment historiaFragment;
    FeirasMenuFragment feirasMenuFragment;
    GeografiaFragment geografiaFragment;
    EconomiaFragment economiaFragment;
    ChegarFragment chegarFragment;
    TourFragment tourFragment;
    FragmentManager fragmentManager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        minhaView= inflater.inflate(R.layout.tela_cidade, container, false);
        botaoHistoria = minhaView.findViewById(R.id.botao_historia_id);
        botaoFeiras = minhaView.findViewById(R.id.botao_feiras_id);
        botaoGeografia = minhaView.findViewById(R.id.botao_geografia_id);
        botaoEconomia = minhaView.findViewById(R.id.botao_econ_id);
        botaoChegar = minhaView.findViewById(R.id.botao_chegar_id);
        botaoTour = minhaView.findViewById(R.id.botao_tour_id);
        historiaFragment = new HistoriaFragment();
        feirasMenuFragment = new FeirasMenuFragment();
        geografiaFragment = new GeografiaFragment();
        economiaFragment = new EconomiaFragment();
        chegarFragment = new ChegarFragment();
        tourFragment = new TourFragment();

        fragmentManager = getActivity().getSupportFragmentManager();

        botaoHistoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToTelaHistoria();
            }
        });

        botaoFeiras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToTelaFeiras();
            }
        });

        botaoGeografia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToTelaGeografia();
            }
        });

        botaoEconomia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToTelaEconomia();
            }
        });

        botaoChegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToTelaChegar();
            }
        });

        botaoTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToTelaTour();
            }
        });

        return minhaView;
    }

    private void moveToTelaFeiras(){
        fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, feirasMenuFragment).addToBackStack("feirasMenuFragment").commit();
    }

    private void moveToTelaHistoria(){
        fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, historiaFragment).addToBackStack("historiaFragment").commit();
    }

    private void moveToTelaGeografia(){
        fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, geografiaFragment).addToBackStack("geografiaFragment").commit();
    }

    private void moveToTelaEconomia(){
        fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, economiaFragment).addToBackStack("economiaFragment").commit();
    }

    private void moveToTelaChegar(){
        fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, chegarFragment).addToBackStack("chegarFragment").commit();
    }

    private void moveToTelaTour(){
        fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, tourFragment).addToBackStack("tourFragment").commit();
    }

}
