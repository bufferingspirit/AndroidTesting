package com.example.admin.androidtesting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    public static final String KEY_RESULT = "key_for_result" ;
    @BindView(R.id.etValue1)
    EditText etValue1;
    @BindView(R.id.etValue2)
    EditText etValue2;
    @BindView(R.id.btnAdd)
    Button btnAdd;
    @BindView(R.id.btnSubtract)
    Button btnSubtract;
    @BindView(R.id.btnMultiply)
    Button btnMultiply;
    @BindView(R.id.btnDivide)
    Button btnDivide;
    @BindView(R.id.tvSolution)
    TextView tvSolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide})
    public void doOperation(View view) {
        double num1 = Double.parseDouble(etValue1.getText().toString());
        double num2 = Double.parseDouble(etValue2.getText().toString());
        Calculation calculation = new Calculation(num1, num2);
        switch (view.getId()) {

            case R.id.btnAdd:
                tvSolution.setText(Double.toString(calculation.add()));
                break;
            case R.id.btnSubtract:
                tvSolution.setText(Double.toString(calculation.subtract()));
                break;
            case R.id.btnMultiply:
                tvSolution.setText(Double.toString(calculation.multiply()));
                break;
            case R.id.btnDivide:
                tvSolution.setText(Double.toString(calculation.divide()));
                break;
        }
    }

    public void goToSecond(View view){
        Intent intent = new Intent(this, Main2Activity.class);
        Log.d("MainActivity", "goToSecond: " + tvSolution.getText().toString());
        intent.putExtra(KEY_RESULT, tvSolution.getText().toString());
        startActivity(intent);
    }
}
