/**
 * Stores information about the created content for later use.
 */
package client.backend;

import java.time.LocalDateTime;
import java.util.TreeSet;

import javax.swing.Icon;

/**
 * @author Eray Altun
 *
 */
public class Content implements Comparable<Content> {
	private static TreeSet<Content> allContent = new TreeSet<Content>();

	private User creator;
	private String title; // must be unique;.
	private Icon image;
	private String text;
	private LocalDateTime time;

	/**
	 * Initializes a new instance of Content.
	 * 
	 * @param title   Content title
	 * @param text    Content text
	 * @param creator The owner of the content
	 */
	public Content(String title, String text, User creator) {
		super();
		setTitle(title);
		this.text = text;
		this.creator = creator;
		time = LocalDateTime.now();

		allContent.add(this);
	}

	/**
	 * Checks if the the given user is the creator of the object.
	 * 
	 * @param user The user that is checked if it's the owner of the content or not.
	 * @return if the user is the creator, returns true, if not returns false.
	 */
	public boolean isCreator(User user) {
		return user.equals(creator);
	}

	/**
	 * Allows contents to by sorted by creation time.
	 * 
	 * @param The other object to compare to.
	 */
	@Override
	public int compareTo(Content content) {
		return content.getTime().compareTo(this.getTime());
	}

	/**
	 * Removed content from the list of allContent.
	 * 
	 * @param content
	 */
	public static void delConent(Content content) {
		allContent.remove(content);
	}

	/**
	 * Disposes of that content from everywhere it was used.
	 * 
	 * @param content Which content to remove.
	 */
	public static void dispose(Content content) {
		for (UserGroup group : UserGroup.getAllGroups()) {
			if (group.getConent().contains(content)) {
				group.delConent(content);
			}
		}
		for (User user : User.getAllUsers()) {
			if (user.getConentPersonal().contains(content)) {
				user.delConent(content);
			}
		}
	}

	/**
	 * Sets the contents title
	 * 
	 * @param title The title to set the content.
	 * @return returns true if the title was not used, and false if the title was
	 *         used. NOTE: content titles are unique.
	 */
	public boolean setTitle(String title) {
		for (Content content : allContent) {
			if (content.getTitle() == title) {
				return false;
			}
		}
		this.title = title;
		return true;
	}

	// Getter - Setters

	public String getTitle() {
		return title;
	}

	public Icon getImage() {
		return image;
	}

	public void setImage(Icon image) {
		this.image = image;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public static TreeSet<Content> getAllContent() {
		return allContent;
	}

}
