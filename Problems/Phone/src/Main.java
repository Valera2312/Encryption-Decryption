class Phone {

    String ownerName;
    String countryCode;
    String cityCode;
    String number;

    public Phone(String ownerName, String number){
        this.ownerName = ownerName;
        this.number = number;
    }
    public Phone(String countryCode, String cityCode, String ownerName ,String number){
        this.countryCode = countryCode;
        this.cityCode = cityCode;
        this.number = number;
        this.ownerName = ownerName;
    }
}