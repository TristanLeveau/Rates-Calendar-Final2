package pojos;

public enum Currency {

    AUD("Australian Dollar"),
    USD("American Dollar"),
    GBP("Great-Britain Pound"),
    EUR("Euro");

    private String label;

    Currency(String label){
        this.label=label;
    }

    public String getLabel(){
        return label;
    }
}
