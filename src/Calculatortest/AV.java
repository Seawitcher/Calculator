package Calculatortest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.InputStream;
import java.lang.String;

public class AV {
    
    private static String[] operators = new String[]{"+", "-", "/", "*"};

    enum DigitType {
        ARABIC,
        ROMAN
    }


    
    public static void main(String[] args)  throws Exception  {
        System.out.println("Please enter the variables a + b, a - b, a * b, a / b");
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String formula = bufferedReader.readLine(); //читаем строку с клавиатуры
        System.out.println( calc(formula));
        }

    public static String calc(String input) {
        //System.out.println(Rim.IX.getTranslation());
        String[] sum = null;
        String oper = null;
        for (String operator : operators) {
            if (input.contains(operator)) {
                oper = operator;
                sum = input.split("\\%s".formatted(operator));
            }
        }
        DigitValue value1 = parseOperand(sum[0]);
        DigitValue value2 = parseOperand(sum[1]);

        if (value1.digitType != value2.digitType) {
            throw new IllegalArgumentException("Both values must be Roman");
        }

        if (!(value1.value > 0 && value1.value <= 10 && value2.value > 0 && value2.value<= 10)) {
            throw new IllegalArgumentException("Enter a value from 1 to 10");
        }


        Integer result = null;
        switch (oper) {
            case "+" :
                result = value1.value + value2.value;
                break;
            case "-" :
                result = value1.value - value2.value;
                break;
            case "*" :
                result = value1.value * value2.value;
                break;
            case "/" :
                result = value1.value / value2.value;
                break;
        }

        if (value1.digitType == DigitType.ROMAN) {
            return MyEnum.getByValue(result).toString();
        } else {
            return result.toString();
        }
    }

    private static DigitValue parseOperand(String strValue) {
        MyEnum rim = MyEnum.valueOfOrNull(strValue);
        if (rim == null) {
            return new DigitValue(DigitType.ARABIC, Integer.parseInt(strValue)) ;
        } else {
            return new DigitValue(DigitType.ROMAN,  rim.getValue()) ;
        }
    }

    public static class DigitValue {
        private DigitType digitType;
        private Integer value;

        public DigitValue(DigitType digitType, Integer value) {
            this.digitType = digitType;
            this.value = value;
        }
    }

}