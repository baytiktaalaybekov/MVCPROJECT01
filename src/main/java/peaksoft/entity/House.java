package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.HouseType;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.REMOVE;

@Entity
@Table(name = "house")
@Getter @Setter
@NoArgsConstructor
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "House_SEQ")
    @SequenceGenerator(name = "House_SEQ",sequenceName = "House_id_gen",allocationSize = 1)
    private Long id;
    @Enumerated(EnumType.STRING)
    private HouseType houseType;
    private String address;
    private int price;
    private int room;
    private String country;
    private String description;
    private Boolean is_Booked;

    @OneToOne(mappedBy = "houses",cascade = {CascadeType.DETACH, MERGE,CascadeType.REFRESH})
    private Booking bookings;

    @ManyToOne(cascade = {CascadeType.DETACH, MERGE,CascadeType.REFRESH,REMOVE})
    private Agency agencies;

    public House(HouseType houseType, String address, int price, int room, String country, String description, Boolean is_Booked) {
        this.houseType = houseType;
        this.address = address;
        this.price = price;
        this.room = room;
        this.country = country;
        this.description = description;
        this.is_Booked = is_Booked;
    }
}