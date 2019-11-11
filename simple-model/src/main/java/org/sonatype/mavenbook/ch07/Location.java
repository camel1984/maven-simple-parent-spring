package org.sonatype.mavenbook.ch07;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Data
@NoArgsConstructor
@Entity
@NamedQueries({
	@NamedQuery(name="Location.uniqueByWoeid", query="from Location l where l.woeid = :woeid")
})
public class Location {
    
    @Id
    private String woeid;

    private String city;
    private String region;
    private String country;
}