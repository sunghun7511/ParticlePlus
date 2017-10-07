package com.SHGroup.ParticlePlus;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import com.SHGroup.ParticlePlus.Lib.ArcEffect;
import com.SHGroup.ParticlePlus.Lib.AtomEffect;
import com.SHGroup.ParticlePlus.Lib.BigBangEffect;
import com.SHGroup.ParticlePlus.Lib.BleedEffect;
import com.SHGroup.ParticlePlus.Lib.ConeEffect;
import com.SHGroup.ParticlePlus.Lib.DnaEffect;
import com.SHGroup.ParticlePlus.Lib.EarthEffect;
import com.SHGroup.ParticlePlus.Lib.Effect;
import com.SHGroup.ParticlePlus.Lib.ExplodeEffect;
import com.SHGroup.ParticlePlus.Lib.FlameEffect;
import com.SHGroup.ParticlePlus.Lib.FountainEffect;
import com.SHGroup.ParticlePlus.Lib.GridEffect;
import com.SHGroup.ParticlePlus.Lib.HelixEffect;
import com.SHGroup.ParticlePlus.Lib.JumpEffect;
import com.SHGroup.ParticlePlus.Lib.LineEffect;
import com.SHGroup.ParticlePlus.Lib.LoveEffect;
import com.SHGroup.ParticlePlus.Lib.MusicEffect;
import com.SHGroup.ParticlePlus.Lib.ParticleEffect;
import com.SHGroup.ParticlePlus.Lib.ShieldEffect;
import com.SHGroup.ParticlePlus.Lib.SkyRocketEffect;
import com.SHGroup.ParticlePlus.Lib.SmokeEffect;
import com.SHGroup.ParticlePlus.Lib.StarEffect;
import com.SHGroup.ParticlePlus.Lib.TraceEffect;
import com.SHGroup.ParticlePlus.Lib.TurnEffect;
import com.SHGroup.ParticlePlus.Lib.VortexEffect;
import com.SHGroup.ParticlePlus.Lib.WarpEffect;
import com.SHGroup.ParticlePlus.Lib.WaveEffect;

