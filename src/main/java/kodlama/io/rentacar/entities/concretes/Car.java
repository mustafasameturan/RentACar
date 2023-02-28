package kodlama.io.rentacar.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "cars")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "plate", unique = true)
    private String plate;

    @Column(name = "daily_price")
    private double dailyPrice;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "state")
    private String state;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
