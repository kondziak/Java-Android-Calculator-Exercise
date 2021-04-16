package com.example.calculator;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import net.objecthunter.exp4j.*;

public class SimpleCalculator extends AppCompatActivity {

    private static TextView screen;
    private static Button[] numbers = new Button[10];
    private static Button plusButton,minusButton,multiplyButton,divideButton;
    private static Button equalButton,dotButton,clearButton,allClearButton,plusMinusButton;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.simple_calculator);
        screen = findViewById(R.id.screenID);
        if(savedInstanceState != null){
            String text = savedInstanceState.getString("text");
            screen.setText(text);
        }
        setAllButtons();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text",screen.getText().toString());
    }

    public void setAllButtons(){
        setNumberZero();
        setNumberOne();
        setNumberTwo();
        setNumberThree();
        setNumberFour();
        setNumberFive();
        setNumberSix();
        setNumberSeven();
        setNumberEight();
        setNumberNine();
        setPlusButton();
        setMinusButton();
        setMultiplyButton();
        setDivideButton();
        setDotButton();
        setClearButton();
        setAllClearButton();
        setPlusMinusButton();
        setEqualButton();
    }


    public void setNumberZero(){
        numbers[0] = findViewById(R.id.zeroButton);
        numbers[0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = screen.getText().toString();
                text += '0';
                screen.setText(text);
            }
        });
    }
    public void setNumberOne(){
        numbers[1] = findViewById(R.id.firstButton);
        numbers[1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = screen.getText().toString();
                text += '1';
                screen.setText(text);
            }
        });
    }
    public void setNumberTwo(){
        numbers[2] = findViewById(R.id.secondButton);
        numbers[2].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = screen.getText().toString();
                text += '2';
                screen.setText(text);
            }
        });
    }
    public void setNumberThree(){
        numbers[3] = findViewById(R.id.thirdButton);
        numbers[3].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = screen.getText().toString();
                text += '3';
                screen.setText(text);
            }
        });
    }
    public void setNumberFour(){
        numbers[4] = findViewById(R.id.fourthButton);
        numbers[4].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = screen.getText().toString();
                text += '4';
                screen.setText(text);
            }
        });
    }
    public void setNumberFive() {
        numbers[5] = findViewById(R.id.fifthButton);
        numbers[5].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = screen.getText().toString();
                text += '5';
                screen.setText(text);
            }
        });
    }
    public void setNumberSix(){
        numbers[6] = findViewById(R.id.sixthButton);
        numbers[6].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = screen.getText().toString();
                text += '6';
                screen.setText(text);
            }
        });
    }
    public void setNumberSeven(){
        numbers[7] = findViewById(R.id.seventhButton);
        numbers[7].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = screen.getText().toString();
                text += '7';
                screen.setText(text);
            }
        });
    }
    public void setNumberEight(){
        numbers[8] = findViewById(R.id.eightButton);
        numbers[8].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = screen.getText().toString();
                text += '8';
                screen.setText(text);
            }
        });
    }
    public void setNumberNine(){
        numbers[9] = findViewById(R.id.ninthButton);
        numbers[9].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = screen.getText().toString();
                text += '9';
                screen.setText(text);
            }
        });
    }

    public boolean hasAnySymbol(String text){
        Character []arr = {'+','-','/','*'};
        boolean flag = false;
        for(Integer i = 0; i < text.length(); i++) {
            char sign = text.charAt(i);
            for (Character s : arr) {
                if (s.equals(sign)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public int calculateSymbols(String text){
        Character []arr = {'+','-','/','*'};
        int counter = 0;
        for(Integer i = 0; i < text.length(); i++) {
            char sign = text.charAt(i);
            for (Character s : arr) {
                if (s.equals(sign)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public boolean checkSymbols(String text){
        Character []arr = {'+','-','/','*','.'};
        boolean flag = true;
        char sign = text.charAt(text.length()-1);
        for(Character s : arr){
            if(s.equals(sign)){
                flag = false;
            }
        }
        return flag;
    }

    public void setPlusButton(){
        plusButton = findViewById(R.id.plusButton);
        plusButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = screen.getText().toString();
                if(!text.isEmpty() && checkSymbols(text)){
                    text += '+';
                    screen.setText(text);
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence sequence = "Invalid operation";
                    Toast toast = Toast.makeText(context,sequence, Toast.LENGTH_SHORT);
                    ViewGroup group = (ViewGroup) toast.getView();
                    TextView messageTextView = (TextView) group.getChildAt(0);
                    messageTextView.setTextSize(30);
                    toast.show();
                }
            }
        });
    }

    public void setMinusButton(){
        minusButton = findViewById(R.id.minusButton);
        minusButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = screen.getText().toString();
                if(!text.isEmpty() && checkSymbols(text)){
                    text += '-';
                    screen.setText(text);
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence sequence = "Invalid operation";
                    Toast toast = Toast.makeText(context,sequence, Toast.LENGTH_SHORT);
                    ViewGroup group = (ViewGroup) toast.getView();
                    TextView messageTextView = (TextView) group.getChildAt(0);
                    messageTextView.setTextSize(30);
                    toast.show();
                }
            }
        });
    }

    public void setMultiplyButton(){
        multiplyButton = findViewById(R.id.multiplyButton);
        multiplyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = screen.getText().toString();
                if(!text.isEmpty() && checkSymbols(text)){
                    text += '*';
                    screen.setText(text);
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence sequence = "Invalid operation";
                    Toast toast = Toast.makeText(context,sequence, Toast.LENGTH_SHORT);
                    ViewGroup group = (ViewGroup) toast.getView();
                    TextView messageTextView = (TextView) group.getChildAt(0);
                    messageTextView.setTextSize(30);
                    toast.show();
                }
            }
        });
    }

    public void setDivideButton(){
        divideButton = findViewById(R.id.divideButton);
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = screen.getText().toString();
                if(!text.isEmpty() && checkSymbols(text)){
                    text += '/';
                    screen.setText(text);
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence sequence = "Invalid operation";
                    Toast toast = Toast.makeText(context,sequence, Toast.LENGTH_SHORT);
                    ViewGroup group = (ViewGroup) toast.getView();
                    TextView messageTextView = (TextView) group.getChildAt(0);
                    messageTextView.setTextSize(30);
                    toast.show();
                }
            }
        });
    }

    public void setEqualButton(){
        equalButton = findViewById(R.id.equalButton);
        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = screen.getText().toString();
                if(!text.isEmpty() && checkSymbols(text)){
                    Expression expression =  new ExpressionBuilder(text).build();
                    try{
                        Double result = expression.evaluate();
                        screen.setText(result.toString());
                    } catch(ArithmeticException e){
                        Context context = getApplicationContext();
                        CharSequence sequence = e.getLocalizedMessage().toString();
                        Toast toast = Toast.makeText(context, sequence, Toast.LENGTH_LONG);
                        ViewGroup group = (ViewGroup) toast.getView();
                        TextView messageTextView = (TextView) group.getChildAt(0);
                        messageTextView.setTextSize(30);
                        toast.show();
                    }
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence sequence = "Invalid operation";
                    Toast toast = Toast.makeText(context,sequence, Toast.LENGTH_SHORT);
                    ViewGroup group = (ViewGroup) toast.getView();
                    TextView messageTextView = (TextView) group.getChildAt(0);
                    messageTextView.setTextSize(30);
                    toast.show();
                }
            }
        });
    }

    public void setPlusMinusButton(){
        plusMinusButton = findViewById(R.id.plusMinusButton);
        plusMinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = screen.getText().toString();
                if(!text.isEmpty()) {
                    if (!hasAnySymbol(text)) {
                        String newText;
                        newText = "-";
                        newText += text;
                        screen.setText(newText);
                    } else if (calculateSymbols(text) == 1 && text.charAt(0) == '-') {
                        String newText;
                        newText = text.substring(1, text.length());
                        screen.setText(newText);
                    }
                    else{
                        Context context = getApplicationContext();
                        CharSequence sequence = "Invalid operation";
                        Toast toast = Toast.makeText(context,sequence, Toast.LENGTH_SHORT);
                        ViewGroup group = (ViewGroup) toast.getView();
                        TextView messageTextView = (TextView) group.getChildAt(0);
                        messageTextView.setTextSize(30);
                        toast.show();
                    }
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence sequence = "Invalid operation";
                    Toast toast = Toast.makeText(context,sequence, Toast.LENGTH_SHORT);
                    ViewGroup group = (ViewGroup) toast.getView();
                    TextView messageTextView = (TextView) group.getChildAt(0);
                    messageTextView.setTextSize(30);
                    toast.show();
                }
            }
        });
    }

    public boolean checkSign(char sign){
        char[] signs = {'+','-','*','/','^','%'};
        for(char s : signs){
            if(sign == s) return true;
        }
        return false;
    }

    public boolean validateDots(String text){
        boolean flag = false;
        for(int i = 0; i < text.length(); i++){
            if(checkSign(text.charAt(i))){
                flag = true;
            }

        }
        if(flag == false){
            for(int j = 0; j < text.length(); j++){
                if(text.charAt(j) == '.') return false;
            }
        }
        else{
            int index = text.length()-1;
            for(int i = text.length()-1; checkSign(text.charAt(i)) == false; i--){
                index = i;
            }
            for(;index < text.length(); index++){
                if(text.charAt(index) == '.') return false;
            }
        }
        return true;
    }

    public void setDotButton(){
        dotButton = findViewById(R.id.dotButton);
        dotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = screen.getText().toString();
                if(!text.isEmpty() && checkSymbols(text)&& validateDots(text)){
                    text += '.';
                    screen.setText(text);
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence sequence = "Invalid operation";
                    Toast toast = Toast.makeText(context,sequence, Toast.LENGTH_SHORT);
                    ViewGroup group = (ViewGroup) toast.getView();
                    TextView messageTextView = (TextView) group.getChildAt(0);
                    messageTextView.setTextSize(30);
                    toast.show();
                }
            }
        });
    }

    public void setClearButton(){
        clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String text = screen.getText().toString();
                if(!text.isEmpty()){
                    text = text.substring(0,text.length()-1);
                    screen.setText(text);
                }
            }
        });
    }

    public void setAllClearButton(){
        allClearButton = findViewById(R.id.allClearButton);
        allClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
            }
        });
    }
}
