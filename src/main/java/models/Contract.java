package models;

import lombok.Data;
import models.utilsclass.CustomGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "contract")
public class Contract {

    //TODO correct custom generator path
    @Id
    @GeneratedValue(generator = "cnt-generator")
    @GenericGenerator(name = "cnt-generator", parameters = @Parameter(name = "prefix", value = "cnt"),strategy = "CustomGenerator")
    private String id;

    @Column(name = "car_id")
    private int car_id;

    @Column(name = "client_id")
    private int client_id;

    @Column(name = "date_start")
    private Date date_start;

    @Column(name = "date_end")
    private Date date_end;

    @Column(name = "auto_house_id")
    private int auto_house_id;

    @Column(name = "driver_id")
    private int driver_id;

    @Column(name = "is_active")
    private boolean is_active;

    @Column(name = "promotion_id")
    private int promotion_id;

    @Column(name = "price_id")
    private int price_id;

}
