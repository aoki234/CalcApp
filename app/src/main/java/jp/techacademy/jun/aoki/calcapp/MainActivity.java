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

    Float value3;

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

        if(variable1.isEmpty() || variable2.isEmpty()){
            showEmptyAlert();
        }else if(variable2.equals("0") && v.getId() == R.id.button4){
            //0で割り算した時のエラー
            showDivisionAlert();
        }else{

            try{
                Float value1 = Float.parseFloat(variable1);
                Float value2 = Float.parseFloat(variable2);

                switch (v.getId()) {
                    case R.id.button1:
                        value3 = value1 + value2;
                        break;
                    case R.id.button2:
                        value3 = value1 - value2;
                        break;
                    case R.id.button3:
                        value3 = value1 * value2;
                        break;
                    case R.id.button4:
                        value3 = value1 / value2;
                        break;
                    default:
                        Log.d("javatest","can not calculate");
                        break;
                }

                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("VALUE3", String.valueOf(value3));

                startActivity(intent);

            }catch (NumberFormatException e){
                //.入力時のエラーをキャッチ
                Log.d("javatest","can not convert float");
                showNumericAlert();
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

    private void showDivisionAlert() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Can not calculate in this value");
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

    private void showNumericAlert() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Can not input this value");
        alertDialogBuilder.setMessage("Please input Numeric value");

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
