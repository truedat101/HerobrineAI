package org.jakub1221.herobrineai;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.jakub1221.herobrineai.support.CustomItemsHook;
import org.jakub1221.herobrineai.support.FactionsHook;
import org.jakub1221.herobrineai.support.GriefPreventionHook;
import org.jakub1221.herobrineai.support.PreciousStonesHook;
import org.jakub1221.herobrineai.support.ResidenceHook;
import org.jakub1221.herobrineai.support.TownyHook;
import org.jakub1221.herobrineai.support.WorldGuardHook;

public class Support {

	private boolean B_Residence = false;
	private boolean B_GriefPrevention = false;
	private boolean B_Towny = false;
	private boolean B_CustomItems = false;
	private boolean B_WorldGuard = false;
	private boolean B_PreciousStones = false;
	private boolean B_Factions = false;
	private ResidenceHook ResidenceCore = null;
	private GriefPreventionHook GriefPreventionCore = null;
	private TownyHook TownyCore = null;
	private CustomItemsHook CustomItems = null;
	private WorldGuardHook WorldGuard = null;
	private PreciousStonesHook PreciousStones = null;
	private FactionsHook Factions = null;

	public Support() {
		ResidenceCore = new ResidenceHook();
		GriefPreventionCore = new GriefPreventionHook();
		TownyCore = new TownyHook();
		CustomItems = new CustomItemsHook();
		WorldGuard = new WorldGuardHook();
		PreciousStones = new PreciousStonesHook();
		Factions = new FactionsHook();
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(HerobrineAI.getPluginCore(), new Runnable() {
			public void run() {
				CheckForPlugins();
			}
		}, 1 * 2L);
	}

	public boolean isPreciousStones() {
		return B_PreciousStones;
	}

	public boolean isWorldGuard() {
		return B_WorldGuard;
	}

	public boolean isResidence() {
		return B_Residence;
	}

	public boolean isGriefPrevention() {
		return B_GriefPrevention;
	}

	public boolean isTowny() {
		return B_Towny;
	}

	public boolean isFactions() {
		return B_Factions;
	}

	public void CheckForPlugins() {
		if (ResidenceCore.Check()) {
			B_Residence = true;
			HerobrineAI.log.info("[HerobrineAI] Residence plugin detected!");
		}
		if (GriefPreventionCore.Check()) {
			B_GriefPrevention = true;
			HerobrineAI.log.info("[HerobrineAI] GriefPrevention plugin detected!");
		}
		if (TownyCore.Check()) {
			B_Towny = true;
			HerobrineAI.log.info("[HerobrineAI] Towny plugin detected!");
		}
		if (CustomItems.Check()) {
			B_CustomItems = true;
			HerobrineAI.log.info("[HerobrineAI] CustomItems plugin detected!");
			CustomItems.init();
		}
		if (WorldGuard.Check()) {
			B_WorldGuard = true;
			HerobrineAI.log.info("[HerobrineAI] WorldGuard plugin detected!");
		}
		if (PreciousStones.Check()) {
			B_PreciousStones = true;
			HerobrineAI.log.info("[HerobrineAI] PreciousStones plugin detected!");
		}
		if (Factions.Check()) {
			B_Factions = true;
			HerobrineAI.log.info("[HerobrineAI] Factions plugin detected!");
		}
	}

	public boolean isSecuredArea(Location loc) {		
		if (B_Residence) 
			return ResidenceCore.isSecuredArea(loc);		
		else if (B_GriefPrevention) 
			return GriefPreventionCore.isSecuredArea(loc);
		else if (B_Towny)
			return TownyCore.isSecuredArea(loc);
		else if (B_WorldGuard)
			return WorldGuard.isSecuredArea(loc);
		else if (B_PreciousStones) 
			return PreciousStones.isSecuredArea(loc);
		else if (B_Factions) 
			return Factions.isSecuredArea(loc);
		else
			return false;
	}

	public boolean checkBuild(final Location loc) {
		return HerobrineAI.getPluginCore().getConfigDB().SecuredArea_Build || !isSecuredArea(loc);
	}

	public boolean checkAttack(final Location loc) {
		return HerobrineAI.getPluginCore().getConfigDB().SecuredArea_Attack || !isSecuredArea(loc);
	}

	public boolean checkHaunt(final Location loc) {
		return HerobrineAI.getPluginCore().getConfigDB().SecuredArea_Haunt || !isSecuredArea(loc);
	}

	public boolean checkSigns(final Location loc) {
		return HerobrineAI.getPluginCore().getConfigDB().SecuredArea_Signs || !isSecuredArea(loc);
	}

	public boolean checkBooks(final Location loc) {
		return HerobrineAI.getPluginCore().getConfigDB().SecuredArea_Books || !isSecuredArea(loc);
	}
	
	public boolean isCustomItems() {
		return B_CustomItems;
	}

	public CustomItemsHook getCustomItems() {
		if (B_CustomItems) {
			return CustomItems;
		}
		return null;
	}

}
