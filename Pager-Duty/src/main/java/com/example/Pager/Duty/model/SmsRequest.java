package com.example.Pager.Duty.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsRequest {

    private String phone_number;

    private String message;
}
