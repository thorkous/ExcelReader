package com.example.rishibhaiya.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "exceltable")
public class Excel {


    @Id
    @Column
    private String uuid;

    @Column
    private String ticker;
    @Column
    private Date date;
    @Column
    private String time;
    @Column
    private String open;
    @Column
    private String high;
    @Column
    private String low;
    @Column
    private String close;
    @Column
    private String volume;
    @Column(name = "open_interest")
    private String openInterest;

}
