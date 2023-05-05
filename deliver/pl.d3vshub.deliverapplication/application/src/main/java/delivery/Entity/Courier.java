package delivery.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "couriers")
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COURIERS_SEQ")
    @SequenceGenerator(name="COURIERS_SEQ", sequenceName = "COURIERS_SEQ", allocationSize = 1)
    private Long id;

    private String name;
    private String email;
    private String phone_number;
    private String vehicle_reg;
    private String vehicle_type;

    public Courier(){
    }

    public Courier(String name, String email, String phone_number, String vehicle_reg, String vehicle_type) {
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.vehicle_reg = vehicle_reg;
        this.vehicle_type = vehicle_type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getVehicle_reg() {
        return vehicle_reg;
    }

    public void setVehicle_reg(String vehicle_reg) {
        this.vehicle_reg = vehicle_reg;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public void setVehicle_type(String vehicle_type) {
        this.vehicle_type = vehicle_type;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", vehicle_reg='" + vehicle_reg + '\'' +
                ", vehicle_type='" + vehicle_type + '\'' +
                '}';
    }
}
