package sem2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;

    private static final int WIN_COUNT = 4; // Выигрышная комбинация

    /**
     * Инициализация объектов игры
     */
    static void initialize(){
        fieldSizeX = 5;
        fieldSizeY = 5;
        field = new char[fieldSizeX][fieldSizeY];

        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Печать текущего состояния игрового поля
     */
    static void printField(){
        System.out.print("+");
        for (int i = 0; i < fieldSizeX; i++){
            System.out.print("-" + (i + 1));
        }
        System.out.println("-");

        for (int x = 0; x < fieldSizeX; x++){
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++){
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Ход игрока (человека)
     */
    static int[] humanTurn(){
        int[] coordinate = new int[2];
        int x;
        int y;
        do {
            System.out.print("Введите координаты хода X и Y\n(от 1 до 5) через пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;

        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        coordinate[0] = x;
        coordinate[1] = y;
        field[x][y] = DOT_HUMAN;
        return coordinate;
    }

    /**
     * Ход игрока (компьютера)
     */
    static int[] aiTurn(){
        int[] coordinate = new int[2];
        int x;
        int y;
        do{
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);

        }
        while (!isCellEmpty(x, y));
        coordinate[0] = x;
        coordinate[1] = y;
        field[x][y] = DOT_AI;
        return coordinate;
    }

    /**
     * Проверка, является ли ячейка игрового поля пустой
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка валидности координат хода
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    static boolean isCellValid(int x, int y){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Поверка на ничью (все ячейки игрового поля заполнены фишками человека или компьютера)
     * @return
     */
    static boolean checkDraw(){
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

    /**
     * TODO: Переработать в рамках домашней работы
     * Метод проверки победы
     * @param dot фишка игрока
     * @return результат проверки победы
     */
    static boolean checkWin(int x, int y, char dot, int win){
        int count = 0; //количество одинаковых фишек подряд

        for (int j = 0; j< fieldSizeX; j++) {
            if (field[x][j] == dot) {
                count++;
                    if (count == win) return true;
                }
                else {
                    count = 0;
                }
            }
        count = 0;

        for (int i = 0; i< fieldSizeY; i++) {
            if (field[i][y] == dot) {
                count++;
                if (count == win) return true;
            }
            else {
                count = 0;
            }
        }
        count = 0;


        while (isCellValid(x,y)) {
            if (field[x][y] == dot) {
                count++;
                if (count == win) return true;
                x--;
                y--;
            }
        }
        count = 0;

        while (isCellValid(x,y)) {
            if (field[x][y] == dot) {
                count++;
                if (count == win) return true;
                x++;
                y++;
            }
        }

        return false;
    }




        // Проверка по трем горизонталям
//        if (field[0][0] == dot && field[0][1] == dot && field[0][2] == dot) return true;
//        if (field[1][0] == dot && field[1][1] == dot && field[1][2] == dot) return true;
//        if (field[2][0] == dot && field[2][1] == dot && field[2][2] == dot) return true;
//
//        // Проверка по трем вертикалям
//        if (field[0][0] == dot && field[1][0] == dot && field[2][0] == dot) return true;
//        if (field[0][1] == dot && field[1][1] == dot && field[2][1] == dot) return true;
//        if (field[0][2] == dot && field[1][2] == dot && field[2][2] == dot) return true;
//
//        // Проверка по двум диагоналям
//        if (field[0][0] == dot && field[1][1] == dot && field[2][2] == dot) return true;
//        if (field[0][2] == dot && field[1][1] == dot && field[2][0] == dot) return true;



//    static boolean checkWinV2(char dot){
//        for (int x = 0; x < fieldSizeX; x++){
//            for (int y = 0; y < fieldSizeY; y++){
//
//            }
//        }
//        return false;
//    }
//
//    static boolean check1(int x, int y, char dot, int win){
//        //if (field[x][y + 1] == dot && field[x][y + 2] == dot && field[x][y + 3] == dot)
//        return false;
//    }
//
//    static boolean check2(int x, int y, char dot, int win){
//        return false;
//    }
//
//    static boolean check3(int x, int y, char dot, int win){
//        return false;
//    }
//
//    static boolean check4(int x, int y, char dot, int win){
//        return false;
//    }


    /**
     * Проверка состояния игры
     * @param dot фишка игрока
     * @param s победный слоган
     * @return состояние игры
     */
    static boolean checkState(int x, int y,char dot, String s){
        if (checkWin(x,y,dot,WIN_COUNT)){
            System.out.println(s);
            return true;
        }
        else if (checkDraw()){
            System.out.println("Ничья!");
            return true;
        }
        // Игра продолжается
        return false;
    }

    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                int[] hum = humanTurn(); // массив, чтобы вытащить значения координат, ввденных человеком
                printField();
                if (checkState(hum[0],hum[1],DOT_HUMAN, "Вы победили!"))
                    break;
                int[] it = aiTurn(); // значения введенные компьютером
                printField();
                if (checkState(it[0],it[1],DOT_AI, "Вы проиграли!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if(!scanner.next().equalsIgnoreCase("Y"))
                break;
//        }
    }




}
