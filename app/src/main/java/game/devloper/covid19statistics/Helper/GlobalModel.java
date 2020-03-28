package game.devloper.covid19statistics.Helper;

import com.google.gson.annotations.SerializedName;

public class GlobalModel {

    @SerializedName("active_cases")
    private String active_cases;

    @SerializedName("critical_cases")
    private String critical_cases;

    @SerializedName("new_cases")
    private String new_cases;

    @SerializedName("new_deaths")
    private String new_deaths;

    @SerializedName("per_mln")
    private String per_mln;

    @SerializedName("total_cases")
    private String total_cases;

    @SerializedName("total_deaths")
    private String total_deaths;

    @SerializedName("total_recovered")
    private String total_recovered;

    public String getActive_cases() {
        return active_cases;
    }

    public void setActive_cases(String active_cases) {
        this.active_cases = active_cases;
    }

    public String getCritical_cases() {
        return critical_cases;
    }

    public void setCritical_cases(String critical_cases) {
        this.critical_cases = critical_cases;
    }

    public String getNew_cases() {
        return new_cases;
    }

    public void setNew_cases(String new_cases) {
        this.new_cases = new_cases;
    }

    public String getNew_deaths() {
        return new_deaths;
    }

    public void setNew_deaths(String new_deaths) {
        this.new_deaths = new_deaths;
    }

    public String getPer_mln() {
        return per_mln;
    }

    public void setPer_mln(String per_mln) {
        this.per_mln = per_mln;
    }

    public String getTotal_cases() {
        return total_cases;
    }

    public void setTotal_cases(String total_cases) {
        this.total_cases = total_cases;
    }

    public String getTotal_deaths() {
        return total_deaths;
    }

    public void setTotal_deaths(String total_deaths) {
        this.total_deaths = total_deaths;
    }

    public String getTotal_recovered() {
        return total_recovered;
    }

    public void setTotal_recovered(String total_recovered) {
        this.total_recovered = total_recovered;
    }
}
