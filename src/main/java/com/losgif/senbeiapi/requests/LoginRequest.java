package com.losgif.senbeiapi.requests;

import lombok.Data;
import lombok.NonNull;

@Data
public class LoginRequest {
    @NonNull
    public String email;
    @NonNull
    public String password;
}
