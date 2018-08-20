package cc.bukkitPlugin.commons.hooks.vaultHook;

import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;

import cc.bukkitPlugin.commons.plugin.ABukkitPlugin;
import net.milkbowl.vault.chat.Chat;

public class ChatHook<T extends ABukkitPlugin<T>>{

    private T mPlugin;
    private Chat mChat;
    private final boolean mInitSuccess;

    public ChatHook(T pPlugin){
        this.mPlugin=pPlugin;
        this.mInitSuccess=false;
    }

    public ChatHook(T pPlugin,Chat pChat){
        this.mPlugin=pPlugin;
        if(pChat==null){
            throw new NullPointerException();
        }
        this.mChat=pChat;
        this.mInitSuccess=true;
    }

    public boolean isValid(){
        return this.mInitSuccess;
    }

    public String getName(){
        return this.isValid()?this.mChat.getName():"FailChatPlugin";
    }

    public boolean isEnabled(){
        return this.isValid()&&this.mChat.isEnabled();
    }

    @Deprecated
    public String getPlayerPrefix(String pWordName,String pPlayerName){
        return this.isValid()?this.mChat.getPlayerPrefix(pWordName,pPlayerName):"";
    }

    public String getPlayerPrefix(String pWordName,OfflinePlayer pPlayer){
        return this.getPlayerPrefix(pWordName,pPlayer==null?null:pPlayer.getName());
    }

    @Deprecated
    public String getPlayerPrefix(World pWorld,String pPlayerName){
        return this.getPlayerPrefix(pWorld==null?null:pWorld.getName(),pPlayerName);
    }

    public String getPlayerPrefix(Player pPlayer){
        if(pPlayer==null)
            return "";
        return this.getPlayerPrefix(pPlayer.getWorld(),pPlayer.getName());
    }

    @Deprecated
    public void setPlayerPrefix(String pWorldName,String pPlayerName,String pPrefix){
        if(this.isValid()){
            this.mChat.setPlayerPrefix(pWorldName,pPlayerName,pPrefix);
        }
    }

    public void setPlayerPrefix(String pWorldName,OfflinePlayer pPlayer,String pPrefix){
        this.setPlayerPrefix(pWorldName,pPlayer==null?null:pPlayer.getName(),pPrefix);
    }

    @Deprecated
    public void setPlayerPrefix(World pWorld,String pPlayerName,String pPrefix){
        this.setPlayerPrefix(pWorld==null?null:pWorld.getName(),pPlayerName,pPrefix);
    }

    public void setPlayerPrefix(Player pPlayer,String pPrefix){
        if(pPlayer==null)
            return;
        this.setPlayerPrefix(pPlayer.getWorld(),pPlayer.getName(),pPrefix);
    }

    @Deprecated
    public String getPlayerSuffix(String pWorldName,String pPlayerName){
        return this.isValid()?this.mChat.getPlayerSuffix(pWorldName,pPlayerName):"";
    }

    public String getPlayerSuffix(String pWorldName,OfflinePlayer pPlayer){
        return this.getPlayerSuffix(pWorldName,pPlayer==null?null:pPlayer.getName());
    }

    @Deprecated
    public String getPlayerSuffix(World pWorld,String pPlayerName){
        return this.getPlayerSuffix(pWorld==null?null:pWorld.getName(),pPlayerName);
    }

    public String getPlayerSuffix(Player pPlayer){
        if(pPlayer==null)
            return "";
        return this.getPlayerSuffix(pPlayer.getWorld(),pPlayer.getName());
    }

    @Deprecated
    public void setPlayerSuffix(String pWorldName,String pPlayerName,String pSuffix){
        if(this.isValid()){
            this.mChat.setPlayerSuffix(pWorldName,pPlayerName,pSuffix);
        }
    }

    public void setPlayerSuffix(String pWorldName,OfflinePlayer pPlayer,String pSuffix){
        this.setPlayerSuffix(pWorldName,pPlayer==null?null:pPlayer.getName(),pSuffix);
    }

    @Deprecated
    public void setPlayerSuffix(World pWorld,String pPlayerName,String pSuffix){
        this.setPlayerSuffix(pWorld==null?null:pWorld.getName(),pPlayerName,pSuffix);
    }

