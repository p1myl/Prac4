package com.pimy.prac4;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("First task");
        System.out.println(sevenBoom(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(sevenBoom(new int[]{8, 6, 33, 100}));
        System.out.println(sevenBoom(new int[]{2, 55, 60, 97, 86}));
        System.out.println();

        System.out.println("Second task");
        System.out.println(cons(new int[]{5, 1, 4, 3, 2}));
        System.out.println(cons(new int[]{5, 1, 4, 3, 2, 8}));
        System.out.println(cons(new int[]{5, 6, 7, 8, 9, 9}));
        System.out.println();

        System.out.println("Third task");
        System.out.println(unmix("123456"));
        System.out.println(unmix("hTsii  s aimex dpus rtni.g"));
        System.out.println(unmix("badce"));
        System.out.println();

        System.out.println("Fourth task");
        System.out.println(noYelling("What went wrong?????????"));
        System.out.println(noYelling("Oh my goodness!!!"));
        System.out.println(noYelling("I just!!! can!!! not!!! believe!!! it!!!\") ➞ \"I just!!! can!!! not!!! believe!!! it!"));
        System.out.println();

        System.out.println("Fifth task");
        System.out.println(xPronounce("Inside the box was a xylophone"));
        System.out.println(xPronounce("The x ray is excellent"));
        System.out.println(xPronounce("OMG x box unboxing video x D"));
        System.out.println();

        System.out.println("Sixth task");
        System.out.println(largestGap(new int[]{9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5}));
        System.out.println(largestGap(new int[]{14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7}));
        System.out.println(largestGap(new int[]{13, 3, 8, 5, 5, 2, 13, 6, 14, 2, 11, 4, 10, 8, 1, 9}));
        System.out.println();

        System.out.println("Seventh task");
        System.out.println(reverseCoding(832));
        System.out.println(reverseCoding(51));
        System.out.println(reverseCoding(7977));
        System.out.println(reverseCoding(1));
        System.out.println(reverseCoding(665));
        System.out.println(reverseCoding(149));
        System.out.println();

        System.out.println("Eighth task");
        System.out.println(commonLastVowel("Hello World!"));
        System.out.println(commonLastVowel("Watch the characters dance!"));
        System.out.println(commonLastVowel("OOI UUI EEI AAI"));
        System.out.println();

        System.out.println("Ninth task");
        System.out.println(memeSum(26, 39));
        System.out.println(memeSum(122, 81));
        System.out.println(memeSum(1222, 30277));
        System.out.println();

        System.out.println("Tenth task");
        System.out.println(unrepeated("teshahset"));
        System.out.println(unrepeated("hello"));
        System.out.println(unrepeated("aaaaa"));
        System.out.println(unrepeated("WWE!!!"));
        System.out.println(unrepeated("call 911"));
        System.out.println();
    }

    public static String sevenBoom(int[] numbers){
        for (int number: numbers){
            if (String.valueOf(number).contains("7")){
                return "Boom";
            }
        }
        return "there is no 7 in the array";
    }

    public static boolean cons(int[] numbers){
        HashSet<Integer> newSet = new HashSet<>();
        for (int number: numbers){
            newSet.add(number);
        }
        if (numbers.length != newSet.size()){
            return false;
        }

        Integer[] sortedNumbers = new Integer[newSet.size()];
        newSet.toArray(sortedNumbers);
        for (int i = 1; i < sortedNumbers.length; i++){
            if (sortedNumbers[i] - sortedNumbers[i - 1] != 1){
                return false;
            }
        }

        return true;
    }

    public static String unmix(String str){
        String result = "";
        for (int i = 0; i < str.length(); i += 2){
            if (i + 1 < str.length()){
                result += Character.toString(str.charAt(i + 1)) + Character.toString((str.charAt(i)));
            } else {
                result += Character.toString(str.charAt(i));
            }
        }
        return result;
    }

    public static String noYelling(String str){
        while (str.endsWith("!!") || str.endsWith("??")){
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static String xPronounce(String str){
        String result = "";
        for (String word : str.split(" ")){
            for (Character ch : word.toCharArray()){
                if (ch == 'x'){
                    if (word.equals("x") || word.indexOf(ch) > 0) {
                        result += "cks";
                    } else if (word.indexOf(ch) == 0){
                        result += "z";
                    }
                } else {
                    result += ch;
                }
            }
            result += " ";
        }
        return result;
    }

    public static int largestGap(int[] numbers){
        Arrays.sort(numbers);
        int gap = numbers[1] - numbers[0];
        for (int i = 0; i < numbers.length - 1; i++){
            if (numbers[i + 1] - numbers[i] > gap){
                gap = numbers[i + 1] - numbers[i];
            }
        }
        return gap;
    }

    public static int reverseCoding(int number){
        int sourceNumber = number;
        ArrayList<Integer> numbers = new ArrayList<>();

        while (number > 0){
            numbers.add(number % 10);
            number = number / 10;
        }

        Collections.sort(numbers);

        int reverseNumber = 0;
        for (int num : numbers){
            reverseNumber = reverseNumber * 10 + num;
        }

        return sourceNumber - reverseNumber;
    }

    // only for commonLastVowel
    public static Character getLastLetter(String word){
        char[] chars = word.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--){
            if (Character.isLetter(chars[i])){
                return chars[i];
            }
        }

        return chars[chars.length - 1];
    }

    public static String commonLastVowel(String str){
        HashMap<Character, Integer> lettersData = new HashMap<>();
        char temp;
        char result = 0;

        for (String word : str.split(" ")){
            temp = getLastLetter(word);
            if (lettersData.get(temp) == null) {
                lettersData.put(temp, 1);
            } else {
                lettersData.put(temp, lettersData.get(temp) + 1);
            }

            if (lettersData.get(temp) > lettersData.getOrDefault(result, 0)){
                result = temp;
            }
        }
        
        return Character.toString(result).toLowerCase();
    }

    public static int memeSum(int a, int b){
        String aStr = Integer.toString(a);
        String bStr = Integer.toString(b);
        if (aStr.length() > bStr.length()){
            for (int i = 0; i < aStr.length() - bStr.length(); i++){
                bStr = "0" + bStr;
            }
        } else {
            for (int i = 0; i < bStr.length() - aStr.length(); i++){
                aStr = "0" + aStr;
            }
        }

        String result = "";

        for (int i = 0; i < aStr.length(); i++){
            result += Character.getNumericValue(aStr.charAt(i)) + Character.getNumericValue(bStr.charAt(i));
        }

        return Integer.parseInt(result);
    }

    public static String unrepeated(String str){
        String result = "";
        for (char ch : str.toCharArray()){
            if (!result.contains(Character.toString(ch))){
                result += ch;
            }
        }
        return result;
    }
}
