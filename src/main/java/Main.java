import android.content.DialogInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int howManyPerson = 0;  // Итоговое кол-во человек
        while (howManyPerson <= 1) {    // Запрос на кол-во персон
            while (true) {
                Scanner p = new Scanner(System.in);
                System.out.println("На сколько человек делить счет?");
                if (p.hasNextInt()) {
                    howManyPerson = p.nextInt();
                    break;
                } else {
                    System.out.println("Некорректное значение! Введите целое число.");
                }
            }
            if (howManyPerson <= 1) { // При введенной 1
                System.out.println("Значение должно быть больше 1.");
            }
        }
        Calculate c = new Calculate();
        while (true) {
            c.addProduct(); // Запуск "addProduct" из "Calculate" для добавления позиции из счета
            System.out.println("Позиция успешно добавлена! Добавить ещё одну?\nЕсли да, то введите любой символ.\nНапишите \"Завершить\", что бы произвести подсчет.");
            String answer = scanner.next(); // Проверка ответа
            if (answer.equalsIgnoreCase("завершить")) {
                break;
            }
        }
        c.print(); // Отображение всех введеных позиций
        String i = String.format("%.2f", c.splitCheck(howManyPerson));  // Округление до сотых.
        System.out.println("Каждый должен заплатить:\n"+  i + " " + c.valuteFormat(c.splitCheck(howManyPerson)) );
    }
}




