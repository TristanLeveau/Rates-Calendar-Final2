package pojos;

public class Rate {

    private Integer idrate;
    private double rate;
    private String uniqueRef;
    private String source;
    private String destination;
    private int transferTime;
    private String currency;
    private String vehicleType;
    private String startDate;
    private String endDate;
    private String IATA;


    public Rate(Integer idRate, double rate, String uniqueRef, String source, String destination, int transferTime, String currency, String vehicleType, String startDate, String endDate, String IATA ) {
        this.idrate=idRate;
        this.rate =rate;
        this.currency =currency;
        this.destination=destination;
        this.source=source;
        this.transferTime=transferTime;
        this.vehicleType=vehicleType;
        this.uniqueRef=uniqueRef;
        this.startDate = startDate;
        this.endDate = endDate;
        this.IATA=IATA;
    }

    public Integer getIdrate() {
        return idrate;
    }

    public void setIdrate(Integer idrate) {
        this.idrate = idrate;
    }

    public double getRate() { return rate; }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getUniqueRef() {
        return uniqueRef;
    }

    public void setUniqueRef(String uniqueRef) {
        this.uniqueRef = uniqueRef;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(int transferTime) {
        this.transferTime = transferTime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getStartDate() { return startDate; }

    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }

    public void setEndDate(String endDate) { this.endDate = endDate; }

    public String getIATA() { return IATA; }

    public void setIATA(String IATA) { this.IATA = IATA; }
}
