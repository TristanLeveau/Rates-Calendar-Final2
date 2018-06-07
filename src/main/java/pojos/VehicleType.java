package pojos;

public enum VehicleType {
    ST("Shuttle Transfer"),
    EPT("Economy Private Transfer"),
    EM("Economy Minivan");
    private String label;

    VehicleType(String label){
        this.label=label;
    }

    public String getLabel(){
        return label;
    }
}
