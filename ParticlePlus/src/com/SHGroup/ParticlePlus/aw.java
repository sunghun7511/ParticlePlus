package com.SHGroup.ParticlePlus;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.SHGroup.ParticlePlus.Lib.EffectLib;
import com.SHGroup.ParticlePlus.Lib.EffectManager;
import com.SHGroup.ParticlePlus.Lib.ItemListener;

public class aw extends JavaPlugin{
	public String ip;
	public String ipall;
	public String pr;
	public String defaultpath;
	public EffectManager efm;
	public EffectLib efl;
	public int time;
	public static aw a;
	public FileManagerai filemanager;
	@SuppressWarnings("static-access")
	@Override
	public void onEnable() {
		this.a = this;
		new b().a();
		getServer().getPluginManager().registerEvents(new Listenerax(),this);
		getServer().getPluginManager().registerEvents(new ItemListener(), this);
	}
	@Override
	public void onDisable() {
		EffectLib.instance().disable();
		PlayParticleag.p.SaveAll();
		aw.a.getServer().getScheduler().cancelTasks(aw.a);
		new ab();
	}
	@Override
	public boolean onCommand(CommandSender a, Command b, String c, String[] d) {
		new onCmdbd(a, c, d);
		return true;
	}
}
