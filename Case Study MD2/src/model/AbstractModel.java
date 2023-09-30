package model;

public class AbstractModel {
    private int id;
    private String name;
    private String chgWho;
    private String chgDate;
    private int status;

    public AbstractModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChgWho() {
        return chgWho;
    }

    public void setChgWho(String chgWho) {
        this.chgWho = chgWho;
    }

    public String getChgDate() {
        return chgDate;
    }

    public void setChgDate(String chgDate) {
        this.chgDate = chgDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
