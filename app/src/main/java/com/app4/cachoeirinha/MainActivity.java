package com.app4.cachoeirinha;



import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    FragmentManager fragmentManager;
    private CidadeFragment cidadeFragment;
    private EventosFragment eventosFragment;
    private GaleriaFragment galeriaFragment;
    private EmailFragment emailFragment;
    private MapFragment mapFragment;
    private InicioFragment inicioFragment;
    ImageButton brasao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        brasao = findViewById(R.id.brasao_inicio_id);
        cidadeFragment = new CidadeFragment();
        eventosFragment = new EventosFragment();
        galeriaFragment = new GaleriaFragment();
        emailFragment = new EmailFragment();
        mapFragment = new MapFragment();
        inicioFragment = new InicioFragment(drawer);
        fragmentManager = getSupportFragmentManager();
        if(fragmentManager.getBackStackEntryCount() == 0){
            fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, inicioFragment).commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else if(fragmentManager.getBackStackEntryCount() == 1){
            fragmentManager.popBackStackImmediate();
            fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, inicioFragment).commit();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.nav_cidade) {
            while (fragmentManager.getBackStackEntryCount() != 0) {
                fragmentManager.popBackStackImmediate();
            }
            fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, cidadeFragment).addToBackStack("telaCidade").commit();
        } else if (id == R.id.nav_eventos) {
            while (fragmentManager.getBackStackEntryCount() != 0) {
                fragmentManager.popBackStackImmediate();
            }
            fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, eventosFragment).addToBackStack("telaEventos").commit();
        } else if(id == R.id.nav_galeria){
            while (fragmentManager.getBackStackEntryCount() != 0) {
                fragmentManager.popBackStackImmediate();
            }
            fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, galeriaFragment).addToBackStack("telaGaleria").commit();
        } else if (id == R.id.nav_mapa) {
            while (fragmentManager.getBackStackEntryCount() != 0) {
                fragmentManager.popBackStackImmediate();
            }
            fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, mapFragment).addToBackStack("telaMapa").commit();
        } else if (id == R.id.nav_email) {
            while (fragmentManager.getBackStackEntryCount() != 0) {
                fragmentManager.popBackStackImmediate();
            }
            fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, emailFragment).addToBackStack("telaInfo").commit();
        } else if(id == R.id.nav_compartilhar){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, "Acesse https://bit.ly/33122VY e descubra mais sobre Cachoeirinha-PE, a terra do Couro e do Aço!");
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent, "Compartilhar via:"));
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
