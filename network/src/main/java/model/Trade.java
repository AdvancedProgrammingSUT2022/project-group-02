package model;

public class Trade {
    private User user;
    private String typeOfExport;
    private String typeOfImport;
    private Object exportingObject;
    private Object importingObject;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTypeOfExport() {
        return typeOfExport;
    }

    public void setTypeOfExport(String typeOfExport) {
        this.typeOfExport = typeOfExport;
    }

    public String getTypeOfImport() {
        return typeOfImport;
    }

    public void setTypeOfImport(String typeOfImport) {
        this.typeOfImport = typeOfImport;
    }

    public Object getExportingObject() {
        return exportingObject;
    }

    public void setExportingObject(Object exportingObject) {
        this.exportingObject = exportingObject;
    }

    public Object getImportingObject() {
        return importingObject;
    }

    public void setImportingObject(Object importingObject) {
        this.importingObject = importingObject;
    }
}
