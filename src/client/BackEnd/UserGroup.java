/**
 * 
 */
package client.BackEnd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Eray Altun
 *
 */
public class UserGroup {

	private static HashSet<UserGroup> allGroups = new HashSet<UserGroup>();
	
	private final User creator;
	private final String groupname; // Title of the group
	private final String location; // Country
	private ArrayList<String> hobbies;
	private HashSet<User> users;
	private HashSet<Content> contents;

	/**
	 * Initialize the user group
	 * 
	 * @param groupname
	 * @param location
	 * @param hobbits
	 */
	public UserGroup(User creator, String groupname, String location, ArrayList<String> hobbies) {
		super();
		this.creator = creator;
		this.groupname = groupname;
		this.location = location;
		this.hobbies = hobbies;
		
		contents = new HashSet<>();
		users = new HashSet<>();
		
		allGroups.add(this);
	}
	
	public String getHobbiesStr() {
		return "Hobbies: " + String.join(", ", hobbies);
	}
	
	/**
	 * Dispose method
	 * 
	 * @param owner, when calling dispose() it should be called as createdgroup.dispose(this);
	 * as only the owner of the group should dispose of the group.
	 */
	public void dispose(User owner) {
		if (owner.equals(creator)) {
			// Removes group from all ex. members list.
			for ( User user : users ) {
				user.delgroup(this);
			}
			// Removes group.
			allGroups.remove(this);
		}
	}
	public void newConent(Content content) {
		contents.add(content);
	}

	public void delConent(Content content) {
		contents.remove(content);
	}
	
	public static HashSet<UserGroup> getAllGroups() {
		return allGroups;
	}
	
	public String getTitle() {
		return groupname;
	}
	
	public void removeUser(User user) {
		// Removes user from the group.
		users.remove(user);
	}
	
	public boolean isCreator(User user) {
		return creator.equals(user);
	}
	
	public boolean isMember(User user) {
		return users.contains(user);
	}
	
	public void addMember(User user) {
		users.add(user);
	}
	// Getters and setters

	public HashSet<Content> getConent() {
		return contents;
	}

	public ArrayList<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}

	public String getUsersStr() {
		return users.toString().replace("[", "").replace("]", "");
	}
	
	public HashSet<User> getUsers() {
		return users;
	}

	public void setUsers(HashSet<User> users) {
		this.users = users;
	}

	public User getCreator() {
		return creator;
	}

	public String getGroupname() {
		return groupname;
	}

	public String getLocation() {
		return location;
	}

}
