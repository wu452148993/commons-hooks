package cc.bukkitPlugin.commons.hooks.vaultHook;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;

import cc.bukkitPlugin.commons.Log;
import cc.bukkitPlugin.commons.plugin.ABukkitPlugin;
import cc.bukkitPlugin.commons.plugin.INeedReload;
import cc.bukkitPlugin.commons.plugin.manager.AManager;
import cc.bukkitPlugin.commons.plugin.manager.fileManager.ILangModel;
import cc.commons.commentedyaml.CommentedYamlConfig;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class VaultHook<T extends ABukkitPlugin<T>>extends AManager<T> implements INeedReload,ILangModel{

    private Plugin mVaultPlugin;

    private boolean mHookEconomy;
    private EconomyHook<T> mEconomy;

    private boolean mHookPermission;
    private PermissionHook<T> mPermission;

    private boolean mHookChat;
    private ChatHook<T> mChat;

    public VaultHook(T pPlugin,boolean pHookEconomy,boolean pHookPermission,boolean pHookChat){
        super(pPlugin);
        this.mHookEconomy=pHookEconomy;
        this.mHookPermission=pHookPermission;
        this.mHookChat=pHookChat;
        this.mPlugin.registerReloadModel(this);
        this.mPlugin.getLangManager().registerLangModel(this);
    }

//    @Override
    public boolean reloadConfig(CommandSender pSender){

        this.mVaultPlugin=Bukkit.getServer().getPluginManager().getPlugin("Vault");
        if(mVaultPlugin==null){
            Log.warn(this.mPlugin.C("MsgNoVaultPluginFound"));
            return false;
        }
        Log.info(this.mPlugin.C("MsgVaultPluginFound"));

        if(this.mHookEconomy)
            this.setupEconomy();
        if(this.mHookPermission)
            this.setupPermission();
        if(this.mHookChat)
            this.setupChat();

        return true;
    }

    protected boolean setupVault(){
        if(this.mVaultPlugin!=null)
            return true;

        if((this.mVaultPlugin==null&&(this.mVaultPlugin=Bukkit.getServer().getPluginManager().getPlugin("Vault"))==null)){
            Log.warn(this.mPlugin.C("MsgNoVaultPluginFound"));
            return false;
        }
        return true;
    }

    protected boolean setupEconomy(){
        this.mHookEconomy=true;
        if(this.mVaultPlugin==null&&!this.setupVault()){
            this.mEconomy=new EconomyHook<T>(this.mPlugin);
            return false;
        }
        this.mPlugin.getLangManager().reloadModel(this.getClass());
        RegisteredServiceProvider<Economy> economyProvider=Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
        if(economyProvider==null){
            Log.warn(this.mPlugin.C("MsgNoEconomyPluginFound"));
            this.mEconomy=new EconomyHook<T>(this.mPlugin);
            return false;
        }
        this.mEconomy=new EconomyHook<T>(this.mPlugin,economyProvider.getProvider());
        return true;
    }

    public EconomyHook<T> getEconomy(){
        if(this.mEconomy==null||!this.mEconomy.isValid()){
            this.setupEconomy();
        }
        return this.mEconomy;
    }

    protected boolean setupPermission(){
        this.mHookPermission=true;
        if(this.mVaultPlugin==null&&!this.setupVault()){
            this.mPermission=new PermissionHook<T>(this.mPlugin);
            return false;
        }
        this.mPlugin.getLangManager().reloadModel(this.getClass());
        RegisteredServiceProvider<Permission> permissionProvider=Bukkit.getServer().getServicesManager().getRegistration(Permission.class);
        if(permissionProvider==null){
            Log.warn(this.mPlugin.C("MsgNoPermissionPluginFound"));
            this.mPermission=new PermissionHook<T>(this.mPlugin);
            return false;
        }
        this.mPermission=new PermissionHook<T>(this.mPlugin,permissionProvider.getProvider());
        return true;
    }

    public PermissionHook<T> getPermission(){
        if(this.mPermission==null||!this.mPermission.isValid()){
            this.setupPermission();
        }
        return this.mPermission;
    }

    protected boolean setupChat(){
        this.mHookChat=true;
        if(this.mVaultPlugin==null&&!this.setupVault()){
            this.mChat=new ChatHook<T>(this.mPlugin);
            return false;
        }
        this.mPlugin.getLangManager().reloadModel(this.getClass());
        RegisteredServiceProvider<Chat> chatProvider=Bukkit.getServer().getServicesManager().getRegistration(Chat.class);
        if(chatProvider==null){
            Log.warn(this.mPlugin.C("MsgNoChatPluginFound"));
            this.mChat=new ChatHook<T>(this.mPlugin);
            return false;
        }
        this.mChat=new ChatHook<T>(this.mPlugin,chatProvider.getProvider());
        return true;
    }

    public ChatHook<T> getChat(){
        if(this.mChat==null||!this.mChat.isValid()){
            this.setupChat();
        }
        return this.mChat;
    }

//    @Override
    public void addDefaultLang(CommentedYamlConfig pConfig){
        pConfig.addDefault("MsgNoVaultPluginFound","未发现Vault插件");
        pConfig.addDefault("MsgVaultPluginFound","发现Vault插件");
        if(this.mHookEconomy){
            pConfig.addDefault("MsgNoEconomyPluginFound","未发现Economy类型插件");
        }
        if(this.mHookPermission){
            pConfig.addDefault("MsgNoPermissionPluginFound","未发现Permission类型插件");
        }
        if(this.mHookChat){
            pConfig.addDefault("MsgNoChatPluginFound","未发现Chat类型插件");
        }
    }

//    @Override
    public void setLang(CommentedYamlConfig pConfig){}
}
