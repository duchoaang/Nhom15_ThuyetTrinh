package com.example.automaticsms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.EditText;

public class OTP_Receiver extends BroadcastReceiver {
    private  static EditText editText;

    public void setEditText(EditText editText)
    {
        OTP_Receiver.editText=editText;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        for(SmsMessage sms : messages)
        {
            String msg = sms.getMessageBody();

            String otp = msg.split(": ")[1];

            editText.setText(otp);
        }

    }
}