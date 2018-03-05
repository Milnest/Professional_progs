/*
 * Copyright (c) 2018. milnest.
 */

package com.milnest.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mResField;
    private TextView mInputField;
    private Button mMinusButton;
    private Button mPlusButton;
    private Button mDivideButton;
    private Button mMultiplyButton;
    private Button mCalculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
        //disableButtons();
    }

    private void initializeComponents() {
        mResField = (TextView) findViewById(R.id.resultField);
        mInputField = (TextView) findViewById(R.id.inputField);
        mMinusButton = (Button) findViewById(R.id.operationMinusButton);
        mPlusButton = (Button) findViewById(R.id.operationPlusButton);
        mDivideButton = (Button) findViewById(R.id.operationDivideButton);
        mMultiplyButton = (Button) findViewById(R.id.operationMultiplyButton);
        mCalculateButton = (Button) findViewById(R.id.operationCalculateButton);
    }

    @Override
    public void onClick(View v) {
        //Добавление в поле ввода
        switch (v.getId()){
            case R.id.operationCalculateButton:
                Сalculate();
                break;
            case R.id.operationDivideButton:
                Divide();
                break;
            case R.id.operationMinusButton:
                Minus();
                break;
            case R.id.operationMultiplyButton:
                Multiply();
                break;
            case R.id.operationPlusButton:
                Plus();
                break;
            case R.id.dotButton:
                Dot();
                break;
            case R.id.deleteButton:
                deleteSymbol();
                break;
            default:
                AppendToInput(v);
                break;
        }
    }

    /**
     * Удаляет последний введённый символ из поля ввода и строки выражения
     */
    private void deleteSymbol() {
        String curInput = mInputField.getText().toString();
        //Если поле ввода не пустое, удалить последний символ
        String calcStr = MyCalculator.getCurrentStatement();
        if (curInput.length() > 0){
            mInputField.setText(curInput.substring(0, curInput.length()-1));
            MyCalculator.setCurrentStatement(calcStr.substring(0, calcStr.length()-1));
        }
        else{
            //Поле ввода пусто, действий не требуется
        }
    }

    /**
     * Выводит результат в поле ввода и предыдущее выражение в поле результата
     */
    private void Сalculate() {
        String calcText = mInputField.getText().toString();
        String curValue = MyCalculator.Сalculate();
        mResField.setText(calcText);
        mInputField.setText(curValue);
    }

    /**
     * Заполняет поле ввода и строку выражения для кнопок-цифр
     * @param v = представление кнопки
     */
    private void AppendToInput(View v) {
        Button anyButon = (Button) v;
        mInputField.append(anyButon.getText().toString());
        String calcStr = MyCalculator.getCurrentStatement();
        MyCalculator.setCurrentStatement(calcStr.concat(anyButon.getText().toString()));
    }

    /**
     * Заполняет поле ввода и строку выражения для операции деления
     */
    private void Divide() {
        mInputField.append("÷");
        MyCalculator.setCurrentStatement(MyCalculator.getCurrentStatement().concat("/"));
    }

    /**
     * Заполняет поле ввода и строку выражения для операции "точка"
     */
    private void Dot() {
        mInputField.append(".");
        MyCalculator.setCurrentStatement(MyCalculator.getCurrentStatement().concat("."));
    }

    /**
     * Заполняет поле ввода и строку выражения для операции сложения
     */
    private void Plus() {
        mInputField.append("+");
        MyCalculator.setCurrentStatement(MyCalculator.getCurrentStatement().concat("+"));
    }

    /**
     * Заполняет поле ввода и строку выражения для операции умножения
     */
    private void Multiply() {
        mInputField.append("×");
        MyCalculator.setCurrentStatement(MyCalculator.getCurrentStatement().concat("*"));
    }

    /**
     * Заполняет поле ввода и строку выражения для операции вычитания
     */
    private void Minus() {
        mInputField.append("-");
        MyCalculator.setCurrentStatement(MyCalculator.getCurrentStatement().concat("-"));
    }

}
