package com.pac.model.utilsclass;

import java.util.Date;

import lombok.Data;

@Data
public class RentDTO {
    private long carId;
    private Date startDate;
    private Date endDate;
}
