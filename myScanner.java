
import java.io.*;

public class myScanner{

	// argv points to a memory location 
	public static void main(String argv[]) throws IOException{
		
		InputStreamReader myReader;

		if (argv.length > 0){

			myReader = new InputStreamReader(new FileInputStream(argv[0]));
		}else{
			myReader = new InputStreamReader(System.in);
		}


		// creating the token here
		StreamTokenizer token = new StreamTokenizer(myReader);
		token.ordinaryChar('.');
		token.ordinaryChar('-');
		token.ordinaryChar('/');

		// keeping current token wihin the variable <nextToken>

		int next;

		while ((next = token.nextToken()) != token.TT_EOF){

			if (next == token.TT_WORD){
				System.out.println("WORD:   " + token.sval);
				break;
			}else if (next == token.TT_NUMBER){
				System.out.println("NUMBER:  " + token.nval);
				break;
			}else{
				switch ((char) next){
					
					case '"':
						System.out.println("STRING:  " + token.sval);
						break;

					case '\'':	
						System.out.println("CHAR:   " + token.sval);
						break;

					default:
						System.out.println("FUNCT:    " + (char)next);	
				}
			}	
		}
	}
}