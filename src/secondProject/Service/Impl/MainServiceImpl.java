package secondProject.Service.Impl;

import secondProject.Service.DBHelper;
import secondProject.Service.MainService;
import secondProject.models.Person;
import secondProject.models.enums.Position;

import java.util.Scanner;

public class MainServiceImpl implements MainService {
    Scanner scanner = new Scanner(System.in);
    DBHelper dbHelper = new DBHelperImpl();
    @Override
    public void start() {
        while (true) {
            System.out.println("Выберите действие ◀  🐱‍🏍️\n1. Заведение нового сотрудника ◀ 🤑\n2. Просмотр списка ◀ 🤓\n3. Анализ ◀ 🧐");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addNewPerson();
                    break;
                case 2:
                    viewPersonList();
                    break;
                case 3:
                    analyze();
                    break;
                default:
                    throw new RuntimeException("Неверно указан ответ");
            }
        }
    }

    private void analyze() {
        while (choice == 'y') {
            int chosenNumber = 0;
            System.out.println("Выберите действие \n" +
                    "1. Вывести средний возраст сотрудников\n" +
                    "2. Вывести мах и мин возраст\n" +
                    "3. Вывести среднюю зп\n" +
                    "4. Вывести сотрудника с самой большой зп\n" +
                    "5. Вывести сотрудника с самой низкой зп\n" +
                    "6. Сгруппировать всех по должности\n" +
                    "7. Сгруппировать всех по возрасту (не работает)\n" +
                    "8. Вывести общую стоимость затрат на зп за год \n" +
                    "9. Вывести только тех у кого зп меньше 10000\n" +
                    "10. Вывести список возрастов сотрудников в определенной должности на ваш выбор");

            chosenNumber = scanner.nextInt();

            dbHelper.getSelectedInormation(chosenNumber);
            System.out.println("Хотите продолжить? \nДа: y.  Нет: n");
            choice = scanner.next().charAt(0);
        }
        choice = 'y';
    }

    private void viewPersonList() {
        while (choice == 'y') {
            System.out.println("Выберите способ сортировки \n1. По имени \n2. От новых к старым \n3. От старых к новым");
            int chosenNumber = scanner.nextInt();
            dbHelper.getSortedPerson(chosenNumber);
            System.out.println("Хотите продолжить? \nДа: y.  Нет: n");
            choice = scanner.next().charAt(0);
        }
        choice = 'y';
    }

    private void addNewPerson() {

        while (choice == 'y') {
            System.out.println("Укажите имя сотрудника");
            String name = scanner.next();
            System.out.println("Укажите возраст сотрудника");
            int age = scanner.nextInt();
            if(age < 18){
                System.out.println("Несовершеннолетних не берем");
                addNewPerson();
            }
            System.out.println("Укажите зарплату сотрудника");
            Double salary = scanner.nextDouble();
            if(salary <= 0){
                System.out.println("За копейки никто не будет работать!!!");
                addNewPerson();
            }
            System.out.println("Выберите позицию");

            for (Position p : Position.values()) {
                System.out.println(p.getVal() + 1 + "." + p);
            }
            int positionVal = scanner.nextInt();

            Position position = Position.values()[positionVal - 1];

            Person person = dbHelper.savePerson(name, age, salary, position);
            System.out.println(person + "\nСотрудник добавлен \n");
            System.out.println("Хотите продолжить? \nДа -- y \nНет -- n");
            choice = scanner.next().charAt(0); System.out.println();
        }
        choice = 'y';
    }

    static char choice = 'y';
}
