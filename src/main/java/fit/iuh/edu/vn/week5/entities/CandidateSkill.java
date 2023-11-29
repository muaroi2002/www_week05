package fit.iuh.edu.vn.week5.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fit.iuh.edu.vn.week5.enums.SkillLevel;
import fit.iuh.edu.vn.week5.ids.CandidateSkillId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidate_skill")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CandidateSkillId.class)
public class CandidateSkill {
    @Id
    @ManyToOne
    @JoinColumn(name = "can_id")
    @JsonIgnore
    private Candidate candidate;
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
        return "CandidateSkill{" +
                "candidate=" + candidate.getId() +
                ", skill=" + skill.getId() +
                ", skillLevel=" + skillLevel +
                ", moreInfo='" + moreInfo + '\'' +
                '}';
    }
}