package com.example.calculadoramaxkotlin;

import junit.framework.TestCase;

public class CalculadoraTest extends TestCase {
    public void testSuma() {
        assertEquals(4, Calculadora.suma(2, 2), 0.1);
    }
    public void testResta() {
        assertEquals(0, Calculadora.resta(2, 2), 0.1);
    }
    public void testMultiplicacion() {
        assertEquals(4, Calculadora.multiplicacion(2, 2), 0.1);
    }
    public void testDivision() {
        assertEquals(1, Calculadora.division(2, 2), 0.1);
    }
    public void testFactorial() {
        assertEquals(120, Calculadora.factorial(5));
    }
    public void testFibonacci() {
        assertEquals(5, Calculadora.fibonacci(5));
    }

}