import java.io.File;

public class Excercise_JavaIO {
    public static void main(String[] args) {
        String workdirPath = System.getProperty("user.dir");
        System.out.printf("Workdir: %s\n", workdirPath);

        File workdir = new File(workdirPath);
        String[] list = workdir.list();
        for (String str : list) {
            System.out.println(str);
        }

        File[] listFiles = workdir.listFiles();
        for (File file : listFiles) {
            System.out.print(file.getPath());
            System.out.print(" > ");
            System.out.println(file.isDirectory() ? "Folder" : "File");
        }
    }

    private static void listFilesinDirectory(File dir) {
        File[] listFiles = dir.listFiles();
        for (File file : listFiles) {
            if (file.isFile()) {
                if (file.getName().compareTo(".DS_Store") != 0)
                    System.out.println(file.getName());
            } else listFilesinDirectory(file);
        }
    }
}