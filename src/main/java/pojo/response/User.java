package pojo.response;

public class User {
	private String accountId;
	private String expand;
	private AvatarUrls avatarUrls;
	private String displayName;
	private String accountType;
	private String self;
	private boolean active;
	private String timeZone;
	private Groups groups;
	private String locale;
	private ApplicationRoles applicationRoles;

	private String emailAddress;

	public void setAccountId(String accountId){
		this.accountId = accountId;
	}

	public String getAccountId(){
		return accountId;
	}

	public void setExpand(String expand){
		this.expand = expand;
	}

	public String getExpand(){
		return expand;
	}

	public void setAvatarUrls(AvatarUrls avatarUrls){
		this.avatarUrls = avatarUrls;
	}

	public AvatarUrls getAvatarUrls(){
		return avatarUrls;
	}

	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}

	public String getDisplayName(){
		return displayName;
	}

	public void setAccountType(String accountType){
		this.accountType = accountType;
	}

	public String getAccountType(){
		return accountType;
	}

	public void setSelf(String self){
		this.self = self;
	}

	public String getSelf(){
		return self;
	}

	public void setActive(boolean active){
		this.active = active;
	}

	public boolean isActive(){
		return active;
	}

	public void setTimeZone(String timeZone){
		this.timeZone = timeZone;
	}

	public String getTimeZone(){
		return timeZone;
	}

	public void setGroups(Groups groups){
		this.groups = groups;
	}

	public Groups getGroups(){
		return groups;
	}

	public void setLocale(String locale){
		this.locale = locale;
	}

	public String getLocale(){
		return locale;
	}

	public void setApplicationRoles(ApplicationRoles applicationRoles){
		this.applicationRoles = applicationRoles;
	}

	public ApplicationRoles getApplicationRoles(){
		return applicationRoles;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
