package lesson03;

import java.util.Random;
import java.util.Scanner;

public class HomeWork03 {

    public static final int SIZE = 10;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
            do {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Комп");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    } while (restart());
    }
    public static boolean checkWin(char symb) {
        int score = 0;
        //========= Подсчет горизонталей ==========//
        for (int x = 0; x < SIZE; x++) {
            score = 0;
            for (int y = 0; y < SIZE; y++) {
                if(map[x][y] == symb) score++;
                else score = 0;
                if (score == DOTS_TO_WIN) return true;
            }
        }
        //========= Подсчет вертикалей ==========//
        for (int y = 0; y < SIZE; y++) {
            score = 0;
            for (int x = 0; x < SIZE; x++) {
                if(map[x][y] == symb) score++;
                else score = 0;
                if (score == DOTS_TO_WIN) return true;
            }
        }
        //========= Подсчет диагоналей параллельных главной ==========//
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                score = 0;
                int x1 = x;
                int y1 = y;
                do {
                    if (map[x1][y1] == symb) score++;
                    else score = 0;
                    if (score == DOTS_TO_WIN) return true;
                    x1++;
                    y1++;
                } while (y1 < SIZE && x1 <SIZE);
            }
        }
        //========= Подсчет диагоналей параллельных побочной ==========//
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                score = 0;
                int x1 = x;
                int y1 = y;
                do {
                    if (map[x1][y1] == symb) score++;
                    else score = 0;
                    if (score == DOTS_TO_WIN) return true;
                    x1--;
                    y1++;
                } while (y1 < SIZE && 0 <= x1);
            }
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер сходил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!aiEmty(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }
    public static boolean restart() {
        int x;
        do {
            System.out.println("Сыгрем еще раз? Введите 1 - да, 0 - нет");
            x = sc.nextInt();
        } while (x != 1 && x != 0);
        if (x == 1) return true;
        else return false;
    }
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            System.out.println("Такого поля нет");
            return false;
        }
        if (map[y][x] == DOT_EMPTY) return true;
        System.out.println("Это поле занято");
        return false;
    }
    public static boolean aiEmty (int x, int y){
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
           System.out.println();
    }

}
