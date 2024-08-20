package com.ori.carfetch.Utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.ori.carfetch.Beans.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarBuilder {
    public static List<Car> buildCarList (JsonNode jsonCarList){
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < jsonCarList.size(); i++) {
            Car car = buildCar(jsonCarList.get(i));
            cars.add(car);
        }
        return cars;
    }
    public static Car buildCar(JsonNode jsonCar) {
        Car car = Car.builder()
                .id(Optional.ofNullable(jsonCar.get("_id")).map(JsonNode::asInt).orElse(null))
                .misparRechev(Optional.ofNullable(jsonCar.get("mispar_rechev")).map(JsonNode::asLong).orElse(null))
                .tozeretCd(Optional.ofNullable(jsonCar.get("tozeret_cd")).map(JsonNode::asLong).orElse(null))
                .sugDegem(Optional.ofNullable(jsonCar.get("sug_degem")).map(JsonNode::asText).orElse(null))
                .tozeretNm(Optional.ofNullable(jsonCar.get("tozeret_nm")).map(JsonNode::asText).orElse(null))
                .degemCd(Optional.ofNullable(jsonCar.get("degem_cd")).map(JsonNode::asLong).orElse(null))
                .degemNm(Optional.ofNullable(jsonCar.get("degem_nm")).map(JsonNode::asText).orElse(null))
                .ramatGimur(Optional.ofNullable(jsonCar.get("ramat_gimur")).map(JsonNode::asText).orElse(null))
                .ramatEivzurBetihuty(Optional.ofNullable(jsonCar.get("ramat_eivzur_betihuty")).map(JsonNode::asLong).orElse(null))
                .kvutzatZihum(Optional.ofNullable(jsonCar.get("kvutzat_zihum")).map(JsonNode::asLong).orElse(null))
                .shnatYitzur(Optional.ofNullable(jsonCar.get("shnat_yitzur")).map(JsonNode::asLong).orElse(null))
                .degemManoa(Optional.ofNullable(jsonCar.get("degem_manoa")).map(JsonNode::asText).orElse(null))
                .mivchanAcharonDt(Optional.ofNullable(jsonCar.get("mivchan_acharon_dt")).map(JsonNode::asText).orElse(null))
                .tokefDt(Optional.ofNullable(jsonCar.get("tokef_dt")).map(JsonNode::asText).orElse(null))
                .baalut(Optional.ofNullable(jsonCar.get("baalut")).map(JsonNode::asText).orElse(null))
                .misgeret(Optional.ofNullable(jsonCar.get("misgeret")).map(JsonNode::asText).orElse(null))
                .tzevaCd(Optional.ofNullable(jsonCar.get("tzeva_cd")).map(JsonNode::asLong).orElse(null))
                .tzevaRechev(Optional.ofNullable(jsonCar.get("tzeva_rechev")).map(JsonNode::asText).orElse(null))
                .zmigKidmi(Optional.ofNullable(jsonCar.get("zmig_kidmi")).map(JsonNode::asText).orElse(null))
                .zmigAhori(Optional.ofNullable(jsonCar.get("zmig_ahori")).map(JsonNode::asText).orElse(null))
                .sugDelekNm(Optional.ofNullable(jsonCar.get("sug_delek_nm")).map(JsonNode::asText).orElse(null))
                .horaatRishum(Optional.ofNullable(jsonCar.get("horaat_rishum")).map(JsonNode::asLong).orElse(null))
                .moedAliyaLakvish(Optional.ofNullable(jsonCar.get("moed_aliya_lakvish")).map(JsonNode::asText).orElse(null))
                .kinuyMishari(Optional.ofNullable(jsonCar.get("kinuy_mishari")).map(JsonNode::asText).orElse(null))
                .rank(Optional.ofNullable(jsonCar.get("rank")).map(JsonNode::floatValue).orElse(null))
                .build();

        return car;
    }
    // data-gov-il car fields are written in snake_case
    public static String camelToSnakeCase(String fieldName) {
        // Convert camelCase to snake_case
        return fieldName.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase();
    }


}




/*   Car car = Car.builder()
                .id(Optional.ofNullable(jsonCar.get("_id")).map(JsonNode::asInt).orElse(null))
                .misparRechev(Optional.ofNullable(jsonCar.get("mispar_rechev")).map(JsonNode::asLong).orElse(null))
                .tozeretCd(Optional.ofNullable(jsonCar.get("tozeret_cd")).map(JsonNode::asLong).orElse(null))
                .sugDegem(Optional.ofNullable(jsonCar.get("sug_degem")).map(JsonNode::asText).orElse(null))
                .tozeretNm(Optional.ofNullable(jsonCar.get("tozeret_nm")).map(JsonNode::asText).orElse(null))
                .degemCd(Optional.ofNullable(jsonCar.get("degem_cd")).map(JsonNode::asLong).orElse(null))
                .degemNm(Optional.ofNullable(jsonCar.get("degem_nm")).map(JsonNode::asText).orElse(null))
                .ramatGimur(Optional.ofNullable(jsonCar.get("ramat_gimur")).map(JsonNode::asText).orElse(null))
                .ramatEivzurBetihuty(Optional.ofNullable(jsonCar.get("ramat_eivzur_betihuty")).map(JsonNode::asLong).orElse(null))
                .kvutzatZihum(Optional.ofNullable(jsonCar.get("kvutzat_zihum")).map(JsonNode::asLong).orElse(null))
                .shnatYitzur(Optional.ofNullable(jsonCar.get("shnat_yitzur")).map(JsonNode::asLong).orElse(null))
                .degemManoa(Optional.ofNullable(jsonCar.get("degem_manoa")).map(JsonNode::asText).orElse(null))
                .mivchanAcharonDt(Optional.ofNullable(jsonCar.get("mivchan_acharon_dt")).map(JsonNode::asText).orElse(null))
                .tokefDt(Optional.ofNullable(jsonCar.get("tokef_dt")).map(JsonNode::asText).orElse(null))
                .baalut(Optional.ofNullable(jsonCar.get("baalut")).map(JsonNode::asText).orElse(null))
                .misgeret(Optional.ofNullable(jsonCar.get("misgeret")).map(JsonNode::asText).orElse(null))
                .tzevaCd(Optional.ofNullable(jsonCar.get("tzeva_cd")).map(JsonNode::asLong).orElse(null))
                .tzevaRechev(Optional.ofNullable(jsonCar.get("tzeva_rechev")).map(JsonNode::asText).orElse(null))
                .zmigKidmi(Optional.ofNullable(jsonCar.get("zmig_kidmi")).map(JsonNode::asText).orElse(null))
                .zmigAhori(Optional.ofNullable(jsonCar.get("zmig_ahori")).map(JsonNode::asText).orElse(null))
                .sugDelekNm(Optional.ofNullable(jsonCar.get("sug_delek_nm")).map(JsonNode::asText).orElse(null))
                .horaatRishum(Optional.ofNullable(jsonCar.get("horaat_rishum")).map(JsonNode::asLong).orElse(null))
                .moedAliyaLakvish(Optional.ofNullable(jsonCar.get("moed_aliya_lakvish")).map(JsonNode::asText).orElse(null))
                .kinuyMishari(Optional.ofNullable(jsonCar.get("kinuy_mishari")).map(JsonNode::asText).orElse(null))
                .rank(Optional.ofNullable(jsonCar.get("rank")).map(JsonNode::floatValue).orElse(null))
                .build();*/