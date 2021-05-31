package models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "drivers")
public class Drivers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driver_id;

    @Column(name = "gender")
    private String gender;

    @Column(name = "start_working_date")
    private Date start_working_date;

    @Column(name = "birth_date")
    private Date birth_date;
}
