package com.ori.carfetch.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ori.carfetch.Beans.ApiRequest;
import com.ori.carfetch.Beans.Car;
import com.ori.carfetch.Beans.CarRequestFilters;
import com.ori.carfetch.Repositories.CarRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.ori.carfetch.Utils.CarBuilder.buildCar;
import static com.ori.carfetch.Utils.CarBuilder.buildCarList;

@Service
@RequiredArgsConstructor
public class CarService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final CarRepo carRepo;
    private final String carURLQuery = "https://data.gov.il/api/3/action/datastore_search?resource_id=053cea08-09bc-40ec-8f7a-156f0677aff3&q=";
    private final String carURL = "https://data.gov.il/api/3/action/datastore_search";
    @Autowired
    private ApiRequest apiRequest;



    public Car getQuery(Long carId) throws Exception {
        if (carRepo.findById(carId).isEmpty()) {
            String carURL = carURLQuery + carId;

            // Fetch the JSON response as a String
            String jsonResponse = restTemplate.getForObject(carURL, String.class);

            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            // get the first object from records (car details)
            JsonNode resultNode = rootNode.path("result").path("records").get(0);

            // Map JSON fields to Car object
            Car car = buildCar(resultNode);
            System.out.println(car);
            carRepo.save(car);

            return car;
        }
        return carRepo.findById(carId).get();
    }
    public Car getCarFromApi(Car car) throws Exception {
        if (carRepo.findById(car.getMisparRechev()).isEmpty()) {
        JsonNode rootNode = postCarRequest(car);
        // get the first object from records (car details)
        JsonNode resultNode = rootNode.path("result").path("records").get(0);
        // Map JSON fields to Car object
        Car car1 = buildCar(resultNode);
        System.out.println("built car: "+car1);

        carRepo.save(car1);

        return car1;
        }
        return carRepo.findById(car.getMisparRechev()).get();
    }
    public List<Car> getCarList(Car car) throws Exception {
        JsonNode rootNode = postCarRequest(car);
        // get the first object from records (car details)
        JsonNode resultNode = rootNode.path("result").path("records");
        // Map JSON fields to Car list
        List<Car> carList = buildCarList(resultNode);

        System.out.println("built car list: " + carList);

        return carList;
    }
    private JsonNode postCarRequest(Car car) throws JsonProcessingException {
        // Set the car as Filters-Object
        apiRequest.setFilters(new CarRequestFilters(car));
        // Fetch the JSON response as a String
        String jsonResponse = restTemplate.postForObject(carURL, apiRequest, String.class);
        return objectMapper.readTree(jsonResponse);

    }

}
