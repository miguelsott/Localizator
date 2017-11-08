package com.example.android.localizator.add_address;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

/**
 * COMENTAR
 */

public class AddAddressPresenter {

    AddAddressView addAddressView;

    public AddAddressPresenter(AddAddressView addAddressView){
        this.addAddressView = addAddressView;
    }

    public void newAddress(TextView edtAddress){
        //verifica se há um endereço digitado
        if (edtAddress.getText().toString().isEmpty()){
            addAddressView.errorToast();
        }else {
            addAddressView.result(edtAddress.getText().toString());
        }
    }
}
