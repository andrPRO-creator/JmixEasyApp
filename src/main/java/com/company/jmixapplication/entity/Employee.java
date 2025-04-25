package com.company.jmixapplication.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.JmixProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@JmixEntity
@Table(name = "EMPLOYEE")
@Entity
public class Employee {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;
    @NotNull
    @InstanceName
    @Column(name = "NAME", nullable = false)
    private String firstName;
    @NotNull
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
    @Email(message = "Type a valid email")
    @Column(name = "EMAIL", nullable = false)
    @NotNull
    private String email;
    @JoinColumn(name = "DEPARTMENT_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Department department;

    @NotNull
    @Column(name = "HIRE_DATE", nullable = false)
    private LocalDate hireDate;
    @JmixProperty
    @Transient
    private Long daysWorked;

    public void setDaysWorked(Long daysWorked) {
        this.daysWorked = daysWorked;
    }


    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public Long getDaysWorked() {
        if (hireDate == null) {
            return 0L;
        }
        return ChronoUnit.DAYS.between(hireDate, LocalDate.now());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}