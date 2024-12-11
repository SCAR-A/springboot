package com.example.springboot.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author:
 * @Date:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoDto implements Serializable {

    private String key = "Hello World";

}
