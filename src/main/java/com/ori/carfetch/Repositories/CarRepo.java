package com.ori.carfetch.Repositories;

import com.ori.carfetch.Beans.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car,Long> {
}
