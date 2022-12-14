package pkg;
import java.util.*;
import java.io.*;

public class BBoard {		// This is your main file that connects all classes.
	// Think about what your global variables need to be.
	private String name;
	private String user;
	private String pascde;
	private Scanner sc;
	private ArrayList<User> ids;
//	private ArrayList<Topic> log;
//	private ArrayList<Reply> log2;
	private ArrayList<Message> log;
	private User drones;
	private Message hello;
//	private Topic hello;
//	private Reply hello2;
	private int activater;
	private int replyId;

	// Default constructor that creates a board with a defaulttitle, empty user and message lists,
	// and no current user
	public BBoard() {
		name = "Welcome to the board";
		System.out.println(name);
		ids = new ArrayList<User>();
		log = new ArrayList<Message>();
//		log = new ArrayList<Topic>();
//		log2 = new ArrayList<Reply>();
		user = "";
		pascde = "";
		drones = new User("", "");
		activater = 0;
		hello = new Message();
		replyId = 0;
//		hello = new Topic();
//		hello2 = new Reply();
	}

	// Same as the default constructor except it sets the title of the board
	public BBoard(String ttl) {	
		name = ttl;
		System.out.println(name);
		ids = new ArrayList<User>();
		log = new ArrayList<Message>();
//		log = new ArrayList<Topic>();
//		log2 = new ArrayList<Reply>();
		user = "";
		pascde = "";
		drones = new User("", "");
		activater = 0;
		hello = new Message();
		replyId = 0;
//		hello = new Topic();
//		hello2 = new Reply();
	}

	// Gets a filename of a file that stores the user info in a given format (users.txt)
	// Opens and reads the file of all authorized users and passwords
	// Constructs a User object from each name/password pair, and populates the userList ArrayList.
	public void loadUsers(String inputFile) throws FileNotFoundException {
		File users = new File(inputFile);
		Scanner fileReader = new Scanner(users);
		while(fileReader.hasNextLine())
		{
			String line = fileReader.nextLine();
			int space = line.indexOf(" ");
			String username = line.substring(0, space);
			String password = line.substring(space+1);
		//	System.out.println(password);
			drones = new User(username, password);
		//	System.out.println(drones.getUsername());
			ids.add(drones);
		}
	}

