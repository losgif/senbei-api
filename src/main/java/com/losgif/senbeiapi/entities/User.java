package com.losgif.senbeiapi.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Data
public class User {
    @TableId
    private Long id;
    @Nullable
    private String nickname;
    @NonNull
    private String email;
    @NonNull
    private String password;
}
