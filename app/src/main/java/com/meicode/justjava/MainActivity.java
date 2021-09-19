package com.meicode.justjava;

import androidx.appcompat.app.AppCompatActivity;

import java.util.*;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

//CLASS 18 STARTED
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //resource.layout.activitymain
    }

    //    Button          android:onClick="submitOrder" this is defined in main.xml file so used here
    public void submitOrder(View view) {
        int numberOfCoffee = 5;
        display(numberOfCoffee);
        displayPrice(numberOfCoffee* 5);
    }
//when we click  +  button
    public void increment(View view) {
        int numberOfCoffee = 3;
        display(numberOfCoffee);
        displayPrice(numberOfCoffee* 5);
    }
//when we click  -  button
    public void decrement(View view){
        int numberOfCoffee = 1;
        display(numberOfCoffee);
        displayPrice(numberOfCoffee* 5);
    }
    private void display(int numbers) {
        //finding the quantity initial value
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        //setting new value to the quantity text
        quantityTextView.setText(" " + numbers);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}