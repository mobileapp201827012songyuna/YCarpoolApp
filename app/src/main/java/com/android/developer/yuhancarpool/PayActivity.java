package com.android.developer.yuhancarpool;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
    }
    public void onDivisionButtonClicked(View view) {
        EditText fee = (EditText) findViewById(R.id.fee);
        TextView result = (TextView) findViewById(R.id.result);

        int n1 = Integer.parseInt(fee.getText().toString());
        result.setText( "요금: " + Integer.toString( + n1/2) + "원\n 고객님께서 결제할\n 금액은 총\n" + Integer.toString( + n1/2)+ "원입니다.!^^");
    }
}
