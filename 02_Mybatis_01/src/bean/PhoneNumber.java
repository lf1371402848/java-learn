package bean;

public class PhoneNumber {
    private String countyCode;
    private String stateCode;
    private String number;

    public PhoneNumber(String str) {
        String[] sp = str.split("-");
        if(sp.length==3){
            this.countyCode=sp[0];
            this.stateCode=sp[1];
            this.number=sp[2];
        }

    }

    public String getAsString(){
        return this.countyCode+"-"+this.stateCode+"-"+this.number;
    }


    public PhoneNumber() {
        // TODO Auto-generated constructor stub
    }


    public PhoneNumber(String countyCode, String stateCode, String number) {
        super();
        this.countyCode = countyCode;
        this.stateCode = stateCode;
        this.number = number;
    }


    public String getCountyCode() {
        return countyCode;
    }
    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }
    public String getStateCode() {
        return stateCode;
    }
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

}
