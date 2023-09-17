package secondProject;

import secondProject.Service.Impl.MainServiceImpl;
import secondProject.Service.MainService;

public class Main {
    public static void main(String[] args) {

        MainService mainService = new MainServiceImpl();
        mainService.start();
    }
}
