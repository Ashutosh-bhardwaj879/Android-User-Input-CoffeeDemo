package com.meicode.justjava;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


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
        //edit text and find view by id
        EditText nameField = findViewById(R.id.name_field);

        //change edit text datatype to string
        String name = nameField.getText().toString();

        //working on check box
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkbox);
        //checking is check box ticked or not
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        //working on chocolate check box
        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        //checking the chocolate check box
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);
        displayMessage(createOrderSummary(name, price, hasWhippedCream, hasChocolate));
    }

    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int basePrice = 5;

        if (hasWhippedCream) {
            basePrice += 1;
        }
        if (hasChocolate) {
            basePrice += 2;
        }
        return quantity * basePrice;
    }

    private String createOrderSummary(String name, int price, boolean hasWhippedCream, boolean hasChocolate) {
        String priceMessage = "Name : " + name;
        priceMessage += "\nAdded Whipped Cream? " + hasWhippedCream;
        priceMessage += "\nAdded Chocolate? " + hasChocolate;
        priceMessage += "\nQuantity " + quantity;
        priceMessage += "\nTotal : $ " + price;
        priceMessage += "\nThank You";
        return priceMessage;
    }


    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);

    }

    //when we click  +  button
    public void increment(View view) {
        if (quantity >= 2) {
            Toast.makeText(this,"You cannot have more then 2 coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);

    }

    //when we click  -  button
    public void decrement(View view) {
        if (quantity <= 0) {
            Toast.makeText(this,"You cannot have less than 0 coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity);

    }

    private void display(int numbers) {
        //finding the quantity initial value
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        //setting new value to the quantity text
        String res = " " + numbers;
        quantityTextView.setText(res);

    }

}