public class Roman {

    public static int getArabFromRoman(String input){  //перевод из арабского числа в римское
        int output=0;
        char[] inputChar = input.toCharArray();
        String tmp="";
        for (char a : inputChar){
            tmp+= a;
            if(contains(tmp)){
                continue;
            }else {
                output+= RomanNumbers.valueOf(tmp.substring(0,tmp.length()-1)).getValue();
                tmp = ""+a;
            }
        }
        output+= RomanNumbers.valueOf(tmp.substring(0,tmp.length())).getValue();
        return output;
    }

    public static String getRomanFromArab(int input){ //перевод из римского числа в арабское
        String output = "";
        while(input>=1){
            output+= getMaxRoman(input);
            input-=RomanNumbers.valueOf(getMaxRoman(input)).getValue();
        }
        return output;
    }

    private static boolean contains(String num) { // проверка есть ли такое римское число в наборе RomanNumbers
        for (RomanNumbers c : RomanNumbers.values()) {
            if (c.name().equals(num)) {
                return true;
            }
        }
        return false;
    }

    private static String getMaxRoman(int input){ // вспомогательный метод для нахождения самого большого римского входимого числа в input
        StringBuffer output= new StringBuffer("");
        for (RomanNumbers c : RomanNumbers.values()) {
            if (input>=c.getValue()) {
                output.setLength(0);
                output.append(c.name());
            }else{break;}
        }
        return output.toString();
    }
}
