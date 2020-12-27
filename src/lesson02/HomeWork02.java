package lesson02;

import java.util.Arrays;

public class HomeWork02 {

    public static void main(String[] args) {

//        ---------------------
//        1 Задать целочисленный массив, состоящий из элементов 0 и 1.
//        Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//        Написать метод, заменяющий в  принятом массиве 0 на 1, 1 на 0;
//        ---------------------

        int[] numberArr01 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};          // входной массив для первой задачи
        int[] numberArr02 = new int[8];                                // входной массив для второй задачи (пустой)
        int[] numberArr03 = {5, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 2};   // входной массив для третей задачи
        int[][] numberArr05 = new int[5][5];                           // входной двухмерный массив для пятой задачи (пустой)
        int[] numberArr07 = {1, 2, 3, 4, 5};                         // входной массив для седьмой задачи
        int n = 2;                                                     // переменная для седьмой задачи

        System.out.println("Первая задача: ");
        System.out.println("Изначальный массив: " + Arrays.toString(numberArr01));
        changeArr01 (numberArr01);
        System.out.println("Измененый массив:   " + Arrays.toString(numberArr01) + "\n");
        System.out.println("Вторая задача: ");
        changeArr02 (numberArr02);
        System.out.println("Заполненный массив:   " + Arrays.toString(numberArr02) + "\n");
        System.out.println("Третья задача: ");
        System.out.println("Изначальный массив: " + Arrays.toString(numberArr03));
        changeArr03 (numberArr03);
        System.out.println("Измененый массив:   " + Arrays.toString(numberArr03) + "\n");
        System.out.println("Четвертая задача: ");
        System.out.println("Изначальный массив: " + Arrays.toString(numberArr03));
        System.out.println("Минимальное число в нем: " + minArr (numberArr03));
        System.out.println("Максимальное число в нем: " + maxArr (numberArr03) + "\n");
        System.out.println("Пятая задача: ");
        changeArr05 (numberArr05);
        System.out.println();
        System.out.println("Шестая задача: ");
        System.out.println("Изначальный массив: " + Arrays.toString(numberArr03));
        System.out.println("Он сбалансирован? - " + compareArr (numberArr03) + "\n");
        System.out.println("Седьмая задача: ");
        System.out.println("Изначальный массив: " + Arrays.toString(numberArr07));
        System.out.println("Смещенный на " + n + " массив" + Arrays.toString(shiftArr(numberArr07, n)) + "\n");
        System.out.println("Восьмая задача: ");
        System.out.println("Изначальный массив: " + Arrays.toString(numberArr07));
        System.out.println("Смещенный на " + n + " массив" + Arrays.toString(shiftArr2(numberArr07, n)) + "\n");

    }

    public static void changeArr01(int[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = (inputArr[i] == 0) ? 1 : 0;
        }
    }
//        ---------------------
//        2 Задать пустой целочисленный массив размером 8.
//        Написать метод, который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
//        ---------------------

    public static void changeArr02(int[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = i * 3 + 1;
        }
    }

//        ---------------------
//        3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
//        написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
//        ---------------------

    public static void changeArr03(int[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = (inputArr[i] < 6) ? inputArr[i] * 2 : inputArr[i];
        }
    }

//        ---------------------
//        4 Задать одномерный массив. (Я взял изменный массив из третей задачи т.к. он идеально подходит)
//        Написать методы поиска в нём минимального и максимального элемента;
//        ---------------------

    public static int minArr(int[] inputArr) {
        int min = inputArr[0];
        for (int i = 0; i < inputArr.length; i++) {
            min = (inputArr[i] < min) ? inputArr[i] : min;
        }
        return (min);
    }

    public static int maxArr(int[] inputArr) {
        int max = inputArr[0];
        for (int i = 0; i < inputArr.length; i++) {
            max = (inputArr[i] > max) ? inputArr[i] : max;
        }
        return (max);
    }

//        ---------------------
//        5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
//        заполнить его диагональные элементы единицами, используя цикл(ы);
//        ---------------------

    public static void changeArr05(int[][] inputArr) {
        for (int x = 0; x < inputArr.length; x++) {
            for (int y = 0; y < inputArr.length; y++) {
                inputArr[x][y] = (x == y || x + y == inputArr.length - 1) ? 1 : 0;
                System.out.print(inputArr[x][y] + "\t");
            }
            System.out.println();
        }
    }

//        ---------------------
//        6 ** Написать метод, в который передается не пустой одномерный целочисленный массив,
//        метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры:
//        checkBalance([1, 1, 1, || 2, 1]) → true,
//        checkBalance ([2, 1, 1, 2, 1]) → false,
//        checkBalance ([10, || 1, 2, 3, 4]) → true.
//        Абстрактная граница показана символами ||, эти символы в массив не входят.
//        ---------------------

    public static boolean compareArr(int[] inputArr) {
        int left = 0;
        int sum = 0;
        boolean balance = false;
        for (int i = 0; i < inputArr.length; i++) {
            sum += inputArr[i];                 //считаем сумму массива
        }
        if (sum % 2 > 0)
            return (balance);   //если сумма всех чисел массива не четная - он априори не может быть сбалансированным
        else {
            for (int i = 0; i < inputArr.length; i++) {
                left += inputArr[i];
                if (left == sum - left) {
                    balance = true;
                    return (balance);
                }
            }
        }
        return (balance);
    }

//        7 *** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным),
//        при этом метод должен циклически сместить все элементы массива на n позиций.
//        [1,2,3,4,5], -2 => [3,4,5,1,2]
//        [1,2,3,4,5], 2 => [4,5,1,2,3]

    public static int[] shiftArr(int[] inputArr, int shift) {
        int[] inputArr2 = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            if (shift >= 0) {
                if (inputArr.length > (i + shift)) inputArr2[i + shift] = inputArr[i];
                else inputArr2[i - (inputArr.length - shift)] = inputArr[i];
            } else {
                if (inputArr.length > (i + shift) && (i + shift) >= 0) inputArr2[i + shift] = inputArr[i];
                else inputArr2[i + (inputArr.length + shift)] = inputArr[i];
            }
        }
        return inputArr2;
    }


//        8 **** Не пользоваться вспомогательным массивом при решении задачи 7.

    public static int[] shiftArr2(int[] inputArr, int shift) {
        for (int i = 0; i < inputArr.length; i++) {
            if (shift >= 0) {
                if (inputArr.length > (i + shift)) inputArr[i + shift] = inputArr[i];
                else inputArr[i - (inputArr.length - shift)] = inputArr[i];
            } else {
                if (inputArr.length > (i + shift) && (i + shift) >= 0) inputArr[i + shift] = inputArr[i];
                else inputArr[i + (inputArr.length + shift)] = inputArr[i];
            }
        }
        return inputArr;
    }
}