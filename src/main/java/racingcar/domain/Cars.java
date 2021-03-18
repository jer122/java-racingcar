package racingcar.domain;

import racingcar.service.RandomStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] playCarName) {
        cars = generateCars(playCarName);
    }

    private List<Car> generateCars(String[] playCarName) {
        List<Car> carList = new ArrayList<>();
        int playCarNum = playCarName.length;
        for (int num = 0; num < playCarNum; num++) {
            carList.add(new Car(playCarName[num]));
        }
        return carList;
    }

    public void playCarGame() {
        for (Car car : cars) {
            car.move(new RandomStrategy());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> copyCars() {
        List<Car> copyCars = cars.stream()
                .map(Car::clone).collect(Collectors.toList());
        return copyCars;
    }
}
