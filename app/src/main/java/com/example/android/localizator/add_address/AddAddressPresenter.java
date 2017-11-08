package com.example.android.localizator.add_address;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Presenter criado para segurar a lógica que estava presente no
 * OnClick do AddAddressActivity
 */

public class AddAddressPresenter {

    // Criação da Interface com métodos implementados na activity
    AddAddressView addAddressView;

    // Construtor recebe interface
    public AddAddressPresenter(AddAddressView addAddressView){
        this.addAddressView = addAddressView;
    }

    // Lógica abstraída da activity, aqui serão chamados os métodos implementados
    public void newAddress(TextView edtAddress){
        //verifica se há um endereço digitado
        if (edtAddress.getText().toString().isEmpty()){
            addAddressView.errorToast();
        }else {
            addAddressView.result(edtAddress.getText().toString());
        }
    }
}