	// Asks for and validates a user/password. 
	// This function asks for a username and a password, then checks the userList ArrayList for a matching User.
	// If a match is found, it sets currentUser to the identified User from the list
	// If not, it will keep asking until a match is found or the user types 'q' or 'Q' as username to quit
	// When the users chooses to quit, sayu "Bye!" and return from the login function
	public void login(){
		System.out.print("Enter username ( 'Q' or 'q' to quit):");
		sc = new Scanner(System.in);
		user = sc.nextLine();
		if(user.equals("Q")||user.equals("q"))
		{
			System.exit(0);
		}
		System.out.print("Enter password:");
		pascde = sc.nextLine();
//		for(int cntr = 0; cntr < ids.size(); cntr++)
//		{
//			System.out.println(ids.get(cntr).getUsername());
//		}
		
		for(int cntr = 0; cntr < ids.size(); cntr++)
		{
			if(ids.get(cntr).check(user, pascde))
			{
				break;
			}
			if(cntr == ids.size()-1)
			{
				login();
			}
		}
	}
	// Contains main loop of Bulletin Board
	// IF and ONLY IF there is a valid currentUser, enter main loop, displaying menu items
	// --- Display Messages ('D' or 'd')
	// --- Add New Topic ('N' or 'n')
	// --- Add Reply ('R' or 'r')
	// --- Change Password ('P' or 'p')
	// --- Quit ('Q' or 'q')
	// With any wrong input, user is asked to try again
	// Q/q should reset the currentUser to 0 and then end return
	// Note: if login() did not set a valid currentUser, function must immediately return without showing menu
	public void run(){
		login();
		sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("");
			System.out.println("--- Display Messages ('D' or 'd')" + "\n" + "--- Add New Topic ('N' or 'n')" + "\n" + "--- Add Reply ('R' or 'r')" + "\n" + "--- Change Password ('P' or 'p')" + "\n" + "--- Quit ('Q' or 'q'))");
			String command = sc.nextLine();
			if(command.equals("D")||command.equals("d"))
			{
				System.out.println("");
				display();
			}
			else
			if(command.equals("N")||command.equals("n"))
			{
				System.out.println("");
				addTopic();
			}
			else
			if(command.equals("R")||command.equals("r"))
			{
				System.out.println("");
				addReply();
			}
			else
			if(command.equals("P")||command.equals("p"))
			{
				System.out.println("");
				setPassword();
			}
			else
			if(command.equals("Q")||command.equals("q"))
			{
				break;
			}
			
		}
	}

	// Traverse the BBoard's message list, and invote the print function on Topic objects ONLY
	// It will then be the responsibility of the Topic object to invoke the print function recursively on its own replies
	// The BBoard display function will ignore all reply objects in its message list
	private void display(){
		if(activater == 0)
		{
			System.out.println("nothing to display");
		}
		else
		for(int cntr = 0; cntr < log.size(); cntr++)
		{
			if(log.get(cntr).isReply())
			{
				log.get(cntr-1).addChild(log.get(cntr));
			}
			else
			{
				log.get(cntr).print(0);
			}
		}
	}


	// This function asks the user to create a new Topic (i.e. the first message of a new discussion "thread")
	// Every Topic includes a subject (single line), and body (single line)

	/* 
	Subject: "Thanks"
	Body: "I love this bulletin board that you made!"
	*/

	// Each Topic also stores the username of currentUser; and message ID, which is (index of its Message + 1)

	// For example, the first message on the board will be a Topic who's index will be stored at 0 in the messageList ArrayList,
	// so its message ID will be (0+1) = 1
	// Once the Topic has been constructed, add it to the messageList
	// This should invoke your inheritance of Topic to Message
	private void addTopic(){
		sc = new Scanner(System.in);
		System.out.print("Subject: ");
		String subject = sc.nextLine();
		System.out.print("Body: ");
		String body = sc.nextLine();
		hello = new Topic(drones.getUsername(),subject,body,activater);
		log.add(hello);
		activater++;
	}

	// This function asks the user to enter a reply to a given Message (which may be either a Topic or a Reply, so we can handle nested replies).
	//		The addReply function first asks the user for the ID of the Message to which they are replying;
	//		if the number provided is greater than the size of messageList, it should output and error message and loop back,
	// 		continuing to ask for a valid Message ID number until the user enters it or -1.
	// 		(-1 returns to menu, any other negative number asks again for a valid ID number)
	
	// If the ID is valid, then the function asks for the body of the new message, 
	// and constructs the Reply, pushing back the Reply on to the messageList.
	// The subject of the Reply is a copy of the parent Topic's subject with the "Re: " prefix.
	// e.g., suppose the subject of message #9 was "Thanks", the user is replying to that message:


	/*
			Enter Message ID (-1 for Menu): 9
			Body: It was a pleasure implementing this!
	*/

	// Note: As before, the body ends when the user enters an empty line.
	// The above dialog will generate a reply that has "Re: Thanks" as its subject
	// and "It was a pleasure implementing this!" as its body.

	// How will we know what Topic this is a reply to?
	// In addition to keeping a pointer to all the Message objects in BBoard's messageList ArrayList
	// Every Message (wheather Topic or Reply) will also store an ArrayList of pointers to all of its Replies.
	// So whenever we build a Reply, we must immediately store this Message in the parent Message's list. 
	// The Reply's constructor should set the Reply's subject to "Re: " + its parent's subject.
	// Call the addChild function on the parent Message to push back the new Message (to the new Reply) to the parent's childList ArrayList.
	// Finally, push back the Message created to the BBoard's messageList. 
	// Note: When the user chooses to return to the menu, do not call run() again - just return fro mthis addReply function. 
	private void addReply()
	{
		replyId = 0;
		String subject = "";
		String body = "";
		sc = new Scanner(System.in);
		if(activater == 0)
		{
			System.out.println("nothing to reply to");
		}
		else
		{
			System.out.print("Enter message ID (-1 for menu): ");
			int logId = sc.nextInt();
			replyId = logId;
			if(logId == -1)
			{
				System.out.print("");
			}
			else
			for(int cntr = 0; cntr < log.size(); cntr++)
			{
				if(logId == log.get(cntr).getId()+1)
				{
					sc = new Scanner(System.in);
					subject = log.get(cntr).getSubject();
					System.out.print("Body: ");
					body = sc.nextLine();
					hello = new Reply(drones.getUsername(),subject,body,activater);
					log.add(hello);
					activater++;
					break;
				}
			}
		}
	}

	// This function allows the user to change their current password.
	// The user is asked to provide the old password of the currentUser.
	// 		If the received password matches the currentUser password, then the user will be prompted to enter a new password.
	// 		If the received password doesn't match the currentUser password, then the user will be prompted to re-enter the password. 
	// 		The user is welcome to enter 'c' or 'C' to cancel the setting of a password and return to the menu.
	// Any password is allowed except 'c' or 'C' for allowing the user to quit out to the menu. 
	// Once entered, the user will be told "Password Accepted." and returned to the menu.
	private void setPassword(){
		sc = new Scanner(System.in);
		System.out.println("Old Password: ");
		String old = sc.nextLine();
		System.out.println("New Password: ");
		String New = sc.nextLine();
		if(drones.setPassword(old,New))
		{
			System.out.print("Password has been updated");
		}
		else
		{
			System.out.println("Password was incorrect please try again");
			setPassword();
		}
	}

}
