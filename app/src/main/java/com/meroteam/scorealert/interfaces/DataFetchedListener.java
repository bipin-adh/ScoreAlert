package com.meroteam.scorealert.interfaces;

/**
 * Created by bpn8adh on 24/04/18.
 */

public interface DataFetchedListener {
    public void onSuccess();
    public void onFailure(String msgError);
}
