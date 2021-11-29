public class Calculator {

    public static String calculate(String input) throws CalculatorException{
        boolean isRomanA=false , isRomanB=false;
        int a,b,res;

        String[] inputStrings = split(input);
        if(inputStrings.length!=3) throw new CalculatorException("формат математической операции не удовлетворяет заданию - два целочисленных операнда и один оператор (+, -, /, *)");
        try {
            a=Integer.parseInt(inputStrings[0]);
            isRomanA = false;
        }catch (NumberFormatException e){
            try {
            a=Roman.getArabFromRoman(inputStrings[0]);
            isRomanA = true;

            }catch (IllegalArgumentException e2){
                throw new CalculatorException("формат математической операции не удовлетворяет заданию - два целочисленных операнда и один оператор (+, -, /, *)");
            }
        }
        try {
            b=Integer.parseInt(inputStrings[2]);
            isRomanB = false;
        }catch (NumberFormatException e){
            try {
                b=Roman.getArabFromRoman(inputStrings[2]);
                isRomanB = true;
            }catch (IllegalArgumentException e2){
                throw new CalculatorException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        }
        if(isRomanA != isRomanB) throw new CalculatorException("используются одновременно разные системы счисления");
        if (a>10 || a<1 || b>10 || b<1) throw new CalculatorException("входные значения имеют диапазон от 1 до 10 включительно");
        res = calc(a,b,inputStrings[1]);
        if(isRomanA  && res<=0)throw new CalculatorException("в римской системе нет отрицательных чисел");
        if(isRomanA)return Roman.getRomanFromArab(res);
        return String.valueOf(res);
    }


    private static int calc(int a, int b, String op){ //выполнение математики
        int output = 0;
        switch (op){
            case "-":
                output =a-b;
                break;
            case "+":
                output = a+b;
                break;
            case "*":
                output = a*b;
                break;
            case "/":
                output = a/b;
                break;
        }
        return output;
    }


    private static String[] split(String input) throws CalculatorException { // метод разделение входной строки на 3 строки где 0- первый операнд, 1 - знак операции, 2- второй операнд
        char[] inputChar = input.toCharArray();
        int index=-1;
        for(int i = 0; i<inputChar.length; i++){
            if(inputChar[i] == '-' || inputChar[i] == '+' || inputChar[i] == '*' || inputChar[i] == '/'){
                index = i;
                break;
            }
        }
        if(index == -1) throw new CalculatorException("строка не является математической операцией");
        String[] output = new String[3];
        output[0] = input.substring(0,index).trim();
        output[1] = input.substring(index,index+1);
        output[2] = input.substring(index+1,input.length()).trim();
        return output;
    }
}
