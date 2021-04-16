package com.app4.cachoeirinha;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmailFragment extends Fragment {

    View minhaView;
    Button botao_enviar;
    private final static String email_padrao = "guiacachoeirinha@outlook.com";
    EditText email, msg_email;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        minhaView = inflater.inflate(R.layout.content_email, container, false);
        botao_enviar = minhaView.findViewById(R.id.botao_email);
        email = minhaView.findViewById(R.id.email_id);
        msg_email = minhaView.findViewById(R.id.mensagem_email_id);

        botao_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
                if (!isOnline()) {
                    Toast.makeText(minhaView.getContext(), "Não há internet para enviar e-mail!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(minhaView.getContext(), "Aguarde um momento para o email ser enviado!", Toast.LENGTH_LONG).show();
                    Toast.makeText(minhaView.getContext(), "Email enviado!", Toast.LENGTH_LONG).show();
                }
                msg_email.setText("");
                email.setText("");
            }
        });
        return minhaView;
    }

    private void enviarEmail() {

        final String email_string = email.getText().toString();
        final String subject = "Cachoeirinha APP";
        final String body = msg_email.getText().toString() + " Enviado por " + email_string;

        new Thread(new Runnable() {
            @Override
            public void run() {
                Mail m = new Mail();

                String[] toArr = {email_padrao};
                m.setTo(toArr);

                //m.setFrom(email_string); //caso queira enviar em nome de outro
                m.setSubject(subject);
                m.setBody(body);

                try {
                    //m.addAttachment("pathDoAnexo");//anexo opcional
                    m.send();
                } catch (RuntimeException rex) {
                }//erro ignorado
                catch (Exception e) {
                    e.printStackTrace();
                }
                Looper.prepare();
            }
        }).start();
    }

    public boolean isOnline() {
        try {
            ConnectivityManager cm = (ConnectivityManager) minhaView.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            return netInfo != null && netInfo.isConnectedOrConnecting();
        } catch (Exception ex) {
            Toast.makeText(minhaView.getContext(), "Erro ao verificar se estava online! (" + ex.getMessage() + ")", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
