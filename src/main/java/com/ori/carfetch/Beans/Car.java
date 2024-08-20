package com.ori.carfetch.Beans;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Entity
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Component
public class Car /*implements Serializable*/ {
    @Id
    private Long misparRechev;
    private Integer id;
    private Long tozeretCd;
    private String sugDegem;
    private String tozeretNm;
    private Long degemCd;
    private String degemNm;
    private String ramatGimur;
    private Long ramatEivzurBetihuty;
    private Long kvutzatZihum;
    private Long shnatYitzur;
    private String degemManoa;
    private String mivchanAcharonDt;
    private String tokefDt;
    private String baalut;
    private String misgeret;
    private Long tzevaCd;
    private String tzevaRechev;
    private String zmigKidmi;
    private String zmigAhori;
    private String sugDelekNm;
    private Long horaatRishum;
    private String moedAliyaLakvish;
    private String kinuyMishari;
    @Column(name = "carRank")
    private Float rank;
}