package com.example.android.localizator.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.localizator.R;
import com.example.android.localizator.add_address.AddAddressActivity;
import com.example.android.localizator.show_addresses.ShowAddressesActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
*   Guilherme de Almeida Henna  RA:619574
*   Miguel de Souza Tosta       RA:619698
* */

public class MainActivity extends AppCompatActivity {

    // Cast dos botões com ButterKnife
    @BindView(R.id.btn_add_address) Button btnAddAddress;
    @BindView(R.id.btn_show_addresses) Button btnShowAddresses;

    //código utilizado para adicionar novos endereços
    private final int RC_ADD_ADDRESS = 123;
    //lista de endereços
    private ArrayList<String> lstAddresses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this); // Binding efetivo com ButterKnife
    }

    // Modificado para funcionar com ButterKnife.
    // Listener estava dentro do OnCreate. Colocamos ele fora com o método OnClick do ButterKnife.
    //abre a activity para adicionar endereços
    @OnClick(R.id.btn_add_address)
    public void openAddAddress(){
        Intent openAddAddressActivity = new Intent(MainActivity.this, AddAddressActivity.class);
        startActivityForResult(openAddAddressActivity, RC_ADD_ADDRESS);
    }

    // Modificado para funcionar com ButterKnife.
    // Listener estava dentro do OnCreate. Colocamos ele fora com o método OnClick do ButterKnife.
    //abre a activity para exibir os endereços cadastrados
    @OnClick(R.id.btn_show_addresses)
    public void openShowAddress(){
        //verifica se há endereços cadastrados antes executar a activity
        if(lstAddresses.size() <= 0){
            Toast.makeText(MainActivity.this, "Não há endereços cadastrados", Toast.LENGTH_SHORT).show();
        }else{
            //abre a ShowAddressActivity enviando a lista de endereços
            Intent openShowAddressActivity = new Intent(MainActivity.this, ShowAddressesActivity.class);
            openShowAddressActivity.putStringArrayListExtra("addresses_list", lstAddresses);
            startActivity(openShowAddressActivity);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //captura o resultado da tela de cadastro de endereços e adiciona na lista
        if(requestCode == RC_ADD_ADDRESS && resultCode == Activity.RESULT_OK) {
            lstAddresses.add(data.getStringExtra("movie_name"));
        }
    }
}
