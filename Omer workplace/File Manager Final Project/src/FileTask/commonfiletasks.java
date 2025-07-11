package FileTask;

import java.io.File;
/**
 So what I do here is to cheak if the file is exits if so re
 */
public abstract class commonfiletasks implements FileAction {
    public boolean checkIfFileExists(String path){
        File file = new File(path);
        return file.exists();
    }
    public File getFileObject(String path){
        return new File(path);
    }
}
