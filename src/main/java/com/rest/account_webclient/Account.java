package com.rest.account_webclient;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Account {

    private Long accountNumber;
    private String accountName;
    private int branch;
    private String ifscCode;
    private boolean isActive;
}
