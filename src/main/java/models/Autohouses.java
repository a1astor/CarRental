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
@Table(name = "autohouses")
public class Autohouses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "address_id")
    private int address_id;

    @Column(name = "start_work")
    private Date start_work;

    @Column(name = "end_work")
    private Date end_work;
}