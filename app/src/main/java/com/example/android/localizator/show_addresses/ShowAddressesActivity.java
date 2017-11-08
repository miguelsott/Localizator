package com.example.android.localizator.show_addresses;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.android.localizator.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowAddressesActivity extends AppCompatActivity {

    // Cast do RecyclerView Adresses com ButterKnife
    @BindView(R.id.rv_addresses) RecyclerView rvAddresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_addresses);
        ButterKnife.bind(this); //Binding efetivo com ButterKnife

        //captura a lista enviada pela MainActivity
        final ArrayList<String> lstAddresses = getIntent().getStringArrayListExtra("addresses_list");
        //instancia um AddressesAdapter passando a lista de endereços
        final AddressesAdapter addressesAdapter = new AddressesAdapter(lstAddresses);

        // COMENTAR
        addressesAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
            @Override
            public void onClick(View view, int position) {
                Intent intentMapa = new Intent(Intent.ACTION_VIEW);
                intentMapa.setData(Uri.parse("geo:0,0?q=" + lstAddresses.get(position)));
                if(intentMapa.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentMapa);
                }else {
                    Toast toast = Toast.makeText(ShowAddressesActivity.this, "Impossível abrir o recurso", Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });

        //seta o adapter no Recycler View
        rvAddresses.setAdapter(addressesAdapter);

        //cria o gerenciador de layouts
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //seta o gerenciador de layouts no Recycler View
        rvAddresses.setLayoutManager(layoutManager);
    }
}
