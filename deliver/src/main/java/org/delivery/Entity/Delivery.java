package org.delivery.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @Column(name = "status", length = 50, nullable = false)
    private String status;

    @Column(name = "estimated_delivery_time", nullable = false)
    private LocalDateTime estimatedDeliveryTime;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public Delivery(){
    }

    public Delivery(Courier courier, String status, LocalDateTime estimatedDeliveryTime) {
        this.courier = courier;
        this.status = status;
        this.estimatedDeliveryTime = estimatedDeliveryTime;
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(LocalDateTime estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // toString method

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", courier=" + courier +
                ", status='" + status + '\'' +
                ", estimatedDeliveryTime=" + estimatedDeliveryTime +
                ", createdAt=" + createdAt +
                '}';
    }
}
