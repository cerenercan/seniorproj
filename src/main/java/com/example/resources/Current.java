package com.example.resources;

import lombok.*;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Current {


    private Double temp_c;
    private Condition condition;

}
