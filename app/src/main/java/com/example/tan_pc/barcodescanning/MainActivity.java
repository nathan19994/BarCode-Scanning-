    package com.example.tan_pc.barcodescanning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

    public class MainActivity extends AppCompatActivity {
TextView result;
        Button barcodedisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=(TextView)findViewById(R.id.result);
        barcodedisplay=(Button)findViewById(R.id.barcode);


    }
    public void Scanbarcode(View v){
        Intent intent= new Intent(this,BarcodeScanning.class);
        startActivityForResult(intent,0);
    }

    @Override
        protected void onActivityResult(int requestcode,int resultcode,Intent data){
        if (requestcode == 0){
            if (resultcode == CommonStatusCodes.SUCCESS){
                if(data!= null){
                    Barcode barcode= data.getParcelableExtra("barcode");
                    result.setText("Barcode Value: "+ barcode.displayValue);
                }
                else
                {
                    result.setText("No Barcode found");
                }
            }
        }
    }




}
