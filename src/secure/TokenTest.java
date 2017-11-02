package secure;

import java.util.UUID;

public class TokenTest {

	public static void main(String[] args) {
		UUID csrfToken= UUID.randomUUID();
		System.out.println(csrfToken);
	}
}
