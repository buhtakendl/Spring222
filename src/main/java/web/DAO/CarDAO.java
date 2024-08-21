package web.DAO;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDAO {

    public static List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Audi", "Black", 20000));
        cars.add(new Car("BMW", "White", 30000));
        cars.add(new Car("Mercedes", "Red", 40000));
        cars.add(new Car("Toyota", "Green", 50000));
        cars.add(new Car("Volkswagen", "Blue", 60000));
    }

    public List<Car> carTable(Integer count) {
        if (count > cars.size() || count == 0) {
            return cars;
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
