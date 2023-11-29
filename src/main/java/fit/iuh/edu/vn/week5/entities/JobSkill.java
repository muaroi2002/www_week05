package fit.iuh.edu.vn.week5.entities;

import fit.iuh.edu.vn.week5.enums.SkillLevel;
import fit.iuh.edu.vn.week5.ids.JobSkillId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "job_skill")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(JobSkillId.class)
public class JobSkill implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
    @Column(name = "skill_level")
    private SkillLevel skillLevel;
    @Column(name = "more_info", length = 1000)
    private String moreInfo;
    @Override
    public String toString() {
        return "JobSkill{" +
                "job=" + job.getId() +
                ", skill=" + skill.getId() +
                ", skillLevel=" + skillLevel +
                ", moreInfo='" + moreInfo + '\'' +
                '}';
    }
}