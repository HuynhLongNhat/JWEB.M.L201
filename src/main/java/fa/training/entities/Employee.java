package fa.training.entities;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String name;
    private String gender;
    private LocalDate dob;
    private int departmentId;
    private String departmentName; // Thêm thuộc tính này
 // Constructor cũ
    public Employee(String name, String gender, LocalDate dob, int departmentId) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.departmentId = departmentId;
    }

    // Constructor mới nếu cần
    public Employee(String name, String gender, LocalDate dob, int departmentId, String departmentName) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }
    
    public Employee() {
       
    }
    // Getters và Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public int getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
