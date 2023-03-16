package ru.denusariy.luckytickets;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вариант1. Количество счастливых билетов: " + variant1()); //скорость ~10ms
        System.out.println("Вариант2. Количество счастливых билетов: " + variant2()); //скорость ~17ms
        System.out.println("Вариант3. Количество счастливых билетов: " + variant3()); //скорость ~1090ms
        System.out.println("Вариант4. Количество счастливых билетов: " + variant4()); //скорость ~1070ms
        //во всех вариантах ответ 55251
    }

    static int variant1() {
        int result = 0;
        for(int h = 0; h < 10; h++){
            for(int i = 0; i < 10; i++){
                for(int j = 0; j < 10; j++){
                    for(int k = 0; k < 10; k++) {
                        for(int l = 0; l < 10; l++) {
                            for(int m = 0; m < 10; m++) {
                                if(h + i + j == k + l + m)
                                    result++;
                            }
                        }
                    }
                }
            }
        }
        return result - 1; //потому что билета 000 000 нет
    }

    static int variant2() {
        int result = 0;
        for(int i = 1; i < 1000000; i++) {
            int num1 = i / 100000;
            int num2 = (i / 10000) % 10;
            int num3 = (i / 1000) % 10;
            int num4 = (i / 100) % 10;
            int num5 = (i / 10) % 10;
            int num6 = i % 10;
            if (num1 + num2 + num3 == num4 + num5 + num6)
                result ++;
        }
        return result;
    }

    static int variant3() {
        int result = 0;
        String s;
        for(int i = 1001; i < 1000000; i++){ //с 1001, потому что все билеты до 001 001 не имеет смысла считать
            s = String.format("%06d", i);
            if((Integer.parseInt(s.substring(0, 1)))
                    + (Integer.parseInt(s.substring(1, 2)))
                    + (Integer.parseInt(s.substring(2, 3)))
                    == ((Integer.parseInt(s.substring(3, 4)))
                    + (Integer.parseInt(s.substring(4, 5)))
                    + (Integer.parseInt(s.substring(5)))))
                result++;
        }
        return result;
    }

    static int variant4() {
        int result = 0;
        String s;
        for(int i = 1001; i < 1000000; i++){
            s = String.format("%06d", i);
            if((s.charAt(0) + s.charAt(1) + s.charAt(2)) == (s.charAt(3) + s.charAt(4) + s.charAt(5)))
                result++;
        }
        return result;
    }

}
