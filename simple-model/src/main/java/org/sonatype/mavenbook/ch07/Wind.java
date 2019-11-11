package org.sonatype.mavenbook.ch07;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@Entity
public class Wind {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String chill;
    private String direction;
    private String speed;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="weather_id", nullable=false)
    private Weather weather;
}