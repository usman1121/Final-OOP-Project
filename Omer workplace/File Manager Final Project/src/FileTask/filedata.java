package FileTask;

public class filedata {
    private String name;
    private String type;
    private String path;
    private String lastModified;
    private int size;

    filedata(String name, String type, String path, String lastModified, int size){
        this.name = name;
        this.type = type;
        this.path = path;
        this.lastModified = lastModified;
    }
    public String getname(){
        return name;
    }
    public void setname(String name){
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getLastModified() {
        return lastModified;
    }
    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    
}

