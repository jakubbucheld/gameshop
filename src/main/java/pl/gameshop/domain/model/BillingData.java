package pl.gameshop.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Locale;

@MappedSuperclass
@Getter @Setter
public abstract class BillingData extends ParentEntity
{
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
}
