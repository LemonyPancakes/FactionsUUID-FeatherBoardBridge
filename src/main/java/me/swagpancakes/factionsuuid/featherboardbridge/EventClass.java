package me.swagpancakes.factionsuuid.featherboardbridge;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.event.FPlayerJoinEvent;
import com.massivecraft.factions.event.FPlayerLeaveEvent;
import com.massivecraft.factions.event.FactionCreateEvent;
import com.massivecraft.factions.event.FactionDisbandEvent;

import be.maximvdw.featherboard.api.FeatherBoardAPI;

public class EventClass implements Listener {
    Main plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void FactionCreateEvent(FactionCreateEvent event) {
        FPlayer player = event.getFPlayer();

        FeatherBoardAPI.showScoreboard(player.getPlayer(), plugin.getConfig().getString("FactionsUUID.HasFaction"));

    }

    @EventHandler
    public void FactionDisbandEvent(FactionDisbandEvent event) {
        FPlayer player = event.getFPlayer();

        FeatherBoardAPI.showScoreboard(player.getPlayer(), plugin.getConfig().getString("FactionsUUID.NoFaction"));

    }

    @EventHandler
    public void FPlayerJoinEvent(FPlayerJoinEvent event) {
        FPlayer player = event.getfPlayer();

        FeatherBoardAPI.showScoreboard(player.getPlayer(), plugin.getConfig().getString("FactionsUUID.HasFaction"));

    }

    @EventHandler
    public void FPlayerLeaveEvent(FPlayerLeaveEvent event) {
        FPlayer player = event.getfPlayer();

        FeatherBoardAPI.showScoreboard(player.getPlayer(), plugin.getConfig().getString("FactionsUUID.NoFaction"));

    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        FPlayer fplayer = FPlayers.getInstance().getByPlayer(player);

        if(fplayer.hasFaction()) {
            FeatherBoardAPI.showScoreboard(player, plugin.getConfig().getString("FactionsUUID.HasFaction"));
        }else {
            FeatherBoardAPI.showScoreboard(player, plugin.getConfig().getString("FactionsUUID.NoFaction"));

        }


    }

}