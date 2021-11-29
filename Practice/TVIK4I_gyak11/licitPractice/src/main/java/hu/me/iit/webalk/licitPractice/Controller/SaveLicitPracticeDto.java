package hu.me.iit.webalk.licitPractice.Controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SaveLicitPracticeDto {

    @NotNull
    @Min(1)
    private Integer licit;

    @NotNull
    @Min(1)
    private Integer userId;

    public int getLicit() {
        return 0;
    }

    public int getUserId() {
        return 0;
    }
}