    public void setPlayerSuffix(Player pPlayer,String pSuffix){
        if(pPlayer==null)
            return;
        this.setPlayerSuffix(pPlayer.getWorld(),pPlayer.getName(),pSuffix);
    }

    public String getGroupPrefix(String pWorldName,String pGroupName){
        return this.isValid()?this.mChat.getGroupPrefix(pWorldName,pGroupName):"";
    }

    public String getGroupPrefix(World pWorld,String pGroupName){
        return this.getGroupPrefix(pWorld==null?null:pWorld.getName(),pGroupName);
    }

    public void setGroupPrefix(String pWorldName,String pGroupName,String pPrefix){
        if(this.isValid()){
            this.mChat.setGroupPrefix(pWorldName,pGroupName,pPrefix);
        }
    }

    public void setGroupPrefix(World pWorld,String pGroupName,String pPrefix){
        this.setGroupPrefix(pWorld==null?null:pWorld.getName(),pGroupName,pPrefix);
    }

    public String getGroupSuffix(String pWorldName,String pGroupName){
        return this.isValid()?this.mChat.getGroupSuffix(pWorldName,pGroupName):"";
    }

    public String getGroupSuffix(World pWorld,String pGroupName){
        return this.getGroupSuffix(pWorld==null?null:pWorld.getName(),pGroupName);
    }

    public void setGroupSuffix(String pWorldName,String pGroupName,String pSuffix){
        if(this.isValid()){
            this.mChat.setGroupSuffix(pWorldName,pGroupName,pSuffix);
        }
    }

    public void setGroupSuffix(World pWorld,String pGroupName,String pSuffix){
        this.setGroupSuffix(pWorld==null?null:pWorld.getName(),pGroupName,pSuffix);
    }

    @Deprecated
    public int getPlayerInfoInteger(String pWorldName,String pPlayerName,String pNodeName,int pDefaultValue){
        return this.isValid()?this.mChat.getPlayerInfoInteger(pWorldName,pPlayerName,pNodeName,pDefaultValue):pDefaultValue;
    }

    @Deprecated
    public int getPlayerInfoInteger(World pWorld,String pPlayerName,String pNodeName,int pDefaultValue){
        return this.getPlayerInfoInteger(pWorld==null?null:pWorld.getName(),pPlayerName,pNodeName,pDefaultValue);
    }

    public int getPlayerInfoInteger(Player pPlayer,String pNodeName,int pDefaultValue){
        if(pPlayer==null)
            return pDefaultValue;
        return this.getPlayerInfoInteger(pPlayer.getWorld(),pPlayer.getName(),pNodeName,pDefaultValue);
    }

    @Deprecated
    public void setPlayerInfoInteger(String pWorldName,String pPlayerName,String pNodeName,int pValue){
        if(this.isValid()){
            this.mChat.setPlayerInfoInteger(pWorldName,pPlayerName,pNodeName,pValue);
        }
    }

    public void setPlayerInfoInteger(String pWorldName,OfflinePlayer pPlayer,String pNodeName,int pValue){
        this.setPlayerInfoInteger(pWorldName,pPlayer==null?null:pPlayer.getName(),pNodeName,pValue);
    }

    @Deprecated
    public void setPlayerInfoInteger(World pWorld,String pPlayerName,String pNodeName,int pValue){
        this.setPlayerInfoInteger(pWorld==null?null:pWorld.getName(),pPlayerName,pNodeName,pValue);
    }

    public void setPlayerInfoInteger(Player pPlayer,String pNodeName,int pValue){
        if(pPlayer!=null){
            this.setPlayerInfoInteger(pPlayer.getWorld(),pPlayer.getName(),pNodeName,pValue);
        }
    }

    public int getGroupInfoInteger(String pWorldName,String pGroupName,String pNodeName,int pDefaultValue){
        return this.isValid()?this.mChat.getGroupInfoInteger(pWorldName,pGroupName,pNodeName,pDefaultValue):pDefaultValue;
    }

    public int getGroupInfoInteger(World pWorld,String pGroupName,String pNodeName,int pDefaultValue){
        return this.getGroupInfoInteger(pWorld==null?null:pWorld.getName(),pGroupName,pNodeName,pDefaultValue);
    }

