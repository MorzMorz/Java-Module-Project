import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
         Race race = new Race();
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 3; i++){
            System.out.println("ВВедите название " + (i+1) + " автомобиля: ");

           String nameCar = scanner.next();

            int speedCar;
            while (true) {
                System.out.println("Введите скорость " + (i + 1) + "-го автомобиля (от 0 до 250 км/час): ");
                speedCar = scanner.nextInt();
                if(speedCar >=0 && speedCar <=250){
                    break;
                } else {
                    System.out.println("Недопустимая скорость автомобиля. Попробуйте еще раз");
                }
            }
            RacingCar racingCar = new RacingCar(nameCar, speedCar);
            race.newLeader(racingCar);
        }
        System.out.println("Победил автомобиль: " + race.winnerCar);
    }
}


class Race {
    String winnerCar = "";
    int distance = 0;

    public void newLeader(RacingCar racingCar){
        int carDistance = 24 * racingCar.speed;
        if (carDistance > distance){
            winnerCar = racingCar.name;
            distance = carDistance;
        }
    }
}


class RacingCar {
    String name;
    int speed;

    public RacingCar(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}
