package demo.app.rest.model;


import demo.app.dto.MentorDto;
import demo.app.dto.StudentDto;

public class MentorModel {

    private Integer id;
    private String name;
    private String oib;
    private String mobilePhone;
    private String email;

    public MentorModel(Integer id, String name, String oib, String mobilePhone, String email) {
        this.id = id;
        this.name = name;
        this.oib = oib;
        this.mobilePhone = mobilePhone;
        this.email = email;
    }

    public MentorModel(){
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


    public static MentorDto ConvertToDto(MentorModel mentorModel){
        MentorDto dto = new MentorDto();

        dto.setId(mentorModel.getId());
        dto.setName(mentorModel.getName());
        dto.setOib(mentorModel.getOib());
        dto.setMobilePhone(mentorModel.getMobilePhone());
        dto.setEmail(mentorModel.getEmail());

        return dto;
    }


    public static MentorModel convertToEntity(MentorDto mentorDto){
        MentorModel model = new MentorModel();

        model.setId(mentorDto.getId());
        model.setName(mentorDto.getName());
        model.setOib(mentorDto.getOib());
        model.setMobilePhone(mentorDto.getMobilePhone());
        model.setEmail(mentorDto.getEmail());

        return model;
    }

    @Override
    public String toString(){
        return "MentorModel{" +
                "id= " + id +
                ", name= " + name + '\'' +
                ", oib= " + oib + '\'' +
                ", mobilePhone= " + mobilePhone + '\'' +
                ", email= " + email +
                "}";
    }
}
