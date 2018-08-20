package cc.bukkitPlugin.commons.hooks.vaultHook;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.OfflinePlayer;

import cc.bukkitPlugin.commons.plugin.ABukkitPlugin;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

public class EconomyHook<T extends ABukkitPlugin<T>>{

    private T mPlugin;
    private Economy mEconomy;
    private final boolean mInitSuccess;

    public EconomyHook(T pPlugin){
        this.mPlugin=pPlugin;
        this.mInitSuccess=false;
    }

    public EconomyHook(T pPlugin,Economy pPermission){
        this.mPlugin=pPlugin;
        this.mEconomy=pPermission;
        this.mInitSuccess=true;
    }

    public boolean isValid(){
        return this.mInitSuccess;
    }

    public boolean isEnabled(){
        return this.isValid()&&this.mEconomy.isEnabled();
    }

    public String getName(){
        return this.isValid()?this.mEconomy.getName():"FailEconomyPlugin";
    }

    public boolean hasBankSupport(){
        return this.isValid()&&this.mEconomy.hasBankSupport();
    }

    public int fractionalDigits(){
        return this.isValid()?this.mEconomy.fractionalDigits():0;
    }

    public String format(double pAmount){
        return this.isValid()?this.mEconomy.format(pAmount):String.format("%.0f",pAmount);
    }

    public String currencyNamePlural(){
        return this.isValid()?this.mEconomy.currencyNamePlural():"";
    }

    public String currencyNameSingular(){
        return this.isValid()?this.mEconomy.currencyNameSingular():"";
    }

    @Deprecated
    public boolean hasAccount(String pPlayerName){
        return this.isValid()&&this.mEconomy.hasAccount(pPlayerName);
    }

    public boolean hasAccount(OfflinePlayer pPlayer){
        return this.isValid()&&this.mEconomy.hasAccount(pPlayer);
    }

    @Deprecated
    public boolean hasAccount(String pPlayerName,String pWorldName){
        return this.isValid()&&this.mEconomy.hasAccount(pPlayerName,pWorldName);
    }

    public boolean hasAccount(OfflinePlayer pPlayer,String pWorldName){
        return this.isValid()&&this.mEconomy.hasAccount(pPlayer,pWorldName);
    }

    @Deprecated
    public double getBalance(String pPlayerName){
        return this.isValid()?this.mEconomy.getBalance(pPlayerName):0D;
    }

    public double getBalance(OfflinePlayer pPlayer){
        return this.isValid()?this.mEconomy.getBalance(pPlayer):0D;
    }

    @Deprecated
    public double getBalance(String pPlayerName,String pWorldName){
        return this.isValid()?this.mEconomy.getBalance(pPlayerName,pWorldName):0D;
    }

    public double getBalance(OfflinePlayer pPlayer,String pWorldName){
        return this.isValid()?this.mEconomy.getBalance(pPlayer,pWorldName):0D;
    }

    @Deprecated
    public boolean has(String pPlayerName,double pAmount){
        return this.isValid()&&this.mEconomy.has(pPlayerName,pAmount);
    }

    public boolean has(OfflinePlayer pPlayer,double pAmount){
        return this.isValid()&&this.mEconomy.has(pPlayer,pAmount);
    }

    @Deprecated
    public boolean has(String pPlayerName,String pWorldName,double pAmount){
        return this.isValid()&&this.mEconomy.has(pPlayerName,pWorldName,pAmount);
    }

    public boolean has(OfflinePlayer pPlayer,String pWorldName,double pAmount){
        return this.isValid()&&this.mEconomy.has(pPlayer,pWorldName,pAmount);
    }

    @Deprecated
    public SimpleResponse withdrawPlayer(String pPlayerName,double pAmount){
        if(this.isValid()){
            return new SimpleResponse(this.mEconomy.withdrawPlayer(pPlayerName,pAmount));
        }else{
            return new SimpleResponse(this.mPlugin.C("MsgNoVaultPluginFound"));
        }
    }

    public SimpleResponse withdrawPlayer(OfflinePlayer pPlayer,double pAmount){
        if(this.isValid()){
            return new SimpleResponse(this.mEconomy.withdrawPlayer(pPlayer,pAmount));
        }else{
            return new SimpleResponse(this.mPlugin.C("MsgNoVaultPluginFound"));
        }
    }

    @Deprecated
    public SimpleResponse withdrawPlayer(String pPlayerName,String pWorldName,double pAmount){
        if(this.isValid()){
            return new SimpleResponse(this.mEconomy.withdrawPlayer(pPlayerName,pWorldName,pAmount));
        }else{
            return new SimpleResponse(this.mPlugin.C("MsgNoVaultPluginFound"));
        }
    }

    public SimpleResponse withdrawPlayer(OfflinePlayer pPlayer,String pWorldName,double pAmount){
        if(this.isValid()){
            return new SimpleResponse(this.mEconomy.withdrawPlayer(pPlayer,pWorldName,pAmount));
        }else{
            return new SimpleResponse(this.mPlugin.C("MsgNoVaultPluginFound"));
        }
    }

    @Deprecated
    public SimpleResponse depositPlayer(String pPlayerName,double pAmount){
        if(this.isValid()){
            return new SimpleResponse(this.mEconomy.depositPlayer(pPlayerName,pAmount));
        }else{
            return new SimpleResponse(this.mPlugin.C("MsgNoVaultPluginFound"));
        }
    }

    public SimpleResponse depositPlayer(OfflinePlayer pPlayer,double pAmount){
        if(this.isValid()){
            return new SimpleResponse(this.mEconomy.depositPlayer(pPlayer,pAmount));
        }else{
            return new SimpleResponse(this.mPlugin.C("MsgNoVaultPluginFound"));
        }
    }

