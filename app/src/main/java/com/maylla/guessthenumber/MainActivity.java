package com.maylla.guessthenumber;


import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity implements View.OnKeyListener {

    EditText numero;
    TextView msg;
    TextView tentativas;
    int sorteio;
    int palpite=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msg = (TextView) findViewById(R.id.message);
        numero = (EditText) findViewById(R.id.input);
        tentativas = (TextView) findViewById(R.id.attempts);
        numero.setOnKeyListener(this);
        sorteio = (int)(Math.random()*101);
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if(i == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() != KeyEvent.ACTION_DOWN){
            verificaPalpite();
            return true;
        }
        return false;
    }

    private void verificaPalpite() {
        palpite++;
        tentativas.setText(Integer.toString(palpite));
        int chute = Integer.parseInt(numero.getText().toString());
        if(chute == sorteio){
            msg.setText("You Win!");
            palpite=0;
            tentativas.setText("");}
        else if(chute > sorteio){
            msg.setText("try a smaller number");}
        else{
            msg.setText("try a larger number");}
    }
}