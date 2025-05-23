package com.company.homeworkhotel.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "ROOM")
@Entity
public class Room {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Max(999)
    @Min(100)
    @InstanceName
    @NotNull
    @Column(name = "NUMBER_", nullable = false)
    private Integer number;

    @Max(9)
    @Min(1)
    @Column(name = "FLOOR_")
    private Integer floor;

    @Positive
    @Column(name = "SQUARE_METERS")
    private Integer squareMeters;

    @NotNull
    @Column(name = "SLEEPING_PLACES", nullable = false)
    private Integer sleepingPlaces;

    @Column(name = "SAFE_DEPOSIT")
    private Boolean safeDeposit;

    @Column(name = "NICE_VIEW_FROM_WINDOW")
    private Boolean niceViewFromWindow;

    @Column(name = "QUIET")
    private Boolean quiet;

    @Column(name = "MINIBAR")
    private Boolean minibar;

    @Column(name = "AIR_CONDITIONER")
    private Boolean airConditioner;
    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;
    @CreatedDate
    @Column(name = "CREATED_DATE")
    private OffsetDateTime createdDate;
    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;
    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    private OffsetDateTime lastModifiedDate;

    public OffsetDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(OffsetDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Boolean getAirConditioner() {
        return airConditioner;
    }

    public void setAirConditioner(Boolean airConditioner) {
        this.airConditioner = airConditioner;
    }

    public Boolean getMinibar() {
        return minibar;
    }

    public void setMinibar(Boolean minibar) {
        this.minibar = minibar;
    }

    public Boolean getQuiet() {
        return quiet;
    }

    public void setQuiet(Boolean quiet) {
        this.quiet = quiet;
    }

    public Boolean getNiceViewFromWindow() {
        return niceViewFromWindow;
    }

    public void setNiceViewFromWindow(Boolean niceViewFromWindow) {
        this.niceViewFromWindow = niceViewFromWindow;
    }

    public Boolean getSafeDeposit() {
        return safeDeposit;
    }

    public void setSafeDeposit(Boolean safeDeposit) {
        this.safeDeposit = safeDeposit;
    }

    public Integer getSleepingPlaces() {
        return sleepingPlaces;
    }

    public void setSleepingPlaces(Integer sleepingPlaces) {
        this.sleepingPlaces = sleepingPlaces;
    }

    public Integer getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(Integer squareMeters) {
        this.squareMeters = squareMeters;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}