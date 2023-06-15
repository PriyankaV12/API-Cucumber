package POJO;

public class baseClass extends dataReader{
    public static baseDataGS data;

    static {
        try {
            data = readData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public baseClass() throws Exception {
    }
}
