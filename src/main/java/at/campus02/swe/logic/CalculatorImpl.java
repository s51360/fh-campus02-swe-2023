package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;

import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

public class CalculatorImpl implements Calculator {


    private Stack<Double> stack_ = new Stack<Double>();

    private HashMap<String, Double> storedValues = new HashMap<>();

    @Override
    public double perform(Operation op) throws CalculatorException {
        double a, b, c;

        switch (op) {
            case add:
                b = pop();
                a = pop();
                return a + b;
            case sub:
                b = pop();
                a = pop();
                return a - b;
            case div:
                b = pop();
                a = pop();
                c = a / b;
                if (Double.isInfinite(c))
                    throw new CalculatorException("Division by zero");
                return c;
            case mul:
                b = pop();
                a = pop();
                return a * b;
            case mod:
                b = pop();
                a = pop();
                return a % b;
            case sin:
                a = pop();
                b = a * Math.PI/180;
                return Math.sin(b);
            case cos:
                a = pop();
                b = a * Math.PI/180;
                return Math.cos(b);
            case random:
                double max = pop();
                double min = pop();

                if (min > max) {
                    throw new CalculatorException("Minimum ist größer als Maximum");
                }

                int minInt = (int) Math.ceil(min);
                int maxInt = (int) Math.floor(max);

                Random rand = new Random();
                return rand.nextInt(maxInt - minInt + 1) + minInt;
            case dotproduct:
                if (stack_.size() < 3) {
                    throw new CalculatorException("Nicht genügend Elemente für Skalarprodukt");
                }

                int n = (int) Math.round(pop());
                double dotProduct = 0;

                for (int i = 0; i < n; i++) {
                     a = pop();
                     b = pop();
                    dotProduct += a * b;
                }

                return dotProduct;
        }
        return 0;
    }

    @Override
    public double pop() throws CalculatorException {
        if (stack_.isEmpty())
            throw new CalculatorException();
        return stack_.pop();
    }

    @Override
    public void push(double v) {
        stack_.push(v);
    }

    @Override
    public void clear() {
        stack_.clear();
    }

    @Override
    public void store(String name) {

        double value = stack_.peek();
        storedValues.put(name, value);

    }

    @Override
    public void load(String name) throws CalculatorException {

        if (storedValues.containsKey(name) == false) {
            throw new CalculatorException("Name nicht im Speicher gefunden");
        }

        double value = storedValues.get(name);
        stack_.push(value);
    }
}
