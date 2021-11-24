package com.example.licit.Controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SaveLicitDto {

    @NotNull
    @Min(1)
    private Integer licit;

    @NotNull
    @Min(1)
    private Integer userid;

    public int getLicit() {
        return 0;
    }

    public int getUserId() {
        return 0;
    }
}
