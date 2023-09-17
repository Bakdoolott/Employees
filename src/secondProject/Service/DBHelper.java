package secondProject.Service;

import secondProject.models.Person;
import secondProject.models.enums.Position;

public interface DBHelper {
    public Person savePerson(String name, int age, Double salary, Position position);

    void getSortedPerson(int choice);

    void getSelectedInormation(int num);
}
