package com.prueba.oansc.tpdm_u5_practica3_alfarofalconsergio;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @SuppressLint("MissingPermission")
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        Object[] pdus = (Object[]) extras.get("pdus");
        if (pdus != null) {
            SmsMessage mensaje = SmsMessage.createFromPdu((byte[]) pdus[0]);

            String texto = mensaje.getMessageBody();
            String numero = mensaje.getOriginatingAddress();

            String clave = "LLAMAME";

            if (clave.equals(texto)) {
                String tel = "tel:" + numero;
                context.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(tel)));
                return;
            }
        }
    }
}
