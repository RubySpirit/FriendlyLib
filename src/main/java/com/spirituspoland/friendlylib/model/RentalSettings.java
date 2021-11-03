package com.spirituspoland.friendlylib.model;

import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RentalSettings {
    @Id
    private Long  id;
    private int maxRentalDays;
    private BigDecimal delayPenalty;
    private int maxRentalRenewals;
}
