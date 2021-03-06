package org.jakub1221.herobrineai;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jakub1221.herobrineai.misc.CustomID;

public class ConfigDB {

	private Logger log;
	public YamlConfiguration config;
	public YamlConfiguration npc;
	public int ShowRate = 2;
	public boolean HitPlayer = true;
	public boolean SendMessages = true;
	public boolean Lighting = true;
	public boolean DestroyTorches = true;
	public int DestroyTorchesRadius = 5;
	public int ShowInterval = 144000;
	public boolean TotemExplodes = true;
	public boolean OnlyWalkingMode = false;
	public boolean BuildStuff = true;
	public boolean PlaceSigns = true;
	public boolean UseTotem = true;
	public boolean WriteBooks = true;
	public boolean Killable = false;
	public boolean UsePotionEffects = true;
	public int CaveChance = 40;
	public int BookChance = 5;
	public int SignChance = 5;
	public String DeathMessage = "You cannot kill me!";
	public List<String> useWorlds = new ArrayList<String>();;
	public List<String> useMessages = new ArrayList<String>();;
	public List<String> useSignMessages = new ArrayList<String>();;
	public List<String> useBookMessages = new ArrayList<String>();;
	public boolean BuildPyramids = true;
	public boolean UseGraveyardWorld = true;
	public boolean BuryPlayers = true;
	public boolean SpawnWolves = true;
	public boolean SpawnBats = true;
	public boolean UseWalkingMode = true;
	public int WalkingModeXRadius = 1000;
	public int WalkingModeZRadius = 1000;
	public int WalkingModeFromXRadius = 0;
	public int WalkingModeFromZRadius = 0;
	public boolean BuildTemples = true;
	public boolean UseArtifactBow = true;
	public boolean UseArtifactSword = true;
	public boolean UseArtifactApple = true;
	public boolean AttackCreative = true;
	public boolean AttackOP = true;
	public boolean SecuredArea_Build = true;
	public boolean SecuredArea_Attack = true;
	public boolean SecuredArea_Haunt = true;
	public boolean SecuredArea_Signs = true;
	public boolean SecuredArea_Books = true;
	public int HerobrineHP = 150;
	public int BuildInterval = 72000;
	public boolean UseHeads = true;
	public boolean UseCustomItems = false;
	public boolean UseAncientSword = true;
	public boolean UseNPC_Guardian = true;
	public boolean UseNPC_Warrior = true;
	public boolean UseNPC_Demon = true;
	public CustomID ItemInHand = null;
	public ArrayList<String> UseCustomItemsList = new ArrayList<String>();
	public boolean Explosions = true;
	public boolean Burn = true;
	public boolean Curse = true;
	public int maxBooks = 1;
	public int maxSigns = 1;
	public int maxHeads = 1;
	public boolean UseIgnorePermission = true;
	public String HerobrineUUID = "f84c6a79-0a4e-45e0-879b-cd49ebd4c4e2";
	public String HerobrineName = "Herobrine";

	private boolean isStartupDone = false;

	public ConfigDB(Logger l) {
		this.log = l;
	}

	public File configF = new File("plugins/HerobrineAI/config.yml");
	public File npcF = new File("plugins/HerobrineAI/npc.yml");

