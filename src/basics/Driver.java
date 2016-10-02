
package basics;


public class Driver {
    
    private String name;
    private String sex;
    private int comNumber;
    private String eMail;
    private int expYears;

    public int getComNumber() {
        return comNumber;
    }

    public void setComNumber(int comNumber) {
        this.comNumber = comNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getExpYears() {
        return expYears;
    }

    public void setExpYears(int expYears) {
        this.expYears = expYears;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String toString() {
        return name + ";" + sex + ";" + comNumber + ";" + eMail + ";" + expYears;
    }

    public Driver(String name, String sex, int comNumber, String eMail, int expYears) {
        this.name = name;
        this.sex = sex;
        this.comNumber = comNumber;
        this.eMail = eMail;
        this.expYears = expYears;
    }
    
}
