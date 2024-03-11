package sem5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CopyFiles {
    public static void main(String[] args) {

        try {
            copyFiles(new File("C:\\Users\\user\\IdeaProjects\\java_core\\src\\sem5\\lesson5"), "C:\\Users\\user\\IdeaProjects\\java_core\\src");
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    static void copyFiles(File whatCopy, String whereCopy) throws IOException {

        File backup = new File(whereCopy + "\\backup");
        //if (backup.mkdir()) {
            File[] files = whatCopy.listFiles();
            for (int i = 0; i < files.length; i++) {
                Files.copy(files[i].toPath(),backup.toPath(), StandardCopyOption.REPLACE_EXISTING);
                //files[i] = new File(backup.getPath() + files[i].getName() + ".txt");

            }
        //}

    }

}

