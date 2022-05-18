/**
 * Users for the social media program are stored here.
 */
package client.backend;

import java.util.ArrayList;
import java.util.Collection;
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
	private String country;
	private ArrayList<String> hobbies;

	private HashSet<User> followingUsers;
	private HashSet<UserGroup> followingGroups;

	private TreeSet<Content> conentPersonal;

	/**
	 * Initialize the user. Adds the user to the allUsers list.
	 * 
	 * @param nickname          Users nickname
	 * @param password          Users password
	 * @param name              Users name
	 * @param surname           Users surname
	 * @param icon              Users profile image
	 * @param country           Users country
	 * @param ArrayList<String> hobbies Users hobbies
	 */
	public User(String nickname, char[] password, String name, String surname, String age, String email, Icon icon,
			boolean premium, String country, ArrayList<String> hobbies) {
		super();
		this.nickname = nickname;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.email = email;
		this.profileImage = icon;
		this.premium = premium;
		this.country = country;
		this.hobbies = hobbies;

		followingUsers = new HashSet<>();
		followingGroups = new HashSet<>();
		conentPersonal = new TreeSet<>();

		allUsers.add(this);
	}

	/**
	 * Follow a user
	 * 
	 * @param user the user to follow
	 */
	public void follow(User user) {
		followingUsers.add(user);
	}

	/**
	 * Unfollow a user
	 * 
	 * @param user the user to unfollow
	 */
	public void unfollow(User user) {
		followingUsers.remove(user);
	}

	/**
	 * Deletes the user from everywhere.
	 */
	public void dispose() {
		followingGroups.forEach(group -> group.removeUser(this));
		followingGroups.clear();
		allUsers.remove(this);
	}

	/**
	 * Added content to the user.
	 * 
	 * @param content the content that will be added.
	 */
	public void newConent(Content content) {
		conentPersonal.add(content);
	}

	/**
	 * Removes content from the user.
	 * 
	 * @param content the content that will be removed.
	 */
	public void delConent(Content content) {
		conentPersonal.remove(content);
		Content.delConent(content);
	}

	/**
	 * Full name.
	 * 
	 * @return returns the name together with the surname with a space between.
	 */
	public String getFullname() {
		return name + " " + surname;
	}

	// Getters and setters

	/*
	 * Removes content from user's content when group is disposed
	 */
	public void delgroup(UserGroup userGroup) {
		followingGroups.remove(userGroup);
		for (Content content : userGroup.getUsersContent(this)) {
			delConent(content);
		}
	}

	/**
	 * Gives suggestions for users to follow.
	 * 
	 * @return Returns a list of users that are suggested to follow
	 */
	public Collection<? extends User> getSugUsers() {
		HashSet<User> sugUsers = new HashSet<>();
		for (User other : User.getAllUsers()) {
			int commonScore = 0;
			if (other.isFollow(this) || other.equals(this)) {
				continue;
			}
			if (Math.abs(Integer.parseInt(other.getAge()) - Integer.parseInt(age)) < 5) {
				if (other.getCountry().equals(country)) {
					commonScore += 3;
				}
				for (String hobbie : hobbies) {
					if (other.getHobbies().contains(hobbie)) {
						commonScore += 2;
					}
				}
			}
			if (commonScore >= 2) {
				sugUsers.add(other);
			}
		}

		return sugUsers;
	}

	/**
	 * Checks if the user is following another user.
	 * 
	 * @param user the users to check
	 * @return true, if the user is following the other user.
	 */
	public boolean isFollow(User user) {
		return user.followingUsers.contains(this);
	}

	/**
	 * Gives suggestions for groups to follow.
	 * 
	 * @return Returns a list of groups that are suggested to follow
	 */
	public Collection<? extends UserGroup> getSugGroups() {
		HashSet<UserGroup> sugGroups = new HashSet<>();
		for (UserGroup group : UserGroup.getAllGroups()) {
			int commonScore = 0;
			if (followingGroups.contains(group)) {
				continue;
			}
			if (group.getLocation().equals(country)) {
				commonScore += 1;
			}
			for (String hobbie : hobbies) {
				if (group.getHobbies().contains(hobbie)) {
					commonScore += 1;
				}
			}
			if (commonScore >= 0) {
				sugGroups.add(group);
			}
		}
		return sugGroups;
	}

	/**
	 * Leaves the group.
	 * 
	 * @param userGroup group to leave.
	 */
	public void removeGroup(UserGroup userGroup) {
		followingGroups.remove(userGroup);
	}

	/**
	 * Joins the group.
	 * 
	 * @param userGroup group to join.
	 */
	public void addGroup(UserGroup userGroup) {
		followingGroups.add(userGroup);
	}

	/**
	 * ToString method
	 */
	@Override
	public String toString() {
		return nickname;
	}

	// Getters - Setters

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public ArrayList<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}

}
