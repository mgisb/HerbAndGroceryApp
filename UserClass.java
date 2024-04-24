public class UserClass {
    private int id;
    private String user;
    private String pass;

    public UserClass(int id, String user, String pass){
        this.id = id;
        this.user = user;
        this.pass = pass;
    }

    public int getUserId(){
        return id;
    }

    public String getUsername(){
        return user;
    }

    public String getUserPass(){
        return pass;
    }

    public void setUserID(int id){
        this.id = id;
    }

    public void setUsername(String user){
        this.user = user;
    }

    public void setUserPass(String pass){
        this.pass = pass;
    }

    public static void main(String[] args) {
        UserClass user1 = new UserClass(1, "john_doe", "password123");
        System.out.println(user1.getUserId());
    }
    
}
