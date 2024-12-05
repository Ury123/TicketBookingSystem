package com.innowise.ticketbookingsystem.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private int row;

    @Column(nullable = false)
    private int number;
}
