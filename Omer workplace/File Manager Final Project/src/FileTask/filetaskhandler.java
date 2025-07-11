import FileTask.FileAction;
import com.sun.source.tree.TryTree;
import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class filetaskhandler implements FileAction {
    
    private Logger logger;//i used logger bc it better for real-world project

    public filetaskhandler(Logger logger){
        this.logger = logger;
    }
    private void logActivity(String action, String filePath, String status, String errorMessage){
        String fullMessage = action + " " + filePath + "-" + status;
        if (errorMessage != null &&!errorMessage.isEmpty()){
            fullMessage += " (" + errorMessage + ")";
        }
        logger.logActivity(new LogEntry(new Date(), fullMessage, filePath, status));
    }
    @Override
    public void create(String parentPath, String name, boolean isDirectory) throws IOException{
        Path newPath = Path.get(parentPath, name);
        String fullPath = newPath.toString();
        String actionType = isDirectory ? "CREATE_DIRECTORY" : "CREATE_FILE";
        
        try {
            if (Files.exists(newPath)){
                String errorMsg = "Path alrady exists.";
                logActivity(actionType, fullPath, "FAILED", errorMsg);
                throw new IOException(errorMsg);
            }

            if (isDirectory){
                File.createDirectories(newPath);
            }else {
                File.createFile(newPath);
            }
            System.out.println("Successfully" + (IsDirectory ? "created directory" : "create file") + ": " + fullPath);
            lodActivity(actionType, fullPath, "SUCCESS", null);
        } catch (IOException e) {
            String errorMsg = "Error creating" + (isDirectory ? "directory" : "file") + "at" + fullPath + ": " + e.getMessage();
            System.err.println(errorMsg);
            logActivity(actionType, fullPath, "FAILED", e.getMessage()); 
            throw e;
        }
    }
    @Override
    public void delete(String path, String name) throws IOException{
        Path targePath = Paths.get(path);
        String actionType = "DELETE";
        
        try {
            if(!Files.exists(targePath)){
                String errorMsg = "Path doesn't exist: " + path;
                logActivity(actionType, path, "FAILED", errorMsg);
                throw new IOException(errorMsg);
            }
            if (!Files.isWritable(targePath)){
                String errorMsg = "No write permissions for: " + path;
                logActivity(actionType, path, "FAILED", errorMsg);
                throw new IOException(errorMsg);
            }

            Files.delete(targePath);
            System.out.println("Successfully deleted: " + path);
            logActivity(actionType, path, "SUCCESS", null);
        } catch (IOException e) {
            String errorMsg = "Error deleting " + path + ": " + e.getMessage();
            System.err.println(errorMsg);
            logActivity(actionType, path, "FAILED", e.getMessage());
            throw e;
        }
    }
    @Override
    public void rename(String oldPath, String newPath) throws IOException{
        Path oldFilePath = Paths.get(oldPath);
        Path newFilePath = Path.get(newPath);
        String actionType = "RENAME";

        try {
            if (!File )
        } catch ( e) {
        }
    }
}
