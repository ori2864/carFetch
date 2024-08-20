package com.ori.carfetch.clr;

import com.ori.carfetch.Beans.Car;
import com.ori.carfetch.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class TestApp implements CommandLineRunner {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CarService carService;

    @Override
    public void run(String... args) throws Exception {
                try {
                    Car car = carService.getQuery(68289002L);
                    System.out.println(car);

                    Car car1 = Car.builder()
                            .degemManoa(car.getDegemManoa())
                            .build();

                    carService.getCarList(car1);

                } catch (Exception e) {
                    e.printStackTrace();
                }

        System.out.println("program end");
    }
}
