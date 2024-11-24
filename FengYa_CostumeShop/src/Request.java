public class Request {
    private String briefIntroduction;
    private int status;
    private int SNumber;
    private int newOrReadOrSettled = 1;
    public Request(String briefIntroduction, int status, int SNumber) {
        setBriefIntroduction(briefIntroduction);
        setStatus(status);
        setSNumber(SNumber);

    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSNumber() {
        return SNumber;
    }

    public void setSNumber(int SNumber) {
        this.SNumber = SNumber;
    }

    public int getNewOrReadOrSettled() {
        return newOrReadOrSettled;
    }

    public void setNewOrReadOrSettled(int newOrReadOrSettled) {
        this.newOrReadOrSettled = newOrReadOrSettled;
    }
}
