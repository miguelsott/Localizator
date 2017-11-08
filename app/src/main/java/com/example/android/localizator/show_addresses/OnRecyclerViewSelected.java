package com.example.android.localizator.show_addresses;

import android.view.View;

/**
 * Interface criada para lidar com
 * click listeners dos endereços listados individualmente
 */

public interface OnRecyclerViewSelected {
    void onClick(View view, int position);
}
