package com.model.entity;




import lombok.Data;

import java.util.Date;

/**
 * @author shadow
 */

@Data
public class Message {
    private String msg;
    private Long id;
    private Date sendTime;

}
