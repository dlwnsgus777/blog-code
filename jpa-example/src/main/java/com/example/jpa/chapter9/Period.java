package com.example.jpa.chapter9;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Period {

    @Temporal(TemporalType.DATE)
    Date startDate;

    @Temporal(TemporalType.DATE)
    Date endDate;

    public boolean isWork(Date date) {
        // ....
    }
}
