package io.github.wysohn.main;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.minelink.ctplus.Tag;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CombatTagPlus extends PlaceholderExpansion {
    private net.minelink.ctplus.CombatTagPlus plugin;

    @Override
    public String getIdentifier() {
        return "combat-tag-plus";
    }

    @Override
    public String getAuthor() {
        return "wysohn";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean canRegister() {
        return Bukkit.getPluginManager().isPluginEnabled("CombatTagPlus");
    }

    @Override
    public boolean register() {
        if(canRegister())
            plugin = (net.minelink.ctplus.CombatTagPlus) Bukkit.getPluginManager().getPlugin("CombatTagPlus");

        return super.register();
    }

    @Override
    public String onPlaceholderRequest(Player p, String params) {
        if(p == null)
            return "";

        Tag tag = plugin.getTagManager().getTag(p.getUniqueId());
        if(tag == null)
            return "0";

        //"%combat-tag-plus_time-left%"
        if("time-left".equals(params)){
            return String.valueOf(tag.getTagDuration());
        }

        return null;
    }
}
