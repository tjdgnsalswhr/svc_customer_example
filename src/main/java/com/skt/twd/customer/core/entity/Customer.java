package com.skt.twd.customer.core.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Slf4j
@ToString
@NoArgsConstructor
@Getter
@Setter
@Table(name = "CUSTOMER")
@Entity
public class Customer {
    @Id
    String id;          //고객id
    String password;    //비밀번호
    String name;        //고객이름
    String svcNum;      //회선번호
    String authLevel;   //권한레벨
    Date regDate;       //등록일자
    Date updDate;       //수정일자
    String regId;       //등록자
    String updId;       //수정자

    @Builder
    public Customer(String customerId, String name, String svcNum, String authLevel, String regId){
        this.id = customerId;
        this.name = name;
        this.svcNum = svcNum;
        this.authLevel = authLevel;
        this.regDate = new Date();
        this.updDate = new Date();
        this.regId = regId;
        this.updId = regId;
    }
}
