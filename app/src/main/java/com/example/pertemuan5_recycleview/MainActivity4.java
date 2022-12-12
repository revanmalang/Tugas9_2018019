package com.example.pertemuan5_recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity4 extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abut;
    ListView pokeListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        pokeListView = findViewById(R.id.pokeListView);
        getPokemons();
        dl = (DrawerLayout) findViewById(R.id.dl);
        abut = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        abut.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abut);
        abut.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    Intent a = new Intent(MainActivity4.this, MainActivity.class);
                    startActivity(a);
                } else if (id == R.id.nav_home) {
                    Intent a = new Intent(MainActivity4.this, MainActivity2.class);
                    startActivity(a);
                } else if (id == R.id.nav_sql) {
                    Intent a = new Intent(MainActivity4.this, MainActivity3.class);
                    startActivity(a);
                } else if (id == R.id.nav_restapi) {
                    Intent a = new Intent(MainActivity4.this, MainActivity4.class);
                    startActivity(a);
                }
                return true;            }        });    }    private void getPokemons() {
        Call<RestApi> call = RetrofitClient.getInstance().getMyApi().getPokemons();
        call.enqueue(new Callback<RestApi>() {
            @Override
            public void onResponse(Call<RestApi> call, Response<RestApi> response) {
                RestApi pokemonData = response.body();
                ArrayList<ResultItem> data = pokemonData.getResult();
                String[] onePokemon = new String[data.size()];
                for (int i = 0; i < data.size(); i++) {onePokemon[i] = data.get(i).getName();
                }
                pokeListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, onePokemon));
            }
            @Override
            public void onFailure(Call<RestApi> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }        });    }    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return abut.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
