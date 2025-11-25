package com.example.cv_builder;

public class CVData {
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String education;
    private String skills;
    private final String experience;
    private final String projects;
    private final String imagePath;

    public CVData(String fullName, String email, String phone, String address, String education, String skills, String experience, String projects, String imagePath) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.education = education;
        this.skills = skills;
        this.experience = experience;
        this.projects = projects;
        this.imagePath = imagePath;
    }

    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getEducation() { return education; }
    public String getSkills() { return skills; }
    public String getExperience() { return experience; }
    public String getProjects() { return projects; }
    public String getImagePath() { return imagePath; }
}
