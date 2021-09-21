package com.meicode.justjava;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



//import java.text.NumberFormat;

//CLASS 18 STARTED
public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //resource.layout.activitymain
    }

    //    Button          android:onClick="submitOrder" this is defined in main.xml file so used here
    public void submitOrder(View view) {
        int price=calculatePrice();
        displayMessage(createOrderSummary(price));
    }

    private int calculatePrice(){
        return quantity*5;
    }

    private String createOrderSummary(int price){
        String priceMessage = "Name : Ashutosh Bhardwaj";
        priceMessage += "\nQuantity "  + quantity;
        priceMessage += "\nTotal : $ " + price;
        priceMessage += "\nThank You";
        return priceMessage;
    }


    private void displayMessage(String message){
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);

    }

//when we click  +  button
    public void increment(View view) {
        quantity = quantity + 1;
        if (quantity >= 0) {
            display(quantity);
        }
    }

//when we click  -  button
    public void decrement(View view) {
        quantity = quantity - 1;
        if (quantity >= 0) {
            display(quantity);
        }
    }

    private void display(int numbers) {
        //finding the quantity initial value
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        //setting new value to the quantity text
        String res = " " + numbers;
        quantityTextView.setText(res);

    }

/*
     private void displayPrice(int number) {
         TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
         orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
     }
*/

}