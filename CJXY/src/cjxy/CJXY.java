package cjxy;

public class CJXY {
    public static void main(String[] args) {
        FileFactory ff = new FileFactory();     //It should be singleton.
        ff.getFile("deneme.json", "{\"a\":\"b\")");
		Logger.getInstance().logInfoWithTime("deneme info");
    }
}
