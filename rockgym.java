public class rockgym {

    public static class RockClimber {
        public String firstName;
        public String lastName;
        public int age;
        public String address;

        public RockClimber(String firstName, String lastName, int age, String address) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.address = address;
        }
    }

    public static void main(String[] args) {

        new RockClimber("Savannah", "Ostrowski-McDonald", 23, "1234 Whatever Lane");
    }
}

