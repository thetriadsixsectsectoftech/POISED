
public class PoisedPersonClass {
        private String name;
        long telenum;
        String email;
        String address;
        // CLASS ATTRIBUTES





        public PoisedPersonClass(String name,long telenum,String email, String address){
                this.name = name;
                this.telenum = telenum;
                this.email = email;
                this.address = address;

        } // CONSTRUCTOR FOR PEOPLE OBJECT

        public String toString(){
                String output =name+": ";output +=telenum+": ";output +=email+": ";output +=address;


                return output;
        }

        //////////////////VARIOUS GETTERS AND SETTERS USED IN THE MAIN///////////////////////////
        public void setName(String name) {this.name = name;}

        public void setTelenum(long telenum) {this.telenum = telenum;}

        public void setAddress(String address) {this.address = address;}

        public void setEmail(String email) {this.email = email;}

        //////////////////VARIOUS GETTERS AND SETTERS USED IN THE MAIN///////////////////////////


}
