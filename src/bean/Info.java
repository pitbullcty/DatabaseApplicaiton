package bean;

public class Info {
    private String name;
    private String hobby;
    private String num;
    private String birthday;
    public Info(){
        name="";
        hobby="";
        num="";
        birthday="";
    }

    public String getBirthday() {
        return birthday;
    }

    public String getHobby() {
        return hobby;
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
