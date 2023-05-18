package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

import static jakarta.persistence.CascadeType.MERGE;

@Entity
@Table(name = "agency")
@Getter @Setter
@NoArgsConstructor
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Agency_SEQ")
    @SequenceGenerator(name = "Agency_SEQ",sequenceName = "Agency_id_gen",allocationSize = 1)
    private Long id;
    private String name;
    private String country;
    @Column(name = "phone_number")
    private int phoneNumber;

    private String email;
    private String image_Link;

    @ManyToMany(mappedBy = "agencies",cascade = {CascadeType.DETACH, MERGE,CascadeType.REFRESH})
    private List<Customer> customers;

    @OneToMany(mappedBy = "agencies",cascade = {CascadeType.DETACH, MERGE,CascadeType.REFRESH})
    private List<House> house;

    public Agency(String name, String country, int phoneNumber, String email,String image_Link) {
        this.name = name;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.image_Link= image_Link;
    }
}