    public void setGroupInfoInteger(String pWorldName,String pGroupName,String pNodeName,int pDefaultValue){
        if(this.isValid()){
            this.mChat.setGroupInfoInteger(pWorldName,pGroupName,pNodeName,pDefaultValue);
        }
    }

    public void setGroupInfoInteger(World pWorld,String pGroupName,String pNodeName,int pDefaultValue){
        this.setGroupInfoInteger(pWorld==null?null:pWorld.getName(),pGroupName,pNodeName,pDefaultValue);
    }

    @Deprecated
    public double getPlayerInfoDouble(String pWorldName,String pPlayerName,String pNodeName,double pDefaultValue){
        return this.isValid()?this.mChat.getPlayerInfoDouble(pWorldName,pPlayerName,pNodeName,pDefaultValue):pDefaultValue;
    }

    @Deprecated
    public double getPlayerInfoDouble(World pWorld,String pPlayerName,String pNodeName,double pDefaultValue){
        return this.getPlayerInfoDouble(pWorld==null?null:pWorld.getName(),pPlayerName,pNodeName,pDefaultValue);
    }

    public double getPlayerInfoDouble(Player pPlayer,String pNodeName,double pDefaultValue){
        if(pPlayer==null)
            return pDefaultValue;
        return this.getPlayerInfoDouble(pPlayer.getWorld(),pPlayer.getName(),pNodeName,pDefaultValue);
    }

    @Deprecated
    public void setPlayerInfoDouble(String pWorldName,String pPlayerName,String pNodeName,double pValue){
        if(this.isValid()){
            this.mChat.setPlayerInfoDouble(pWorldName,pPlayerName,pNodeName,pValue);
        }
    }

    public void setPlayerInfoDouble(String pWorldName,OfflinePlayer pPlayer,String pNodeName,double pValue){
        this.setPlayerInfoDouble(pWorldName,pPlayer==null?null:pPlayer.getName(),pNodeName,pValue);
    }

    @Deprecated
    public void setPlayerInfoDouble(World pWorld,String pPlayerName,String pNodeName,double pValue){
        this.setPlayerInfoDouble(pWorld==null?null:pWorld.getName(),pPlayerName,pNodeName,pValue);
    }

    public void setPlayerInfoDouble(Player pPlayer,String pNodeName,double pValue){
        if(pPlayer!=null){
            this.setPlayerInfoDouble(pPlayer.getWorld(),pPlayer.getName(),pNodeName,pValue);
        }
    }

    public double getGroupInfoDouble(String pWorldName,String pGroupName,String pNodeName,double pDefaultValue){
        return this.isValid()?this.mChat.getGroupInfoDouble(pWorldName,pGroupName,pNodeName,pDefaultValue):pDefaultValue;
    }

    public double getGroupInfoDouble(World pWorld,String pGroupName,String pNodeName,double pDefaultValue){
        return this.getGroupInfoDouble(pWorld==null?null:pWorld.getName(),pGroupName,pNodeName,pDefaultValue);
    }

    public void setGroupInfoDouble(String pWorldName,String pGroupName,String pNodeName,double pDefaultValue){
        if(this.isValid()){
            this.mChat.setGroupInfoDouble(pWorldName,pGroupName,pNodeName,pDefaultValue);
        }
    }

    public void setGroupInfoDouble(World pWorld,String pGroupName,String pNodeName,double pDefaultValue){
        this.setGroupInfoDouble(pWorld==null?null:pWorld.getName(),pGroupName,pNodeName,pDefaultValue);
    }

    public boolean getPlayerInfoBoolean(String pWorldName,OfflinePlayer pPlayer,String pNodeName,boolean pDefaultValue){
        return this.getPlayerInfoBoolean(pWorldName,pPlayer==null?null:pPlayer.getName(),pNodeName,pDefaultValue);
    }

    @Deprecated
    public boolean getPlayerInfoBoolean(String pWorldName,String pPlayerName,String pNodeName,boolean pDefaultValue){
        return this.isValid()?this.mChat.getPlayerInfoBoolean(pWorldName,pPlayerName,pNodeName,pDefaultValue):pDefaultValue;
    }

