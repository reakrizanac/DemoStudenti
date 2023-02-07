package demo.app.rest.model;


import demo.app.dto.StudentDto;

public class StudentModel {

    private Integer id;
    private String name;
    private String oib;
    private String mobilePhone;
    private String email;
    private Integer mentorId;

    public StudentModel(Integer id, String name, String oib, String mobilePhone, String email, Integer mentorId) {
        this.id = id;
        this.name = name;
        this.oib = oib;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.mentorId = mentorId;
    }

    public StudentModel(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMentorId() {
        return mentorId;
    }

    public void setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
    }

    public static StudentDto ConvertToDto(StudentModel studentModel){
        StudentDto dto = new StudentDto();

        dto.setId(studentModel.getId());
        dto.setName(studentModel.getName());
        dto.setOib(studentModel.getOib());
        dto.setMobilePhone(studentModel.getMobilePhone());
        dto.setEmail(studentModel.getEmail());
        dto.setMentorId(studentModel.getMentorId());

        return dto;
    }



    @Override
    public String toString(){
        return "StudentModel{" +
                "id= " + id +
                ", name= " + name + '\'' +
                ", oib= " + oib + '\'' +
                ", mobilePhone= " + mobilePhone + '\'' +
                ", email= " + email + '\'' +
                ", mentorId= " + mentorId +
                "}";
    }


}
