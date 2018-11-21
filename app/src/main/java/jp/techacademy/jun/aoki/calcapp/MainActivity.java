package jp.techacademy.jun.aoki.calcapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button)findViewById(R.id.button1);
        Button btn2 = (Button)findViewById(R.id.button2);
        Button btn3 = (Button)findViewById(R.id.button3);
        Button btn4 = (Button)findViewById(R.id.button4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
    }


    @Override
    public void onClick(View v) {

        String variable1 = editText1.getText().toString();
        String variable2 = editText2.getText().toString();
        //Log.d("javatest",variable2);
        //Log.d("javatest",String.valueOf(v.getId()));

        if(variable1.isEmpty() || variable2.isEmpty()){
            showEmptyAlert();
        }else if(variable2.equals("0") && v.getId() == 2131165221){
            showinputAlert();
        }else{

            try{
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("VALUE1", Float.parseFloat(variable1));
                intent.putExtra("VALUE2", Float.parseFloat(variable2));
                intent.putExtra("VALUE3", String.valueOf(v.getId()));
                //Log.d("javatest",String.valueOf(v.getId()));

                startActivity(intent);
            }catch (NumberFormatException e){
                Log.d("javatest","can not convert float");
                showinputAlert();
            }

        }
    }

    private void showEmptyAlert() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("variable is empty");
        alertDialogBuilder.setMessage("Please input variable");

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("UI_PARTS", "OK");
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void showinputAlert() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Can not calculate this value");
        alertDialogBuilder.setMessage("Please input correct value");

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("UI_PARTS", "OK");
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
