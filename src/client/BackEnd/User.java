/**
 * 
 */
package client.BackEnd;

import java.awt.Image;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


/**
 * @author Eray Altun
 *
 */
public class User {
	
	private static HashSet<User> allUsers = new HashSet<>();
	
	/**
	 * Personal information regarding the user.
	 *
	 */
	private final String nickname;
	private String password;
	private String name;
	private String surname;
	private Image profileImage;
	
	private HashSet<User> followingUsers;
	private HashSet<UserGroup> followingGroups;
	
	private HashMap<Integer, Content> contentGroups; // HashMap<Group_ID, Post>
	private LinkedList<Content> conentPersonal;
	
	/**
	 * Initialize the user.
	 * Adds the user to the allUsers list.
	 * 
	 * @param nickname
	 * @param password
	 * @param name
	 * @param surname
	 * @param profileImage
	 */
	public User(String nickname, String password, String name, String surname, Image profileImage) {
		super();
		this.nickname = nickname;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.profileImage = profileImage;
		
		allUsers.add(this);
	}

	public void dispose() {
		for (UserGroup group : followingGroups) {
			group.removeUser(this);
		}
		allUsers.remove(this);
	}
	
	public void delgroup(UserGroup userGroup) {
		followingGroups.remove(userGroup);
	}
	
	// Getters and setters
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Image getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(Image profileImage) {
		this.profileImage = profileImage;
	}

	public HashSet<User> getFollowingUsers() {
		return followingUsers;
	}

	public void setFollowingUsers(HashSet<User> followingUsers) {
		this.followingUsers = followingUsers;
	}

	public HashSet<UserGroup> getFollowingGroups() {
		return followingGroups;
	}

	public void setFollowingGroups(HashSet<UserGroup> followingGroups) {
		this.followingGroups = followingGroups;
	}

	public HashMap<Integer, Content> getContentGroups() {
		return contentGroups;
	}

	public void setContentGroups(HashMap<Integer, Content> contentGroups) {
		this.contentGroups = contentGroups;
	}

	public LinkedList<Content> getConentPersonal() {
		return conentPersonal;
	}

	public void setConentPersonal(LinkedList<Content> conentPersonal) {
		this.conentPersonal = conentPersonal;
	}

	public static HashSet<User> getAllUsers() {
		return allUsers;
	}

	public String getNickname() {
		return nickname;
	}

}
