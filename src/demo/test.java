/* Pledge of Honor *************************************************************************************
I hereby certify that I have completed this programming project on my own without any help from
anyone else. The effort in the project thus belongs completely to me. I did not search for a
solution, or I did not consult to any program written by others or did not copy any program from
other sources. I read and followed the guidelines provided in the project description.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: Eray Altun, 0077808
************************************************************************************************************/
package demo;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;

import client.backend.Content;
import client.backend.User;
import client.backend.UserGroup;
import client.frontend.entry.LoginPage;

public class test {
	private static char[] password = { '1', '2', '3' };

	public static void demo() {
		User empressNoodle = new User("EmpressNoodle", password, "Empress", "Noodle", "30", "reddit1@gmail.com",
				new ImageIcon(new ImageIcon("IMG/demo/profilePicRedditer.png").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				true, "America", new ArrayList<String>(Arrays.asList("linux, reddit, UI, UX")));

		User fietund = new User("Fietund", password, "Bruce", "May", "71", "BruceNMay@rhyta.com",
				new ImageIcon(new ImageIcon("IMG/demo/pharm.png").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				false, "America",
				new ArrayList<String>(Arrays.asList("sandcastles, drugs, phones, running, heathcare")));

		User demir = new User("Demir", password, "Demir", "Demirbilek", "18", "demir@magic.com",
				new ImageIcon(new ImageIcon("IMG/demo/demirProfilePic.png").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				false, "Turkey", new ArrayList<String>(
						Arrays.asList("linux, gaming, steam, dota2, C#, divinity2, movies, girls, dnd, swiming")));

		User eray = new User("Eray", password, "Eray", "Altun", "20", "ealtun21@ku.edu.tr",
				new ImageIcon(new ImageIcon("IMG/demo/eray.jpg").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				false, "Turkey", new ArrayList<String>(Arrays
						.asList("linux, rust, UI, UX, tennis, cooking, anime, manga, coding, java, dota2, steam")));

		User yunus = new User("Yunus", password, "Yunus", "Yunusoglu", "19", "yunus@gmail.com",
				new ImageIcon(new ImageIcon("IMG/demo/yunus.jpg").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				true, "Turkey", new ArrayList<String>(
						Arrays.asList("windows, android, dota2, php, java, html, css, vadi, antilol, dnd")));

		User berkay = new User("Berkay", password, "Berkay", "Kılıç", "18", "berkaykılıc@gmail.com",
				new ImageIcon(new ImageIcon("IMG/demo/berkay.jpg").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				false, "Turkey",
				new ArrayList<String>(Arrays.asList("windows, dnd, gaming, english, mamajoke, history, divinity2")));

		User zeynep = new User("Zeynep", password, "Zeyenp", "Uçar", "18", "zeynep@gmail.com",
				new ImageIcon(new ImageIcon("IMG/demo/zeynep.jpg").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				false, "Turkey",
				new ArrayList<String>(Arrays.asList("linux, art, manga, anime, cats, tennis, baking, walking")));

		User elon = new User("Elon", password, "Elon", "Musk", "50", "elon@gmail.com",
				new ImageIcon(new ImageIcon("IMG/demo/elon.jpg").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				true, "America",
				new ArrayList<String>(Arrays.asList("food, twitter, spacex, UI, UX, tesla, coding, money")));

		User jeff = new User("Jeff", password, "Jeff", "Bezos", "54", "jeff@amazon.com",
				new ImageIcon(new ImageIcon("IMG/demo/jeff.jpg").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				false, "America", new ArrayList<String>(Arrays.asList("amazon, money, twitter")));

		User baumi = new User("Baumi", password, "Baumi", "Cats", "46", "baumi@gmail.com",
				new ImageIcon(new ImageIcon("IMG/demo/baumi.jpg").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				true, "Germany", new ArrayList<String>(Arrays.asList("dota2, cats, TI, steaming, twitch")));

		User jenkins = new User("Jenkins", password, "Jenkins", "Dota", "25", "jenkinsdota@gmail.com",
				new ImageIcon(new ImageIcon("IMG/demo/jenkins.jpg").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				false, "America", new ArrayList<String>(Arrays.asList("twitch, dota2, dota2pro, unstable")));

		User gorgc = new User("Gorgc", password, "Gorgc", "Youtube", "25", "gorgc@evolved.gg ",
				new ImageIcon(new ImageIcon("IMG/demo/gorgc.jpg").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				false, "America", new ArrayList<String>(Arrays.asList("dota2, dota2pro, rager, twitter, twitch")));
		
		// Groups 
		UserGroup unixporn = new UserGroup(empressNoodle, "Unix_Porn", "America", empressNoodle.getHobbies());
		unixporn.addMember(empressNoodle);
		unixporn.addMember(eray);
		unixporn.addMember(demir);
		
		// empressNoodle Content
		Content contentE = new Content("Pink Mac", "[mlvwm] Not your average Mac OS", empressNoodle);
		contentE.setImage(new ImageIcon(new ImageIcon("IMG/demo/mac.png").getImage().getScaledInstance(240, 180, java.awt.Image.SCALE_SMOOTH)));
		empressNoodle.newConent(contentE);
		unixporn.newConent(contentE);
		
		Content contentA = new Content("[i3-Gaps] First Time Ricing My Linux System", "Don't judgme me too much first time ricing my linux system :)", empressNoodle);
		contentA.setImage(new ImageIcon(new ImageIcon("IMG/demo/firstRice.png").getImage().getScaledInstance(240, 150, java.awt.Image.SCALE_SMOOTH)));
		empressNoodle.newConent(contentA);
		unixporn.newConent(contentA);
		
		Content contentB = new Content("[GNOME] Voila strikes again!", "It's Tokyo night time baby!\n\nThe wallpaper can be found in my wallpaper repo.", empressNoodle);
		contentB.setImage(new ImageIcon(new ImageIcon("IMG/demo/voila.png").getImage().getScaledInstance(292, 164, java.awt.Image.SCALE_SMOOTH)));
		empressNoodle.newConent(contentB);
		unixporn.newConent(contentB);
		
		// Eray Content
		Content contentC = new Content("[rEFInd] Blue Red", "Take the blue pill, you'll wake up in Windows and believe whatever you want to believe.\nTake the red pill, I'll show you how deep the rabbit hole goes...", eray);
		contentC.setImage(new ImageIcon(new ImageIcon("IMG/demo/bluered.png").getImage().getScaledInstance(204, 153, java.awt.Image.SCALE_SMOOTH)));
		eray.newConent(contentC);
		unixporn.newConent(contentC);

		
	}

	public static void main(String[] args) {
		demo();
		LoginPage window = new LoginPage();
		window.setVisible(true);

	}

}