    @Deprecated
    public boolean getPlayerInfoBoolean(World pWorld,String pPlayerName,String pNodeName,boolean pDefaultValue){
        return this.getPlayerInfoBoolean(pWorld==null?null:pWorld.getName(),pPlayerName,pNodeName,pDefaultValue);
    }

    public boolean getPlayerInfoBoolean(Player pPlayer,String pNodeName,boolean pDefaultValue){
        if(pPlayer==null)
            return pDefaultValue;
        return this.getPlayerInfoBoolean(pPlayer.getWorld(),pPlayer.getName(),pNodeName,pDefaultValue);
    }

    @Deprecated
    public void setPlayerInfoBoolean(String pWorldName,String pPlayerName,String pNodeName,boolean pValue){
        if(this.isValid()){
            this.mChat.setPlayerInfoBoolean(pWorldName,pPlayerName,pNodeName,pValue);
        }
    }

    public void setPlayerInfoBoolean(String pWorldName,OfflinePlayer pPlayer,String pNodeName,boolean pValue){
        this.setPlayerInfoBoolean(pWorldName,pPlayer==null?null:pPlayer.getName(),pNodeName,pValue);
    }

    @Deprecated
    public void setPlayerInfoBoolean(World pWorld,String pPlayerName,String pNodeName,boolean pValue){
        this.setPlayerInfoBoolean(pWorld==null?null:pWorld.getName(),pPlayerName,pNodeName,pValue);
    }

    public void setPlayerInfoBoolean(Player pPlayer,String pNodeName,boolean pValue){
        if(pPlayer!=null){
            this.setPlayerInfoBoolean(pPlayer.getWorld(),pPlayer.getName(),pNodeName,pValue);
        }
    }

    public boolean getGroupInfoBoolean(String pWorldName,String pGroupName,String pNodeName,boolean pDefaultValue){
        return this.isValid()?this.mChat.getGroupInfoBoolean(pWorldName,pGroupName,pNodeName,pDefaultValue):pDefaultValue;
    }

    public boolean getGroupInfoBoolean(World pWorld,String pGroupName,String pNodeName,boolean pDefaultValue){
        return this.getGroupInfoBoolean(pWorld==null?null:pWorld.getName(),pGroupName,pNodeName,pDefaultValue);
    }

    public void setGroupInfoBoolean(String pWorldName,String pGroupName,String pNodeName,boolean pDefaultValue){
        if(this.isValid()){
            this.mChat.setGroupInfoBoolean(pWorldName,pGroupName,pNodeName,pDefaultValue);
        }
    }

    public void setGroupInfoBoolean(World pWorld,String pGroupName,String pNodeName,boolean pDefaultValue){
        this.setGroupInfoBoolean(pWorld==null?null:pWorld.getName(),pGroupName,pNodeName,pDefaultValue);
    }

    @Deprecated
    public String getPlayerInfoString(String pWorldName,String pPlayerName,String pNodeName,String pDefaultValue){
        return this.isValid()?this.mChat.getPlayerInfoString(pWorldName,pPlayerName,pNodeName,pDefaultValue):pDefaultValue;
    }

    @Deprecated
    public String getPlayerInfoString(World pWorld,String pPlayerName,String pNodeName,String pDefaultValue){
        return this.getPlayerInfoString(pWorld==null?null:pWorld.getName(),pPlayerName,pNodeName,pDefaultValue);
    }

    public String getPlayerInfoString(Player pPlayer,String pNodeName,String pDefaultValue){
        if(pPlayer==null)
            return pDefaultValue;
        return this.getPlayerInfoString(pPlayer.getWorld(),pPlayer.getName(),pNodeName,pDefaultValue);
    }

    @Deprecated
    public void setPlayerInfoString(String pWorldName,String pPlayerName,String pNodeName,String pValue){
        if(this.isValid()){
            this.mChat.setPlayerInfoString(pWorldName,pPlayerName,pNodeName,pValue);
        }
    }

    public void setPlayerInfoString(String pWorldName,OfflinePlayer pPlayer,String pNodeName,String pValue){
        this.setPlayerInfoString(pWorldName,pPlayer==null?null:pPlayer.getName(),pNodeName,pValue);
    }

