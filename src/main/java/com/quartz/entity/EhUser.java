package com.quartz.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (EhUser)实体类
 *
 * @author makejava
 * @since 2020-02-13 18:52:13
 */
@Data
public class EhUser implements Serializable {
    private static final long serialVersionUID = 599572162386215593L;
    
    private String id;
    
    private String username;
    
    private String pwd;


}