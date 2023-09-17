package secondProject.Service.Impl;

import secondProject.Service.DBHelper;
import secondProject.models.Person;
import secondProject.models.enums.Position;

import java.util.*;

public class DBHelperImpl implements DBHelper {
    public List<Person> personList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    Long idGenerate = 0l;
    @Override
    public Person savePerson(String name, int age, Double salary, Position position) {
        Person person = new Person();
        person.setId(++idGenerate);
        person.setAge(age);
        person.setName(name);
        person.setPosition(position);
        person.setSalary(salary);
        personList.add(person);
        return person;
    }

    @Override
    public void getSortedPerson(int choice) {
        switch (choice){
            case 1:
                Collections.sort(personList, Comparator.comparing(Person::getName));
                break;
            case 3:
                Collections.sort(personList, Comparator.comparing(Person::getId));
                break;
            case 2:
                Collections.sort(personList, Comparator.comparing(Person::getId).reversed());
                break;
        }
        System.out.println(personList);
    }

    @Override
    public void getSelectedInormation(int num) {
        switch (num){
            case 1:
                int mediumAge = 0;
                for(Person p: personList){
                    mediumAge += p.getAge();
                }
                System.out.println(mediumAge / personList.size());
                break;

            case 2:
                System.out.println(Collections.max(personList, Comparator.comparing(Person::getAge)).getAge() + "\n" +
                Collections.min(personList, Comparator.comparing(Person::getAge)).getAge());
                break;
            case 3:
                double mediumSalary = 0;
                for(Person p: personList){
                    mediumSalary += p.getSalary();
                }
                System.out.println(mediumSalary / personList.size());
                break;
            case 4:
                System.out.println(Collections.max(personList, Comparator.comparing(Person::getSalary)));
                break;
            case 5:
                System.out.println(Collections.min(personList, Comparator.comparing(Person::getSalary)));
                break;
            case 6:
                Collections.sort(personList, Comparator.comparing(Person::getPosition));
                System.out.println(personList);
                break;
            case 7:
                System.out.println("Данная операция не доступна");
                break;
            case 8:
                double totalSalary = 0;
                for(Person p: personList)
                    totalSalary += p.getSalary();
                System.out.println(totalSalary * 12);
                break;
            case 9:
                for(Person p: personList)
                    if(p.getSalary() <= 10000)
                        System.out.println(p);
            case 10:
                System.out.println("Выберите позцию");
                for (Position p : Position.values()) {
                    System.out.println(p.getVal() + 1 + "." + p);
                }
                int positionVal = scanner.nextInt();

                Position position = Position.values()[positionVal - 1];
                for(Person p: personList){
                    if(p.getPosition() == position){
                        System.out.println(p.getName() + " " + p.getAge());
                    }
                }
        }
    }
}
