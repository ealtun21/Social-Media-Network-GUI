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
				true, "America", new ArrayList<String>(Arrays.asList("linux, reddit, UI, UX, memes")));

		User fietund = new User("Fietund", password, "Bruce", "May", "71", "BruceNMay@rhyta.com",
				new ImageIcon(new ImageIcon("IMG/demo/pharm.png").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				false, "America",
				new ArrayList<String>(Arrays.asList("sandcastles, drugs, phones, running, heathcare, money")));

		User demir = new User("Demir", password, "Demir", "Demirbilek", "18", "demir@magic.com",
				new ImageIcon(new ImageIcon("IMG/demo/demirProfilePic.png").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				false, "Turkey", new ArrayList<String>(Arrays
						.asList("linux, gaming, steam, dota2, C#, divinity2, movies, girls, dnd, swiming, memes")));

		User eray = new User("Eray", password, "Eray", "Altun", "20", "ealtun21@ku.edu.tr",
				new ImageIcon(new ImageIcon("IMG/demo/eray.jpg").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				false, "Turkey", new ArrayList<String>(Arrays.asList(
						"linux, rust, UI, UX, tennis, cooking, anime, manga, coding, java, dota2, steam, memes")));

		User yunus = new User("Yunus", password, "Yunus", "Yunusoglu", "19", "yunus@gmail.com",
				new ImageIcon(new ImageIcon("IMG/demo/yunus.jpg").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				false, "Turkey", new ArrayList<String>(
						Arrays.asList("windows, android, dota2, php, java, html, css, vadi, antilol, dnd, memes")));

		User berkay = new User("Berkay", password, "Berkay", "Kılıç", "18", "berkaykılıc@gmail.com",
				new ImageIcon(new ImageIcon("IMG/demo/berkay.jpg").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				false, "Turkey", new ArrayList<String>(
						Arrays.asList("windows, dnd, gaming, english, mamajoke, history, divinity2, memes")));

		User zeynep = new User("Zeynep", password, "Zeyenp", "Uçar", "18", "zeynep@gmail.com",
				new ImageIcon(new ImageIcon("IMG/demo/zeynep.jpg").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				false, "Turkey",
				new ArrayList<String>(Arrays.asList("linux, art, manga, anime, cats, tennis, baking, walking, memes")));

		User elon = new User("Elon", password, "Elon", "Musk", "50", "elon@gmail.com",
				new ImageIcon(new ImageIcon("IMG/demo/elon.jpg").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				true, "America",
				new ArrayList<String>(Arrays.asList("food, twitter, spacex, UI, UX, tesla, coding, money, memes")));

		User jeff = new User("Jeff", password, "Jeff", "Bezos", "54", "jeff@amazon.com",
				new ImageIcon(new ImageIcon("IMG/demo/jeff.jpg").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				true, "America", new ArrayList<String>(Arrays.asList("amazon, money, twitter")));

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

		UserGroup memes = new UserGroup(elon, "The Chadson's meme Group", "Germany",
				new ArrayList<String>(Arrays.asList("memes, twitter, twitch")));
		memes.addMember(elon);
		memes.addMember(eray);
		memes.addMember(zeynep);
		memes.addMember(demir);
		memes.addMember(yunus);
		memes.addMember(berkay);

		UserGroup money = new UserGroup(jeff, "Money 101, Earn Fast", "China",
				new ArrayList<String>(Arrays.asList("money, coding, amazon, tesla, gaming")));
		money.addMember(elon);
		money.addMember(jeff);
		money.addMember(fietund);

		UserGroup dota2 = new UserGroup(baumi, "Baumi's Dota2 Group", "Germany",
				new ArrayList<String>(Arrays.asList("dota2, twitter, twitch")));
		dota2.addMember(baumi);
		dota2.addMember(eray);
		dota2.addMember(zeynep);
		dota2.addMember(demir);
		dota2.addMember(yunus);
		dota2.addMember(berkay);
		dota2.addMember(jenkins);
		dota2.addMember(gorgc);

		// empressNoodle Content
		Content contentE = new Content("Pink Mac", "[mlvwm] Not your average Mac OS", empressNoodle);
		contentE.setImage(new ImageIcon(
				new ImageIcon("IMG/demo/mac.png").getImage().getScaledInstance(240, 180, java.awt.Image.SCALE_SMOOTH)));
		empressNoodle.newConent(contentE);
		unixporn.newConent(contentE);

		Content contentAA = new Content("Why Linux is great",
				"The package-manager of Linux is way more robust than any other OS. Installing software in Linux is notably easy compared to Windows. It can enhance the work-flow for programmers remarkably. Most cases, you only need to open up the terminal and write.",
				empressNoodle);
		empressNoodle.newConent(contentAA);

		Content contentA = new Content("[i3-Gaps] First Time Ricing My Linux System",
				"Don't judgme me too much first time ricing my linux system :)", empressNoodle);
		contentA.setImage(new ImageIcon(new ImageIcon("IMG/demo/firstRice.png").getImage().getScaledInstance(240, 150,
				java.awt.Image.SCALE_SMOOTH)));
		empressNoodle.newConent(contentA);
		unixporn.newConent(contentA);

		Content contentB = new Content("[GNOME] Voila strikes again!",
				"It's Tokyo night time baby!\n\nThe wallpaper can be found in my wallpaper repo.", empressNoodle);
		contentB.setImage(new ImageIcon(new ImageIcon("IMG/demo/voila.png").getImage().getScaledInstance(292, 164,
				java.awt.Image.SCALE_SMOOTH)));
		empressNoodle.newConent(contentB);
		unixporn.newConent(contentB);

		// Eray Content
		Content contentC = new Content("[rEFInd] Blue Red",
				"Take the blue pill, you'll wake up in Windows and believe whatever you want to believe.\nTake the red pill, I'll show you how deep the rabbit hole goes...",
				eray);
		contentC.setImage(new ImageIcon(new ImageIcon("IMG/demo/bluered.png").getImage().getScaledInstance(204, 153,
				java.awt.Image.SCALE_SMOOTH)));
		eray.newConent(contentC);
		unixporn.newConent(contentC);

		Content contentAB = new Content("Valve Please!",
				"I think it would be a great idea to have a \"Choose Your Arcana\" reward in the battle pass for people who missed out on previous battlepasses. This would give new players, people who weren't able to afford BPs previously, and people who were on hiatus to obtain arcanas that they missed out on.\n"
						+ "\n"
						+ "It can be say a Level 500 reward, and maybe one more arcana unlock at Level 1000. This is a great incentive for players who desperately want an arcana they missed out on to level up their BPs beyond the new arcanas.\n"
						+ "\n"
						+ "And for people who already have those arcanas, give them an alternative reward at those levels, maybe a couple immortal treasures? I'm not sure what would be a fair alternative reward for those people. But then again, they don't really need to level up their BP beyond the new arcanas if they don't want to.\n"
						+ "\n" + "Best,\n" + "\n"
						+ "A QoP and Windranger main who took a hiatus and was a working college student in 2020.",
				eray);
		eray.newConent(contentAB);
		dota2.newConent(contentAB);

		Content contentAC = new Content("Phone goes kaboom", "phone goes kaboom", eray);
		contentAC.setImage(new ImageIcon("IMG/demo/phoneboom.gif"));
		eray.newConent(contentAC);
		memes.newConent(contentAC);

		Content contentAD = new Content("Why Linux is best",
				"Linux allows a user to control every aspect of the operating system.\nAs Linux is an open-source operating system, it allows a user to modify its source (even source code of applications) itself as per the user requirements.\nLinux allows the user to install only the desired software nothing else (no bloatware).",
				eray);
		eray.newConent(contentAD);

	}

	public static void main(String[] args) {
		demo();
		LoginPage window = new LoginPage();
		window.setVisible(true);

	}

}
