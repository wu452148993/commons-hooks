package cc.bukkitPlugin.commons.hooks.vaultHook;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import cc.bukkitPlugin.commons.plugin.ABukkitPlugin;
import cc.commons.util.StringUtil;
import net.milkbowl.vault.permission.Permission;

public class PermissionHook<T extends ABukkitPlugin<T>>{

    private T mPlugin;
    private Permission mPermission;
    private final boolean mInitSuccess;

    public PermissionHook(T pPlugin){
        this.mPlugin=pPlugin;
        this.mInitSuccess=false;
    }

    public PermissionHook(T pPlugin,Permission pPermission){
        this.mPlugin=pPlugin;
        this.mPermission=pPermission;
        this.mInitSuccess=true;
    }

    public boolean isValid(){
        return this.mInitSuccess;
    }

    public boolean bukkitHasPermission(String pPlayerName,String pPermissionName){
        return this.bukkitHasPermission(StringUtil.isEmpty(pPlayerName)?null:Bukkit.getPlayer(pPlayerName),pPermissionName);
    }

    public boolean bukkitHasPermission(Player pPlayer,String pPermissionName){
        if(pPlayer==null||StringUtil.isEmpty(pPermissionName))
            return false;
        return pPlayer.hasPermission(pPermissionName);
    }

    public String getName(){
        return this.isValid()?this.mPermission.getName():"FailPermissionPlugin";
    }

    public boolean isEnabled(){
        return this.isValid()&&this.mPermission.isEnabled();
    }

    public boolean hasSuperPermsCompat(){
        return this.isValid()&&this.mPermission.hasSuperPermsCompat();
    }

    @Deprecated
    public boolean has(String pWorldName,String pPlayerName,String pPermissionName){
        if(this.isValid()){
            return this.mPermission.playerHas(pWorldName,pPlayerName,pPermissionName);
        }else{
            return this.bukkitHasPermission(pPlayerName,pPermissionName);
        }
    }

    @Deprecated
    public boolean has(World pWorld,String pPlayerName,String pPermissionName){
        return this.has(pWorld==null?null:pWorld.getName(),pPlayerName,pPermissionName);
    }

    public boolean has(CommandSender pSender,String pPermissionName){
        return pSender!=null&&pSender.hasPermission(pPermissionName);
    }

    public boolean has(Player pPlayer,String pPermissionName){
        if(pPlayer==null){
            return this.has((String)null,(String)null,pPermissionName);
        }else{
            return this.has(pPlayer.getWorld(),pPlayer.getName(),pPermissionName);
        }
    }

    @Deprecated
    public boolean playerHas(String pWorldName,String pPlayerName,String pPermissionName){
        if(this.isValid()){
            return this.mPermission.playerHas(pWorldName,pPlayerName,pPermissionName);
        }else{
            return this.bukkitHasPermission(pPlayerName,pPermissionName);
        }
    }

    @Deprecated
    public boolean playerHas(World pWorld,String pPlayerName,String pPermissionName){
        return this.playerHas(pWorld==null?(String)null:pWorld.getName(),pPlayerName,pPermissionName);
    }

    public boolean playerHas(String pWorldName,OfflinePlayer pPlayer,String pPermissionName){
        return this.playerHas(pWorldName,pPlayer==null?null:pPlayer.getName(),pPermissionName);
    }

    public boolean playerHas(Player pPlayer,String pPermissionName){
        if(pPlayer==null){
            return this.has((String)null,null,pPermissionName);
        }else{
            return this.has(pPlayer.getWorld(),pPlayer.getName(),pPermissionName);
        }
    }

    @Deprecated
    public boolean playerAdd(String pWorldName,String pPlayerName,String pPermissionName){
        return this.isValid()&&this.mPermission.playerAdd(pWorldName,pPlayerName,pPermissionName);
    }

    @Deprecated
    public boolean playerAdd(World pWorld,String pPlayerName,String pPermissionName){
        return this.playerAdd(pWorld==null?null:pWorld.getName(),pPlayerName,pPermissionName);
    }

    public boolean playerAdd(String pWorldName,OfflinePlayer pPlayer,String pPermissionName){
        return this.playerAdd(pWorldName,pPlayer==null?null:pPlayer.getName(),pPermissionName);
    }

    public boolean playerAdd(Player pPlayer,String pPermissionName){
        if(pPlayer==null){
            return this.playerAdd((String)null,(String)null,pPermissionName);
        }else{
            return this.playerAdd(pPlayer.getWorld(),pPlayer.getName(),pPermissionName);
        }
    }

    @Deprecated
    public boolean playerRemove(String pWorldName,String pPlayerName,String pPermissionName){
        return this.isValid()&&this.mPermission.playerRemove(pWorldName,pPlayerName,pPermissionName);
    }

    public boolean playerRemove(String pWorldName,OfflinePlayer pPlayer,String pPermissionName){
        return this.playerRemove(pWorldName,pPlayer==null?null:pPlayer.getName(),pPermissionName);
    }

    @Deprecated
    public boolean playerRemove(World pWorld,String pPlayerName,String pPermissionName){
        return this.playerRemove(pWorld==null?null:pWorld.getName(),pPlayerName,pPermissionName);
    }

    public boolean playerRemove(Player pPlayer,String pPermissionName){
        if(pPlayer==null){
            return this.playerRemove((String)null,(String)null,pPermissionName);
        }else{
            return playerRemove(pPlayer.getWorld(),pPlayer.getName(),pPermissionName);
        }
    }

    public boolean groupHas(String pWorldName,String pGroupName,String pPermissionName){
        return this.isValid()&&this.mPermission.groupHas(pWorldName,pGroupName,pPermissionName);
    }

