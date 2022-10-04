package com.openclassrooms.paymybuddy.dto;

public record AngularTransaction(int payerAccountId, int recipientAccountId, float amount, String description){}