    @Deprecated
    public void setPlayerInfoString(World pWorld,String pPlayerName,String pNodeName,String pValue){
        this.setPlayerInfoString(pWorld==null?null:pWorld.getName(),pPlayerName,pNodeName,pValue);
    }

    public void setPlayerInfoString(Player pPlayer,String pNodeName,String pValue){
        if(pPlayer!=null){
            this.setPlayerInfoString(pPlayer.getWorld(),pPlayer.getName(),pNodeName,pValue);
        }
    }

    public String getGroupInfoString(String pWorldName,String pGroupName,String pNodeName,String pDefaultValue){
        return this.isValid()?this.mChat.getGroupInfoString(pWorldName,pGroupName,pNodeName,pDefaultValue):pDefaultValue;
    }

    public String getGroupInfoString(World pWorld,String pGroupName,String pNodeName,String pDefaultValue){
        return this.getGroupInfoString(pWorld==null?null:pWorld.getName(),pGroupName,pNodeName,pDefaultValue);
    }

    public void setGroupInfoString(String pWorldName,String pGroupName,String pNodeName,String pDefaultValue){
        if(this.isValid()){
            this.mChat.setGroupInfoString(pWorldName,pGroupName,pNodeName,pDefaultValue);
        }
    }

    public void setGroupInfoString(World pWorld,String pGroupName,String pNodeName,String pDefaultValue){
        this.setGroupInfoString(pWorld==null?null:pWorld.getName(),pGroupName,pNodeName,pDefaultValue);
    }

    @Deprecated
    public boolean playerInGroup(String pWorldName,String pPlayerName,String pGroupName){
        return this.isValid()&&this.mChat.playerInGroup(pWorldName,pPlayerName,pGroupName);
    }

    public boolean playerInGroup(String pWorldName,OfflinePlayer pPlayer,String pGroupName){
        return this.playerInGroup(pWorldName,pPlayer==null?null:pPlayer.getName(),pGroupName);
    }

    @Deprecated
    public boolean playerInGroup(World pWorld,String pPlayerName,String pGroupName){
        return this.playerInGroup(pWorld==null?null:pWorld.getName(),pPlayerName,pGroupName);
    }

    public boolean playerInGroup(Player pPlayer,String pGroupName){
        if(pPlayer==null)
            return false;
        return this.playerInGroup(pPlayer.getWorld(),pPlayer.getName(),pGroupName);
    }

    public String[] getPlayerGroups(String pWorldName,OfflinePlayer pPlayer){
        return this.getPlayerGroups(pWorldName,pPlayer==null?null:pPlayer.getName());
    }

    @Deprecated
    public String[] getPlayerGroups(String pWorldName,String pPlayerName){
        return this.isValid()?this.mChat.getPlayerGroups(pWorldName,pPlayerName):new String[0];
    }

    @Deprecated
    public String[] getPlayerGroups(World pWorld,String pPlayerName){
        return this.getPlayerGroups(pWorld==null?null:pWorld.getName(),pPlayerName);
    }

    public String[] getPlayerGroups(Player pPlayer){
        if(pPlayer==null)
            return new String[0];
        return this.getPlayerGroups(pPlayer.getWorld(),pPlayer.getName());
    }

    public String getPrimaryGroup(String pWorldName,OfflinePlayer pPlayer){
        return this.getPrimaryGroup(pWorldName,pPlayer==null?null:pPlayer.getName());
    }

    @Deprecated
    public String getPrimaryGroup(String pWorldName,String pPlayerName){
        return this.isValid()?this.mChat.getPrimaryGroup(pWorldName,pPlayerName):null;
    }

    @Deprecated
    public String getPrimaryGroup(World pWorld,String pPlayerName){
        return this.getPrimaryGroup(pWorld==null?null:pWorld.getName(),pPlayerName);
    }

    public String getPrimaryGroup(Player pPlayer){
        if(pPlayer==null)
            return null;
        return this.getPrimaryGroup(pPlayer.getWorld(),pPlayer.getName());
    }

    public String[] getGroups(){
        return this.isValid()?this.mChat.getGroups():new String[0];
    }
}
