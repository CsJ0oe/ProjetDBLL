package tn.dbll.beans;

public class JsonStatus {
    
    public static String success(String obj) {
        return "{ \"status\":\"success\", \"obj\":"+obj+" }";
    }
    
    public static String failed(String msg) {
        return "{ \"status\":\"failed\", \"msg\":\""+msg+"\" }";
    }
    
    public static String error(String msg) {
        return "{ \"status\":\"error\", \"msg\":\""+msg+"\" }";
    }
    
}