    @Deprecated
    public SimpleResponse depositPlayer(String pPlayerName,String pWorldName,double pAmount){
        if(this.isValid()){
            return new SimpleResponse(this.mEconomy.depositPlayer(pPlayerName,pWorldName,pAmount));
        }else{
            return new SimpleResponse(this.mPlugin.C("MsgNoVaultPluginFound"));
        }
    }

    public SimpleResponse depositPlayer(OfflinePlayer pPlayer,String pWorldName,double pAmount){
        if(this.isValid()){
            return new SimpleResponse(this.mEconomy.depositPlayer(pPlayer,pWorldName,pAmount));
        }else{
            return new SimpleResponse(this.mPlugin.C("MsgNoVaultPluginFound"));
        }
    }

    @Deprecated
    public SimpleResponse createBank(String pBankName,String pPlayerName){
        if(this.isValid()){
            return new SimpleResponse(this.mEconomy.createBank(pBankName,pPlayerName));
        }else{
            return new SimpleResponse(this.mPlugin.C("MsgNoVaultPluginFound"));
        }
    }

    public SimpleResponse createBank(String pBankName,OfflinePlayer pPlayer){
        if(this.isValid()){
            return new SimpleResponse(this.mEconomy.createBank(pBankName,pPlayer));
        }else{
            return new SimpleResponse(this.mPlugin.C("MsgNoVaultPluginFound"));
        }
    }

    public SimpleResponse deleteBank(String pBankName){
        if(this.isValid()){
            return new SimpleResponse(this.mEconomy.deleteBank(pBankName));
        }else{
            return new SimpleResponse(this.mPlugin.C("MsgNoVaultPluginFound"));
        }
    }

    public SimpleResponse bankBalance(String pBankName){
        if(this.isValid()){
            return new SimpleResponse(this.mEconomy.bankBalance(pBankName));
        }else{
            return new SimpleResponse(this.mPlugin.C("MsgNoVaultPluginFound"));
        }
    }

    public SimpleResponse bankHas(String pBankName,double pAmount){
        if(this.isValid()){
            return new SimpleResponse(this.mEconomy.bankHas(pBankName,pAmount));
        }else{
            return new SimpleResponse(this.mPlugin.C("MsgNoVaultPluginFound"));
        }
    }

    public SimpleResponse bankWithdraw(String pBankName,double pAmount){
        if(this.isValid()){
            return new SimpleResponse(this.mEconomy.bankWithdraw(pBankName,pAmount));
        }else{
            return new SimpleResponse(this.mPlugin.C("MsgNoVaultPluginFound"));
        }
    }

    public SimpleResponse bankDeposit(String pBankName,double pAmount){
        if(this.isValid()){
            return new SimpleResponse(this.mEconomy.bankDeposit(pBankName,pAmount));
        }else{
            return new SimpleResponse(this.mPlugin.C("MsgNoVaultPluginFound"));
        }
    }

    @Deprecated
    public SimpleResponse isBankOwner(String pBankName,String pPlayerName){
        if(this.isValid()){
            return new SimpleResponse(this.mEconomy.isBankOwner(pBankName,pPlayerName));
        }else{
            return new SimpleResponse(this.mPlugin.C("MsgNoVaultPluginFound"));
        }
    }

    public SimpleResponse isBankOwner(String pBankName,OfflinePlayer pPlayer){
        if(this.isValid()){
            return new SimpleResponse(this.mEconomy.isBankOwner(pBankName,pPlayer));
        }else{
            return new SimpleResponse(this.mPlugin.C("MsgNoVaultPluginFound"));
        }
    }

    @Deprecated
    public SimpleResponse isBankMember(String pBankName,String pPlayerName){
        if(this.isValid()){
            return new SimpleResponse(this.mEconomy.isBankMember(pBankName,pPlayerName));
        }else{
            return new SimpleResponse(this.mPlugin.C("MsgNoVaultPluginFound"));
        }
    }

    public SimpleResponse isBankMember(String pBankName,OfflinePlayer pPlayer){
        if(this.isValid()){
            return new SimpleResponse(this.mEconomy.isBankMember(pBankName,pPlayer));
        }else{
            return new SimpleResponse(this.mPlugin.C("MsgNoVaultPluginFound"));
        }
    }

    public List<String> getBanks(){
        return this.isValid()?this.mEconomy.getBanks():new ArrayList<String>(0);
    }

    @Deprecated
    public boolean createPlayerAccount(String pPlayerName){
        return this.isValid()&&this.mEconomy.createPlayerAccount(pPlayerName);
    }

    public boolean createPlayerAccount(OfflinePlayer pPlayer){
        return this.isValid()&&this.mEconomy.createPlayerAccount(pPlayer);
    }

    @Deprecated
    public boolean createPlayerAccount(String pPlayerName,String pWorldName){
        return this.isValid()&&this.mEconomy.createPlayerAccount(pPlayerName,pWorldName);
    }

    public boolean createPlayerAccount(OfflinePlayer pPlayer,String pWorldName){
        return this.isValid()&&this.mEconomy.createPlayerAccount(pPlayer,pWorldName);
    }

    public class SimpleResponse{

        public final double amount;
        public final double balance;
        public final boolean success;
        public final String errorMessage;

        public SimpleResponse(EconomyResponse pResponse){
            this(pResponse.amount,pResponse.balance,pResponse.transactionSuccess(),pResponse.errorMessage);
        }

        public SimpleResponse(String pErrorMessage){
            this(0D,0D,false,pErrorMessage);
        }

        public SimpleResponse(double pAmount,double pBalance,boolean pSuccess,String pErrorMessage){
            this.amount=pAmount;
            this.balance=pBalance;
            this.errorMessage=pErrorMessage;
            this.success=pSuccess;
        }
    }

}
