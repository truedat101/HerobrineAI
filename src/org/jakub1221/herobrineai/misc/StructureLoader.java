package org.jakub1221.herobrineai.misc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

public class StructureLoader {

	private int current = 0;
	private int length = 0;
	private InputStream inp;
	private YamlConfiguration file;

	public StructureLoader(InputStream in) {
		inp = in;

		file = new YamlConfiguration();

		try {
			file.load(inp);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (InvalidConfigurationException e) {

			e.printStackTrace();
		}

		try {
			inp.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Build(World world, int MainX, int MainY, int MainZ) {

		length = file.getInt("DATA.LENGTH") - 1;
		for (current = 0; current <= length; current++) {
			world.getBlockAt(MainX + file.getInt("DATA." + current + ".X"),
					MainY + file.getInt("DATA." + current + ".Y"), MainZ + file.getInt("DATA." + current + ".Z"))
					.setTypeIdAndData(+file.getInt("DATA." + current + ".ID"),(byte) +file.getInt("DATA." + current + ".DATA"), false);
		}

	}

}
