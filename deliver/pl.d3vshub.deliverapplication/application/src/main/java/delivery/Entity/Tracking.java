package delivery.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Tracking")
public class Tracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @Column(name = "status", length = 50, nullable = false)
    private String status;

    @Column(name = "location", length = 255, nullable = false)
    private String location;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

  public Tracking(){
  }

    public Tracking(Delivery delivery, String status, String location, LocalDateTime updatedAt) {
        this.delivery = delivery;
        this.status = status;
        this.location = location;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Tracking{" +
                "id=" + id +
                ", delivery=" + delivery +
                ", status='" + status + '\'' +
                ", location='" + location + '\'' +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

