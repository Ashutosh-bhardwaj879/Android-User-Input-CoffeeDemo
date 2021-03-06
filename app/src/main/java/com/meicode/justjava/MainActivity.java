package com.meicode.justjava;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
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

        int priceMessage = calculatePrice(hasWhippedCream, hasChocolate);
        displayMessage(createOrderSummary(name, priceMessage, hasWhippedCream, hasChocolate));
//APPLYING GOOGLE MAP INTENT
        /*
        Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
        */
//APPLYING EMAIL INTENT
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(intent.EXTRA_SUBJECT,"just java order for"+name);
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
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
        String priceMessage = getString(R.string.order_summary_name,name);
        priceMessage += "\nAdded Whipped Cream? " + hasWhippedCream;
        priceMessage += "\nAdded Chocolate? " + hasChocolate;
        priceMessage += "\nQuantity " + quantity;
        priceMessage += "\nTotal : $ " + price;
        priceMessage += "\n" + getString(R.string.thank_you);
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