public class PlayParticleag {
	public static ArrayList<Exhibitionau> a = new ArrayList<Exhibitionau>();
	public static HashMap<String, Effect> pe = new HashMap<String, Effect>();
	private static BukkitScheduler sch;
	public static PlayParticleag p;
	@SuppressWarnings("static-access")
	public PlayParticleag(){
		this.p = this;
		sch = Bukkit.getScheduler();
		FileManagerai.load();
		sch.scheduleSyncRepeatingTask(aw.a, new Runnable(){
			@Override
			public void run() {
				for(int i = 0 ; i < a.size() ; i ++){
					Entity e = a.get(i).l.getWorld().spawnEntity(a.get(i).l,EntityType.SNOWBALL);
					e.remove();
					display(a.get(i).l, a.get(i).p, a.get(i).t, e);
				}
			}
		}, 2L, 2L);
	}
	public static ArrayList<Exhibitionau> getExhibitionau(){
		return a;
	}
	public static Location getLoc(int index){
		try{
			return a.get(index).l;
		}catch(Exception ex){
			return null;
		}
	}
	public static ParticleEffect geteffectType(int index){
		try{
			return a.get(index).p;
		}catch(Exception ex){
			return null;
		}
	}
	public static ParticleTypear getParticleType(int index){
		try{
			return a.get(index).t;
		}catch(Exception ex){
			return null;
		}
	}
	public static void PlayParticleCustom(Location l, ParticleTypear s, ParticleEffect ss){
		Exhibitionau e = new Exhibitionau(l,ss,s);
		PlayParticleag.p.SaveAll();
		a.add(e);
	}
	public static void editPlayParticle(int index, Location location,
			ParticleTypear sha, ParticleEffect pe2) {

		Exhibitionau e = a.get(index);
		e.l = location;
		e.p = pe2;
		e.t = sha;
		a.set(index, e);
		PlayParticleag.p.SaveAll();
	}
	public static void display(Location i, ParticleEffect e, ParticleTypear type, Entity es){
		switch(type){
		case ARC:
			{
				ArcEffect c = new ArcEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.iterations = 1;
				c.particle = e;
				c.start();
			}
			break;
		case ATOM:
			{
				AtomEffect c = new AtomEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.iterations = 1;
				c.particleNucleus = e;
				c.particleOrbital = e;
				c.start();
			}
			break;
		case BIG_BANG:
			{
				BigBangEffect c = new BigBangEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.iterations = 1;
				c.fireworkType = Type.BALL;
				c.start();
			}
			break;
		case BLEED:
			{
				BleedEffect c = new BleedEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.iterations = 1;
				c.start();
			}
			break;
		case DEFAULT:
			{
				ConeEffect c = new ConeEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.iterations = 1;
				c.particle = e;
				c.start();
			}
			break;
		case DNA:
			{
				DnaEffect c = new DnaEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.iterations = 1;
				c.particleBase1 = e;
				c.particleBase2 = e;
				c.start();
			}
			break;
		case EARTH:
			{
				EarthEffect c = new EarthEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.iterations = 1;
				c.start();
			}
			break;
		case EXPLODE:
			{
				ExplodeEffect c = new ExplodeEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.iterations = 1;
				c.start();
			}
			break;
		case FLAME:
			{
				FlameEffect c = new FlameEffect(aw.a.efm);
				c.iterations = 1;
				c.setTarget(i);c.setEntity(es);
				c.start();
			}
			break;
		case FOUNTAIN:
			{
				FountainEffect c = new FountainEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.particle = e;
				c.iterations = 1;
				c.start();
			}
			break;
		case GRID:
			{
				GridEffect c = new GridEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.particle = e;
				c.iterations = 1;
				c.start();
			}
			break;
		case HELIX:
			{
				HelixEffect c = new HelixEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.particle = e;
				c.iterations = 1;
				c.start();
			}
			break;
		case JUMP:
			{
				JumpEffect c = new JumpEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.iterations = 1;
				c.start();
			}
			break;
		case LINE:
			{
				LineEffect c = new LineEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.particle = e;
				c.iterations = 1;
				c.start();
			}
			break;
		case LOVE:
			{
				LoveEffect c = new LoveEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.particle = e;
				c.iterations = 1;
				c.start();
			}
			break;
		case MUSIC:
			{
				MusicEffect c = new MusicEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.iterations = 1;
				c.start();
			}
			break;
		case SHIELD:
			{
				ShieldEffect c = new ShieldEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.particle = e;
				c.iterations = 1;
				c.start();
			}
			break;
		case SKYROCKET:
			{
				SkyRocketEffect c = new SkyRocketEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.iterations = 1;
				c.start();
			}
			break;
		case SMOKE:
			{
				SmokeEffect c = new SmokeEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.particle = e;
				c.iterations = 1;
				c.start();
			}
			break;
		case STAR:
			{
				StarEffect c = new StarEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.particle = e;
				c.iterations = 1;
				c.start();
			}
			break;
		case TRACE:
			{
				TraceEffect c = new TraceEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.particle = e;
				c.iterations = 1;
				c.start();
			}
			break;
		case TURNPLAYER:
			{
				TurnEffect c = new TurnEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.targetOffset = i.getDirection();
				c.iterations = 1;
				c.start();
			}
			break;
		case VORTEX:
			{
				VortexEffect c = new VortexEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.particle = e;
				c.iterations = 1;
				c.start();
			}
			break;
		case WARP:
			{
				WarpEffect c = new WarpEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.particle = e;
				c.iterations = 1;
				c.start();
			}
			break;
		case WAVE:
			{
				WaveEffect c = new WaveEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(es);
				c.particle = e;
				c.iterations = 1;
				c.start();
			}
			break;
		default:
			return;
		}
	}
	public static void stopPlayParticleCustom(int index){
		a.remove(index);
		PlayParticleag.p.SaveAll();
	}
	public static void stopPlayAllParticleCustom(){
		a.clear();
		PlayParticleag.p.SaveAll();
	}
	public void SaveAll(){
		try{
			File f = new File(aw.a.defaultpath + "\\Data\\exhibition.dat");
			if(!f.exists()){
				try{new File(aw.a.defaultpath + "\\Data\\").mkdirs();}catch(Exception e){}
				f.createNewFile();
			}
			String d = "";
			for(Exhibitionau e : a){
				if(d.equals("")){
					d = e.l.getWorld().getName() + "_" + Double.toString(e.l.getX()) + "_" + Double.toString(e.l.getY()) + "_" + Double.toString(e.l.getZ())
							+ ":" + e.p.toString() + ":" + e.t.toString();
				}else{
					d += "\n" + e.l.getWorld().getName() + "_" + Double.toString(e.l.getX()) + "_" + Double.toString(e.l.getY()) + "_" + Double.toString(e.l.getZ())
							+ ":" + e.p.toString() + ":" + e.t.toString();
				}
			}
			BufferedWriter br = new BufferedWriter(new FileWriter(f));
			br.append(d);
			br.flush();
			br.close();
			return;
		}catch(Exception ex){
			ex.printStackTrace();
			return;
		}
	}
	public static void PlayParticle(Player p, PlayerParticePlayTypeo b, Location l){
		if(!aw.a.filemanager.hasData(p.getName())){
			return;
		}
		if(pe.containsKey(p.getName())){
			Effect e = pe.get(p.getName());
			try{e.cancel();}catch(Exception ex){}
			pe.remove(p.getName());
		}
		Effect e = null;
		ParticleTypear type = aw.a.filemanager.getData(p.getName()).getType(b);
		Location i = p.getLocation();
		if(l != null){
			i = l;
		}
		switch(type){
		case ARC:
			{
				ArcEffect c = new ArcEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.particle = aw.a.filemanager.getData(p.getName()).getType2(b);
				c.start();
				e = c;
			}
			break;
		case ATOM:
			{
				AtomEffect c = new AtomEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.particleNucleus = aw.a.filemanager.getData(p.getName()).getType2(b);
				c.particleOrbital = aw.a.filemanager.getData(p.getName()).getType2(b);
				c.start();
				e = c;
			}
			break;
		case BIG_BANG:
			{
				BigBangEffect c = new BigBangEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.fireworkType = Type.BALL;
				c.start();
				e = c;
			}
			break;
		case BLEED:
			{
				BleedEffect c = new BleedEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case DEFAULT:
			{
				i = i.add(0,2,0);
				ConeEffect c = new ConeEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.particle = aw.a.filemanager.getData(p.getName()).getType2(b);
				c.start();
				e = c;
			}
			break;
		case DNA:
			{
				DnaEffect c = new DnaEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.particleBase1 = aw.a.filemanager.getData(p.getName()).getType2(b);
				c.particleBase2 = aw.a.filemanager.getData(p.getName()).getType2(b);
				c.start();
				e = c;
			}
			break;
		case EARTH:
			{
				i = i.add(0,1,0);
				EarthEffect c = new EarthEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case EXPLODE:
			{
				ExplodeEffect c = new ExplodeEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case FLAME:
			{
				FlameEffect c = new FlameEffect(aw.a.efm);
				c.iterations = 1;
				c.setTarget(i);c.setEntity(p);
				c.start();
				e = c;
			}
			break;
		case FOUNTAIN:
			{
				FountainEffect c = new FountainEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = aw.a.filemanager.getData(p.getName()).getType2(b);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case GRID:
			{
				GridEffect c = new GridEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = aw.a.filemanager.getData(p.getName()).getType2(b);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case HELIX:
			{
				i = i.add(0,2,0);
				HelixEffect c = new HelixEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = aw.a.filemanager.getData(p.getName()).getType2(b);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case JUMP:
			{
				JumpEffect c = new JumpEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case LINE:
			{
				LineEffect c = new LineEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = aw.a.filemanager.getData(p.getName()).getType2(b);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case LOVE:
			{
				LoveEffect c = new LoveEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = aw.a.filemanager.getData(p.getName()).getType2(b);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case MUSIC:
			{
				MusicEffect c = new MusicEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case SHIELD:
			{
				ShieldEffect c = new ShieldEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = aw.a.filemanager.getData(p.getName()).getType2(b);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case SKYROCKET:
			{
				SkyRocketEffect c = new SkyRocketEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case SMOKE:
			{
				SmokeEffect c = new SmokeEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = aw.a.filemanager.getData(p.getName()).getType2(b);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case STAR:
			{
				StarEffect c = new StarEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = aw.a.filemanager.getData(p.getName()).getType2(b);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case TRACE:
			{
				TraceEffect c = new TraceEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = aw.a.filemanager.getData(p.getName()).getType2(b);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case TURNPLAYER:
			{
				TurnEffect c = new TurnEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.targetOffset = i.getDirection();
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case VORTEX:
			{
				i = i.add(0,1,0);
				VortexEffect c = new VortexEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = aw.a.filemanager.getData(p.getName()).getType2(b);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case WARP:
			{
				WarpEffect c = new WarpEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = aw.a.filemanager.getData(p.getName()).getType2(b);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case WAVE:
			{
				WaveEffect c = new WaveEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = aw.a.filemanager.getData(p.getName()).getType2(b);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		default:
			return;
		}
		pe.put(p.getName(), e);
	}
	public void cancel(aw a,Player p){
		if(pe.containsKey(p.getName())){
			Effect e = pe.get(p.getName());
			e.cancel();
			pe.remove(p.getName());
		}
	}
	public static void PlayParticle(Player p, ParticleTypear type,
			ParticleEffect effect, Location i) {
		if(pe.containsKey(p.getName())){
			Effect e = pe.get(p.getName());
			try{e.cancel();}catch(Exception ex){}
			pe.remove(p.getName());
		}
		Effect e = null;
		switch(type){
		case ARC:
			{
				ArcEffect c = new ArcEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.particle = effect;
				c.start();
				e = c;
			}
			break;
		case ATOM:
			{
				AtomEffect c = new AtomEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.particleNucleus = effect;
				c.particleOrbital = effect;
				c.start();
				e = c;
			}
			break;
		case BIG_BANG:
			{
				BigBangEffect c = new BigBangEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.fireworkType = Type.BALL;
				c.start();
				e = c;
			}
			break;
		case BLEED:
			{
				BleedEffect c = new BleedEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case DEFAULT:
			{
				i = i.add(0,2,0);
				ConeEffect c = new ConeEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.particle = effect;
				c.start();
				e = c;
			}
			break;
		case DNA:
			{
				DnaEffect c = new DnaEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.particleBase1 = effect;
				c.particleBase2 = effect;
				c.start();
				e = c;
			}
			break;
		case EARTH:
			{
				i = i.add(0,1,0);
				EarthEffect c = new EarthEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case EXPLODE:
			{
				ExplodeEffect c = new ExplodeEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case FLAME:
			{
				FlameEffect c = new FlameEffect(aw.a.efm);
				c.iterations = 1;
				c.setTarget(i);c.setEntity(p);
				c.start();
				e = c;
			}
			break;
		case FOUNTAIN:
			{
				FountainEffect c = new FountainEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = effect;
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case GRID:
			{
				GridEffect c = new GridEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = effect;
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case HELIX:
			{
				i = i.add(0,2,0);
				HelixEffect c = new HelixEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = effect;
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case JUMP:
			{
				JumpEffect c = new JumpEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case LINE:
			{
				LineEffect c = new LineEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = effect;
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case LOVE:
			{
				LoveEffect c = new LoveEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = effect;
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case MUSIC:
			{
				MusicEffect c = new MusicEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case SHIELD:
			{
				ShieldEffect c = new ShieldEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = effect;
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case SKYROCKET:
			{
				SkyRocketEffect c = new SkyRocketEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case SMOKE:
			{
				SmokeEffect c = new SmokeEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = effect;
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case STAR:
			{
				StarEffect c = new StarEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = effect;
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case TRACE:
			{
				TraceEffect c = new TraceEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = effect;
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case TURNPLAYER:
			{
				TurnEffect c = new TurnEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.targetOffset = i.getDirection();
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case VORTEX:
			{
				i = i.add(0,1,0);
				VortexEffect c = new VortexEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = effect;
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case WARP:
			{
				WarpEffect c = new WarpEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = effect;
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		case WAVE:
			{
				WaveEffect c = new WaveEffect(aw.a.efm);
				c.setTarget(i);c.setEntity(p);
				c.particle = effect;
				c.iterations = 1;
				c.start();
				e = c;
			}
			break;
		default:
			return;
		}
		pe.put(p.getName(), e);
		
	}
}