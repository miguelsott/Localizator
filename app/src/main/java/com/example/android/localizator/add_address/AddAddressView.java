package com.example.android.localizator.add_address;

/**
 * Interface do AddAddressActivity e AddAddressPresenter
 */

public interface AddAddressView {
    void errorToast();
    void result(String address);
}
