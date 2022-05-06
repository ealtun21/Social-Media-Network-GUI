package client.BackEnd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import javax.swing.Icon;

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
	private char[] password;
	private String name;
	private String surname;
	private String age;
	private String email;
	private Icon profileImage;
	private boolean premium;

	private HashSet<User> followingUsers;
	private HashSet<UserGroup> followingGroups;

	private TreeSet<Content> conentPersonal;

	/**
	 * Initialize the user. Adds the user to the allUsers list.
	 * 
	 * @param nickname
	 * @param password
	 * @param name
	 * @param surname
	 * @param icon
	 */
	public User(String nickname, char[] password, String name, String surname, String age, String email,Icon icon, boolean premium) {
		super();
		this.nickname = nickname;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.setEmail(email);
		this.profileImage = icon;
		this.premium = premium;
		
		followingUsers = new HashSet<>();
		followingGroups = new HashSet<>();
		conentPersonal = new TreeSet<>();
		
		allUsers.add(this);
	}

	public void dispose() {
		for (UserGroup group : followingGroups) {
			group.removeUser(this);
		}
		allUsers.remove(this);
	}
	
	public void newConent(Content content) {
		conentPersonal.add(content);
	}

	public void delConent(Content content) {
		conentPersonal.remove(content);
	}
	// Getters and setters

	public void delgroup(UserGroup userGroup) {
		followingGroups.remove(userGroup);
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	public String getPassword() {
		return String.valueOf(password);
	}
	
	public char[] getPasswordChr() {
		return password;
	}

	public void setPassword(char[] password) {
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Icon getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(Icon profileImage) {
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

	public TreeSet<Content> getConentPersonal() {
		return conentPersonal;
	}

	public void setConentPersonal(TreeSet<Content> conentPersonal) {
		this.conentPersonal = conentPersonal;
	}

	public static HashSet<User> getAllUsers() {
		return allUsers;
	}

	public String getNickname() {
		return nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
