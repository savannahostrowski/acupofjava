public class EscapeSequencesComments {
    public static void main( String[] args) {
        System.out.print( "Savannah\tMichelle\nOstrowski-McDonald" );
        // This is a comment in Java, allegedly.
        System.out/*This is also a comment*/.print( "Weird!" );
        System.out.println( "Can I comment in a string?/*Nope*/" );
        System.out.println( "\\\\ \\\\\\ \\\\\\" ); //it takes two to make one
    }
}