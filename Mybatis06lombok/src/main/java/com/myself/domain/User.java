package com.myself.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/*
    使用lambok简化操作(不推荐)
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{

    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

}
