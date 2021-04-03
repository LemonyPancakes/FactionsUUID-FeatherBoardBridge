package me.swagpancakes.factionsuuid.featherboardbridge;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.event.FactionCreateEvent;
import com.massivecraft.factions.event.FactionDisbandEvent;
import com.massivecraft.factions.event.FPlayerJoinEvent;
import com.massivecraft.factions.event.FPlayerLeaveEvent;

import be.maximvdw.featherboard.api.FeatherBoardAPI;
import fr.xephi.authme.api.v3.AuthMeApi;
import fr.xephi.authme.events.LoginEvent;
import fr.xephi.authme.events.LogoutEvent;
import fr.xephi.authme.events.RegisterEvent;
import fr.xephi.authme.events.RestoreSessionEvent;
import fr.xephi.authme.events.UnregisterByAdminEvent;
import fr.xephi.authme.events.UnregisterByPlayerEvent;

public class AuthMe implements Listener {
    Main plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        new BukkitRunnable() {

            @Override
            public void run() {
                Player player = event.getPlayer();
                FPlayer fplayer = FPlayers.getInstance().getByPlayer(player);

                if (!AuthMeApi.getInstance().isAuthenticated(player)) {
                    FeatherBoardAPI.showScoreboard(player, plugin.getConfig().getString("AuthMe.NotAuthenticated"));
                }

                if (AuthMeApi.getInstance().isAuthenticated(player)) {
                    if(fplayer.hasFaction()) {
                        FeatherBoardAPI.showScoreboard(player, plugin.getConfig().getString("FactionsUUID.HasFaction"));
                    } else{
                        FeatherBoardAPI.showScoreboard(player, plugin.getConfig().getString("FactionsUUID.NoFaction"));
                    }
                }

            }

        }.runTaskLater(plugin, plugin.getConfig().getLong("AuthMe.TicksToExecute"));
    }

    @EventHandler
    public void onRestoreSessionEvent(RestoreSessionEvent event) {
        Player player = event.getPlayer();
        FPlayer fplayer = FPlayers.getInstance().getByPlayer(player);

        if (fplayer.hasFaction()) {
            FeatherBoardAPI.showScoreboard(player, plugin.getConfig().getString("FactionsUUID.HasFaction"));

        }else{
            FeatherBoardAPI.showScoreboard(player, plugin.getConfig().getString("FactionsUUID.NoFaction"));

        }

    }

    @EventHandler
    public void onRegisterEvent(RegisterEvent event) {
        Player player = event.getPlayer();
        FPlayer fplayer = FPlayers.getInstance().getByPlayer(player);

        if (fplayer.hasFaction()) {
            FeatherBoardAPI.showScoreboard(player, plugin.getConfig().getString("FactionsUUID.HasFaction"));

        }else{
            FeatherBoardAPI.showScoreboard(player, plugin.getConfig().getString("FactionsUUID.NoFaction"));

        }

    }

    @EventHandler
    public void onUnregisterByPlayerEvent(UnregisterByPlayerEvent event) {
        Player player = event.getPlayer();
        FeatherBoardAPI.showScoreboard(player, plugin.getConfig().getString("AuthMe.NotAuthenticated"));
    }

    @EventHandler
    public void onUnregisterByAdminEvent(UnregisterByAdminEvent event) {
        Player player = event.getPlayer();

        if (player != null) {
            FeatherBoardAPI.showScoreboard(player, plugin.getConfig().getString("AuthMe.NotAuthenticated"));
        }
    }

    @EventHandler
    public void onLoginEvent(LoginEvent event) {
        Player player = event.getPlayer();
        FPlayer fplayer = FPlayers.getInstance().getByPlayer(player);

        if (fplayer.hasFaction()) {
            FeatherBoardAPI.showScoreboard(player, plugin.getConfig().getString("FactionsUUID.HasFaction"));

        }else{
            FeatherBoardAPI.showScoreboard(player, plugin.getConfig().getString("FactionsUUID.NoFaction"));

        }

    }

    @EventHandler
    public void onLogoutEvent(LogoutEvent event) {
        Player player = event.getPlayer();
        FeatherBoardAPI.showScoreboard(player, plugin.getConfig().getString("AuthMe.NotAuthenticated"));
    }

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

}