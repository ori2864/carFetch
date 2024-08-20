package com.ori.carfetch.Beans;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static com.ori.carfetch.Utils.CarBuilder.camelToSnakeCase;

@Data
@Component
public class CarRequestFilters {
    private Map<String, Object> filters;

    public CarRequestFilters(Car car) {
        this.filters = new HashMap<>();
        populateFilters(car);
    }

    public void populateFilters(Car car) {
        if (car.getId() != null) {
            filters.put("_id", car.getId());
        }
        if (car.getMisparRechev() != null) {
            filters.put("mispar_rechev", car.getMisparRechev());
        }
        if (car.getTozeretCd() != null) {
            filters.put("tozeret_cd", car.getTozeretCd());
        }
        if (car.getSugDegem() != null) {
            filters.put("sug_degem", car.getSugDegem());
        }
        if (car.getTozeretNm() != null) {
            filters.put("tozeret_nm", car.getTozeretNm());
        }
        if (car.getDegemCd() != null) {
            filters.put("degem_cd", car.getDegemCd());
        }
        if (car.getDegemNm() != null) {
            filters.put("degem_nm", car.getDegemNm());
        }
        if (car.getRamatGimur() != null) {
            filters.put("ramat_gimur", car.getRamatGimur());
        }
        if (car.getRamatEivzurBetihuty() != null) {
            filters.put("ramat_eivzur_betihuty", car.getRamatEivzurBetihuty());
        }
        if (car.getKvutzatZihum() != null) {
            filters.put("kvutzat_zihum", car.getKvutzatZihum());
        }
        if (car.getShnatYitzur() != null) {
            filters.put("shnat_yitzur", car.getShnatYitzur());
        }
        if (car.getDegemManoa() != null) {
            filters.put("degem_manoa", car.getDegemManoa());
        }
        if (car.getMivchanAcharonDt() != null) {
            filters.put("mivchan_acharon_dt", car.getMivchanAcharonDt());
        }
        if (car.getTokefDt() != null) {
            filters.put("tokef_dt", car.getTokefDt());
        }
        if (car.getBaalut() != null) {
            filters.put("baalut", car.getBaalut());
        }
        if (car.getMisgeret() != null) {
            filters.put("misgeret", car.getMisgeret());
        }
        if (car.getTzevaCd() != null) {
            filters.put("tzeva_cd", car.getTzevaCd());
        }
        if (car.getTzevaRechev() != null) {
            filters.put("tzeva_rechev", car.getTzevaRechev());
        }
        if (car.getZmigKidmi() != null) {
            filters.put("zmig_kidmi", car.getZmigKidmi());
        }
        if (car.getZmigAhori() != null) {
            filters.put("zmig_ahori", car.getZmigAhori());
        }
        if (car.getSugDelekNm() != null) {
            filters.put("sug_delek_nm", car.getSugDelekNm());
        }
        if (car.getHoraatRishum() != null) {
            filters.put("horaat_rishum", car.getHoraatRishum());
        }
        if (car.getMoedAliyaLakvish() != null) {
            filters.put("moed_aliya_lakvish", car.getMoedAliyaLakvish());
        }
        if (car.getKinuyMishari() != null) {
            filters.put("kinuy_mishari", car.getKinuyMishari());
        }
    }

}
//        if (car.getRank() != null) {
//            filters.put("rank", car.getRank());
//        }

//    public Map<String, Object> convertCarToMap(Car car) {
//        Map<String, Object> carMap = new HashMap<>();
//        for (Field field : Car.class.getDeclaredFields()) {
//            field.setAccessible(true);
//            try {
//                Object value = field.get(car);
//                if (value != null) {
//                    String snakeCaseKey = camelToSnakeCase(field.getName());
//                    carMap.put(snakeCaseKey, value);
//                }
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//        return carMap;
//    }
