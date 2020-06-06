package pl.gameshop.domain.model;

import javax.persistence.Column;

public class PersonalBillingData extends BillingData
{
    @Column
    private String firstName;

    @Column
    private String lastName;

}