    public boolean groupHas(World pWorld,String pGroupName,String pPermissionName){
        return this.groupHas(pWorld==null?null:pWorld.getName(),pGroupName,pPermissionName);
    }

    public boolean groupAdd(String pWorldName,String pGroupName,String pPermissionName){
        return this.isValid()&&this.mPermission.groupAdd(pWorldName,pGroupName,pPermissionName);
    }

    public boolean groupAdd(World pWorld,String pGroupName,String pPermissionName){
        return this.groupAdd(pWorld==null?null:pWorld.getName(),pGroupName,pPermissionName);
    }

    public boolean groupRemove(String pWorldName,String pGroupName,String pPermissionName){
        return this.isValid()&&this.mPermission.groupRemove(pWorldName,pGroupName,pPermissionName);
    }

    public boolean groupRemove(World pWorld,String pGroupName,String pPermissionName){
        return this.groupRemove(pWorld==null?null:pWorld.getName(),pGroupName,pPermissionName);
    }

    @Deprecated
    public boolean playerInGroup(String pWorldName,String pPlayerName,String pGroupName){
        return this.isValid()&&this.mPermission.playerInGroup(pWorldName,pPlayerName,pGroupName);
    }

    @Deprecated
    public boolean playerInGroup(World pWorld,String pPlayerName,String pGroupName){
        return this.playerInGroup(pWorld==null?null:pWorld.getName(),pPlayerName,pGroupName);
    }

    public boolean playerInGroup(String pWorldName,OfflinePlayer pPlayer,String pGroupName){
        return this.playerInGroup(pWorldName,pPlayer==null?null:pPlayer.getName(),pGroupName);
    }

    public boolean playerInGroup(Player pPlayer,String pGroupName){
        if(pPlayer==null){
            return this.playerInGroup((String)null,(String)null,pGroupName);
        }else{
            return this.playerInGroup(pPlayer.getWorld(),pPlayer.getName(),pGroupName);
        }
    }

    @Deprecated
    public boolean playerAddGroup(String pWorldName,String pPlayerName,String pGroupName){
        return this.isValid()&&this.mPermission.playerAddGroup(pWorldName,pPlayerName,pGroupName);
    }

    @Deprecated
    public boolean playerAddGroup(World pWorld,String pPlayerName,String pGroupName){
        return this.playerAddGroup(pWorld==null?null:pWorld.getName(),pPlayerName,pGroupName);
    }

    public boolean playerAddGroup(String pWorldName,OfflinePlayer pPlayer,String pGroupName){
        return this.playerAddGroup(pWorldName,pPlayer==null?null:pPlayer.getName(),pGroupName);
    }

    public boolean playerAddGroup(Player pPlayer,String pGroupName){
        if(pPlayer==null)
            return false;
        return playerAddGroup(pPlayer.getWorld(),pPlayer.getName(),pGroupName);
    }

    @Deprecated
    public boolean playerRemoveGroup(String pWorldName,String pPlayerName,String pGroupName){
        return this.isValid()&&this.mPermission.playerRemoveGroup(pWorldName,pPlayerName,pGroupName);
    }

    @Deprecated
    public boolean playerRemoveGroup(World pWorld,String pPlayerName,String pGroupName){
        return this.playerRemoveGroup(pWorld==null?null:pWorld.getName(),pPlayerName,pGroupName);
    }

    public boolean playerRemoveGroup(String pWorldName,OfflinePlayer pPlayer,String pGroupName){
        return this.playerRemoveGroup(pWorldName,pPlayer==null?null:pPlayer.getName(),pGroupName);
    }

    public boolean playerRemoveGroup(Player pPlayer,String pGroupName){
        if(pPlayer==null){
            return this.playerRemoveGroup((String)null,(String)null,pGroupName);
        }else{
            return this.playerRemoveGroup(pPlayer.getWorld(),pPlayer.getName(),pGroupName);
        }
    }

    @Deprecated
    public String[] getPlayerGroups(String pWorldName,String pPlayerName){
        return this.isValid()?this.mPermission.getPlayerGroups(pWorldName,pPlayerName):new String[0];
    }

    @Deprecated
    public String[] getPlayerGroups(World pWorld,String pPlayerName){
        return this.getPlayerGroups(pWorld==null?null:pWorld.getName(),pPlayerName);
    }

    public String[] getPlayerGroups(String pWorldName,OfflinePlayer pPlayer){
        return this.getPlayerGroups(pWorldName,pPlayer==null?null:pPlayer.getName());
    }

    public String[] getPlayerGroups(Player pPlayer){
        if(pPlayer==null){
            return this.getPlayerGroups((String)null,(String)null);
        }else{
            return this.getPlayerGroups(pPlayer.getWorld(),pPlayer.getName());
        }
    }

    @Deprecated
    public String getPrimaryGroup(String pWorldName,String pPlayerName){
        return this.isValid()?this.mPermission.getPrimaryGroup(pWorldName,pPlayerName):null;
    }

    @Deprecated
    public String getPrimaryGroup(World pWorld,String pPlayerName){
        return this.getPrimaryGroup(pWorld==null?null:pWorld.getName(),pPlayerName);
    }

    public String getPrimaryGroup(String pWorldName,OfflinePlayer pPlayer){
        return this.getPrimaryGroup(pWorldName,pPlayer==null?null:pPlayer.getName());
    }

    public String getPrimaryGroup(Player pPlayer){
        if(pPlayer==null){
            return null;
        }
        return getPrimaryGroup(pPlayer.getWorld(),pPlayer.getName());
    }

    public String[] getGroups(){
        return this.isValid()?this.mPermission.getGroups():new String[0];
    }

    public boolean hasGroupSupport(){
        return this.isValid()&&this.mPermission.hasGroupSupport();
    }
}
