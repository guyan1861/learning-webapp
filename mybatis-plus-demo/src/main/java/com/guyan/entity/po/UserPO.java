package com.guyan.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@TableName("user")
public class UserPO {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
