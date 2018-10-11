/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.generaljewish.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.concurrent.TimeUnit;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quant=0;

    /**
     * This method is called when the plus button is clicked.
     */
    public void increaseQuant(View view) {
        quant++;
        display(quant);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decreaseQuant(View view) {
        if(quant==0){
            return;
        }
        quant--;
        display(quant);
    }

    /**
     * This method displays the given quantity value and price on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.NumView);
        TextView priceTextView= (TextView) findViewById(R.id.CostView);
        quantityTextView.setText("" + number);
        double price=2.35*number;
        String pricing=String.format("%,.2f",price);
        priceTextView.setText("$"+pricing);
    }

    /**
     * This method creates the order message and then resets the price.
     */
    public void completeOrder(View view){
        String total=(String)(((TextView)findViewById(R.id.CostView)).getText());
        display(total);
        display(0);
        quant=0;
    }
    private void display(String message){
        TextView histTextView=(TextView)findViewById(R.id.HistView);
        histTextView.setText("Your last order cost "+message+". Thank you for your purchase.");
    }
}
