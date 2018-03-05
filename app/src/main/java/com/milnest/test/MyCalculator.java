/*
 * Copyright (c) 2018. milnest.
 */

package com.milnest.test;

import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.mXparser;

/**
 * Created by t-yar on 04.03.2018.
 * Класс рассчёта результата
 */

public class MyCalculator {

    private static String sCurrentStatement = "";

    public static String getCurrentStatement() {
        return sCurrentStatement;
    }

    public static void setCurrentStatement(String currentStatement) {
        sCurrentStatement = currentStatement;
    }

    /**
     * С использованием библиотеки mxparser парсит строку в математическое выражение и расчитывак
     * результат
     * @return строковое представление результата
     */
    public static String Сalculate() {
        Expression exToCalc = new Expression(sCurrentStatement);
        mXparser.enableUlpRounding();
        setCurrentStatement(String.valueOf(exToCalc.calculate()));
        return sCurrentStatement;
    }
}

