package pkg;
import java.util.*;
import java.io.*;

public class Topic extends Message {
	private String subject;
	// Default Constructor
	public Topic() {
		super();
	}

	// Parameterized constructor
	public Topic(String auth, String subj, String bod, int i) {
		super(auth,subj,bod,i);
		subject = subj;
	}

	// Returns if it's a reply (false)
	public boolean isReply(){
		return false;
	}
}
