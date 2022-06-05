
package Modelo;

public class Usuario {
    
    private String user;
    private String password;
    private int id;
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
