package com.jangel.root.computebmi;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btCompute = (Button)findViewById(R.id.compute);

        btCompute.setOnClickListener(new MyOnClickListener());
    }

    class MyOnClickListener implements View.OnClickListener{
        public void onClick(View v){
            //System.out.println("here!");
            Compute();
        }

    }

    private void Compute(){
        EditText edWeight = (EditText)findViewById(R.id.weight_et);
        EditText edHeight = (EditText)findViewById(R.id.height_et);

        if(edWeight.getText().toString().equals("") || edHeight.getText().toString().equals(""))
        {
            AlertDialog.Builder err = new AlertDialog.Builder(this);
            err.setTitle("没有输入");
            err.setMessage("请输入身高体重哦!");
            err.show();

            return;
        }

        Double weight = Double.parseDouble(edWeight.getText().toString());
        Double height = Double.parseDouble(edHeight.getText().toString());

        if((weight<=0 || weight>=200)&& (height<=0  || height >=4)){
            AlertDialog.Builder err = new AlertDialog.Builder(this);
            err.setTitle("输入的参数不合法");
            err.setMessage("请输入合理的体重身高哦!");
            err.show();

            edWeight.setText("");
            edHeight.setText("");

            edWeight.requestFocus();

            return;

            /*
            AlertDialog.Builder err = new AlertDialog.Builder(this);
            edWeight.requestFocus();
            if(weight<=0 || weight>=200) {

                err.setTitle("输入的参数不合法");
                err.setMessage("请输入合理的体重哦!");
                err.show();

                edWeight.setText("");


            }
            if(height<=0 || height >=4) {

                err.setTitle("输入的参数不合法");
                err.setMessage("请输入合理的身高哦!");
                err.show();

                edHeight.setText("");
                edHeight.requestFocus();

                return;
            }
            edWeight.requestFocus();
*/

        } else if(height<=0.0 || height >=4.0 ) {
            AlertDialog.Builder err = new AlertDialog.Builder(this);
            err.setTitle("输入的参数不合法");
            err.setMessage("请输入合理的身高哦!");
            err.show();

            edHeight.setText("");

            edHeight.requestFocus();

            return;
        }else if(weight<=0 || weight>=200 ) {
            AlertDialog.Builder err = new AlertDialog.Builder(this);
            err.setTitle("输入的参数不合法");
            err.setMessage("请输入合理的体重哦!");
            err.show();

            edWeight.setText("");

            edWeight.requestFocus();

            return;
        }


        Double restrul = weight / Math.pow(height, 2);
        String strRes = String.format("%.2f",restrul);
        TextView ttRes = (TextView)findViewById(R.id.res);

        ttRes.setText(getString(R.string.showBMI) + strRes);

        System.out.println("height is:" + height);
        System.out.println("weight is:" + weight);
        System.out.println("Math.pow(height, height) is:" + Math.pow(height, 2));

        System.out.println("restrul is:" + restrul);

    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/
}
