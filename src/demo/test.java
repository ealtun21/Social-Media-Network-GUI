/* Pledge of Honor *************************************************************************************
I hereby certify that I have completed this programming project on my own without any help from
anyone else. The effort in the project thus belongs completely to me. I did not search for a
solution, or I did not consult to any program written by others or did not copy any program from
other sources. I read and followed the guidelines provided in the project description.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: Eray Altun, 0077808
************************************************************************************************************/

/*
 * Startup of the application and hardcoded data.
 */
package demo;

// NOTE: This project only works when running on a computer at 1080p with scaling set to 100%

// TODO Finish Adding content for demo requirements. (Do on 2nd submission)

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

		User yunus = new User("Yunus", password, "Yunus", "Yunusoğlu", "19", "yunus@gmail.com",
				new ImageIcon(new ImageIcon("IMG/demo/yunus.jpg").getImage().getScaledInstance(128, 128,
						java.awt.Image.SCALE_SMOOTH)),
				false, "Turkey", new ArrayList<String>(
						Arrays.asList("windows, android, dota2, php, java, html, css, vadi, antilol, dnd, memes")));

		User berkay = new User("Berkay", password, "Berkay", "Kılıç", "18", "berkaykilic@gmail.com",
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
		dota2.addMember(yunus);

		// Follow Each Other
		empressNoodle.follow(eray);
		empressNoodle.follow(elon);
		empressNoodle.follow(fietund);

		fietund.follow(demir);
		fietund.follow(jeff);
		fietund.follow(eray);

		demir.follow(elon);
		demir.follow(jeff);
		demir.follow(fietund);

		eray.follow(zeynep);
		eray.follow(empressNoodle);
		eray.follow(jeff);

		yunus.follow(jenkins);
		yunus.follow(baumi);
		yunus.follow(demir);

		berkay.follow(jenkins);
		berkay.follow(jeff);
		berkay.follow(gorgc);

		zeynep.follow(eray);
		zeynep.follow(gorgc);
		zeynep.follow(jenkins);

		elon.follow(eray);
		elon.follow(empressNoodle);
		elon.follow(fietund);

		jeff.follow(fietund);
		jeff.follow(eray);
		jeff.follow(demir);

		baumi.follow(zeynep);
		baumi.follow(berkay);
		baumi.follow(yunus);

		jenkins.follow(berkay);
		jenkins.follow(yunus);
		jenkins.follow(gorgc);

		gorgc.follow(yunus);
		gorgc.follow(berkay);
		gorgc.follow(eray);

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

		// fietund Content

		Content contentZA = new Content("Pharmacy Times",
				"Calling all #pharmacists! We need your help. Please take this year’s OTC Guide survey & share your top OTC product recommendations. This survey will help pharmacists provide better care for patients with valuable info. Take the survey: https://bit.ly/3tkHasV #pharmacytwitter\n",
				fietund);
		contentZA.setImage(new ImageIcon(new ImageIcon("IMG/demo/farm.jpg").getImage().getScaledInstance(216, 113,
				java.awt.Image.SCALE_SMOOTH)));
		fietund.newConent(contentZA);

		Content contentZB = new Content("Former employer still paying me",
				"My former employer is still submitting my paycheck via direct deposit and I left the company two months ago. I emailed my manager, my manager’s manager, and HR to alert them. They are not responding. I have the money set aside in my savings and do not plan on using it, obviously. What else can I do if they don’t respond?\n"
						+ "\n"
						+ "It’s creating a headache as my old health insurance which should technically be terminated is listed as “primary” so my clinic has to bill them first or the claim will get denied. This insurance will like cancel at some point in the past, rendering all these paid claims to be denied retroactively.\n"
						+ "\n" + "Contributions and matching funds are still being sent to my 401k.\n" + "\n"
						+ "I’m not sure how to stop this madness, and I’m also worried about tax implications.\n" + "\n"
						+ "(Above and beyond that, how can you not realize you are paying someone who no longer works there?!)\n"
						+ "\n"
						+ "Update 1: In an interesting turn of events, the company just called me and said “we seem to have made a mistake. Here are instructions to send a money order to us in the amount overpaid.”\n"
						+ "\n" + "Update 2: I think I need to get a lawyer to ensure this gets resolved successfully.",
				fietund);
		fietund.newConent(contentZB);
		money.newConent(contentZB);

		Content contentZC = new Content("FDA Lifts Hold",
				"The FDA has lifted a clinical hold placed on Gilead Sciences’ Investigational New Drug Application for injectable lenacapavir for HIV treatment and pre-exposure prophylaxis (PrEP).",
				fietund);
		fietund.newConent(contentZC);

		Content contentZD = new Content("Congress Bill",
				"A new congressional bill aims to increase drug availability and market competition and help drive down costs.",
				fietund);
		fietund.newConent(contentZD);

		// yunus Content

		Content contentVA = new Content("If the USA is so great", "You can see the pictures, can't you?", yunus);
		contentVA.setImage(new ImageIcon(new ImageIcon("IMG/demo/yunus_USA.jpg").getImage().getScaledInstance(216, 113,
				java.awt.Image.SCALE_SMOOTH)));
		yunus.newConent(contentVA);

		Content contentVB = new Content("Elite Wholesome Meme", "1 hour here is 7 years on Earth\n*quietly* dog planet",
				yunus);
		yunus.newConent(contentVB);
		dota2.newConent(contentVB);

		Content contentVC = new Content("Why did Adele cross the road?", "To say hello from the other side.", yunus);
		yunus.newConent(contentVC);

		Content contentVD = new Content("What kind of concert only costs 45 cents?",
				"A 50 Cent concert featuring Nickelback.", yunus);
		yunus.newConent(contentVD);

		// Demir Content

		Content contentXA = new Content("[KDE] kde plasma with polybar?", "Amazing", demir);
		contentXA.setImage(new ImageIcon(
				new ImageIcon("IMG/demo/kde.png").getImage().getScaledInstance(273, 153, java.awt.Image.SCALE_SMOOTH)));
		demir.newConent(contentXA);
		unixporn.newConent(contentXA);

		Content contentXB = new Content("I want to be cremated", "as it is my last hope for a smoking hot body.",
				demir);
		demir.newConent(contentXB);

		Content contentXC = new Content("What did the grape say when it got crushed?",
				"Nothing, it just let out a little wine.", demir);
		demir.newConent(contentXC);

		Content contentXD = new Content("Time flies like an arrow.", "Fruit flies like a banana.", demir);
		demir.newConent(contentXD);

		// Berkay Content

		Content contentWA = new Content("What a lovely day for a shower", "Showers are cool", berkay);
		contentWA.setImage(new ImageIcon("IMG/demo/shower.gif"));
		berkay.newConent(contentWA);
		memes.newConent(contentWA);

		Content contentWB = new Content("Can February March?", "No, but April May.", berkay);
		berkay.newConent(contentWB);

		Content contentWC = new Content("Need an ark to save two of every animal?", "I noah guy.", berkay);
		berkay.newConent(contentWC);

		Content contentWD = new Content("I don’t trust stairs because", "they’re always up to something.", berkay);
		berkay.newConent(contentWD);

		// Zeynep Content

		Content content2A = new Content("What a joke!", "Jokes, jokes, jokes....*sigh*", zeynep);
		content2A.setImage(new ImageIcon("IMG/demo/phd.gif"));
		zeynep.newConent(content2A);
		memes.newConent(content2A);

		Content content2B = new Content("Riki is broken!", "Too bad no one actually knows, untill now!", zeynep);
		zeynep.newConent(content2B);
		dota2.newConent(content2B);

		Content content2C = new Content("Sure, I drink brake fluid.", "But I can stop anytime!", zeynep);
		zeynep.newConent(content2C);

		Content content2D = new Content("How did the picture end up in jail?", "It was framed!", zeynep);
		zeynep.newConent(content2D);

		// Elon Content

		Content content3A = new Content("It drains everything from you", "Didn't drop out for nothing!", elon);
		content3A.setImage(new ImageIcon("IMG/demo/drain.gif"));
		elon.newConent(content3A);
		memes.newConent(content3A);

		Content content3B = new Content("What is money?",
				"Money is called many things. Cash. Coin. Bread. Bucks. Chips. Currency. Dough. Green. Loot. Moolah.\n"
						+ "\n"
						+ "Whatever you call it, money is how we buy goods and services and pay for things. Some people have lots of money. Other people have little. But rich or poor, everyone can relate to money.",
				elon);
		elon.newConent(content3B);
		money.newConent(content3B);

		Content content3C = new Content("My ex-wife still misses me.", "But her aim is starting to improve!", elon);
		elon.newConent(content3C);

		Content content3D = new Content("Coffee has a rough time in our house.", "It gets mugged every single morning!",
				elon);
		elon.newConent(content3D);

		// Jeff Content

		Content content4A = new Content("I just count", "and count.. and count.... and count...........", jeff);
		content4A.setImage(new ImageIcon("IMG/demo/money.gif"));
		jeff.newConent(content4A);
		money.newConent(content4A);

		Content content4B = new Content("I said that it would be like this.",
				"their best to add another $3.5 TRILLION to federal spending. They failed, but if they had succeeded, inflation would be even higher than it is today, and inflation today is at a 40 year high.",
				jeff);
		jeff.newConent(content4B);

		Content content4C = new Content("Bars", "The past, the present, and the future walk into a bar. It was tense!",
				jeff);
		jeff.newConent(content4C);

		Content content4D = new Content("Tonight!", "Having a beer with Elon Musk", jeff);
		jeff.newConent(content4D);

		// Baumi Content

		Content content5A = new Content("A quick suggestion", "Hi,\n" + "\n"
				+ "my suggestion is fairly simple but I think it'll make playing consecutive games where I know I already got the right mode and Underlord selected a bit quicker. By switching the position of the Underlord selection screen and the find match button you'll be able to just quickly double click to search for a match. I think this would be especially helpful with the new knockout mode where you end up clicking find match a lot more often than before due to the shorter match length.\n"
				+ "\n" + "Also a \"play again\" button for kockout would be neat.", baumi);
		content5A.setImage(new ImageIcon(
				new ImageIcon("IMG/demo/sug.jpg").getImage().getScaledInstance(273, 153, java.awt.Image.SCALE_SMOOTH)));
		baumi.newConent(content5A);
		dota2.newConent(content5A);

		Content content5B = new Content("I screwed up. I'm sorry.", "Hey,\n" + "\n"
				+ "I don't really know how to start this. I want to apologize. For everything. I screwed up.\n" + "\n"
				+ "I decided to run a tournament without the proper infrastructure in place. I should have started on a smaller scale or done more testing. I could have stress tested the document better or I could have hired someone to build a more sturdy system. Instead I decided to push forward, knowing full well that something could go wrong. I'm sorry.\n"
				+ "\n"
				+ "When things went wrong I didn't have a backup plan in place. I improvised on the spot but without the proper experience or required workforce it resulted in an unjust and unfair situation where lots of people were unfairly disqualified. When I announced the tournament I entered an agreement with everybody that signed up. They would show up and I would make it possible for them to play. Not only did I not properly honor that agreement by not having the proper infrastructure but also I then actively disregarded my responsibility in the agreement by not making sure everybody that honored their side got to play. I'm sorry.\n"
				+ "\n"
				+ "Instead of managing the situation professionally I got stressed and angry. I disregarded players coming to me with legitimate concerns in favor of focusing on the negative side. I grouped everybody into the same category and assumed the worst of people. I'm sorry.\n"
				+ "\n"
				+ "I especially want to apologize to zhgary0410. I didn't treat you well. I disregarded your concerns when you voiced them and instead made a racist joke at your expense. That isn't acceptable. Any sort of racism, even in jest, isn't acceptable. By responding to your concern that we disqualified you because of your chinese ID with saying \"Yes\" I engaged in discrimination. I later wrote a shitty, awful response to you voicing your legitimate concerns on reddit. I tried to push my failure onto a failure in the system, others and worst of all, you. I shouldn't have done that. I should have listened to what you had to say and I should have made an effort to fix the error that unfairly kicked you out of the tournament. Instead I humiliated you and refused to take the blame for it. I don't know how I can properly express how sorry I am but I deeply regret everything that happened and how I acted. I didn't kick you out of the tournament because of your chinese ID and I didn't replace you with a friend of mine. But with how I acted I might as well have. What I did is not better and I understand how you came to that conclusion. I tried to apologize to you privately but you didn't respond to me. That's fair and I don't expect you to respond. But if you do please let me know how I can make it up to you. I'm so sorry.\n"
				+ "\n"
				+ "I don't deal well when my plans don't work. I'm hypocritical because I make fun of people all the time but I'm incredibly sensitive to being made fun of. I'm awful at acting professional. I saw this tournament as \"something fun I do with my friends\" while trying to sell it as a community event. If I want to run community events I need to put the community first and I didn't. I'm sorry.\n"
				+ "\n"
				+ "I overstepped and acted awful. I know a lot of you won't believe me but it wasn't out of malice. I didn't mean to harm anybody but that doesn't mean I didn't harm anybody. I should have taken responsibility for my actions right away but instead I tried to deflect and shift blame away from me. I'm truly, deeply sorry with how I handled all of this. You might not believe me and think I'm doing this just to safe face and that's fair to assume. I don't know how to prove that I'm being honest. I have done a lot of soul searching over the past few days, I have hardly been able to sleep and been eating almost nothing. It took me too long to realize my mistakes and I don't know how to fix that.\n"
				+ "\n" + "I'm so sorry. I'll do my best to not make the same mistakes again.\n" + "\n" + "Baumi",
				baumi);
		baumi.newConent(content5B);

		Content content5C = new Content("What are the problems with Metagame?",
				"Samox refused to let anyone else help with editing and it really shows, why can he not be criticized for that?",
				baumi);
		baumi.newConent(content5C);

		Content content5D = new Content("JimBen, known for his Silly Builds series, has passed away.",
				"God, I called it \"funny\" builds. Sorry, I'm a little all over the place at the moment.", baumi);
		baumi.newConent(content5D);

		// Jenkins Content

		Content content6A = new Content("What's going on with this Jenkins guy?",
				"He seems deranged every time I see him on camera. Is he awkward ironically? Or just awkward? Maybe I don't get his humor.",
				jenkins);
		content6A.setImage(new ImageIcon(new ImageIcon("IMG/demo/andrew.jpg").getImage().getScaledInstance(320, 214,
				java.awt.Image.SCALE_SMOOTH)));
		jenkins.newConent(content6A);

		Content content6B = new Content("Jenkins Explains",
				"I have played 3-4 games in since Animajor. It's just been random streams then Gorp,qojqva,mason, etc.\n"
						+ "\n" + "But today is the day I am going back on the grind again. Wish me luck boys",
				jenkins);
		jenkins.newConent(content6B);

		Content content6C = new Content("Here we see",
				"He lost some weight, nice!\n"
						+ "I'm going to send him a small miniature techies to congratulate him, his favorite hero.",
				jenkins);
		jenkins.newConent(content6C);

		Content content6D = new Content("Broke up with techies.", "New main is silencer!", jenkins);
		jenkins.newConent(content6D);

		// Gorgc Content

		Content content7A = new Content("Sometimes, I just can't hold me self", "Smash... SMASH.. SMASHH!!!!!", gorgc);
		content7A.setImage(new ImageIcon("IMG/demo/gorgcsmash.gif"));
		gorgc.newConent(content7A);

		Content content7B = new Content("Gorgc to the major",
				"Is inviting Gorgc to the major the reason why BSJ and Kyle didn't come\n" + "\n"
						+ "Maybe they don't want to be on the same space with Gorgc IRL",
				gorgc);
		gorgc.newConent(content7B);

		Content content7C = new Content("Water Fast",
				"72 hour water fast done. that was some of the hardest sh!t ive ever done.  ate some eggs and chicken and slept for 14 hours. chillin now",
				gorgc);
		gorgc.newConent(content7C);

		Content content7D = new Content("GiveAway!",
				"10 winners $300 giveaway later on stream, retweet and comment your BTC adress or gamdom account ",
				gorgc);
		gorgc.newConent(content7D);
	}

	public static void main(String[] args) {
		demo();
		LoginPage window = new LoginPage();
		window.setVisible(true);

	}

}
