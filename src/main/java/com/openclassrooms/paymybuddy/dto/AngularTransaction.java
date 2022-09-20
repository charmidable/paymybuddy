package com.openclassrooms.paymybuddy.dto;

import java.math.BigDecimal;

public record AngularTransaction(int payerAccountId, int recipientAccountId, BigDecimal amount, String description){}
