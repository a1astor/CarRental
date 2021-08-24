package com.pac.model.utilsclass;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RentDTO {
    @NotNull
    private long carId;
    @NotNull
    private String startDate;
    @NotNull
    private String endDate;
    @NotNull
    private Long userId;
}
