package report;

public class OSUtilis {
    public enum OS {WINDOWS, MAC, LINUX, OTHER}
    public static OS getOS (){
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) return OS.WINDOWS;
        if (os.contains("mac")) return OS.MAC;
        if (os.contains("nux") || os.contains("nix")) return OS.LINUX;
        return OS.OTHER;

    }
}
