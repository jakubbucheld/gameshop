package pl.gameshop.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Locale;

@Entity
@Table(name = "billing_datas")

@Getter @Setter @ToString(callSuper = true, exclude =
        {"user", "phoneNumber", "addressFirstLine",
        "addressSecondLine", "houseNumber", "flatNumber",
        "city","postalCode", "isoCountryCode"})
public class BillingData extends ParentEntity
{
    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String addressFirstLine;

    @Column
    private String addressSecondLine;

    @Column(nullable = false)
    private String houseNumber;

    @Column
    private String flatNumber;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private Locale.IsoCountryCode isoCountryCode;

    @ManyToOne
    private User user;
}
