package FileTask;

import java.io.IOException;

public interface FileAction {
    void create(String parent, String name, boolean isDirectory) throws IOException ;
    void delete(String path, String name)throws IOException;
    void rename(String oldPath, String newPath)throws IOException;
    void move(String source, String destinationPath)throws IOException;
    void listContents(String directoryPath)throws IOException;
    void search(String DirectoryPath, String filename)throws IOException;

}
