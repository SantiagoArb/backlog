package co.com.poli.backlog.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class ProjectTask {
    private Long id;
    private String name;
    private String summary;
    private String acceptanceCriteria;
    private String status;
    private int priority;
    private double hours;
    private Date startDate;
    private Date endDate;
    private String projectIdentifier;
}
