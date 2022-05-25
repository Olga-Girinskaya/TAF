package models;

public class UserBuilder {
    private  String name;
    private  String email;
    private  String psw;

    public static class Builder{
        private  UserBuilder newUser;

        public Builder(){
            newUser =new UserBuilder();
        }

        public  Builder withEmail(String email){
            newUser.email=email;
            return this;
        }

        public  Builder withName(String name){
            newUser.name=name;
            return this;
        }

        public  Builder withPsw(String psw){
            newUser.psw=psw;
            return this;
        }

        public UserBuilder build(){
            return newUser;
        }
    }

    public String getName(){
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPsw() {
        return psw;
    }
}
