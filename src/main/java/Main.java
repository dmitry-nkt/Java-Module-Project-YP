import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList <Product> productList = new ArrayList<>();
        int amount;
        System.out.println("На скольких человек необходимо разделить счёт?");

        while (true) {
            Scanner sc = new Scanner(System.in);

            if (sc.hasNextInt()) {

                while (true) {
                    amount = sc.nextInt();

                    if (amount < 1) {
                        System.out.println("Это некорректное значение для подсчёта.");
                    } else if (amount == 1) {
                        System.out.println("Деление счёта бессмыслено :)");
                    } else {
                        System.out.println("Введите наименование товара и стоимость товара в формате рубли.копейки, например 'Цезарь 250.70'. Для окончания подсчета введите 'Завершить'");
                        Calculator newCalculator = new Calculator();

                        sc.nextLine();

                        while (true) {
                            Product newProduct = new Product();
                            String userAnswer = sc.nextLine();

                            if (!userAnswer.equalsIgnoreCase("завершить")) {
                                try {
                                    String[] userAnswerArr = userAnswer.split(" ");
                                    String price = userAnswerArr[userAnswerArr.length - 1];
                                    String name = userAnswer.replaceAll(price, "");

                                    newProduct.setProductName(name);
                                    newProduct.setProductPrice(price);
                                    newCalculator.setAllProductPrice(newProduct.getProductPrice());
                                    productList.add(newProduct);
                                    System.out.println("Товар успешно добавлен в список");
                                    System.out.println("Хотите добавить еще товар или завершить подсчёт? Для окончания подсчета введите 'Завершить'");
                                } catch (NumberFormatException e) {
                                    System.out.println("Неверный формат цены. Повторите попытку");
                                } catch (Exception e) {
                                    System.out.println("Неверный формат товара");
                                }
                            }

                            else {
                                break;
                            }
                        }
                        if (newCalculator.getAllProductPrice() != 0.00) {
                            System.out.println("Добавленные товары:");

                            for (Product eachProduct: productList) {
                                System.out.println(eachProduct.getProductInfo());
                            }

                            System.out.println("Сумма к оплате каждого гостя: " + newCalculator.getGuestBill(amount));
                            break;
                        }
                    }
                }
                break;
            } else {
                System.out.println("Неправильный ввод. Введите корректное цифровое значение");
            }
        }
    }
}
