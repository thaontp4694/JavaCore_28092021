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

        Excercise_JavaIO example = new Excercise_JavaIO();
        example.listChild(workdir, 0);
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

    private void listChild(File file, int level) {

        if (file.isDirectory()) {
            System.out.println(getPadding(level) + " - " + file.getName());
            File[] children = file.listFiles();
            for (File child : children) {
                this.listChild(child, level + 1);
            }
        } else {
            System.out.println(getPadding(level) + " + " + file.getName());
        }

    }

    private String getPadding(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= level; i++) {
            sb.append("    ");
        }
        return sb.toString();
    }
}