	public void Startup() {
		new File("plugins/HerobrineAI").mkdirs();

		if (!configF.exists())
			try {
				configF.createNewFile();

			} catch (IOException e) {
				e.printStackTrace();
			}

		config = new YamlConfiguration();

		if (!npcF.exists())
			try {
				npcF.createNewFile();

			} catch (IOException e) {
				e.printStackTrace();
			}

		npc = new YamlConfiguration();

		try {
			config.load(configF);
			npc.load(npcF);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (InvalidConfigurationException e) {

			e.printStackTrace();
		}

		if (!npc.contains("npc.Guardian")) {
			npc.set("npc.Guardian.SpawnCount", 1);
			npc.set("npc.Guardian.HP", 40);
			npc.set("npc.Guardian.Speed", 0.3);
			npc.set("npc.Guardian.Drops.283.Chance", 40);
			npc.set("npc.Guardian.Drops.283.Count", 1);
			npc.set("npc.Guardian.Drops.286.Chance", 30);
			npc.set("npc.Guardian.Drops.286.Count", 1);
			npc.set("npc.Warrior.SpawnChance", 4);
			npc.set("npc.Warrior.HP", 40);
			npc.set("npc.Warrior.Speed", 0.3);
			npc.set("npc.Warrior.Drops.307.Chance", 25);
			npc.set("npc.Warrior.Drops.307.Count", 1);
			npc.set("npc.Warrior.Drops.306.Chance", 20);
			npc.set("npc.Warrior.Drops.306.Count", 1);
			npc.set("npc.Demon.SpawnChance", 4);
			npc.set("npc.Demon.HP", 40);
			npc.set("npc.Demon.Speed", 0.3);
			npc.set("npc.Demon.Drops.322.Chance", 40);
			npc.set("npc.Demon.Drops.322.Count", 1);
			npc.set("npc.Demon.Drops.397.Chance", 20);
			npc.set("npc.Demon.Drops.397.Count", 1);

			try {
				npc.save(npcF);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		if (!config.contains("config.ShowRate")) {

			useWorlds.add("world");
			useMessages.add("Even Notch can�t save you now!");
			useMessages.add("Fear me!");
			useMessages.add("Welcome to my world!");
			useMessages.add("I am your death!");
			useMessages.add("Grave awaits you!");
			useSignMessages.add("I�m watching.");
			useSignMessages.add("Death...");
			useSignMessages.add("Eyes in dark...");
			useBookMessages.add("White eyes in dark...");
			useBookMessages.add("... was last what I saw ...");
			useBookMessages.add("... before i was dead.");
			UseCustomItemsList.add("ItemExample");

			log.info("[HerobrineAI] Creating new Config ...");
			config.set("config.ShowInterval", 144000);
			config.set("config.ShowRate", 2);
			config.set("config.HitPlayer", true);
			config.set("config.SendMessages", true);
			config.set("config.Lighting", false);
			config.set("config.DestroyTorches", true);
			config.set("config.DestroyTorchesRadius", 5);
			config.set("config.Worlds", useWorlds);
			config.set("config.TotemExplodes", true);
			config.set("config.OnlyWalkingMode", false);
			config.set("config.BuildStuff", true);
			config.set("config.PlaceSigns", true);
			config.set("config.UseTotem", true);
			config.set("config.WriteBooks", true);
			config.set("config.Killable", false);
			config.set("config.UsePotionEffects", true);
			config.set("config.CaveChance", 40);
			config.set("config.BookChance", 5);
			config.set("config.SignChance", 5);
			config.set("config.DeathMessage", "You cannot kill me!");
			config.set("config.Messages", useMessages);
			config.set("config.SignMessages", useSignMessages);
			config.set("config.BookMessages", useBookMessages);
			config.set("config.Drops.264.count", 1);
			config.set("config.Drops.264.chance", 20);
			config.set("config.BuildPyramids", true);
			config.set("config.UseGraveyardWorld", true);
			config.set("config.BuryPlayers", true);
			config.set("config.SpawnWolves", true);
			config.set("config.SpawnBats", true);
			config.set("config.UseWalkingMode", true);
			config.set("config.WalkingModeRadius.X", 1000);
			config.set("config.WalkingModeRadius.Z", 1000);
			config.set("config.WalkingModeRadius.FromX", 0);
			config.set("config.WalkingModeRadius.FromZ", 0);
			config.set("config.BuildInterval", 72000);
			config.set("config.BuildTemples", true);
			config.set("config.UseArtifacts.Bow", true);
			config.set("config.UseArtifacts.Sword", true);
			config.set("config.UseArtifacts.Apple", true);
			config.set("config.HerobrineHP", 300);
			config.set("config.AttackCreative", true);
			config.set("config.AttackOP", true);
			config.set("config.SecuredArea.Build", true);
			config.set("config.SecuredArea.Attack", true);
			config.set("config.SecuredArea.Haunt", true);
			config.set("config.SecuredArea.Signs", true);
			config.set("config.SecuredArea.Books", true);
			config.set("config.UseHeads", true);
			config.set("config.UseCustomItems", false);
			config.set("config.CustomItemsList", UseCustomItemsList);
			config.set("config.UseAncientSword", true);
			config.set("config.UseNPC.Guardian", true);
			config.set("config.UseNPC.Warrior", true);
			config.set("config.UseNPC.Demon", true);
			config.set("config.ItemInHand", "0");
			config.set("config.Explosions", true);
			config.set("config.Burn", true);
			config.set("config.Curse", true);
			config.set("config.Limit.Books", 1);
			config.set("config.Limit.Signs", 1);
			config.set("config.Limit.Heads", 1);
			config.set("config.UseIgnorePermission", true);
			config.set("config.HerobrineUUID", "f84c6a79-0a4e-45e0-879b-cd49ebd4c4e2");
			config.set("config.HerobrineName", "Herobrine");

			try {
				config.save(configF);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		Reload();
	}

	public void Reload() {

		try {
			config.load(configF);
			npc.load(npcF);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (InvalidConfigurationException e) {

			e.printStackTrace();
		}

		ShowInterval = config.getInt("config.ShowInterval");
		ShowRate = config.getInt("config.ShowRate");
		HitPlayer = config.getBoolean("config.HitPlayer");
		SendMessages = config.getBoolean("config.SendMessages");
		Lighting = config.getBoolean("config.Lighting");
		DestroyTorches = config.getBoolean("config.DestroyTorches");
		DestroyTorchesRadius = config.getInt("config.DestroyTorchesRadius");
		useWorlds = config.getStringList("config.Worlds");
		TotemExplodes = config.getBoolean("config.TotemExplodes");
		OnlyWalkingMode = config.getBoolean("config.OnlyWalkingMode");
		BuildStuff = config.getBoolean("config.BuildStuff");
		PlaceSigns = config.getBoolean("config.PlaceSigns");
		UseTotem = config.getBoolean("config.UseTotem");
		WriteBooks = config.getBoolean("config.WriteBooks");
		Killable = config.getBoolean("config.Killable");
		UsePotionEffects = config.getBoolean("config.UsePotionEffects");
		CaveChance = config.getInt("config.CaveChance");
		BookChance = config.getInt("config.BookChance");
		SignChance = config.getInt("config.SignChance");
		DeathMessage = config.getString("config.DeathMessage");
		useMessages = config.getStringList("config.Messages");
		useSignMessages = config.getStringList("config.SignMessages");
		useBookMessages = config.getStringList("config.BookMessages");
		BuildPyramids = config.getBoolean("config.BuildPyramids");
		UseGraveyardWorld = config.getBoolean("config.UseGraveyardWorld");
		BuryPlayers = config.getBoolean("config.BuryPlayers");
		SpawnWolves = config.getBoolean("config.SpawnWolves");
		SpawnBats = config.getBoolean("config.SpawnBats");
		UseWalkingMode = config.getBoolean("config.UseWalkingMode");
		WalkingModeXRadius = config.getInt("config.WalkingModeRadius.X");
		WalkingModeZRadius = config.getInt("config.WalkingModeRadius.Z");
		WalkingModeFromXRadius = config.getInt("config.WalkingModeRadius.FromX");
		WalkingModeFromZRadius = config.getInt("config.WalkingModeRadius.FromZ");
		BuildInterval = config.getInt("config.BuildInterval");
		BuildTemples = config.getBoolean("config.BuildTemples");
		UseArtifactBow = config.getBoolean("config.UseArtifacts.Bow");
		UseArtifactSword = config.getBoolean("config.UseArtifacts.Sword");
		UseArtifactApple = config.getBoolean("config.UseArtifacts.Apple");
		HerobrineHP = config.getInt("config.HerobrineHP");
		AttackCreative = config.getBoolean("config.AttackCreative");
		AttackOP = config.getBoolean("config.AttackOP");
		SecuredArea_Build = config.getBoolean("config.SecuredArea.Build");
		SecuredArea_Attack = config.getBoolean("config.SecuredArea.Attack");
		SecuredArea_Haunt = config.getBoolean("config.SecuredArea.Haunt");
		SecuredArea_Signs = config.getBoolean("config.SecuredArea.Signs");
		SecuredArea_Books = config.getBoolean("config.SecuredArea.Books");
		UseHeads = config.getBoolean("config.UseHeads");
		UseCustomItems = config.getBoolean("config.UseCustomItems");
		UseCustomItemsList = (ArrayList<String>) config.getStringList("config.CustomItemsList");
		UseAncientSword = config.getBoolean("config.UseAncientSword");
		UseNPC_Guardian = config.getBoolean("config.UseNPC.Guardian");
		UseNPC_Warrior = config.getBoolean("config.UseNPC.Warrior");
		UseNPC_Demon = config.getBoolean("config.UseNPC.Demon");
		ItemInHand = new CustomID(config.getString("config.ItemInHand"));
		Explosions = config.getBoolean("config.Explosions");
		Burn = config.getBoolean("config.Burn");
		Curse = config.getBoolean("config.Curse");
		maxBooks = config.getInt("config.Limit.Books");
		maxSigns = config.getInt("config.Limit.Signs");
		maxHeads = config.getInt("config.Limit.Heads");
		UseIgnorePermission = config.getBoolean("config.UseIgnorePermission");
		HerobrineUUID = config.getString("config.HerobrineUUID");
		HerobrineName = config.getString("config.HerobrineName");
		
		HerobrineAI.HerobrineMaxHP = HerobrineHP;
		HerobrineAI.getPluginCore().getAICore().Stop_MAIN();
		HerobrineAI.getPluginCore().getAICore().Start_MAIN();
		HerobrineAI.getPluginCore().getAICore().Stop_BD();
		HerobrineAI.getPluginCore().getAICore().Start_BD();
		HerobrineAI.getPluginCore().getAICore().Stop_RC();
		HerobrineAI.getPluginCore().getAICore().Start_RC();
		HerobrineAI.AvailableWorld = false;
		HerobrineAI.getPluginCore().getAICore().getResetLimits().updateFromConfig();

		if (HerobrineAI.getPluginCore().HerobrineNPC != null) {
			HerobrineAI.getPluginCore().HerobrineNPC.setItemInHand(ItemInHand.getItemStack());
		}

		if (isStartupDone) {

			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(HerobrineAI.getPluginCore(), new Runnable() {
				public void run() {
					for (int i = 0; i <= useWorlds.size() - 1; i++) {
						if (Bukkit.getServer().getWorlds().contains(Bukkit.getServer().getWorld(useWorlds.get(i)))) {
							HerobrineAI.AvailableWorld = true;
						}
					}

					if (HerobrineAI.AvailableWorld == false) {
						log.warning("**********************************************************");
						log.warning("[HerobrineAI] There are no available worlds for Herobrine!");
						log.warning("**********************************************************");
					} else {
						log.info("**********************************************************");
						log.info("[HerobrineAI] No problems detected.");
						log.info("**********************************************************");
					}
				}
			}, 1L);

		}
		isStartupDone = true;
	}

	public void addAllWorlds() {

		ArrayList<String> allWorlds = new ArrayList<String>();
		List<World> worlds_ = Bukkit.getWorlds();
		for (int i = 0; i <= worlds_.size() - 1; i++) {
			if (!worlds_.get(i).getName().equalsIgnoreCase("world_herobrineai_graveyard")) {
				allWorlds.add(worlds_.get(i).getName());
			}
		}

		try {
			config.load(configF);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}

		config.set("config.Worlds", allWorlds);

		try {
			config.save(configF);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Reload();

	}

}
