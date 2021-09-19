package com.meicode.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//CLASS 18 STARTED
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //resource.layout.activitymain
    }

//    Button          android:onClick="submitOrder" this is defined in main.xml file so used here
    public void submitOrder(View view){
        display(1);
    }

    private void display(int numbers){
        //finding the quantity initial value
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        //setting new value to the quantity text
        quantityTextView.setText(" "+numbers);
    }
}