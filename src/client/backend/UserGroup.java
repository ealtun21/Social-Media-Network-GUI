/**
 * Groups for the social media program are stored here.
 */
package client.backend;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

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
	private TreeSet<Content> contents;

	/**
	 * Initialize the user group
	 * 
	 * @param creator   The creator of the group.
	 * @param groupname The name of the group.
	 * @param location  The location of the group.
	 * @param hobbits   The hobbies of the group.
	 */
	public UserGroup(User creator, String groupname, String location, ArrayList<String> hobbies) {
		super();
		this.creator = creator;
		this.groupname = groupname;
		this.location = location;
		this.hobbies = hobbies;

		contents = new TreeSet<>();
		users = new HashSet<>();

		allGroups.add(this);
	}

	/**
	 * Dispose method, Deletes the group and removes all members from the group.
	 * 
	 * @param owner, when calling dispose() it should be called as
	 *               createdgroup.dispose(this); as only the owner of the group
	 *               should dispose of the group.
	 */
	public void dispose(User owner) {
		if (owner.equals(creator)) {
			// Removes group from all ex. members list.
			for (User user : users) {
				user.delgroup(this);
			}
			// Removes group.
			allGroups.remove(this);
		}
	}

	/**
	 * Gets all contents of the group.
	 * 
	 *
	 * @param user This should be the logged in user. Needed to check whether a
	 *             certain content is created by the caller user.
	 * @return returns all contents of the group.
	 */
	public ArrayList<Content> getUsersContent(User user) {
		ArrayList<Content> usersContent = new ArrayList<>();
		for (Content content : contents) {
			if (content.isCreator(user)) {
				usersContent.add(content);
			}
		}
		return usersContent;
	}

	/**
	 * Gets hobbies in a human readable format.
	 * 
	 * @return returns String of hobbies separated by a comma and space.
	 */
	public String getHobbiesStr() {
		return String.join(", ", hobbies);
	}

	/**
	 * Adds content to the group.
	 * 
	 * @param content content which will be added.
	 */
	public void newConent(Content content) {
		contents.add(content);
	}

	/**
	 * Removes content to the group.
	 * 
	 * @param content content which will be removed.
	 */
	public void delConent(Content content) {
		contents.remove(content);
		Content.delConent(content);
	}

	/**
	 * Removes user from the group.
	 * 
	 * @param user user to be removed.
	 */
	public void removeUser(User user) {

		users.remove(user);
		user.removeGroup(this);
	}

	/**
	 * ToString method
	 */
	@Override
	public String toString() {
		return groupname;
	}

	/**
	 * Adds user to the group
	 * 
	 * @param user user to be added.
	 */
	public void addMember(User user) {
		users.add(user);
		user.addGroup(this);
	}

	// Getters and setters

	public static HashSet<UserGroup> getAllGroups() {
		return allGroups;
	}

	public String getTitle() {
		return groupname;
	}

	public boolean isCreator(User user) {
		return creator.equals(user);
	}

	public boolean isMember(User user) {
		return users.contains(user);
	}

	public TreeSet<Content> getConent() {
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
