package com.spirituspoland.friendlylib.model;


import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class RentalCard {
    @Id
    private UUID id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;
    private LocalDateTime rentalDate;
    private int penaltyNumber;
    private int renewalNumber;
    private boolean canRenew;
    private LocalDateTime estimatedReturn;
    private RentalCardStatus status;
    private LocalDateTime returnDate;
}
