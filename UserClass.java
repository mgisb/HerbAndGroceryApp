public class UserClass {
    private int id;
    private String user;
    private String pass;
    private String address;
    private String email;

    public UserClass(int id, String user, String pass, String address, String email){
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.address = address;
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

    public String getUserAddress(){
        return address;
    }

    public String getEmail(){
        return email;
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

    public void setUserAddress(String address){
        this.address = address;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public static void main(String[] args) {
        UserClass user1 = new UserClass(231, "johnny", "password","220 Arch Dr. Arlington Heights, IL 60004", "johnny@gmail.com");
        System.out.println("UserID: "+user1.getUserId()+"\n"+ "Username: "+user1.getUsername()+"\n"+"Password: "+user1.getUserPass()+"\n"+"Address: "+user1.getUserAddress());
    }
    
}
