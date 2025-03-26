package vidmot;
/**
 * @author María Björk Gunnarsdóttir (mbg13@hi.is)
 */

public enum View {
    VELKOMIN("velkomin-view.fxml"),
    SPURNINGAR("spurningar-view.fxml"),
    KVEDJA("kvedja-view.fxml");

    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Nær í nafn á skrá
     * @return nafn á skrá
     */
    public String getFileName() {
        return fileName;
    }
}
