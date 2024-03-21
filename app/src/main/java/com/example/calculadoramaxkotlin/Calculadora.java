package com.example.calculadoramaxkotlin;
public class Calculadora {
    public static double suma(double a, double b) {
        return a + b;
    }
    public static double resta(double a, double b) {
        return a - b;
    }
    public static double multiplicacion(double a, double b) {
        return a * b;
    }
    public static double division(double a, double b) {
        return a / b;
    }
    public static int factorial(int a) {
        //hacer el factorial con recursividad
        if (a == 0) {
            return 1;
        } else {
            return a * factorial(a - 1);
        }
    }
    public static int fibonacci(int a) {
        //hacer el fibonacci con recursividad
        if (a == 0) {
            return 0;
        } else if (a == 1) {
            return 1;
        } else {
            return fibonacci(a - 1) + fibonacci(a - 2);
        }
    }
}
