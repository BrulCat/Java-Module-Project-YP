import java.util.Scanner;

public class Calculate {
    Scanner scanner = new Scanner(System.in);
    String ProductList;
    double check = 0.0;

    void addProduct(){
        System.out.println("Введите наименование позиции:");
        String name = scanner.nextLine();
        double price; // Стоимость позиции
        while (true) {
            Scanner pr = new Scanner(System.in);
            System.out.println("Введите цену (Рубли,копейки): ");
            if (pr.hasNextDouble()) {
                double x = pr.nextDouble();
                if (x > 0){
                    price = x;
                    break;
                } else {
                    System.out.println("Цена должна быть больше 0."); // За подарки от соседнего столика тоже надо платить :c
                }
            } else {
                System.out.println("Некорректное значение! Убедитесь, что вводите в правильном формате (Рубли,копейки).");
            }
        }
        Product product = new Product(name, price);
        ProductList += name + "\n";
        check += price;
    }
    void print() {
        System.out.println("Добавленные позиции:\n" + ProductList);
    }
    double splitCheck(int howManyPerson) {
        double f;
        f = check / howManyPerson;
        return f;
    }
    String valuteFormat(double num) { // Честно, взят с интернета. Хотелось бы видеть такие задание в тренажерах ранее ;)
        int x = (int) num;
        if (x %100 / 10 == 1){
            return "рублей";
        } else {
            switch(x %10) {
                case 1: return "Рубль";
                case 2:
                case 3:
                case 4: return "Рубля";
                default: return "Рублей";
            }
        }
    }
}

