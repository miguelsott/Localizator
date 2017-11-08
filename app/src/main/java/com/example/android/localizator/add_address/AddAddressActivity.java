package com.example.android.localizator.add_address;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.localizator.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddAddressActivity extends AppCompatActivity implements AddAddressView{

    // Ajuste de casting de view pelo Butterknife
    @BindView(R.id.edt_address) TextView edtAddress;
    @BindView(R.id.btn_add) Button btnAdd;

    AddAddressPresenter addAddressPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        ButterKnife.bind(this); //Binding efetivo com ButterKnife

        addAddressPresenter = new AddAddressPresenter(this);
    }

    // Apresenta mensagem de erro no toast no caso de endereço não digitado
    @Override
    public void errorToast() {
        Toast.makeText(AddAddressActivity.this, "Digite o endereço que deseja adicionar", Toast.LENGTH_SHORT).show();
    }

    // Implementação do retorno do endereço inserido
    @Override
    public void result(String address) {
        //retorna o endereço para a MainActivity
        Intent resultIntent = new Intent();
        resultIntent.putExtra("movie_name", edtAddress.getText().toString());
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    // OnClick Listener movido para fora do método OnCreate,
    // utilizando do método do ButterKnife.
    @OnClick (R.id.btn_add)
    public void addAddress(){
        addAddressPresenter.newAddress(edtAddress);
    }
}
