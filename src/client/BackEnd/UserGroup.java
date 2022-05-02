/**
 * 
 */
package client.BackEnd;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Eray Altun
 *
 */
public class UserGroup {

	private static HashSet<UserGroup> allGroups;
	
	private final User creator;
	private final String groupname; // Title of the group
	private final String location; // Country
	private ArrayList<String> hobbies;
	private HashSet<User> users;

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
		
		allGroups.add(this);
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
	
	public void removeUser(User user) {
		// Removes user from the group.
		users.remove(user);
	}

	// Getters and setters

	public ArrayList<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
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
