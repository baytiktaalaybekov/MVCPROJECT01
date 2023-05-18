package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.REMOVE;


@Entity
@Table(name = "booking")
@Getter @Setter
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Booking_SEQ")
    @SequenceGenerator(name = "Booking_SEQ",sequenceName = "Booking_id_gen",allocationSize = 1)
    private Long id;

    @Transient
    private Long customer_id;
    @Transient
    private Long house_id;

    @OneToOne(cascade = {CascadeType.DETACH, MERGE,CascadeType.REFRESH})
    private House houses;

    @ManyToOne(cascade = {CascadeType.DETACH, MERGE,CascadeType.REFRESH,REMOVE})
    private Customer customers;

}