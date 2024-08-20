package com.ori.carfetch.Beans;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Data
@Component
public class ApiRequest {
    private String resource_id;
    private Map<String, Object> filters;
    private String q;
    private boolean distinct;
    private boolean plain;
    private int limit;
    private int offset;
    private String[] fields;
    private String sort;
    private boolean include_total;
    private String records_format;

    // Constructor with default settings
    public ApiRequest() {
        this.resource_id = "053cea08-09bc-40ec-8f7a-156f0677aff3";
        this.filters = new HashMap<>();
        this.q = "";
        this.distinct = true;
        this.plain = true;
        this.limit = 10;
        this.offset = 0;
        this.fields = new String[]{};
        this.sort = "";
        this.include_total = true;
        this.records_format = "objects";
    }
    // Function to convert filters to a query string -
    // data-gov-il receives strings for "q" fields as queries with car fields filters
    public void setQueryFromFilters(CarRequestFilters filters) {
        StringBuilder queryBuilder = new StringBuilder();
        filters.getFilters().forEach((key, value) -> {
            if (value != null) {
                if (queryBuilder.length() > 0) {
                    queryBuilder.append(" , ");
                }
//                queryBuilder.append("\"").append(key).append("\":\"");
                queryBuilder.append(value.toString());
            }
        });
        this.q = queryBuilder.toString();
    }
    public void setFilters(CarRequestFilters carRequestFilters){
        this.filters=carRequestFilters.getFilters();
    }







}