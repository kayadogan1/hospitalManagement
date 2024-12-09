package com.example.HastaneSistemi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LabResults {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id",nullable = false)
    private Integer ResultId;
    private String result;
    private String notes;
    @OneToOne
    LabTests labTest;

    public int getResultId() {
        return ResultId;
    }

    public void setResultId(int resultId) {
        ResultId = resultId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LabTests getLabTest() {
        return labTest;
    }

    public void setLabTest(LabTests labTest) {
        this.labTest = labTest;
    }
}
